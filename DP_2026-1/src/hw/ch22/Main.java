package hw.ch22;

import hw.ch22.command.*;
import hw.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력
    private MacroCommand history = new MacroCommand();
    // 그리는 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 버튼들
    private JButton clearButton = new JButton("clear");
    private JButton redButton   = new JButton("red");
    private JButton greenButton = new JButton("green");
    private JButton blueButton  = new JButton("blue");
    // [추가] undo / redo 버튼
    private JButton undoButton  = new JButton("undo");
    private JButton redoButton  = new JButton("redo");

    // 생성자
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        clearButton.addActionListener(e -> {
            history.clear(); // commands와 commandsForRedo 모두 초기화
            canvas.init();
            canvas.repaint();
        });
        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        });
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });
        // [추가] undo 버튼 이벤트
        // history.undo() -> 최근 명령을 commandsForRedo로 이동
        // canvas.repaint() -> paint()가 history.execute()를 호출해 화면 재구성
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });
        // [추가] redo 버튼 이벤트
        // history.redo() -> commandsForRedo의 최근 명령을 commands로 복원
        // canvas.repaint() -> 복원된 이력 기준으로 화면 재구성
        redoButton.addActionListener(e -> {
            history.redo();
            canvas.repaint();
        });

        // [변경] buttonBox에 undoButton, redoButton 추가
        // 버튼 순서: clear | red | green | blue | undo | redo
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton); // 추가
        buttonBox.add(redoButton); // 추가
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // 마우스 이동 (사용 안 함)
    @Override
    public void mouseMoved(MouseEvent e) {}

    // 마우스 드래그: 점 그리기 명령 추가
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // 창 닫기
    @Override
    public void windowClosing(WindowEvent e) { System.exit(0); }
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern - Undo/Redo");
    }
}
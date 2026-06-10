package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {
    // [원본] commands만 존재했음
    // [변경] commandsForRedo 추가 - undo()로 제거된 명령을 임시 보관하여 redo() 시 복원에 사용
    private Deque<Command> commands = new ArrayDeque<>();
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // [변경] descendingIterator()를 사용하여 꼬리(가장 먼저 추가된 명령)부터 순서대로 실행
    // [원본] for-each는 머리부터 순회하여 최신 명령이 먼저 실행되는 역순 문제 발생
    @Override
    public void execute() {
        Iterator<Command> it = commands.descendingIterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }

    // [변경] commandsForRedo.clear() 추가
    // 새 명령이 추가되면 기존 redo 이력을 무효화
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
        commandsForRedo.clear(); // 새 명령 추가 시 redo 이력 초기화
    }

    // [변경] 단순 삭제 대신 꺼낸 명령을 commandsForRedo에 보관
    // redo() 호출 시 복원 가능하도록 유지
    public void undo() {
        if (!commands.isEmpty()) {
            commandsForRedo.push(commands.pop()); // 제거한 명령을 redo 스택에 보관
        }
    }

    // [추가] redo() 신규 추가
    // commandsForRedo에서 가장 최근에 undo된 명령을 꺼내 commands에 복원
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            commands.push(commandsForRedo.pop()); // redo 스택에서 꺼내 명령 스택에 복원
        }
    }

    // [변경] commandsForRedo.clear() 추가
    // clear 후 redo 버튼으로 이전 이력이 복원되지 않도록 함께 초기화
    public void clear() {
        commands.clear();
        commandsForRedo.clear(); // redo 스택도 함께 초기화
    }
}
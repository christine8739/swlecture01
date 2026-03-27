package hw.ch03;

public class StringDisplay extends AbstractDisplay {
    private String string;  // 표시해야 하는 문자열 
    private int width;      // 문자열의 길이

    // 생성자 
    public StringDisplay(String string) {
        super(); // 부모 클래스의 기본 생성자 호출 (반복 횟수 5로 고정)
        this.string = string;
        this.width = string.length();
    }
    
    //반복 횟수 지정 생성자 추가
    public StringDisplay(String string, int repeatCount) {
        super(repeatCount); // 부모한테 반복 횟수 전달
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    //  open과 close에서 호출되어 "+----+" 문자열을 표시하는 메소드
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}

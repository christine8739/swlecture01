package hw.ch03;

public class NumberDisplay extends AbstractDisplay {
    // 출력할 숫자
    private int number;
    
    //반복 횟수 지정하는 생성자 
    //super(repeatCount)로 부모에게 횟수 전달
    public NumberDisplay(int number,int repeatCount) {
        super(repeatCount); // 상위 클래스의 생성자 호출
        this.number = number;
    }
    //시작 부분 :"<<Number>>" 출력
    @Override
    public void open() {
        System.out.println("<<Number>>");
    }
    // 출력 부분 : 숫자 출력,반복해서 한 줄씩 출력
    @Override
    public void print() {
        System.out.println(number);
    }

    //끝 부분 :"<<Number>>" 출력
    @Override
    public void close() {
        System.out.println("<<Number>>");
    }
    
}

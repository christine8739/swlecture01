package hw.ch03;
// 템플릿 메소드 패턴
public abstract class AbstractDisplay {
    //reaptCount : 출력 횟수
    // 템플릿 메소드에서 사용할 필드
    //private으로 선언해서 하위클래스가 직접 접근 못함
    private int repeatCount;

    //기본 생성자: 반복 횟수를 5로 아에 고정 
    public AbstractDisplay(){
        this.repeatCount = 5;
    }

    // 반복 횟수를 직접 지정할 수 있는 생성자 
    // 하위 클래스에서 호출할 수 있도록 super(repeatCount)로 호출
    public AbstractDisplay(int repeatCount){
        this.repeatCount = repeatCount;
    }
    //하위클래스에서 구현하는 추상 메서드
    public abstract void open(); //시작
    public abstract void print(); //출력
    public abstract void close(); //끝

    // 템플릿 메소드: final로 선언해서 하위 클래스에서 오버라이드 못하게 함
    //final로  선언해서 하위 클래스에서 오버라이드 못하게 함
    public final void display(){
        open();
        for(int i=0; i<repeatCount; i++){
            print();
        }
        close();
    }
}

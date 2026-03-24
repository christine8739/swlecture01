package practice.ch03;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    abstract protected void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    //큰 틀을(흐름,구조) 제공함 ,실제 오픈 프린트 클로즈를 어떻게 하느냐에 따라 달라짐 - 템플릿 메소드 패턴(메소드인데 구멍이 뻥뻥 뚤려있는 형태)
    public final void display() { //final-하위클래스에서 오버라이드 할 수 없다(큰 흐름은 자식들이 바꿀 수 없다)
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}

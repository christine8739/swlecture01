package practice.ch02.delegation;

//클라이언트가 원하는 인터페이스,필요로하는 인터페이스, Target 인터페이스 <= 추상클래스
public abstract class Print {
    public abstract void printWeak();
    public abstract void printStrong();
}

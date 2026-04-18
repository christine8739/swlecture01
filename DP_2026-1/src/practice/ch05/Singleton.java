package practice.ch05;

// 싱글턴 패턴 적용하기
public class Singleton {
    // private메소드를 생성자가 외부에서 생성자를 호출해서 객체를 생성하지 못하낟.
    //(3) Singleton 객체를 하나 만들어 둔다.
    private static Singleton singleton = new Singleton(); //클래스가 로딩될때 singleton 객체가 하나 만들어짐

    // (1) 생성자를 private으로 한다.,외부에서 객체를 생성하지 못하도록 막는다.(new Singleton() 불가능)
    private Singleton() {
        System.out.println("Singleton 객체가 생성됩니다.");
    }

    // (2) Singleton 객체를 얻어갈 수 있는 메소드를 정의함
    public static Singleton getInstance() {
        return new Singleton();
    }

}

package practice.ch03;

public class Main {
    public static void main(String[] args) {
       // CharDisplay d1 = new CharDisplay('H'); // 'H', 'H' -부모 타입으로 해도 상관없음(밑에 있는 추상클래스)
       AbstractDisplay d1 = new CharDisplay('H'); // 'H', 'H'
       d1.display();
       d1.open();

       //StringDisplay d2 = new StringDisplay("Hello, world."); // "Hello, world.", "Hello, world."-근데  부모타입으로 하는게 더 좋다 
       AbstractDisplay d2 = new StringDisplay("Hello, world."); // "Hello, world.", "Hello, world."
       d2.display();

       //AbstractDisplay d3  = new AbstractDisplay(); 
       // 추상 클래스는 인스턴스를 만들 수 없다. - 추상 클래스는 구체적인 구현이 없는 클래스이기 때문에 인스턴스를 만들 수 없다.


    }
}

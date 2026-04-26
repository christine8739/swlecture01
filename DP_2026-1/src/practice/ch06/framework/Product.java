package practice.ch06.framework;

public interface Product extends Cloneable { // Cloneable 인터페이스는 객체를 복제할 수 있도록 하는 인터페이스,
//  이 인터페이스를 구현한 클래스는 객체를 복제할 수 있다.
    public abstract void use(String s);
    public abstract Product createCopy(); //복제 메서드 
}

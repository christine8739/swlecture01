package hw.ch06.framework;

public interface Product extends Cloneable {
    public abstract void use(String s); // 제품 사용(각 클래스마다 다르게 구현)
    public abstract Product createCopy(); // 제품 복제-- clone() 활용
}

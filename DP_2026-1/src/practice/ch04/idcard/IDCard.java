package practice.ch04.idcard;

import practice.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;

     public IDCard(String owner) {
        //부모 클래스의 생성자에서 호출하는 메소드가 자식 클래스에서 오버라이드 되어 있다면, 부모 클래스의 생성자에서 호출하는 메소드는 자식 클래스의 오버라이드된 메소드가 호출된다.
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(this.toString() + "을 사용합니다.");
    }

    @Override
    // Object 클래스의 tostring 메소드 오버드라이브
    public String toString() {
        return "[IDCard:" + owner + "]";
    }

    public String getOwner() {
        return owner;
    }
}

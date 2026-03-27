package practice.ch04.idcard;

import practice.ch04.framework.Factory;
import practice.ch04.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    //부모 타입은 자식 객체를 참조 할 수 있다.(다형성)
    //부모 객체는 자식 타입이 참조 할 수 없다.
    protected Product createProduct(String owner) { //실제 제품 생성
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) { //제품 등록
        System.out.println(product.toString() + "을 등록했습니다.");
    }
}

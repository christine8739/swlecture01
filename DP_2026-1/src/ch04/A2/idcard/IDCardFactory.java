package ch04.A2.idcard;


import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100; // 정수 기본 데이터 타입
    private Map<Integer, String> cardRegistry = new HashMap<>(); //정수 객체

    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        if (product instanceof IDCard) {
            IDCard card = (IDCard) product;
            cardRegistry.put(card.getSerial(), card.getOwner()); //serial을 키로, owener를 값으로 저장
        }
        System.out.println(product + "을 등록했습니다.");
    }

    public Map<Integer, String> getCardRegistry() {
        return cardRegistry;
    }
}

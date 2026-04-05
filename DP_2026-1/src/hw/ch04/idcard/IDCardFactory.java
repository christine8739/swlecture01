package hw.ch04.idcard;


import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;
import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private int serial = 100; // 정수 기본 데이터 타입
    private Map<Integer, String> cardRegistry = new HashMap<>(); //정수 객체
    private String baseDate; // 발급 날짜 정보 추가

    // IDCardFactory 생성자에 발급 날짜 정보 추가-baseDate 사용하여
    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }
    // baseDate를 createProduct 메소드에서 IDCard 생성 시 전달하여 발급 날짜 정보 포함
    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++, baseDate);
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

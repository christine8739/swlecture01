package ch04.A2;

import ch04.A2.framework.Factory;
import ch04.A2.framework.Product;
import ch04.A2.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Heungmin Son");
        Product card3 = factory.create("Kane");
        card1.use();
        card2.use();
        card3.use();
        
        // 시리얼 번호 100에 해당하는 오너 조회
        IDCardFactory idCardFactory = (IDCardFactory) factory;
        String owner = idCardFactory.getCardRegistry().get(100);
        System.out.println("시리얼 번호 100의 오너: " + owner);
    }   
}

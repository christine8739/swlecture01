package practice.ch04;

//import practice.ch04.idcard.IDCard;
import practice.ch04.idcard.IDCardFactory;
import practice.ch04.framework.Product;

public class Main {
    public static void main(String[] args) {
        //(1)IDcard를 직접 생성
        // IDCard c1 = new IDCard("임수영");
        // c1.use();


        //(2)공장을 통해서 IDcard 생성
        IDCardFactory factory = new IDCardFactory();
        Product c2 = factory.create("임수영");
        c2.use();


    }
}

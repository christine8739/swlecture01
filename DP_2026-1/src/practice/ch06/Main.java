package practice.ch06;

import practice.ch06.MessageBox;
import practice.ch06.framework.Manager;
import practice.ch06.framework.Product;


public class Main {
    public static void main(String[] args) {
        // // MessageBox 인스턴스 생성
        // MessageBox mbox1 = new MessageBox('*');
        // mbox1.createCopy().use("Hello, world.");
        
        // // UnderlinePen 인스턴스 생성
        // UnderlinePen upen = new UnderlinePen('~');
        // upen.use("Hello, world.");
        
        // // 복사된 객체 사용
        // upen.createCopy().use("Hello, world.");

        // Manager 인스턴스 생성

        //Manager에 원본(prototype) 등록

        //준비
        Manager manager = new Manager();
        MessageBox mbox1 = new MessageBox('*');
        MessageBox mbox2 = new MessageBox('/');
        UnderlinePen upen1 = new UnderlinePen('+');

        //등록
        manager.register("star box", mbox1);
        manager.register("plus line", upen1);
        manager.register("slash line", mbox2);

        // 등록된 이름으로 복제품을 얻어서 사용
        Product p1 = manager.create("star box");  
        p1.use("Hello, world.");


        Product p2 = manager.create("plus line");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash line");
        p3.use("Hello, world.");


    }
}
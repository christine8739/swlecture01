package hw.ch06;

import hw.ch06.framework.Manager;
import hw.ch06.framework.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240886 이름: 임수영");
        System.out.println("밑에 복사실패,성공등에 대한 기호가 나타나지 않아서 지웠습니다");

        // 준비
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        BorderLine bline = new BorderLine('=');

        // 등록
        manager.register("underline", upen);
        manager.register("message", mbox);
        manager.register("border", bline);

        // 생성과 사용
        System.out.println("===== Test 1: UnderlinePen =====");
        Product p1 = manager.create("underline");
        p1.use("Welcome");

        System.out.println("\n===== Test 2: MessageBox =====");
        Product p2 = manager.create("message");
        p2.use("Welcome");

        System.out.println("\n===== Test 3: BorderLine =====");
        Product p3 = manager.create("border");
        p3.use("Welcome");

        // 복사 검증 : 두 객체가 서로 다른지 인증
        System.out.println("\n===== Clone Test =====");
        Product p3_copy = manager.create("border");
        if (p3 != p3_copy) {
            // ! = 이걸로 서로 다른지 확인
            System.out.println("정상적으로 복사됨 (서로 다른 인스턴스)");
        } else {
            System.out.println("복사 실패");
        }
    }
}    
package hw.ch03;

public class Main {
    public static void main(String[] args) {
        //무조건 앞에 내 학번과 이름 넣기
        System.out.println("학번: 20240886 이름: 임수영");
        //**[3-1] 기본 테스트** -기존 코드 호환성 확인
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello");
        d1.display();
        d2.display();

        //**[3-2] Step 1 테스트: 반복 횟수 제어**
        AbstractDisplay d3 = new CharDisplay('X', 3);
        AbstractDisplay d4 = new StringDisplay("Test", 7);
        d3.display();
        d4.display();

        //**[3-3] Step 2 테스트: 새로운 Display**
        AbstractDisplay num = new NumberDisplay(42, 4);
        num.display();


    }
}

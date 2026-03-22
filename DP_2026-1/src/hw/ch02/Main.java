package hw.ch02;

public class Main {
    //한국 콘선트 Adpater로 충전
    public static void main(String[] args) {
        //무조건 앞에 내 학번과 이름 넣기
        System.out.println("학번: 20240886 이름: 임수영");
         //KoreanOutletAdapter 생성
        KoreanOutlet koreanOutlet = new KoreanOutlet();
        //KoreanOutletAdapter 생성-provide()를 charge()로 변환
        Charger charger = new KoreanOutletAdapter(koreanOutlet);
        //Smartphone 에 전달
        Smartphone smartphone = new Smartphone(charger);
        //charge() 호출
        smartphone.charge();
    }



}

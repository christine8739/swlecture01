package hw.ch02;

public class KoreanOutletAdapter implements Charger {
    //KoreanOutlet을 내부적으로 포함,위임을 이용한 어댑터(직접 수정은 못함,안 에 넣어서 사용 가능)
    private KoreanOutlet koreanOutlet;

    //Charger 인터페이스를 구현
    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }   

    // KoreanOutlet의 'provide'를 'charge()'로 변환-220v 그대로 반환
    @Override
    public int charge() {
        return koreanOutlet.provide();
    }
}
 
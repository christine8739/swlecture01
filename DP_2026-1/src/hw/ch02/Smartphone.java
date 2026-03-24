package hw.ch02;

public class Smartphone {
    private Charger charger;
    //생성자에서 Charger 인터페이스를 받음
    public Smartphone(Charger charger) {
        this.charger = charger;
    }
    //charge() 메서드에서 Charger의 charge() 호출
    public void charge() {
        int voltage = charger.charge();
        System.out.println("스마트폰이 " + voltage + "V에서 충전됩니다.");
    }

}

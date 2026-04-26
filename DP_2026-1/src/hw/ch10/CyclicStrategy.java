package hw.ch10;

public class CyclicStrategy implements Strategy{
    private int index = 0; // 현재 순서( 0=바위, 1= 가위, 2 = 보 )
    

    @Override
    public Hand nextHand(){
        Hand hand = Hand.getHand(index); // 현재 순서에 해당하는 손을 얻는다
        index = (index + 1) % 3; // 다음 순서로 이동
        return hand;
    }

    @Override
    public void study(boolean win) {
        // 순환 전략은 승패와 무관하게 항상 순서대로->
        // 이 전략은 학습하지 않으므로 아무것도 하지 않는다
    }
}

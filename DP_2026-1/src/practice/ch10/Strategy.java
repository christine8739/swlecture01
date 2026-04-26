package practice.ch10;
// 전략 인터페이스
// 전략 인터페이스: 알고리즘을 캡슐화하여 클라이언트에서 독립적으로 변경할 수 있도록 하는 인터페이스
public interface Strategy {
    public abstract Hand nextHand(); // 다음에 낼 손을 결정하는 메소드-nextHand()는 다음에 낼 손을 결정하는 메소드로,
    //  Hand 객체를 반환한다. Hand 클래스는 가위, 바위, 보를 나타내는 클래스이다.
    public abstract void study(boolean win); 
    // 결과를 학습하는 메소드-study()는 게임의 결과를 학습하는 메소드로, win 매개변수는 게임에서 이겼는지 여부를 나타낸다. 
    // 이 메소드를 통해 전략은 자신의 행동을 조정할 수 있다.
}

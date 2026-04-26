package hw.ch10;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random; // 무작위 선택을 위한 Random 객체

    // 시드값으로 Random 객체 생성
    public RandomStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public void study(boolean win) {
        // 무작위 전략은 승패 결과와 무관하게 동작하므로 아무것도 하지 않음
    }

    @Override
    public Hand nextHand() {
        // 0, 1, 2 중 하나를 무작위로 선택하여 손 반환 (0=바위, 1=가위, 2=보)
        return Hand.getHand(random.nextInt(3));
    }
}
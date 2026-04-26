package hw.ch10;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false; // 직전 게임 승리 여부
    private Hand prevHand;       // 직전에 낸 손

    // 시드값으로 Random 객체 생성
    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            // 직전에 졌거나 처음이면 새로운 손을 무작위로 선택
            prevHand = Hand.getHand(random.nextInt(3));
        }
        // 직전에 이겼으면 같은 손을 그대로 반환
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        // 직전 게임 결과를 won에 저장 (true=이김, false=짐)
        won = win;
    }
}
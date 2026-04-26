package hw.ch10;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;      // 이전에 낸 손의 값
    private int currentHandValue = 0;   // 현재 낸 손의 값
    // 승패 이력을 기록하는 2차원 배열
    // history[이전 손][현재 손] = 해당 조합으로 이긴 횟수
    private int[][] history = {
        { 1, 1, 1, },   // 이전에 바위(0)를 냈을 때
        { 1, 1, 1, },   // 이전에 가위(1)를 냈을 때
        { 1, 1, 1, },   // 이전에 보(2)를 냈을 때
    };

    // 시드값으로 Random 객체 생성
    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        // 현재 손 기준으로 history 합계 범위 내에서 랜덤 값 추출
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        // bet 값이 어느 구간에 속하는지에 따라 다음 손 결정
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;  // 바위
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;  // 가위
        } else {
            handvalue = 2;  // 보
        }
        prevHandValue = currentHandValue;   // 현재 손을 이전 손으로 저장
        currentHandValue = handvalue;       // 새로 결정한 손을 현재 손으로 저장
        return Hand.getHand(handvalue);
    }

    // 특정 손의 history 합계를 반환 (확률 계산에 사용)
    private int getSum(int handvalue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            // 이겼을 때: 이전 손 → 현재 손 조합의 횟수 증가
            history[prevHandValue][currentHandValue]++;
        } else {
            // 졌을 때: 현재 손이 아닌 다른 두 손의 횟수 증가
            // (다음엔 다른 손을 내도록 유도)
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
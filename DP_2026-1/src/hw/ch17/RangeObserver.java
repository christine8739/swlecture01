package hw.ch17;

/**
 * 숫자의 범위를 판별하여 레이블을 출력하는 Observer 구현체
 * - 0 이상 10 미만 : Low
 * - 10 이상 20 미만 : Mid
 * - 20 이상       : High
 */
public class RangeObserver implements Observer {

    /**
     * NumberGenerator로부터 통지를 받으면 호출되는 메서드
     * 현재 숫자를 읽어 범위 레이블과 함께 출력한다
     * @param generator 관찰 대상 NumberGenerator
     */
    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber(); // 현재 숫자 취득
        String label;

        // 범위에 따라 레이블 결정
        if (number < 10) {
            label = "Low";
        } else if (number < 20) {
            label = "Mid";
        } else {
            label = "High";
        }

        System.out.println("RangeObserver: [" + label + "] " + number);
    }
}
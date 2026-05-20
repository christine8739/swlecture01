package hw.ch17;

/**
 * 짝수만 순서대로 생성하는 NumberGenerator 구현체
 * start부터 end 미만까지 2씩 증가하며 짝수를 생성한다
 */
public class EvenNumberGenerator extends NumberGenerator {

    private int number; // 현재 숫자
    private int end;    // 종료값 (이 값은 포함하지 않는다)

    /**
     * 생성자
     * @param start 시작값 (짝수여야 한다)
     * @param end   종료값 (이 값은 포함하지 않는다)
     */
    public EvenNumberGenerator(int start, int end) {
        this.number = start;
        this.end = end;
    }

    /**
     * 현재 숫자를 반환한다
     * @return 현재 짝수 값
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * 짝수를 순서대로 생성하며, 값이 바뀔 때마다 Observer에 통지한다
     * 증가폭은 항상 2로 고정된다
     */
    @Override
    public void execute() {
        while (number < end) {
            notifyObservers(); // 등록된 모든 Observer에 통지
            number += 2;       // 다음 짝수로 이동
        }
    }
}
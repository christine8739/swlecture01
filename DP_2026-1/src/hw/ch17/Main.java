package hw.ch17;

public class Main {
    public static void main(String[] args) {
        // EvenNumberGenerator 생성: 0부터 30 미만까지 짝수 생성 (0, 2, 4, ..., 28)
        NumberGenerator generator = new EvenNumberGenerator(0, 30);

        // Observer 등록
        generator.addObserver(new DigitObserver());  // 숫자 형식 출력
        generator.addObserver(new GraphObserver());  // * 막대 그래프 출력
        generator.addObserver(new RangeObserver());  // 범위 레이블 출력

        // 수 생성 시작
        generator.execute();
    }
}
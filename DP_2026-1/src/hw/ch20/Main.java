package hw.ch20;

public class Main {

    // ========== 추가 시작 ==========
    // ANSI 색상 코드 상수 — 외재 상태로 사용된다
    // BigChar 안에 저장되지 않고 print() 호출 시점에 전달된다
    static final String RED     = "\u001B[31m";
    static final String GREEN   = "\u001B[32m";
    static final String YELLOW  = "\u001B[33m";
    static final String BLUE    = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN    = "\u001B[36m";
    static final String RESET   = "\u001B[0m"; // 색상 초기화 (반드시 필요)
    // ========== 추가 끝 ==========

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        // 공유하지 않는 BigString 출력 (기존)
        BigString bs;
        bs = new BigString(args[0], false);
        bs.print();

        // 공유하는 BigString 출력 (기존)
        bs = new BigString(args[0], true);
        bs.print();

        // ========== 추가 시작 ==========
        // 과제 4.1: 1(RED) 2(BLUE) 1(GREEN) 2(MAGENTA) 1(CYAN) 2(YELLOW) 3(BLUE)
        // 입력 문자열 길이에 맞게 색상 배열을 구성한다
        String[] colorCycle = { RED, BLUE, GREEN, MAGENTA, CYAN, YELLOW, BLUE };
        String[] colors = new String[args[0].length()];
        for (int i = 0; i < colors.length; i++) {
            // 순환 할당: 입력이 7자를 넘어도 색상이 반복된다
            colors[i] = colorCycle[i % colorCycle.length];
        }

        // 공유 인스턴스를 사용하면서 각 문자에 다른 색상(외재 상태)을 적용
        // → 같은 BigChar 인스턴스가 공유된 채로 출력마다 다른 색상이 나오는 것을 확인
        BigString colorBs = new BigString(args[0], true);
        colorBs.print(colors);
        // ========== 추가 끝 ==========
    }
}
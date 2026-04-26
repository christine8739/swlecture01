package hw.ch10;

public class Main {
    public static void main(String[] args) {
        // 필수로 추가: 학번 및 이름 출력
        System.out.println("학번: 20240886 이름: 임수영");

        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));

        System.out.println("\n===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());

        // CyclicStrategy 순환 확인
        System.out.println("CyclicStrategy 의 손가락 순환:");
        Strategy cyclic = new CyclicStrategy();
        for (int i = 0; i < 9; i++) {
            Hand hand = cyclic.nextHand();
            System.out.println((i + 1) + "번째: " + hand);
            cyclic.study(false);
        }

        // player1 vs player2 10번 게임 진행
        System.out.println("\n===== 게임 진행 =====");
        for (int i = 0; i < 10; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();
            if (hand1.isStrongerThan(hand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (hand2.isStrongerThan(hand1)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("\nTotal result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
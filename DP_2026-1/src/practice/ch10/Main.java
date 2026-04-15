package practice.ch10;

public class Main {
    public static void main(String[] args) {
        // // 손을 2개 생성
        // Hand h1 = Hand.ROCK;
        // Hand h2 = Hand.SCISSORS;

        // // 손을 대결시킴

        // if(h1.isStrongerThan(h2)){
        //     System.out.println(h1 + "이 " + h2 + "보다 강하다.");
        // } else if(h1.isWeakerThan(h2)){
        //     System.out.println(h1 + "이 " + h2 + "보다 약하다.");
        // } else {
        //     System.out.println(h1 + "과 " + h2 + "는 비겼다.");
        // }

        // 플렝이어 2명 만들기
        Player player1 = new Player("임수영", new WinningStrategy(314));
        Player player2 = new Player("김동현", new WinningStrategy(15));

        // 게임 시키기
        for (int i =0; i<10; i++){
            Hand h1 = player1.nextHand();
            Hand h2 = player2.nextHand();

            // 손을 대결시킴
            if (h1.isStrongerThan(h2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (h1.isWeakerThan(h2)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
            System.out.println("Total result:");
            System.out.println(player1);    
            System.out.println(player2);

        }

    }
}

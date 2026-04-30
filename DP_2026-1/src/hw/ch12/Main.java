package hw.ch12;

public class Main {
    public static void main(String[] args) {
        // 필수로 추가: 학번 및 이름 출력
        System.out.println("학번: 20240886 이름: 임수영");

        // MultiStringDisplay 인스턴스 생성
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Hello, java!");
        md.add("Decorator Pattern");
        md.add("is powerful.");

        //[2-1] 원본 출력 
        System.out.println("===== [2-1] 원본 출력  =====");
        md.show();
        System.out.println();

        //[2-2] NumberedBorder 단독 적용
        System.out.println("===== [2-2] NumberedBorder 단독 적용  =====");
        Display d1 = new NumberedBorder(md);
        d1.show();
        System.out.println();

        //[2-3] FullBorder + NumberedBorder 조합
        System.out.println("===== [2-3] FullBorder + NumberedBorder 조합  =====");
        Display d2 = new FullBorder(new NumberedBorder(md));
        d2.show();
        System.out.println();

        //[2-4] SideBorder + NumberedBorder + FullBorder 3 단 중첩
        System.out.println("===== [2-4] SideBorder + NumberedBorder + FullBorder 3 단 중첩  =====");
        Display d3 = new SideBorder(new FullBorder(new NumberedBorder(md)), '*');
        d3.show();
        System.out.println();
    }
}

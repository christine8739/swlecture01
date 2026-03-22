package practice.ch02.inheritance;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("Hello world");
        banner.showWithParen();
        banner.showWithAster();
        
        //어댑터 이용
        System.err.println("=== 어댑터 이용 ===");
        Print bannerPrint = new PrintBannerAdapter01("Hello world");
        bannerPrint.printWeak();
        bannerPrint.printStrong();
    }
}

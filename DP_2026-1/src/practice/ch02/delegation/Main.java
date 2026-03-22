package practice.ch02.delegation;

public class Main {
    public static void main(String[] args) {
        Print print = new PrintBannerAdapter02("Hello world");
        print.printWeak();
        print.printStrong();
        ((PrintBannerAdapter02)print).getYourName(); //형변환(타입캐스팅)
    }
}

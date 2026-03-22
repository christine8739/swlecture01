package practice.ch02.inheritance;

//클라이언트가 원하는 인터페이스를 구현한 어댑터 클래스
public class PrintBannerAdapter01 extends Banner implements Print{

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
    
}

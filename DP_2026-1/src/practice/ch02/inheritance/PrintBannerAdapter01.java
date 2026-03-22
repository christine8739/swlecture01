package practice.ch02.inheritance;

//클라이언트가 원하는 인터페이스를 구현한 어댑터 클래스
public class PrintBannerAdapter01 extends Banner implements Print{
    //(1) 인자없는 생성자는 자동으로 생성됨
    //(2) 생성자는 상속되지 않음 

    public PrintBannerAdapter01(String string) {
        super(string); //super-부모 생성자 호출 
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
    
}

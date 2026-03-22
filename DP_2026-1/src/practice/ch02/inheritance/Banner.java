package practice.ch02.inheritance;
// 이미 존재하는 클래스, vender 클래스, 강아지(멍멍() 제공) , 수정할 수 없음ㅁ
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}

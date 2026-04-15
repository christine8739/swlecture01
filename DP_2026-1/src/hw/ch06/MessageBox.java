package hw.ch06;

import hw.ch06.framework.Product;

public class MessageBox implements Product{
    // 상자를 그리는 데 사용할 문자
    private char decochar;
    // 생성자: 장식 문자를 인자로 받음
    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void use(String s) {
        //위쪽 라인
        for (int i = 0; i < s.length() + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println(); // 줄바꿈

        // 본문( 양쪽에 "*" 와 "*" 추가)
        System.out.println(decochar + " " + s + " " + decochar);

        // 아래쪽 라인
        for (int i = 0; i < s.length() + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println(); // 줄바꿈
    }
    // clone()을 활용해 현재 객체를 복사하여 반환
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}

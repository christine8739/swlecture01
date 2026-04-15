package hw.ch06;

import hw.ch06.framework.Product;


public class UnderlinePen implements Product {  
    // 밑줄에 사용할 문자
    private char ulchar;
    // 생성자: 밑줄에 사용할 문자를 인자로 받음 
    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        //본문 출력
        System.out.println(s);
        //텍스트 길이만큼 밑줄 출력
        for (int i = 0; i < s.length(); i++) {
            System.out.print(ulchar);
        }
        System.out.println(); //줄바꿈
    }
    // 클론을 활용해 현재 객체를 복사하여 반환
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
package hw.ch06;

import hw.ch06.framework.Product;

public class BorderLine implements Product {
    //위아래 라인에 사용할 문자
    private char borderChar;

    // 생성자: 경계 문자를 인자로 받음
    public BorderLine(char borderChar){
        this.borderChar = borderChar;
    }

    // use()메서드 구현
    @Override
    public void use (String s){
        int length = s.length();

        //위쪽 라인 출력(s.length() 만큼)
        for (int i = 0; i<length; i++){
            System.out.print(borderChar);
        }
        System.out.println(); // 줄바꿈

        //본문 출력(텍스트 그대로)
        System.out.println(s);

        //아래쪽 라인 출력(s.length() 만큼)
        for (int i = 0; i<length; i++){
            System.out.print(borderChar);
        }
        System.out.println(); // 줄바꿈
    }

    // createCopy() 메서드 구현(clone() 활용)
    @Override
    public Product createCopy(){
        Product p = null;
        try{
            p=(Product) clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}

package hw.ch12;

public class NumberedBorder extends Border{
    public NumberedBorder(Display display){
        super(display);
    }

    @Override
    public int getColumns(){
        // %2d 형식 = 숫자 2자리 'ㅣ' = 3 글자 이지만
        // 과제 형식에서 +4 해야하기 때문에 (공백포함"1ㅣ" 느낌)
        return 4 + display.getColumns();

    }

    @Override
    public int getRows(){
        //행 수 는 내용물과 동일
        return display.getRows();
    }

    @Override
    public String getRowText(int row){
        // row는 0부터 시작->+1해서 1부터 출력
        //String.format("%2d",1)->"1l" (3글자)
        return String.format("%2d| ", row + 1) + display.getRowText(row);
    }
}


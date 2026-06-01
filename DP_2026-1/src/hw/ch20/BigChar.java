package hw.ch20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'의 열) — 내재 상태(Intrinsic State)
    // 같은 문자는 항상 동일한 모양이므로 인스턴스 안에 저장해 공유한다
    private String fontdata;

    // ========== 추가 시작 ==========
    // ANSI 색상 리셋 코드 — BigChar 안에서 직접 정의해 Main 의존성 제거
    private static final String RESET = "\u001B[0m";
    // ========== 추가 끝 ==========

    // 생성자: 파일에서 폰트 데이터를 읽어 fontdata에 저장
    public BigChar(char charname) {
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontdata = sb.toString();
        } catch (IOException e) {
            // 파일이 없으면 문자 이름 + '?' 로 대체
            this.fontdata = charname + "?";
        }
    }

    // 색상 없이 큰 문자를 표시한다 (기존 메서드)
    public void print() {
        System.out.print(fontdata);
    }

    // ========== 추가 시작 ==========
    // 외재 상태(colorCode)를 받아 해당 색상으로 큰 문자를 표시한다
    // - colorCode는 BigChar 안에 저장하지 않는다 (외재 상태)
    // - 같은 BigChar 인스턴스를 공유하면서도 호출마다 다른 색상으로 출력 가능
    // - fontdata(내재 상태)는 그대로 공유, 색상만 호출 시점에 전달받는다
    public void print(String colorCode) {
        // [색상 시작] + [폰트 데이터] + [색상 리셋] 순서로 출력
        // RESET을 붙이지 않으면 이후 터미널 출력 전체가 해당 색상으로 남는다
        System.out.print(colorCode + fontdata + RESET);
    }
    // ========== 추가 끝 ==========
}
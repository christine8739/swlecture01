package hw.ch20;

// 클라이언트 클래스: BigChar 배열로 큰 문자열을 구성한다
public class BigString {
    // 큰 문자의 배열
    private BigChar[] bigchars;

    // 생성자: 공유 모드로 초기화 (기본)
    public BigString(String string) {
        initShared(string);
    }

    // 생성자: shared 인수로 공유 여부를 직접 지정
    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);   // Factory를 통해 인스턴스 공유
        } else {
            initUnshared(string); // 매번 새 인스턴스 생성
        }
    }

    // Factory를 통해 BigChar 인스턴스를 공유하며 초기화
    private void initShared(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            // 같은 문자면 동일한 인스턴스를 반환받아 공유한다
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // BigChar 인스턴스를 공유하지 않고 매번 새로 생성하며 초기화
    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    // 색상 없이 큰 문자열을 표시한다 (기존 메서드)
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }

    // ========== 추가 시작 ==========
    // 각 문자에 대응하는 색상 배열(외재 상태)을 받아 색상으로 표시한다
    // - colors[i]는 bigchars[i]를 출력할 때만 사용되고 저장되지 않는다
    // - colors.length == bigchars.length 라고 가정한다
    public void print(String[] colors) {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print(colors[i]); // 각 문자에 색상(외재 상태)을 전달
        }
    }
    // ========== 추가 끝 ==========
}
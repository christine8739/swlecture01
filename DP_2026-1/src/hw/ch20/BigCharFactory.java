package hw.ch20;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory — Singleton 패턴으로 구현
// pool로 BigChar 인스턴스를 관리하여 같은 문자에 대해 항상 동일한 인스턴스를 반환한다
public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리하는 풀 (문자 → BigChar)
    private Map<String, BigChar> pool = new HashMap<>();

    // Singleton 패턴: 유일한 인스턴스를 클래스 변수로 보유
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자를 private으로 막아 외부에서 인스턴스 생성 불가
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 반환한다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스를 생성하거나 pool에서 꺼내 반환한다
    // synchronized: 멀티스레드 환경에서 중복 생성 방지
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));
        if (bc == null) {
            // pool에 없으면 새로 생성하고 등록
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        // pool에 있으면 기존 인스턴스를 그대로 반환 (공유)
        return bc;
    }
}
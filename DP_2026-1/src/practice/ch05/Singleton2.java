package practice.ch05;

public enum Singleton2 {
    // 상수
    INSTANCE1,
    INSTANCE2,
    INSTANCE3; // 클래스 로드시 싱글톤 객체를 하나 만들어 둠
    // 메소드
    public void hello() {
        System.out.println("싱글톤 객체의 hello  메소드가 호출되었습니다.");
    }
    
}

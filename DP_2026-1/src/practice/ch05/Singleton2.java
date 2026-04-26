package practice.ch05;

public enum Singleton2 {
    // 상수
    INSTANCE1,
    INSTANCE2,
    INSTANCE3; // 클래스 로드시 싱글톤 객체를 하나 만들어 둠
    // 생성자는 하나만 만들어야함-> 생성자는 private으로 해야함-> 외부에서 객체를 생성하지 못하도록 막는다.(new Singleton2() 불가능)
    // 메소드
    public void hello() {
        System.out.println("싱글톤 객체의 hello  메소드가 호출되었습니다.");
    }
    
}

package hw.ch05;

public enum LoggerEnum {

    // INSTANCE 자체가 싱글톤 인스턴스 역할
    // → 별도로 instance 변수나 getInstance() 메서드가 필요 없음
    INSTANCE;

    // 로그 메시지를 누적해서 저장하는 버퍼
    private StringBuilder logBuffer;

    // Enum 생성자는 자동으로 private d이기 때문에 키워드 없이 씀
    //-> 외부에서 new LoggerEnum()로 인스턴스 생성 불가-> 싱글톤 보장
    //INSTANCE가 처음 사요용될때 JVM이 한번만 호출
    LoggerEnum(){
        System.out.println("[LoggerEnum] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder();
    }

    //로그 메시지를 기록하는 메서드
    // - logBuffer에 현재 시각(밀리초) + 메시지를 누적 저장
    // - 콘솔에도 로그 출력(동시에)
    public void log(String message){
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerEnum] " + message);
    }
    // 지금까지 누적된 전체 로그를 문자열로 반환
    public String getLog(){
        return logBuffer.toString();
    }   
}

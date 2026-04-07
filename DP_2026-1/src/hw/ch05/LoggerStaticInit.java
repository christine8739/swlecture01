package hw.ch05;

public class LoggerStaticInit {

    // 클래스가 로드될 때 인스턴스가 생성되는 방식,이후엔 이 인스턴스를 재사용
    //final: 한번 할당되면 다시 바꿀 수 없음 -> 항상 동일한 인스턴스 보장
    private static final LoggerStaticInit instance = new LoggerStaticInit();

    //로그 메세지를 누적해서 저장하는 버퍼
    private StringBuilder logBuffer;

    //private:외부에서 new LoggerStaticInit() 호출 불가 -> 싱글톤 핵심
    private LoggerStaticInit() {
        System.out.println("[LoggerStaticInit] 인스턴스를 생성했습니다.");
        logBuffer = new StringBuilder(); //버퍼 초기화
    }
    //외부에서 인스턴스를 얻는 유일한 방법
    //항상 위에서 만들어둔 동일한 instance를 반환 
    public static LoggerStaticInit getInstance() {
        return instance;
    }
    //로그 메시지를 기록하는 메서드
    //-logBuffer에 현재 시각(밀리초) + 메세지를 누적 저장
    //-콘솔에도 로그 출력(동시에)
    public void log(String message) {
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerStaticInit] " + message);
    }
    
    //지금까지 누적된 전체 로그를 문자열로 반환
    public String getLog(){
        return logBuffer.toString();
    }
    //summary
    //private static final -> 싱글톤의 핵심,클래스 로드시 1회 생성 후 고정
    //private 생성자 -> 외부에서 인스턴스를 새로 못 만들게 막는것
    //getInstance() -> 외부가 인스턴스에 접근하는 유일한 창구 
    //
}

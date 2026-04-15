package hw.ch05;

public class LoggerSynchronizedLazy {
    //처음에는 null로 시작->getInstance() 호출 전까지 인스턴스 생성 안 함(지연 초기화)
    private static LoggerSynchronizedLazy instance = null;
    //로그 메시지를 누적해서 저장하는 버퍼
    private StringBuilder logBuffer;

    
    //synchronized: 여러 스레드가 동시에 이 메서드에 들어오지 못하도록 잠금
    //->instance 가 중복 생성되는 것을 방지
    private LoggerSynchronizedLazy(){
        System.out.println("[LoggerSynchronizedLazy] 인스턴스를 생성했습니다");
        logBuffer = new StringBuilder();
    }
    
    //외부에서 인스턴스를 얻는 유일한 방법
    public static synchronized LoggerSynchronizedLazy getInstance(){
        if (instance == null){ // 이 인스턴스가 없으면 
            instance = new LoggerSynchronizedLazy(); //그때 처음 생성
        }
        return instance; // 이미 있으면 기존 인스턴스 그대로 반환
    }

    //로그 메시지를 기록하는 메서드
    //-logbuffer에 현재 시각(밀리초) + 메시지를 누적 저장
    //-콘솔에도 동시에 출력
    public void log(String message){
        logBuffer.append("[").append(System.currentTimeMillis()).append("] ").append(message).append("\n");
        System.out.println("[LoggerSynchronizedLazy] " + message);
    }
    //지금까지 누적된 전체 로그를 문자열로 변환
    public String getLog(){
        return logBuffer.toString();
    }

    //summary
    //instance = null -> wldus chrlghk
    //synchronized -> 멀티스레드 환경에서 안전하게 인스턴스 생성 보장

}

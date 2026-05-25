package hw.ch19;

public class ClosingState implements State {
    private static ClosingState singleton = new ClosingState();

    private ClosingState() {            // 생성자는 private (Singleton)
    }

    public static State getInstance() { // 유일한 인스턴스를 얻는다
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) { // 시간에 따라 상태 전환
        if (hour < 17) {
            context.changeState(DayState.getInstance());   // 17시 이전 → 주간
        } else if (20 <= hour) {
            context.changeState(NightState.getInstance()); // 20시 이후 → 야간
        }
    }

    @Override
    public void doUse(Context context) {    // 금고 사용 → 마감 점검 통보
        context.callSecurityCenter("마감 금고 점검");
    }

    @Override
    public void doAlarm(Context context) {  // 비상벨 → 경비 센터 호출 + 비상 상태로 전환
        context.callSecurityCenter("비상벨(마감)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {  // 일반 통화 → 퇴근 확인 기록
        context.recordLog("퇴근 확인 통화(마감)");
    }

    @Override
    public String toString() {             // 상태 이름 표시
        return "[마감]";
    }
}
package hw.ch19;

public class DayState implements State {
    private static DayState singleton = new DayState(); // 유일한 인스턴스 (Singleton)

    private DayState() {                // 생성자는 private (Singleton)
    }

    public static State getInstance() { // 유일한 인스턴스를 얻는다
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) { // 시간에 따라 상태 전환
        if (hour < 9) {
            context.changeState(NightState.getInstance());   // 새벽 → 야간
        } else if (17 <= hour) {
            context.changeState(ClosingState.getInstance()); // 수정: 17시 이후 → 마감 (기존: NightState)
        }
    }

    @Override
    public void doUse(Context context) {    // 금고 사용 → 로그 기록
        context.recordLog("금고 사용(주간)");
    }

    @Override
    public void doAlarm(Context context) {  // 비상벨 → 경비 센터 호출 + 비상 상태로 전환
        context.callSecurityCenter("비상벨(주간)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {  // 일반 통화 → 경비 센터 호출
        context.callSecurityCenter("일반 통화(주간)");
    }

    @Override
    public String toString() {             // 상태 이름 표시
        return "[주간]";
    }
}
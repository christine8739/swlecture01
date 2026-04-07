package hw.ch05;

public class Main {
    public static void main(String[] args) {
         //무조건 앞에 내 학번과 이름 넣기
        System.out.println("학번: 20240886 이름: 임수영");
        //[2-1] Static Initializer 테스트
        //-getINstance()로 인스턴스 얻어서 로그 기록,두번 호출해서 같은 인스턴스인지 확인
        System.out.println("========== 방식 1: Static Initializer ==========");
        LoggerStaticInit logger1a = LoggerStaticInit.getInstance();
        LoggerStaticInit logger1b = LoggerStaticInit.getInstance();

        logger1a.log("Static Message 1");
        logger1b.log("Static Message 2");

        // == 연산자로 두 변수가 동일한 인스턴스를 가리키는지 확인
        if(logger1a == logger1b){
            System.out.println("✓ 동일한 인스턴스");
        } else {
            System.out.println("✗ 다른 인스턴스");
        }

        // logbuffer에 누적된 전체 로그 출력
        //-getInstance()를 두번 호출해서 같은 인스턴스인지 확인
        //-첫 호출 시에만 인스턴스 생성됨(지연 초기화)
        System.out.println("\n========== 로그 출력 1 =========="); 
        System.out.println("[LoggerStaticInit 로그]");
        System.out.println(logger1a.getLog());

        //[2-2] Synchronized Lazy 테스트
        System.out.println("\n========== 방식 2: Synchronized Lazy ==========");
        LoggerSynchronizedLazy logger2a = LoggerSynchronizedLazy.getInstance();
        LoggerSynchronizedLazy logger2b = LoggerSynchronizedLazy.getInstance();

        logger2a.log("Synchronized Message 1");
        logger2b.log("Synchronized Message 2");

        // == 연산자로 두 변수가 동일한 인스턴스를 가리키는지 확인
        if(logger2a == logger2b){
            System.out.println("✓ 동일한 인스턴스");
        } else {
            System.out.println("✗ 다른 인스턴스");
        }

        // logBuffer에 누적된 전체 로그 출력
        System.out.println("\n========== 로그 출력 2 ==========");
        System.out.println("[LoggerSynchronizedLazy 로그]");
        System.out.println(logger2a.getLog());

        //[2-3] Enum 테스트
        //-INSTANCE로 직접 접근(getInstance() 필요 없음 )
        //-ENUM 특성상 항상 동일한 인스턴스 보장
        System.out.println("\n========== 방식 3: Enum (권장) ==========");
        LoggerEnum logger3a = LoggerEnum.INSTANCE;
        LoggerEnum logger3b = LoggerEnum.INSTANCE;

        logger3a.log("Enum Message 1");
        logger3b.log("Enum Message 2");

        // == 연산자로 두 변수가 동일한 인스턴스를 가리키는지 확인
        if(logger3a == logger3b){
            System.out.println("✓ 동일한 인스턴스");
        } else {
            System.out.println("✗ 다른 인스턴스");
        }

        // logBuffer에 누적된 전체 로그 출력
        System.out.println("\n========== 로그 출력 3 ==========");
        System.out.println("[LoggerEnum 로그]");
        System.out.println(logger3a.getLog());
    }
    
    
}

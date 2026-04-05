package practice.ch05.ex;

//다른방법으로 싱글턴 패턴 적용하기 
public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("인스턴스가 생성되었습니다.");
        slowdown(); //인스턴스가 생성될 때 시간을 지연시킴
    }

    public static synchronized Singleton getInstance() {
        if (singleton == null) { // 처음 호출되는지 검사
            singleton = new Singleton();
        }
        return singleton;
    }

    private void slowdown() {
        try {
            Thread.sleep(1000); //CPU를 내놓고 쉼
        } catch (InterruptedException e) {
        }
    }
}

package practice.ch11;

public abstract class Entry { // 파일과 디렉터리의 공통된 인터페이스를 정의하는 추상 클래스
    // 이름을 얻는다
    public abstract String getName();

    // 크기를 얻는다 
    public abstract int getSize();

    // printList(): 메소드 오버로딩
    // add()는 기본적으로 예외 발생 => 디렉터리에서만 add()가 구현되어야 한다
    //throws: 예외가 발생할 수 있음을 나타내는 키워드, 예외가 발생할 수 있는 메소드에서 반드시 선언해야 한다
    //fileTreatmentException: 파일에 디렉터리를 추가하려고 할 때 발생하는 예외
    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    // 목록을 표시한다
    public void printList() {
        printList(""); // prdfix 없음- 오버로드(오버라이딩아님)
    }

    // prefix를 앞에 붙여서 목록을 표시한다 
    protected abstract void printList(String prefix);

    // 문자열 표시 
    @Override
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

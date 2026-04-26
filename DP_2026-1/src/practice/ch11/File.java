package practice.ch11;

public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    
    @Override
    public String getName() { // 파일의 이름을 반환한다
        return name;
    }

    @Override
    public int getSize() { // 파일의 크기를 반환한다
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}

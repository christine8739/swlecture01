package practice.ch11;

public class Main {
    public static void main(String[] args) {
        //디렉터리 트리를 만든가
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin);
        root.add(tmp);
        root.add(usr);

        // 파일 생성 및 추가
        bin.add(new File("vi",10000));
        bin.add(new File("latex",20000)); // bin 디렉터리에 파일 추가
        // 디렉터리 리스트 출력 
        root.printList();
    }
}

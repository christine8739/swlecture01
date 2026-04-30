package hw.ch11;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 필수로 추가: 학번 및 이름 출력
        System.out.println("학번: 20240886 이름: 임수영");

        //디렉토리 생성
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory usr = new Directory("usr");
        Directory lib = new Directory("lib");
        Directory home = new Directory("home");
        Directory alice = new Directory("alice");
        
        //트리 구조 구성
        root.add(bin);
        root.add(usr);
        root.add(home);
        
        //bin디렉토리에 파일 추가
        bin.add(new File("bash", 120));
        bin.add(new File("gcc.exe", 200));
        
        //usr디렉토리에 파일과 디렉토리 추가
        usr.add(new File("readme.txt", 5));
        usr.add(lib);
        
        //lib디렉토리에 파일 추가
        lib.add(new File("libc.so", 800));
        lib.add(new File("libm.so", 150));
        
        //home디렉토리에 alice 디렉토리 추가
        home.add(alice);
        alice.add(new File("note.txt", 10));
        alice.add(new File("lib_memo.txt", 8));
        alice.add(new File("lib_memo.tmp", 20));
        
        // 전체 트리 출력
        System.out.println("===== 전체 트리 =====");
        root.printList();

        System.out.println("\n===== \"lib\" 검색 결과 =====");
        for (Entry e : root.search("lib")) {
            System.out.println(e.getFullName());
        }

        System.out.println("\n===== \"exe\" 검색 결과 =====");
        for (Entry e : root.search("exe")) {
            System.out.println(e.getFullName());
        }

        System.out.println("\n===== \"tmp\" 검색 결과 =====");
        List<Entry> result = root.search("tmp");
        for (Entry e : result) {
            System.out.println(e.getFullName());
        }
    }
}
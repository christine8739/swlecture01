package practice.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry { // Entry는 부모타입, Directory는 자식타입
    private String name;
    private List<Entry> directory = new ArrayList<>(); // 자식을 보관하는 리스트; Entry : 부모타입( Dirextory와 FIle 모두를 담을 수 있음)

    public Directory(String name) { // 디렉터리 이름을 설정한다
        this.name = name;
    }

    @Override
    public String getName() { // 디렉터리의 이름을 반환한다
        return name;
    }

    @Override
    public int getSize() { // 모든 자식의 크기를 더함
        int size = 0;
        for (Entry entry: directory) { // 형식 (원소 변수 : 컬렉션)
            size += entry.getSize(); // 재귀적 호출 
        }
        return size; 
    }

    @Override
    protected void printList(String prefix) { // 이 디렉터리의 이전 경로
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);// 이 폴더까지 포함한 경로를 자식에게 전달
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}

package hw.ch06.framework;

import java.util.HashMap;

public class Manager {
    //이름(string)과 Product 객체를 저장하는 맵
    private HashMap<String, Product> showcase = new HashMap<>();

    //prototype 등록을 이름과 함께 등록하는 메ㅓ드
    public void register(String name, Product proto){
        showcase.put(name, proto);
    }

    // 등록된 prototype을 복제하여 생성
    //new로 직접 생성하지 않고, 복사하는것이 핵심
    public Product create(String protoname){
        Product p = showcase.get(protoname);
        return p.createCopy();  // clone()으로 복사본 반환
    }
}

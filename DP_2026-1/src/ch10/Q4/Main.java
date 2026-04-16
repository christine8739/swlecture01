package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서(오름차순)
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        }); // Comparator 객체를 넣어주려함
    
        System.out.println(list);

        // 사전순으로 큰 순서 
        list.sort( /* 미구현 */ );
        System.out.println(list);
    }
}

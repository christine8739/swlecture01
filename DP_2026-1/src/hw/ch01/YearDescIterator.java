package hw.ch01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class YearDescIterator implements Iterator<Book> {
    private Book[] sorted; // 내림차순 베열
    private int index; //현재 순회중인 위치 

    public YearDescIterator(BookShelf bookShelf) {
        // 책꽂이의 책들을 복사하여 새로운 배열에 저장 bookShelf의 책들을 복사하여 새로운 배열에 저장
        this.sorted = new Book[bookShelf.getLength()];
        // 책꽂이의 책들을 복사하여 새로운 배열에 저장
        for (int i = 0; i < bookShelf.getLength(); i++) {
            sorted[i] = bookShelf.getBookAt(i);
        }
        // 출판연도를 기준으로 내림차순 정렬 (최신->오래된 순서)
        Arrays.sort(sorted, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                // 내림차순 정렬: b2의 연도가 b1의 연도보다 크면 양수, 같으면 0, 작으면 음수 반환
                return Integer.compare(b2.getYear(), b1.getYear());
            }
        });
        // 순회 시작 위치 초기화
        this.index = 0;
    }
    @Override
    public boolean hasNext(){
        // 아직 순회할 책 남아있음 -t,없으면 -f
        return index < sorted.length;
    }
    @Override 
    public Book next() {
        // 현재 위치의 책 반환 후 다음 위치로 이동
        Book book = sorted[index];
        index++;
        return book;
    }

}

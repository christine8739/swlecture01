package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //무조건 앞에 내 학번과 이름 넣기
        System.out.println("학번: 20240886 이름: 임수영");

        // 책 테스트
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));

        // 명시적으로 Iterator를 사용하는 방법 
        Iterator<Book> it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println();

        // 확장 for문을 사용하는 방법 
        for (Book book: bookShelf) {
            System.out.println(book.getName());
        }
        System.out.println();

        // 책 데이터 추가( 기존책 있던거 없애면 이상해질것같아서 그냥 추가했어요)
        BookShelf shelf = new BookShelf(10);
        shelf.appendBook(new Book("클린코드","기술",2008,30000));
        shelf.appendBook(new Book("해리포터와 마법사의 돌","소설",1997,15000));
        shelf.appendBook(new Book("사피엔스","역사",2011,18000));
        shelf.appendBook(new Book("이펙티브 자바","기술",2018,36000));
        shelf.appendBook(new Book("객체지향의 사실과 오해","기술",2015,20000));
        shelf.appendBook(new Book("레미제라블","소설",1862,12000));
        shelf.appendBook(new Book("총균쇠","역사",1997,22000));
        shelf.appendBook(new Book("리팩터링","기술",2018,34000));
        shelf.appendBook(new Book("로마인 이야기","역사",1992,25000));
        shelf.appendBook(new Book("어린왕자","소설",1943,9000));

        //4-2 장르 필터 iterator를 테스트 -소설 장르만출력
        System.out.println("소설 장르의 책들:");
        Iterator<Book> genreIt = shelf.genreIterator("소설");
        while (genreIt.hasNext()) {
            Book book = genreIt.next();
            System.out.printf("제목: %-20s 장르: %s 출판연도: %d 가격: %.0f원%n",
                book.getName(), book.getGenre(), book.getYear(), book.getPrice());
        }
        System.out.println();

        //4-3 출판연도 역순 iterator 테스트 -출판연도 내림차순으로 출력
        System.out.println("=== 출판연도 역순 책 목록 ===");
        Iterator<Book> yearIt = shelf.yearDescIterator();
        while (yearIt.hasNext()) {
            Book book = yearIt.next();
            System.out.printf("제목: %-20s 장르: %s 출판연도: %d 가격: %.0f원%n",
                book.getName(), book.getGenre(), book.getYear(), book.getPrice());
        }
    }   
}

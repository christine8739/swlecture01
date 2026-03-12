package practice.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books; //배열 선언
    private int last = 0; //책의 마지막 위치 

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; // 배열 생성
    }

    public Book getBookAt(int index) { // 책을 가져오는 메소드
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book; // 책을 추가하는 메소드 
        last++;
    }

    public int getLength() { //책의 개수를 반환하는 메소드
        return last;
    }

    @Override
    public Iterator<Book> iterator() { //자기 자신(현쟈 챶꽂이)의 iterator를생성해서  반환하는 메소드
        return new BookShelfIterator(this); //this : 현재 객체(책꽂이)를 가리킴 
    }
}

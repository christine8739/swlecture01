package hw.ch01;

import java.util.Iterator;

public class GenreIterator implements Iterator<Book> { //인터페이스 구현 , hasNext(), next() 메소드 구현해야함
    private BookShelf bookShelf; //책꽂이
    private String genre; //찾고자 하는 장르
    private int index = 0; //현재 책꽂이에서 검사하고 있는 위치

    public GenreIterator(BookShelf bookShelf, String genre) {
        this.bookShelf = bookShelf;
        this.genre = genre;
        this.index = 0;
    }
    @Override
    public boolean hasNext() { //while문으로 책꽂이 끝까지 검사 하면서 있으면 t,없으면 f
        while (index < bookShelf.getLength()) {
            Book book = bookShelf.getBookAt(index);
            if (book.getGenre().equals(genre)) {
                return true;
            }
            index++;
        }
        return false;
    }
    @Override
    public Book next() { //제대로 다음요소를 반환할 수 있도록 hasNext()에서 검사한 위치에서 장르가 일치하는 책을 반환하도록 구현
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}

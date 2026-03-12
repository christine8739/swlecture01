package practice.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index; // 현재 위치를 나타내는 인덱스,변수

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) { // 책꽂이에 남아있는 책이 있는지 확인하는 메소드
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) { // 다음 요소가 없는 경우 예외를 던지는 메소드
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}

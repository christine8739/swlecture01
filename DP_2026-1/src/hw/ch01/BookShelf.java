package hw.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
    // 장르 필터 iterator 얻어오는 메소드
    public Iterator<Book> genreIterator(String genre) {
        return new GenreIterator(this, genre);
    }
    // 출판연도 내림차순 iterator 얻어오는 메소드
    public Iterator<Book> yearDescIterator() {
        return new YearDescIterator(this);
    }
}

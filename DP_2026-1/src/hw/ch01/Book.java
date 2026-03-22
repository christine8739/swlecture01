package hw.ch01;

public class Book {
    private String name;
    private String genre; // 장르: 소설,과학,역사,기술등
    private int year; //출판연도(예:2008)
    private double price; //가격(단위:원,예:20000,0)

    //원래 있던거
    public Book(String name) {
        this.name = name;
    }
    //새로 추가- name은 앞에 있지만 또 넣은 이유는 오버로딩때문에 
    public Book(String name, String genre, int year, double price) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getGenre() {
        return genre;
    }
    public int getYear() {
        return year;
    }
    public double getPrice() {
        return price;
    }
}

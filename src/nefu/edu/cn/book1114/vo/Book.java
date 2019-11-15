package nefu.edu.cn.book1114.vo;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class Book {

    Integer isbn;
    String bookName;
    Integer price;
    public Book(){

    }

    public Book(Integer isbn,String bookName, Integer price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

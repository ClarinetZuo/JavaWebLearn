package nefu.edu.cn.book_curd.dao;

import com.oracle.jdbc.util.Dao;
import nefu.edu.cn.book_curd.vo.Book;

import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class BookDao {

    public List<Book> getAll(){
        return Dao.query("select * from book order by isbn",Book.class);
    }

    public void save(Integer isbn,String bookName,String price){
        Dao.executeSql("insert into book values (?,?,?)",isbn,bookName,price);
    }

    public void delete(Integer isbn){
        Dao.executeSql("delete from book where isbn=?",isbn);
    }

    public Book getBookById(Integer isbn){
        return Dao.queryOne("select * from book where isbn=?",Book.class,isbn);
    }

    public void update(Book book){
        Dao.executeSql("update book set bookName=?,price=? where isbn=?",book.getBookName(),book.getPrice(),book.getIsbn());
    }
}

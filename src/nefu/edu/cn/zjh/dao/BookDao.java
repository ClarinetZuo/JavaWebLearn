package nefu.edu.cn.zjh.dao;

import com.oracle.jdbc.util.Dao;
import nefu.edu.cn.zjh.vo.Book;

import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class BookDao {
    /**
      * @author ClarinetZuo
      * @use as 查询所有
      * @Date 2019/11/2 19:35
      */
    public List<Book> getAll(){
        return Dao.query("select * from book",Book.class);
    }

    public void save(Book book){
        Dao.executeSql("insert into book values (?,?,?)",book.getIsbn(),book.getBookName(),book.getPrice());
    }
}

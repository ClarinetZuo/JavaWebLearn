package nefu.edu.cn.book1114.dao;

import com.oracle.jdbc.util.Dao;
import nefu.edu.cn.book1114.vo.Book;
import nefu.edu.cn.util.PageInfo;

import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class BookDao {

    public List<Book> getAll(){
        return Dao.query("select * from book order by isbn",Book.class);
    }
    /**
      * @author ClarinetZuo
      * @use as 分页查询
      * @Date 2019/11/19 14:43
      */
    public void getBooksForPage(PageInfo pageInfo){
        List list = Dao.query("select * from book order by isbn limit ?,?",Book.class,(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize(),pageInfo.getPageSize());
        pageInfo.setList(list);
        Long count = (Long) Dao.queryOne("select count(*) from book")[0];
        pageInfo.setRecordCount(count.intValue());
    }

    public Book getBookById(Integer isbn){
        return Dao.queryOne("select * from book where isbn=?",Book.class,isbn);
    }

    public void save(Book book){
        Dao.executeSql("insert into book values(?,?,?)",book.getIsbn(),book.getBookName(),book.getPrice());
    }

    public void update(Book book){
        Dao.executeSql("update book set bookName=?,price=? where isbn=?",book.getBookName(),book.getPrice(),book.getIsbn());
    }

    public void delete(Integer[] isbns){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < isbns.length; i++) {
            stringBuffer.append("?");
            if (i < isbns.length-1){
                stringBuffer.append(",");
            }
        }
        Dao.execute("delete from book where isbn in("+stringBuffer+")",isbns);
    }


}

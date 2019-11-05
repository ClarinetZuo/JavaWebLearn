package nefu.edu.cn.exer.dao;

import com.oracle.jdbc.util.Dao;
import nefu.edu.cn.exer.vo.User;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class UserDao {

    public User getUser(String userName,String password){
        User user = Dao.queryOne("select * from user where userName=? and password=md5(?)",User.class,userName,password);
        return user;
    }
}

package nefu.edu.cn.book1114.dao;

import com.oracle.jdbc.util.Dao;
import nefu.edu.cn.book1114.vo.User;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class UserDao {
    /*
        下面两个方法，组合起来，是一次登录
     */
    public User getUser(String userName,String password){
        return Dao.queryOne("select * from user where userName=? and password=md5(?)",User.class,userName,password);
    }
    /**
      * @author ClarinetZuo
      * @use as 登录成功后，登录次数+1，最后一次登录时间为当前时间
      * @Date 2019/11/15 14:28
      */
    public void updateUserLoginCount(Integer userId){
        Dao.executeSql("update user set loginCount=loginCount+1,lastDate=now() where userId=?",userId);
    }

}

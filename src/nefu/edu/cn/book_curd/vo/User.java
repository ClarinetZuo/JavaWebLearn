package nefu.edu.cn.book_curd.vo;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class User {

    private Integer userId;
    private String userName;
    private String password;
    private String realName;
    public User(){

    }

    public User(Integer userId, String userName, String password, String realName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}

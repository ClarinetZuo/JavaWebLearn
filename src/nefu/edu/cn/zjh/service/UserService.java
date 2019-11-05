package nefu.edu.cn.zjh.service;

import java.util.HashMap;
import java.util.Map;

/**
 * author:Zuo Junhao
 * NEFU
 */
public class UserService {

    static Map<String,String> map = new HashMap<>();
    /*
    模拟一个内存数据库
     */
    static {
        map.put("Tom","111");
        map.put("Jerry","222");
        map.put("Tiger","333");
        map.put("Simon","444");
    }

    public boolean login(String userName,String password){
        if (map.containsKey(userName) && map.get(userName).equals(password)){
            return true;
        }else {
            return false;
        }
    }
}

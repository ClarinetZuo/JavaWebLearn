package nefu.edu.cn.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Zuo Junhao
 * NEFU
 * 封装所有分页数据的类；这个类是通用的
 */
public class PageInfo {
    // 查询数据
    List<Object> list = new ArrayList<>();
    // 当前页
    int currentPage = 1;
    // 总记录数
    int recordCount = 0;
    // 每页记录数
    int pageSize = 10;

    String url = null;

    public PageInfo(HttpServletRequest request){
        if (request.getParameter("currentPage") != null){
            // 设置当前页，看请求中是否有这个参数
            this.currentPage = Integer.valueOf(request.getParameter("currentPage"));
        }
        // url不变
        this.url = request.getRequestURL().toString();
        request.setAttribute("pageInfo",this);
    }
    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    /**
      * @author ClarinetZuo
      * @use as 获得总页数=总记录数/每页记录数
      * @Date 2019/11/19 14:29
      */
    public int getPageCount(){
        return this.recordCount % this.pageSize == 0 ? this.recordCount/this.pageSize : this.recordCount/this.pageSize + 1;
    }
}

# BookCURD的demo
## 登录
- 定义User的VO
- 定义Dao
- 定义登录页login.html
- 定义一个UserServlet
## 查询图书列表
- 定义Dao的查询方法
- 定义BookListServlet
## 添加新图书
- 定义Dao的添加方法
- 定义addBook.html网页
- 定义AddBookServlet
## 删除图书
- 定义Dao的删除方法
- 在列表中增加a标记；<a href='deleteBook.do?isbn="+...+"'>
- 定义DeleteBookServlet类
## 修改图书
### 编辑
- 定义Dao的查询和修改方法
- 在列表页增加编辑的超链接
### 修改
- 修改时，isbn不能随意修改，在标签中可以使用hidden隐藏，因为暴露给用户没有意义
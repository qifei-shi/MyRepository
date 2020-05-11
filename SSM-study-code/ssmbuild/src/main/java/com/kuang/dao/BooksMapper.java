package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBooks(@Param("bookId") int id);

    //更新一本书
    int updateBooks(Books books);

    //查询一本书
    Books queryBookById(@Param("bookId") int id);

    //查询全部的书
    List<Books> queryAllBook();

    //搜索框
    Books queryBookName(@Param("bookName") String bookName);

}

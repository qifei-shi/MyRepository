package com.kuang.service;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooksService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBooks(int id);

    //更新一本书
    int updateBooks(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    //搜索框
    Books queryBookName(String bookName);
}

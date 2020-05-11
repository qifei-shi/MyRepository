package com.kuang.service;

import com.kuang.dao.BooksMapper;
import com.kuang.pojo.Books;

import java.util.List;

public class BooksServiceImpl implements BooksService{

    //service调dao层: 组合Dao
    private BooksMapper booksMapper;

    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books books) {
        return booksMapper.addBook(books);
    }

    @Override
    public int deleteBooks(int id) {
        return booksMapper.deleteBooks(id);
    }

    @Override
    public int updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }

    @Override
    public Books queryBookName(String bookName) {
        return booksMapper.queryBookName(bookName);
    }
}

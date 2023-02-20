package com.test.service;

import com.test.model.Book;
import com.test.util.PageBean;

import java.util.List;

public interface IBookService {
    int save(Book book);

    Book selectSingle(Long bookid);

    List<Book> queryByPage(Book book, PageBean pageBean);
}

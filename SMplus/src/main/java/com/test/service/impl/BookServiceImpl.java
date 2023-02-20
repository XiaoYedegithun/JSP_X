package com.test.service.impl;

import com.test.mapper.BookMapper;
import com.test.model.Book;
import com.test.service.IBookService;
import com.test.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    BookMapper bookMapper;
    public int save(Book book) {
        return bookMapper.insertSelective(book);
    }

    public Book selectSingle(Long bookId) {
        return bookMapper.selectSingle(bookId);
    }

    public List<Book> queryByPage(Book book, PageBean pageBean) {
        return bookMapper.list(book);
    }
}

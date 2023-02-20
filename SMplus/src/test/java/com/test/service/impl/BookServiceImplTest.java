package com.test.service.impl;

import com.test.model.Book;
import com.test.service.IBookService;
import com.test.util.PageBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BookServiceImplTest {

    private Book book;
    @Autowired
    private IBookService bookService;

    private PageBean pageBean;
    @Before
    public void setUp() throws Exception {
        pageBean = new PageBean();
        book = new Book();
    }

    @Test
    public void save() {
        book.setBookName("三体");
        book.setBookNamePinyin("santi");
        book.setPublishing("人民教育出版社");
        book.setBookPrice(88f);
        book.setBookCategoryId(1l);
        book.setBookDesc("描述外星文明入侵地球");
        book.setBookAuthor("刘慈欣");
        int n = bookService.save(book);
        System.out.println(n);
    }

    @Test
    public void selectSingle() {
        book.setBookId(392l);
        Book b = bookService.selectSingle(book.getBookId());
        System.out.println(b);
    }

    @Test
    public void queryByPage() {
        List<Book> b = bookService.queryByPage(book, pageBean);
        for (Book b1 : b) {
            System.out.println(b1);
        }
    }
}
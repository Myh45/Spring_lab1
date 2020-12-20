package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private BookDao fakeBookRepos;

    @Autowired
    public BookService(@Qualifier("fakeDB") BookDao fakeBookRepos){
        this.fakeBookRepos=fakeBookRepos;
    }

    public int addBook(Book book){
        return fakeBookRepos.insertBook(book);
    }

    public List<Book> getAllBooks(){
        return fakeBookRepos.sellectAllBooks();
    }

    public Optional<Book> getBookById(UUID id){
        return fakeBookRepos.selectBookById(id);
    }

    public int deleteBook(UUID id){
        return fakeBookRepos.deleteBookById(id);
    }

    public int updateBook(UUID id, Book newBook){
        return fakeBookRepos.updateBookById(id, newBook);
    }
    public int deleteAllBooks()
    {
        return  fakeBookRepos.deleteAllBooks();
    };
    public Optional<Book> getBookByAuthor(String author) {
        return fakeBookRepos.selectByAuthor(author);
    }
    public Optional<Book> getBookByPublishing(String publishing) {
        return fakeBookRepos.selectByPublishing(publishing);
    }

}

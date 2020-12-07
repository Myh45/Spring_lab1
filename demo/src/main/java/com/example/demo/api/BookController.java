package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
        System.out.println("test of add method");
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") UUID id){
        return bookService.getBookById(id)
                .orElse(null);
    }

    @DeleteMapping(path="{id}")
    public void deleteBookById(@PathVariable("id") UUID id){
        bookService.deleteBook(id);
    }

    @PutMapping(path="{id}")
    public void updateBook(@PathVariable("id") UUID id, @RequestBody Book bookToUpdate){
        bookService.updateBook(id, bookToUpdate);
    }


}

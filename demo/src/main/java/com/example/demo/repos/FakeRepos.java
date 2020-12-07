package com.example.demo.repos;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Qualifier("fakeDB")
public class FakeRepos implements BookDao {
    private List<Book> booksDB=new ArrayList<>();


    @Override
    public int insertBook(UUID id,Book book) {
        booksDB.add(new Book(id,book.getTitle(),book.getAuthor(),book.getYear(),book.getPublishing(),book.getPageCount()));
        return 0;
    }

    @Override
    public List<Book> sellectAllBooks() {
        return booksDB;
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        return booksDB.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> bookMaybe = selectBookById(id);
        if(bookMaybe.isEmpty()){
            return 0;
        }
        booksDB.remove(bookMaybe.get());
        return 1;
    }

    @Override
    public int updateBookById(UUID id, Book update) {
        return selectBookById(id)
                .map(book -> {
                    int indexOfBookToUpdate = booksDB.indexOf(book);
                    if(indexOfBookToUpdate>=0){
                        booksDB.set(indexOfBookToUpdate,new Book(id,
                                book.getTitle(),
                                book.getAuthor(),
                                book.getYear(),
                                book.getPublishing(),
                                book.getPageCount()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}

package com.example.SpringHomework_4.exercise10.mysolution.service;

import com.example.SpringHomework_4.exercise10.mysolution.exception.BookException;
import com.example.SpringHomework_4.exercise10.mysolution.module.Book;
import com.example.SpringHomework_4.exercise10.mysolution.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(final BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAllBooks(){
        return booksRepository.findAll();
    }

    public Book addBook(Book book){
        book.setId(null);
        return booksRepository.save(book);
    }

    public void updateBook(Long id, Book book){
        Book updatableBook = booksRepository.findBookById(id)
                .orElseThrow(() -> new BookException("Book with id " + id + " doesn't exist."));

        updatableBook.setTitle(book.getTitle());
        updatableBook.setAuthor(book.getAuthor());
        updatableBook.setISBN(book.getISBN());
        updatableBook.setPagesNum(book.getPagesNum());

        booksRepository.save(updatableBook);
    }

    public void deleteBookById(Long id){
        booksRepository.findBookById(id)
                .orElseThrow(() -> new BookException("Book with id " + id + " doesn't exist."));
        booksRepository.deleteById(id);
    }

    public List<Book> findAllByTitle(String title){
        return booksRepository.findAllByTitle(title);
    }

    public List<Book> findBookByIsbnIsAfter(String isbn){
        List<Book> bookList = booksRepository.findBookByISBNIsAfter(isbn);
        return bookList.stream().limit(1).collect(Collectors.toList());
    }

    public List<Book> findBooksByPagesNumBetween(Integer minimumPages, Integer maximumPages){
        return booksRepository.findBooksByPagesNumBetween(minimumPages, maximumPages);
    }

    public List<Book> findThreeBooksByAuthorOrderByPagesNumDesc(String author){
        List<Book> bookList = booksRepository.findBookByAuthorOrderByPagesNumDesc(author);
       return bookList.stream().limit(3).collect(Collectors.toList());
    }

    public List<Book> findBookByTitleIsStartingWith(String firstLetter){
        return booksRepository.findBookByTitleIsStartingWith(firstLetter);
    }

    public Book findBookByAuthorAndIsbn(String author, String isbn){
        return booksRepository.findBookByAuthorAndISBN(author, isbn);
    }
}

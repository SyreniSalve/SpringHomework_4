package com.example.SpringHomework_4.exercise10.mysolution.repository;

import com.example.SpringHomework_4.exercise10.mysolution.module.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BooksRepository extends JpaRepository<Book, Long> {


    Optional<Book> findBookById(Long id);

    List<Book> findAllByTitle(String title);

    List<Book> findBookByISBNIsAfter(String ISBN);

    Book findBookByAuthorAndISBN(String author, String ISBN);

    List<Book> findBookByAuthorOrderByPagesNumDesc(String author);

    List<Book> findBookByTitleIsStartingWith(String firstLetter);

    List<Book> findBooksByPagesNumBetween(Integer minimumPages, Integer maximumPages);
}

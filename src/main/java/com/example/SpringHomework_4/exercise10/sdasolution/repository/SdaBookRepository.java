package com.example.SpringHomework_4.exercise10.sdasolution.repository;

import com.example.SpringHomework_4.exercise10.sdasolution.module.SdaBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SdaBookRepository extends JpaRepository<SdaBook, Long> {

    List<SdaBook> findAllByTitle(String title);
    Optional<SdaBook> findFirstByISBN(String isbn);
    Optional<SdaBook> findAllByTitleAndAuthor(String title, String author);
    List<SdaBook> findTop3ByAuthorOrderByPagesNumDesc(String author);
    List<SdaBook> findAllByTitleStartingWith(String titleStart);
    List<SdaBook> findAllByPagesNumBetween(Integer minPages, Integer maxPages);

    @Query("SELECT b FROM sda_books b WHERE b.pagesNum >= :pagesNum")
    List<SdaBook> findWherePagesNumIsGreaterThanX(@Param("pagesNum")Integer pagesNum);
}

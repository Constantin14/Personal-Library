package com.project.MyLibrary.repositories;

import com.project.MyLibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByYear(Integer year);
    @Query(value = "select * from book b where b.year = ?1 and b.id_user_account = ?2", nativeQuery = true)
    Optional <List<Book>> findAllBooksByYearAndIdUserAccount(Integer year, Integer userId);
    @Query(value = "select * from book b where b.is_read = ?1 and b.id_user_account = ?2", nativeQuery = true)
    Optional <List<Book>> findAllBooksByIsReadAndIdUserAccount(Boolean isRead, Integer userId);
    @Query(value = "select * from book b where b.id_user_account = ?1", nativeQuery = true)
    Optional <List<Book>> findAllBooksByUserAccount(Integer userId);

}

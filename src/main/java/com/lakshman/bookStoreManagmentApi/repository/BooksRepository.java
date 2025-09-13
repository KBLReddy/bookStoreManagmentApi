package com.lakshman.bookStoreManagmentApi.repository;

import com.lakshman.bookStoreManagmentApi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}

package com.lakshman.bookStoreManagmentApi.service;

import com.lakshman.bookStoreManagmentApi.dto.BookDto;
import com.lakshman.bookStoreManagmentApi.dto.BookResponseDto;
import com.lakshman.bookStoreManagmentApi.entity.Book;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.BookCreationException;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.ResourceNotFoundException;
import com.lakshman.bookStoreManagmentApi.repository.BooksRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BooksRepository booksRepository;
    @Transactional
    public BookResponseDto createBook(BookDto bookDto) {
        try {
            Book book = new Book();
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPrice(bookDto.getPrice());
            book.setStock(bookDto.getStock());
            booksRepository.save(book);

            return mapToDto(book);
        } catch (DataIntegrityViolationException e) {
            throw new BookCreationException("Book with the same title and author already exists");
        }

    }
    public List<BookResponseDto> getAllBooks() {
        return booksRepository
                .findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }
    public BookResponseDto getBookById(Long bookId) {
        try {
            Book book = booksRepository.getReferenceById(bookId);
            return new BookResponseDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getStock());
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");

        }
    }
    @Transactional
    public BookResponseDto updateBook(Long id,BookDto bookDto) {
        try {
            Book book = booksRepository.getReferenceById(id);
            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPrice(bookDto.getPrice());
            book.setStock(bookDto.getStock());
            booksRepository.save(book);
            return new BookResponseDto(
                    book.getId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getStock()
            );
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Can't update, Book not found");
        }
    }
    @Transactional
    public BookResponseDto deleteBookById(Long bookId) {
        try {
            BookResponseDto bookDto = getBookById(bookId);
            booksRepository.deleteById(bookId);
            return bookDto;

        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Can't delete, Book not found");
        }
    }
    private BookResponseDto mapToDto(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock()
        );
    }

}

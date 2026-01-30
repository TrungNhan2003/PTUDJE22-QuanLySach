package com.example.PhatTrienUngDungJ2EE.bai2.Controller;

import com.example.PhatTrienUngDungJ2EE.bai2.Model.Book;
import com.example.PhatTrienUngDungJ2EE.bai2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    // Lấy danh sách tất cả các sách
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    // Lấy sách theo ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    // Thêm sách mới
    @PostMapping
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully!";
    }
    
    // Cập nhật thông tin sách
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "Book updated successfully!";
    }
    
    // Xóa sách theo ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully!";
    }
}

package com.example.mapper;

import com.example.demo.entities.Book;
import com.example.dto.BookDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookMapperTest {
    @Test
    public void testUpdateBookFromDTO() {
        BookDTO dto = new BookDTO();
        dto.setId(-1l);
        dto.setAuthor("John Doe");
        dto.setTitle("Star Galaxy");
        Book book = new Book();
        BookMapper.INSTANCE.updateBookFromDto(dto, book);
        assertEquals(book.getAuthor(), "John Doe");
        assertEquals(book.getTitle(), "Star Galaxy");
        assertNull(book.getId());
    }
}

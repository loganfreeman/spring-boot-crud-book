package com.example.demo.mapper;

import com.example.demo.entities.Book;
import com.example.demo.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateBookFromDto(BookDTO bookDTO, @MappingTarget Book book);
}

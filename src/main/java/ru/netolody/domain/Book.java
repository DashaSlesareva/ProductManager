package ru.netolody.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor

public class Book extends Product {
    private String author;

    public Book (int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

}

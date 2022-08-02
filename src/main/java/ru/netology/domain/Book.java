package ru.netology.domain;

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

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        }
        return false;
    }

}

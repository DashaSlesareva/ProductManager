package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    protected int id;
    protected String title;
    protected int price;

    public boolean matches(String search) {
        if (title.contains(search)) {
            return true;
        }
        return false;
    }

}

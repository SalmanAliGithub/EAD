package com.example.bookstore.Task_2;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

// Class to test DB intries

@Getter
@Setter
@NoArgsConstructor
public class Test_Books {
    private int id;
    private String title;
    private String author;
    private int price;

    public Test_Books(int id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

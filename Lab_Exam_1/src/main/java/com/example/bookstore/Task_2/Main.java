//Name: Salman Ali Abdurahman
//ID: UGR/7808/14


package com.example.bookstore.Task_2;

// This is the main class to verify that our dependendenies and coded class works
public class Main {
    public static void main(String[] args) {
        Test_Books book = new Test_Books();
        book.setId(1);
        book.setTitle("Book tile 1");
        book.setAuthor("Salman Ali");
        book.setPrice(10);

        System.out.println("Book ID: " + book.getId());
        System.out.println("Book title: " + book.getTitle());
        System.out.println("Book author: " + book.getAuthor());
        System.out.println("Book pricee: " + book.getPrice());
    }
}

package com.aiwenbin.exam.Exam02;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }
    public static List<String> getAuthorAllBooKName(List<Book> books, String authorName) {
         return books.stream()
                .filter(book -> book.getAuthor().equals(authorName))
                 .map(Book::getBookName)
                .collect(Collectors.toList());
    }

    public static List<String> getAllBookNameOrderByPrice(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getCount))
                .map(Book::getBookName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<Book>> getMap(List<Book> books) {
        return books.stream()
                .collect(Collectors.toMap(Book::getPublish, bookList -> books));
    }
}

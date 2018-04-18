package com.example.akbar.book_ing;

/**
 * Created by Akbar on 4/14/2018.
 */
public class Book {

    String bookName;
    String authorName;
    String courseName;
    String year;
    String subjectName;
    String bookPrice;
    String bookKey;
    boolean sold;

    public Book()
    {

    }

    public Book(String bookName, String authorName, String courseName, String year, String subjectName, String bookPrice,boolean sold) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.courseName = courseName;
        this.year = year;
        this.subjectName = subjectName;
        this.bookPrice = bookPrice;
        this.sold=sold;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getYear() {
        return year;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public String getBookKey() {
        return bookKey;
    }

    public boolean isSold() {
        return sold;
    }

    public void setBookKey(String bookKey) {
        this.bookKey = bookKey;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}

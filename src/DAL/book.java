/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author msrel
 */
public class book {
    public int BookID;
    public String BookName;
    public String BookAuthor;
    public int BookCategoryID;

    public book() {
    }

    public book(int BookID, String BookName, String BookAuthor, int BookCategoryID) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.BookAuthor = BookAuthor;
        this.BookCategoryID = BookCategoryID;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }

    public int getBookCategoryID() {
        return BookCategoryID;
    }

    public void setBookCategoryID(int BookCategoryID) {
        this.BookCategoryID = BookCategoryID;
    }
    
    
}

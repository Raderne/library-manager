/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DAL.BookCategory;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author msrel
 */
public class BooksService {
    public ArrayList<BookCategory> getAllBooksCategories(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement("Select Category");
        Statement stm = null;
        String query = "select categoryID, categoryName from bookscategory";
        ArrayList<BookCategory> bookCategoryList = new ArrayList<>();
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            BookCategory newBook;
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                newBook = new BookCategory(id, name);
                
                bookCategoryList.add(newBook);
                
                model.addElement(name);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                stm.close();
                }
            } catch (SQLException e) {
            }
            
        }
        
        return bookCategoryList;
    }
    
    public DefaultTableModel getAllBooks(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        
        String query = "select BookID, BookName, BookAuthor, BookCategoryID from books";
        ArrayList<DAL.book> bookList = new ArrayList<>();
        Statement stm = null;
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                int categoryID = rs.getInt(4);
                String categoryName = GetCategoryName(categoryID);
                
                model.addRow(new Object[] {id, name, author, categoryName});
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             try {
                if (stm != null) {
                stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return model;
    }
    
    public String GetCategoryName(int id) {
        String query = "select categoryName from bookscategory where categoryID=?";
        String name = "";
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = con.createStatement();
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();
            if (!rs.next()) return "null";
            name = rs.getString(1);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return name;
    }
    
    public void Ekleme(String name, String author, int categoryID) {
        String query = "insert into books(BookName, BookAuthor, BookCategoryID) values(?, ?, ?)";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = con.createStatement();
            PreparedStatement preparedStm = con.prepareStatement(query);
            preparedStm.setString(1, name);
            preparedStm.setString(2, author);
            preparedStm.setInt(3, categoryID);
            
            boolean val = preparedStm.execute();
            
            if (val == true) {
                new Mesajlar().Success("not added");
            }else{
                new Mesajlar().Success(name + " added");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(int id, String name, String author, int categoryID) {
        String query = "update books set BookName=?, BookAuthor=?, BookCategoryID=? where BookID=?";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement(query);
            
            pstm.setString(1, name);
            pstm.setString(2, author);
            pstm.setInt(3, categoryID);
            pstm.setInt(4, id);
            
            boolean val = pstm.execute();
            if (val == true) {
                new Mesajlar().Success("not updated");
            }else{
                new Mesajlar().Success(name + " updated");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Delete(int id) {
        String query = "delete from books where BookID=?";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = con.createStatement();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            
            boolean val = pstm.execute();
            if (val == true) {
                new Mesajlar().Success("not deleted");
            }else{
                new Mesajlar().Success("deleted");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

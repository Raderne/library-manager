/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author msrel
 */
public class BookCategoryService {
    public DefaultTableModel getAllCategoryNames(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stm = null;
        String query = "select categoryID, categoryName from bookscategory order by categoryID asc";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while (rs.next()) {
                int ID = rs.getInt(1);
                String name = rs.getString(2);
                
                model.addRow(new Object[] {ID, name});
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
               if(stm!=null){
                  stm.close();
               }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return model;
    }
    
    public void Ekleme(String name) {
        String query = "insert into bookscategory(categoryName) values(?)";
        
        try {
            Connection conn = new DBConnect().getConnectionDB();
            Statement stm = (Statement) conn.createStatement();
            PreparedStatement preparedStm = conn.prepareStatement(query);
            preparedStm.setString(1, name);
            
            boolean val = preparedStm.execute();
            if (val == false) {
                new Mesajlar().Success("category added");
            }else{
                new Mesajlar().Success("category not added");
            }
        } catch (SQLException e) {
            System.err.println(""+e.getMessage());
        }
    }
    
    public void Update(int id, String name) {
        String query = "update bookscategory set categoryName=? where categoryID=?";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStm = con.prepareStatement(query);
            preparedStm.setString(1, name);
            preparedStm.setInt(2, id);
            boolean val = preparedStm.execute();
            
            if (val == true) {
                new Mesajlar().Success("not updated");
            }else{
                new Mesajlar().Success("updated");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Delete(int id) {
        String query = "delete from bookscategory where categoryID=?";
        
        try {
            Connection con = new DBConnect().getConnectionDB();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preStm = con.prepareStatement(query);
            preStm.setInt(1, id);
            
            boolean val = preStm.execute();
            if (val == true) {
                new Mesajlar().Success("not deleted");
            }else{
                new Mesajlar().Success(id + " is deleted");
            }
        } catch (Exception e) {
        }
    }
}

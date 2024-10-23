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

/**
 *
 * @author msrel
 */
public class BookCategoryService {
    public void Ekleme(String name) {
        String query = "insert into bookscategory(categoryName) values(?)";
        
        try {
            Connection conn = new DBConnect().getConnectionDB();
            Statement stm = (Statement) conn.createStatement();
            PreparedStatement preparedStm = conn.prepareStatement(query);
            preparedStm.setString(1, name);
            
            boolean val = preparedStm.execute();
            if (val) {
                new Mesajlar().Success("category added");
            }else{
                new Mesajlar().Success("category not added");
            }
        } catch (Exception e) {
        }
    }
}

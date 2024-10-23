/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author msrel
 */
public class DBConnect {
    public Connection getConnectionDB() {
        Connection connect = null;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return connect;
    }
    
    public void closeDB(Connection baglanti) {
        try {
            if(baglanti != null) {
                baglanti.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}

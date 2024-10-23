/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import javax.swing.JOptionPane;

/**
 *
 * @author msrel
 */
public class Mesajlar {
    public String Success(String mesaj) {
        JOptionPane.showMessageDialog(null, mesaj);
        return mesaj;
    }
}

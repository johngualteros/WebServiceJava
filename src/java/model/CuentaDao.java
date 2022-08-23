/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author jhon fredy ospina ya
 */
public class CuentaDao {
    
    public Connection con;
    PreparedStatement preparedstatement;
    ResultSet resultset;
    String query = null;
    int root;
    boolean success = false;
    
    public int queryBalance(int numberAccount) throws SQLException {
        query = "SELECT * FROM `cuenta` WHERE numerocuenta =" + numberAccount;
        int saldo = 0;
        try {
            con = Conexion.connection();
            preparedstatement = con.prepareStatement(query);
            resultset = preparedstatement.executeQuery(query);
            while (resultset.next()) {
                CuentaVo accountVo = new CuentaVo();
                saldo = resultset.getInt("saldo");
                System.out.println(saldo);
            }
        } catch (Exception e) {
            System.out.println("no se encontro el numero de cuenta" + numberAccount + e.getMessage());
        } finally {
            con.close();
        }
        preparedstatement.close();
        return saldo;
    }
}

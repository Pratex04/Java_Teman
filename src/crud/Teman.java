/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Alvonso
 */
public class Teman {
    String nama; int id, umur;
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root"; String pass = "";
    Scanner cin = new Scanner(System.in);
    
    void showData(){
        try {
            String query = "SELECT * FROM teman;";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                System.out.println("");
                System.out.println("ID   : " + rs.getString("id"));
                System.out.println("Nama : " + rs.getString("name"));
                System.out.println("Umur : " + rs.getString("umur"));
            }
            System.out.println("");
            rs.close(); pst.close(); rs.close();
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan karena : " + e);
        }
    }
    
    void addData(){
        System.out.print("Masukan ID   : ");
        this.id = Integer.valueOf(cin.nextLine());
        System.out.print("Masukan Nama : ");
        this.nama = cin.nextLine();
        System.out.print("Masukan Umur : ");
        this.umur = Integer.valueOf(cin.nextLine());
        
        try {
            String query = "INSERT INTO teman VALUES (" + this.id + ", '" + this.nama + "', " + this.umur + ");";
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            System.out.println("Mantappp, Data berhasil disimpan..!!");
        } catch (Exception e) {
            System.err.println("Data gagal Disimpan karena : " + e);
        }
    }
    
    void delData(){
        System.out.print("Masukan ID [Del]: ");
        this.id = Integer.valueOf(cin.nextLine());
        
        try {
            String query = "DELETE FROM teman WHERE id=" + this.id + ";";
            Connection  con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Mantapp, Data berhasil di delete..!!");
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan karena : " + e);
        }
    }
    
    void updData(){
        System.out.print("Masukan ID [Upd]  : ");
        this.id = Integer.valueOf(cin.nextLine());
        System.out.print("Masukan Nama [Upd]: ");
        this.nama = cin.nextLine();
        System.out.print("Masukan Umur [Upd]: ");
        this.umur = Integer.valueOf(cin.nextLine());
        
        try {
            String query = "UPDATE teman SET name='" + this.nama + "', umur="+umur+" WHERE id=" + this.id +";";
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("Data berhasil di update..!!");
        } catch (Exception e) {
            System.err.println("Terjadi kegagalan karena : " + e);
        }
    }
}

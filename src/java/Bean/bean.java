/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Hashim
 */
@ManagedBean(name="bean")
@RequestScoped
public class bean 
{
    private String username;
    private String password;
    private String name;
    private String Gender;
    private int lis;
    private int phone;
    private int nid;
    private String address;
    private String email;
    private int credit;
    private CachedRowSet crs = null; 

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return Gender;
    }

    public int getLis() {
        return lis;
    }

    public int getPhone() {
        return phone;
    }

    public int getNid() {
        return nid;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getCredit() {
        return credit;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setLis(int lis) {
        this.lis = lis;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void add()
    {
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            crs = new CachedRowSetImpl();
            crs.setUrl("jdbc:derby://localhost:1527/Project");
            crs.setUsername("a");
            crs.setPassword("b");
            crs.setCommand("Insert into users(username, password, name, gender, license_number, phone, NID_number, address, email, card_number) values (?,?,?,?,?,?,?,?,?,?) ");
            crs.setString(1, username);
            crs.setString(2, password);
            crs.setString(3, name);
            crs.setString(4, Gender);
            crs.setInt(5, lis);
            crs.setInt(6, phone);
            crs.setInt(7, nid);
            crs.setString(8, address);
            crs.setString(9, email);
            crs.setInt(10, credit);
            crs.execute();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(bean.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(bean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

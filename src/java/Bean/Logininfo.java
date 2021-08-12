/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Hashim
 */
@ManagedBean(name="loginInfo")
@RequestScoped
public class Logininfo 
{
    private CachedRowSet crs = null;
    private String username;
    private String password;
    private boolean valid;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid() {
        return valid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Logininfo() 
    {
        try 
        {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/Project");
            crs.setUsername("a");
            crs.setPassword("b");
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Logininfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean getCheck() throws SQLException
    {
        crs.setCommand("select * from USERS where USERNAME = ?");
        String pass;
        crs.setString(1, username);
        crs.execute();
        while (crs.next()) 
        {
            if (crs.getString("username").equals(username))
            {
                pass = crs.getString("password");
                System.out.println(pass);
                System.out.println(password);
                if(pass.equalsIgnoreCase(password)) 
                {
                    System.out.println("VALIIDDDDDDDDD");
                        valid = true;
                }
                else
                    valid = false;
            }
       }
        return valid;
    }
    
    
}

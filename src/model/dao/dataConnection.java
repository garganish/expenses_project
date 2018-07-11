/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utility.configration;

/**
 *
 * @author anishgarg
 */
public class dataConnection {
    private static Connection cc;
    private dataConnection()
    {
        
    }
    public static Connection getConnection() throws Exception
    {
        if(cc==null)
        {
            Class.forName(configration.driver_name);
            cc= DriverManager.getConnection(configration.db_url, configration.db_user, configration.db_pass);
        }
        return cc;
    }
    public static void closeConnection()
    {
        
            try
            {
                if(cc!=null)
               {
                cc.close();
                }
                cc=null;
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }
        }
    public static PreparedStatement getStatement(String query) throws Exception
    {
        return getConnection().prepareStatement(query);
    }
    }


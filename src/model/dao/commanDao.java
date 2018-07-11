/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.to.expensesinfoTo;
import utility.errorHandler;

/**
 *
 * @author anishgarg
 */
public class commanDao {
     public static String errormessage;
    public static String getErrormessage()
    {
        return errormessage;
    }
    public static int generateId()
    {
        int id=0;
        try
        {
        String query="select last_insert_id()";
        PreparedStatement smt= dataConnection.getStatement(query);
            //expensesinfoTo result=null;
            ResultSet rs=smt.executeQuery();
            if(rs.next())
            {
                id = rs.getInt(1);
            }
            rs.close();
            smt.close();
        }
        catch(Exception ex)
        {
            errorHandler.printStackTrace(ex);
        }
        return id;
    }
}

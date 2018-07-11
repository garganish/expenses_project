/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.loginsTo;
import utility.errorHandler;

/**
 *
 * @author anishgarg
 */
public class loginsDao {
    public String errormessage;
    public String getErrormessage()
    {
        return errormessage;
    }
    public boolean insertRecord(loginsTo records)
    {
        try
        {
            String query="insert into logininfo";
            query+="(username,password,rolename,lastlogin)";
            query+="values(?,?,?,null)";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1,records.getUsername());
            smt.setString(2, records.getPassword());
            smt.setString(3, records.getRolename());
            boolean res=smt.executeUpdate()>0;
            smt.close();
            return res;
        }
        catch(Exception ex)
        {
            errormessage=ex.toString();
            errorHandler.printStackTrace(ex);
            return false;
        }
    }
    
    public boolean updateRecord(loginsTo records)
    {
        try
        {
            String query="update logininfo";
            query+=" set password=?,rolename=?,lastlogin=?";
            query+=" where username=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            
            smt.setString(1, records.getPassword());
            smt.setString(2, records.getRolename());
            smt.setTimestamp(3,records.getLastlogin());
            smt.setString(4,records.getUsername());
            boolean res=smt.executeUpdate()>0;
            smt.close();
            return res;
        }
        catch(Exception ex)
        {
            errormessage=ex.toString();
            errorHandler.printStackTrace(ex);
            return false;
        }
    }
    
     public boolean deleteRecord(String username)
    {
        try
        {
            String query="delete from logininfo";
            query+=" where username=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, username);
            boolean res=smt.executeUpdate()>0;
            smt.close();
            return res;
        }
        catch(Exception ex)
        {
            errormessage=ex.toString();
            errorHandler.printStackTrace(ex);
            return false;
        }
    }
         public loginsTo getRecord(String username)
    {
        try
        {
            String query="select username,password,rolename,lastlogin ";
            query+=" from logininfo ";
            query+=" where username=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, username);
            loginsTo result=null;
            ResultSet res=smt.executeQuery();
            if(res.next())
            {
                result=new loginsTo();
                result.setUsername(res.getString("username"));
                result.setPassword(res.getString("password"));
                result.setRolename(res.getString("rolename"));
                result.setLastlogin(res.getTimestamp("lastlogin"));
            }
            smt.close();
            return result;
        }
        catch(Exception ex)
        {
            errormessage=ex.toString();
            errorHandler.printStackTrace(ex);
            return null;
        }
    }
         
       public List<loginsTo> getAllRecord() {
        try {
            String query = "select username,password,rolename,lastlogin ";
            query += " from logininfo ";
            PreparedStatement stmt = dataConnection.getStatement(query);
            List<loginsTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    loginsTo res = new loginsTo();
                    res.setUsername(rs.getString("username"));
                    res.setPassword(rs.getString("password"));
                    res.setRolename(rs.getString("rolename"));
                    res.setLastlogin(rs.getTimestamp("lastlogin"));
                    result.add(res);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            errorHandler.printStackTrace(ex);
            return null;
        }
    }
}

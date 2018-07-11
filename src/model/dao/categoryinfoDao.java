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
import model.to.categoryinfoTo;
import model.to.loginsTo;
import utility.errorHandler;

/**
 *
 * @author anishgarg
 */
public class categoryinfoDao {
     public String errormessage;
    public String getErrormessage()
    {
        return errormessage;
    }
    
    public boolean insertRecord(categoryinfoTo records)
    {
        try
        {
            String query="insert into categoryinfo";
            query+="(categoryid,categoryname)";
            query+="values(?,?)";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1,records.getCategoryid());
            smt.setString(2, records.getCategoryname());
            
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
    
    public boolean updateRecord(categoryinfoTo records)
    {
        try
        {
            String query="update categoryinfo";
            query+=" set categoryname=?";
            query+=" where categoryid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, records.getCategoryname());
            smt.setString(2, records.getCategoryid());
            
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
    
     public boolean deleteRecord(String categoryid)
    {
        try
        {
            String query="delete from categoryinfo";
            query+=" where categoryid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, categoryid);
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
         public categoryinfoTo getRecord(String categoryid)
    {
        try
        {
            String query="select categoryid,categoryname ";
            query+=" from categoryinfo ";
            query+=" where categoryid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, categoryid);
            categoryinfoTo result=null;
            ResultSet res=smt.executeQuery();
            if(res.next())
            {
                result=new categoryinfoTo();
                result.setCategoryid(res.getString("categoryid"));
                result.setCategoryname(res.getString("categoryname"));
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
         
     public List<categoryinfoTo> getAllRecord() {
        try {
            String query = "select categoryid,categoryname ";
            query += " from categoryinfo ";
            PreparedStatement stmt = dataConnection.getStatement(query);
            List<categoryinfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    categoryinfoTo res = new categoryinfoTo();
                    res.setCategoryid(rs.getString("categoryid"));
                    res.setCategoryname(rs.getString("categoryname"));
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

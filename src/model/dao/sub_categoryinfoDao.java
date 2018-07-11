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
import model.to.expensesinfoTo;
import model.to.sub_categoryinfoTo;
import utility.errorHandler;

/**
 *
 * @author anishgarg
 */
public class sub_categoryinfoDao {
     public String errormessage;
    public String getErrormessage()
    {
        return errormessage;
    }
    
    public boolean insertRecord(sub_categoryinfoTo records)
    {
        try
        {
            String query="insert into sub_categoryinfo";
            query+="(subcategoryinfo,subcategoryname,categoryid)";
            query+="values(?,?,?)";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setInt(1,records.getSubcategoryinfo());
            smt.setString(2, records.getSubcategoryname());
            smt.setString(3, records.getCategoryid());
            
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
    
    public boolean updateRecord(sub_categoryinfoTo records)
    {
        try
        {
            String query="update sub_categoryinfo";
            query+=" set subcategoryname=?,categoryid=?";
            query+=" where subcategoryinfo=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1, records.getSubcategoryname());
            smt.setString(2, records.getCategoryid());
            smt.setInt(3, records.getSubcategoryinfo());
            
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
    
     public boolean deleteRecord(int subcategoryinfo)
    {
        try
        {
            String query="delete from sub_categoryinfo";
            query+=" where subcategoryinfo=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setInt(1, subcategoryinfo);
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
     public sub_categoryinfoTo getRecord(int subcategoryinfo)
    {
        try
        {
            String query="select subcategoryinfo,subcategoryname,categoryid ";
            query+=" from sub_categoryinfo ";
            query+=" where subcategoryinfo=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setInt(1, subcategoryinfo);
            sub_categoryinfoTo result=null;
            ResultSet res=smt.executeQuery();
            if(res.next())
            {
                result=new sub_categoryinfoTo();
                result.setSubcategoryinfo(res.getInt("subcategoryinfo"));
                result.setSubcategoryname(res.getString("subcategotyname"));
                result.setCategoryid(res.getString("categoryid"));
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
     
      public List<sub_categoryinfoTo> getAllRecord() {
        try {
            String query = "select subcategoryinfo,subcategoryname,categoryid ";
            query += " from sub_categoryinfo ";
            PreparedStatement stmt = dataConnection.getStatement(query);
            List<sub_categoryinfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    sub_categoryinfoTo res = new sub_categoryinfoTo();
                    res.setSubcategoryinfo(rs.getInt("subcategoryinfo"));
                    res.setSubcategoryname(rs.getString("subcategoryname"));
                    res.setCategoryid(rs.getString("categoryid"));
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

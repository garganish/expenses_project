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
import model.to.expensesinfoTo;
import utility.errorHandler;

/**
 *
 * @author anishgarg
 */
public class expensesinfoDao {
     public String errormessage;
    public String getErrormessage()
    {
        return errormessage;
    }
    public boolean insertRecord(expensesinfoTo records)
    {
        try
        {
            String query="insert into expensesinfo";
            query+="(description,amount,subcategoryinfo,expensedate)";
            query+="values(?,?,?,?)";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1,records.getDescription());
            smt.setFloat(2, records.getAmount());
            smt.setInt(3, records.getSubcategoryinfo());
            smt.setDate(4, records.getExpensedate());
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
    
    public boolean updateRecord(expensesinfoTo records)
    {
        try
        {
            String query="update expensesinfo";
            query+=" set description=?,amount=?,subcategoryinfo=?,expensedate=?";
            query+=" where expenseid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setString(1,records.getDescription());
            smt.setFloat(2, records.getAmount());
            smt.setInt(3, records.getSubcategoryinfo());
            smt.setDate(4, records.getExpensedate());
            smt.setInt(5,records.getExpenseid());
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
    
     public boolean deleteRecord(int expenseid)
    {
        try
        {
            String query="delete from expensesinfo";
            query+=" where expenseid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setInt(1, expenseid);
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
     
     public expensesinfoTo getRecord(int expenseid)
    {
        try
        {
            String query="select expenseid,description,amount,subcategoryinfo,expensedate ";
            query+=" from expensesinfo ";
            query+=" where expenseid=?";
            PreparedStatement smt=dataConnection.getStatement(query);
            smt.setInt(1, expenseid);
            expensesinfoTo result=null;
            ResultSet res=smt.executeQuery();
            if(res.next())
            {
                result=new expensesinfoTo();
                result.setExpenseid(res.getInt("expenseid"));
                result.setDescription(res.getString("description"));
                result.setAmount(res.getFloat("amount"));
                result.setSubcategoryinfo(res.getInt("subcategoryinfo"));
                result.setExpensedate(res.getDate("expensedate"));
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
     
     public List<expensesinfoTo> getAllRecord() {
        try {
            String query="select expenseid,description,amount,subcategoryinfo,expensedate ";
            query+=" from expensesinfo ";
            PreparedStatement stmt = dataConnection.getStatement(query);
            List<expensesinfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    expensesinfoTo res = new expensesinfoTo();
                    
                res.setExpenseid(rs.getInt("expenseid"));
                res.setDescription(rs.getString("description"));
                res.setAmount(rs.getFloat("amount"));
                res.setSubcategoryinfo(rs.getInt("subcategoryinfo"));
                res.setExpensedate(rs.getDate("expensedate"));
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

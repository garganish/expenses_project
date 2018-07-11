/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.sql.Date;

/**
 *
 * @author anishgarg
 */
public class expensesinfoTo {
    private int expenseid;
    private String description;
    private float amount;
    private int subcategoryinfo;
    private Date expensedate;

    public int getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(int expenseid) {
        this.expenseid = expenseid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getSubcategoryinfo() {
        return subcategoryinfo;
    }

    public void setSubcategoryinfo(int subcategoryinfo) {
        this.subcategoryinfo = subcategoryinfo;
    }

    public Date getExpensedate() {
        return expensedate;
    }

    public void setExpensedate(Date expensedate) {
        this.expensedate = expensedate;
    }
     public String toString()
    {
        return String.valueOf(subcategoryinfo);
    }
    
}

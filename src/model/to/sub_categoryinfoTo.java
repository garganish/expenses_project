/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author anishgarg
 */
public class sub_categoryinfoTo {
    private int subcategoryinfo;
    private String subcategoryname;
    private String categoryid;

    public int getSubcategoryinfo() {
        return subcategoryinfo;
    }

    public void setSubcategoryinfo(int subcategoryinfo) {
        this.subcategoryinfo = subcategoryinfo;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }
    public String toString()
    {
        return String.valueOf(subcategoryinfo);
    }
    
}

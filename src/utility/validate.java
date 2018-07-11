/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author anishgarg
 */
public class validate {
    public static boolean isEmpty(String value)
    {
        if(value!=null)
        {
            return value.trim().isEmpty();
        }
        return false;
    }
    public static boolean isNumeric(String value)
    {
        try
        {
            if(value!=null)
            {
            Integer.parseInt(value.trim());
            return true;
             }
        }catch(NumberFormatException ex)
        {
            System.out.println(ex); 
        }
        return false;
    }
}

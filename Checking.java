package MasterData;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.lang.String.*;
import MasterData.mySQLQueries;


public class Checking {
public static boolean IsValidName(String str)
{
    if(IsNull(str))
        return false;
    if(IsLetter(str))
        return false;
    if(str.charAt(0) == ' ')
    	return false;
    return true;
}
public static boolean IsNull(String str)
{
    if(str.trim().equals("")||str.trim().equals(null))
        return true;
    else
        return false;
}
public static boolean IsLetter(String str)
{
    boolean b = false ;
    for(int i=0 ; i<str.length() ; i++)
    {
        if(Character.isLetter(str.charAt(i)))b = true ;
        else { b = false ; break ;}
    }
  return b;
}
public static boolean IsEformat(String str)
{
    boolean b = false ;
    int t = str.indexOf(".");
    int a = str.indexOf("@");
    if((t< 0)|| (a<0) || (str.indexOf(" ")>0) )
    {
        return b ; 
    }
    String st1 = str.substring(0,a);
    String st = str.substring(t+1);
    if((!st1.trim().equals(""))&&(st.equals("com")))
    {
        b=true;
        return b;
    }
    else
        return b ;
   }
public static boolean IsAllDigit(String str)
{
    boolean b = false ;
    for(int i = 0 ; i<str.length() ; i++)
    {
        if(Character.isDigit(str.charAt(i)))b=true;
        else { b=false ; break ;}

    }
    return b;
}
public static boolean IsContain(char c, String str)
{
    for(int i = 0 ; i<str.length() ; i++)
    {if(str.charAt(i)==c)return true;}
    return false;
}
public static boolean IsContain (String s , Vector str)
{
    for(int i=0 ; i<str.size() ; i++)
    {if(s.equals((String)str.elementAt(i)))return true;}
    return false;
}
public static boolean checktxtquantity(String strqp)
{
    if(strqp.equals(" "))
    {
        JOptionPane.showMessageDialog(null, "You must enter the Quantity!");
        return false;
    }
    else if(!IsAllDigit(strqp))
    {
        JOptionPane.showMessageDialog(null, "You must enter NUMBER for Quantity!");
        return false;
    }
    else if(Integer.parseInt(strqp)>10000)
    {
        JOptionPane.showMessageDialog(null, "The Quantity you entered is too many to purchase!");
        return false;
    }
    else return true;
}
public static boolean checktxtprice(String strqp)
{
    if(strqp.equals(""))
    {
        JOptionPane.showMessageDialog(null, "You must enter the Price!");
        return false;
    }
    else if(!IsAllDigit(strqp))
    {
        JOptionPane.showMessageDialog(null, "You must enter NUMBER for Price!");
        return false;
    }
    else if(Long.parseLong(strqp)>1000000000)
    {
        JOptionPane.showMessageDialog(null, "The Price you entered is too much (more than 1,000,000,000)! ");
        return false;
    }
    else return true;
}

public static String Sumamount(Vector data , int t)
{
    long sum = 0 ;
    for(int i = 0 ; i<data.size() ; i++)
        sum+=Long.parseLong((String)data.elementAt(i));
    
    if(t==1)
    {
        int len = String.valueOf(sum).length(),
        index = 0 ;
        StringBuffer str = new StringBuffer("");
        for(int i = 0 ; i<len ; i++)
        {
            if(index==3)
            {
                str.append(",");
                index = 0 ;
                i--;
            }
            else
            {
                str.append(String.valueOf(sum).charAt(len-i-1));
                index++;
            }
        }
            return str.reverse().toString();
        }
    
        else
        {
            return String.valueOf(sum);
        }
 }
public static String[] fromtable(JTable mtable , int size , int column )
{
    String[]str = new String[size];
    for(int i = 0 ; i<size ; i++)
    {
        if(IsContain(':',((String)mtable.getValueAt(i, column))))
        {
            int j = ((String)mtable.getValueAt(i, column)).indexOf("::");
            str[i]=((String)mtable.getValueAt(i, column)).substring(0,j);

        }
        else
        {
            str[i]=((String)mtable.getValueAt(i, column));
        }
    }
    return str;
    }

public static boolean checksaleQuantity(String strqp , String id)
{
    if(strqp.equals(""))
    {
        JOptionPane.showMessageDialog(null, "You must enter the Quantity!");
        return false;
    }
    else if(!IsAllDigit(strqp))
    {
        JOptionPane.showMessageDialog(null, "You must enter NUMBER for Quantity!");
        return false;
    }
    else
    {
       // mySQLQueries mysql = new mySQLQueries();
        String q = mySQLQueries.getItemData(id)[5];
        if(Integer.parseInt(strqp)>Integer.parseInt(q)-2)
        {
            JOptionPane.showMessageDialog(null, "The Quantity you entered does not exist in stock!");
            
            return false;
        }
        else return true;
    }
}

}


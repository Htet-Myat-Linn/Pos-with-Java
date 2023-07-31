package MasterData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class clsDBConnection {
	private final String CONNECTION =  
			"jdbc:mysql://localhost:3306/pos?characterEncoding=latin1&useConfigs=maxPerformance";
	private final String PASSWORD = "root";
	private static Connection con = null;

	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public Connection getConnection() throws SQLException
{

		if (null == con)
		
		{
			con = (Connection) DriverManager.getConnection(this.CONNECTION, "root", this.PASSWORD);
		}
		return con;
}
public Connection ConnectionStop()
{
    return null;
}
public ResultSet SQLSelect(String field , String table) throws ClassNotFoundException
{
    ResultSet rs = null ;
    try
    {
        Statement stmt = (Statement) getConnection().createStatement();
        rs = stmt.executeQuery("SELECT "+field+" FROM "+table);
    }catch(SQLException ex)
    {
        System.out.println(ex);
    }
    return rs;
}

public boolean ExecuteSQL(String sql) throws ClassNotFoundException
{
    try{
        Statement stmt = (Statement) getConnection().createStatement();
        stmt.execute(sql);
        return true;
    }catch(SQLException ex)
    {
        ex.printStackTrace();
        return false;
    }
}
public String getPrimaryKey(String field,String table , String prefix) throws ClassNotFoundException
{
    ResultSet rs = SQLSelect(field , table);
    int current;
    try{
        java.util.ArrayList result = new java.util.ArrayList();
        while(rs.next())
        {
            result.add(rs.getString(field));
        }
        if(result.size()>0)
        {
            current = Integer.parseInt(result.get(result.size()-1).toString().substring(2,10))+1;
           if(current>0&&current<=9){return prefix +"0000000"+current;}
           else if(current>9 && current<=99){return prefix +"000000"+current;}
           else if(current>99 && current<=999){return prefix +"00000"+current;}
           else if(current>999 && current<=9999){return prefix +"0000"+current;}
           else if(current>9999 && current<=99999){return prefix +"000"+current;}
           else if(current>99999 && current<=999999){return prefix +"00"+current;}
           else if(current>999999 && current<=9999999){return prefix +"0"+current;}
           else if(current>9999999 && current<=99999999){return prefix +current;}
        }
    }catch(SQLException ex){//SQL Exception

        }
    return prefix+"00000001";//Return
}//end GetPrimarykey
public String getPrimaryKey2(String field,String table , String prefix) throws ClassNotFoundException
{
    ResultSet rs = SQLSelect(field , table);
    int current;
    try{
        java.util.ArrayList result = new java.util.ArrayList();
        while(rs.next())
        {
            result.add(rs.getString(field));
        }
        if(result.size()>0)
        {
            current = Integer.parseInt(result.get(result.size()-1).toString().substring(3,10))+1;
           if(current>0 && current<=9){return prefix +"000000"+current;}
           else if(current>9 && current<=99){return prefix +"00000"+current;}
           else if(current>99 && current<=999){return prefix +"0000"+current;}
           else if(current>999 && current<=9999){return prefix +"000"+current;}
           else if(current>9999 && current<=99999){return prefix +"00"+current;}
           else if(current>99999 && current<=999999){return prefix +"0"+current;}
          else if(current>999999 && current<=9999999){return prefix +current;}
        }
    }catch(SQLException ex){//SQL Exception

        }
    return prefix+"0000001";//Return
}//end GetPrimarykey2

public static void main(String[] args)
{
	try
	{
	clsDBConnection c=new clsDBConnection();
	System.out.println(c.getConnection());
	System.out.print("Conection Successfully");
	}
	catch(Exception e)
	{
		System.out.print(e);
	}
}
}

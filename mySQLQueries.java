package MasterData;
import MasterData.clsDBConnection;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;


public class mySQLQueries {
	
	static Connection con = null;
	static Statement stmt;
	static String query , query1;
	static ResultSet rs;
	static clsDBConnection connect = new clsDBConnection();
	public mySQLQueries() throws ClassNotFoundException
	{
	    try{
	        con=connect.getConnection();
	    }
	    catch(SQLException sqle)
	    {
	        System.out.println(sqle);
	    }catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public static boolean insertData(String tbName , String[]data)
	{
	    if(tbName.equals("brand"))
	    {
	        query = "insert into brand values ('"+data[0]+"','"+data[1]+"');";
	    }
	    else if(tbName.equals("type"))
	    {
	        query = "insert into type values ('"+data[0]+"','"+data[1]+"')";
	    }
	    else if(tbName.equals("supplier"))
	    {
	        query = "insert into supplier(supplierID,Name,Address,PhoneNo,Email)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
	    }

	    else if(tbName.equals("merchandise"))
	    {
	        query = "insert into merchandise(merID,brandID,typeID)values('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	    }
	    else if(tbName.equals("customer"))
	    {
	        query = "insert into customer(customerID,Name,Address,PhoneNo,Email)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
	    }
	     else if(tbName.equals("itemdetail"))
	    {
	        query = "insert into itemdetail(itemid,merid,itemname,remark)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"')";
	    }

	     else if(tbName.equals("purchase"))
	     {
	         int cat = data[2].indexOf("(");
	         query = "insert into purchase(purchaseID,supplierID,purchaseDate)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	     }
	     else if(tbName.equals("purchasedetail"))
	     {
	         query = "insert into purchasedetail(purchaseID,purchasePrice,purchaseQuantity,itemID)values('"+data[0]+"','"+Long.parseLong(data[2])+"','"+Integer.parseInt(data[3])+"','"+data[1]+"')";
	     }
	     else if(tbName.equals("saledetail"))
	     {
	         query = "insert into saledetail(saleID,salePrice,saleQuantity,itemID)values('"+data[0]+"','"+Long.parseLong(data[2])+"','"+Integer.parseInt(data[3])+"','"+data[1]+"')";
	     }
	     else if(tbName.equals("sale"))
	     {
	         //int cat = data[2].indexOf("(");
	         query = "insert into sale(saleID,customerID,saleDate)values ('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
	     }
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        boolean r = stmt.execute(query);
	       //System.out.println(query+r);
	        if(r)
	        {
	            return false;
	        }
	        else return true;

	    }catch(SQLException e)
	    {
	        JOptionPane.showMessageDialog(null,e.getMessage());
	        e.printStackTrace();
	        return true;
	    }
	}
	
	public static boolean isduplicate(String tbName , String []data)
	{
	    if(tbName.equals("brand"))
	    {
	        query = "select * from brand where brandname='"+data[0]+"'";
	    }
	    else if(tbName.equals("type"))
	    {
	        query = "select * from type where typename='"+data[0]+"'";
	    }

	    else if(tbName.equals("supplier"))
	    {
	        query = "select * from supplier where Name ='"+data[0]+"'and Address ='"+data[1]+"'and PhoneNo ='"+data[2]+"'and Email='"+data[3]+"'";
	    }
	    
	    else if(tbName.equals("merchandise"))
	    {
	        query = "select * from merchandise where brandid='"+data[0]+"'and typeid='"+data[1]+"'";
	    }
	    else if(tbName.equals("customer"))
	    {
	        query = "select * from customer where Name ='"+data[0]+"'and Address ='"+data[1]+"'and PhoneNo ='"+data[2]+"'and Email='"+data[3]+"'";
	    }
	    else if(tbName.equals("itemdetail"))
	    {
	        query = "select * from itemdetail where itemname ='"+data[0]+"'and merid ='"+data[1]+"'";
	    }
	    try{
	    	con=connect.getConnection();
	        stmt = con.createStatement();
	        rs = stmt.executeQuery(query);
	        if(rs.next())
	            return false;
	        else
	            return true;
	    }catch(SQLException e){
	        JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	}

    public static String getTypeName(String typeid)
    {
        try
        {
            String typename;
            con=connect.getConnection();
            stmt = con.createStatement();
            query = "select * from type where typeID ='"+typeid+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            typename = rs.getString(2);
            return typename;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
    public static String getTypeID(String typename)
    {
        String typeid;
        try
        {
            stmt = con.createStatement();
            query = "select typeid from type where typename='"+typename+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            typeid=rs.getString(1);
            return typeid;
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
    public static String getBrandID(String brandname)
    {
        try{
            String brandid;
            stmt = con.createStatement();
            query = "select brandid from brand where brandname='"+brandname+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            brandid=rs.getString(1);
            return brandid;
        }catch(SQLException sqle)
        {
            System.out.println(sqle);
            return null;
        }
    }
     public static String getBrandName(String brandid)
    {
        try{
            String brandname;
            con=connect.getConnection();
            stmt = con.createStatement();
            query = "select * from brand where brandid='"+brandid+"';";
            rs=stmt.executeQuery(query);
            rs.next();
            brandname=rs.getString(2);
            return brandname;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
     public static   String getAutoid(String field , String tabel , String prefix) throws ClassNotFoundException
     {
         if(tabel.equals("sale")||tabel.equals("purchase"))
         {
             return connect.getPrimaryKey(field, tabel, prefix);
         }
         else
         {
             return connect.getPrimaryKey2(field, tabel, prefix);
         }
     }
     public static String[]getIDForChoice(String tbName)
     {
         try{
             if((tbName.equals("itemdetail")))
                 rs = connect.SQLSelect("itemID","itemdetail ");
             else if(tbName.equals("supplier"))
                 rs=connect.SQLSelect("supplierID", "supplier");
             else if(tbName.equals("type"))
                 rs=connect.SQLSelect("typeID", "type");
             else if(tbName.equals("customer"))
             {  con=connect.getConnection();
             	stmt = con.createStatement();
            	 rs = stmt.executeQuery("SELECT customerid  FROM customer order by customerid");
             }
             else if(tbName.equals("merchandise"))
                 rs=connect.SQLSelect("merID", "merchandise");
             else if(tbName.equals("brand"))
                 rs=connect.SQLSelect("brandID", "brand");
             else if(tbName.equals("orders"))
                 rs=connect.SQLSelect("distinct orderid","orders");
             else if(tbName.equals("orderdetail"))
                 rs = connect.SQLSelect("orderid","orderdetail where remark !=0");

             int rowcount = 0 ;
             while(rs.next())
             {
                 rowcount++;
             }
             String temp[]=new String[rowcount];
             rs.beforeFirst();
             int i = 0 ;
             while(rs.next())
             {
                 temp[i]=rs.getString(1);
                 i++;
             }
             return temp;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null ;
         }
         catch(Exception e)
         {
             e.printStackTrace();
             return null;
         }
     }

     public static String []getMerchandise(String merid)
     {
         try{
        	 con=connect.getConnection();
             String[]value= new String[2];
             stmt=con.createStatement();
             query = "select * from merchandise where merid='"+merid+"'";
             rs=stmt.executeQuery(query);
             rs.next();
             value[0]=rs.getString(2);
             value[1]=rs.getString(3);
             return value;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage());
             return null;
         }
     }
     public static String[]getNameForChoice(String tbName)
     {
         try{
             if(tbName.equals("type"))
                 rs=connect.SQLSelect("typeName", "type");
             else if(tbName.equals("brand"))
                 rs=connect.SQLSelect("brandname", "brand");
             else if(tbName.equals("customer"))
                 rs = connect.SQLSelect("name","customer");
              else if(tbName.equals("customeraddress"))
                 rs = connect.SQLSelect("distinct address","customer");
               else if(tbName.equals("supplieraddress"))
                 rs = connect.SQLSelect("distinct address","supplier");
             else if(tbName.equals("supplier"))
                 rs = connect.SQLSelect("name","supplier");

             int rowcount = 0 ;
             while(rs.next())
             {
                 rowcount++;
             }
             String []temp = new String[rowcount];
             rs.beforeFirst();
             int i = 0 ;
             while(rs.next())
             {
                 temp[i]=rs.getString(1);
                 i++;
             }
             return temp;
         }
         catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }
         catch(Exception e)
         {
             e.printStackTrace();
             return null;
         }
     }
     public static boolean updateRecord(String tbName,String id , String []data)
     {
         if(tbName.equals("supplier"))
             query = "update supplier set Name='"+data[0]+"',Address='"+data[1]+"',PhoneNo='"+data[2]+"',Email='"+data[3]+"'where supplierID='"+id+"'";
         else  if(tbName.equals("customer"))
             query = "update customer set Name='"+data[0]+"',Address='"+data[1]+"',PhoneNo='"+data[2]+"',Email='"+data[3]+"'where customerID='"+id+"'";
         else if(tbName.equals("itemdetail"))
             query = "update itemdetail set itemname='"+data[0]+"',cursaleprice="+data[1]+",remark='"+data[2]+"'where itemid='"+id+"'";
         else if(tbName.equals("brand"))
              query = "update brand set brandname='"+data[0]+"' where brandid='"+id+"'";
         else if(tbName.equals("type"))
              query = "update type set typename='"+data[0]+"' where typeid='"+id+"'";
         else if(tbName.equals("orderdetail"))
              query = "update orderdetail set remark = "+Integer.parseInt(data[0])+" where orderid='"+id+"'";
         else if(tbName.equals("orders"))
         {
              int cat = data[0].indexOf("(");
              query = "update orders set orderdate='"+data[0].substring(0,cat)+"'where orderid='"+id+"'";
         }

             
             try{
            	 con=connect.getConnection();
                 stmt = con.createStatement();
                 if(stmt.executeUpdate(query)==1)
                 {
                     return true;
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"The table does not contain the specified ID.","Update Fail",JOptionPane.ERROR_MESSAGE);
                     return false;}
             }
             catch(SQLException e)
             {
                 JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                 return false;
             }
       }

     public static String []getSupplierData(String id)
     {
         try
         {
        	 con=connect.getConnection();
             stmt = con.createStatement();
             String str[];
             query = "select * from supplier where supplierID='"+id+"'";
             str = new String[4];
             rs = stmt.executeQuery(query);
             if(rs.next())
             {
                 for(int i = 0 ; i<str.length ; i++)
                 {
                     str[i]=rs.getString(i+2);
                 }
             }
             return str;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,e.getMessage());
             return null;
         }
     }
     public static String []getCustomerData(String id)
     {
         try
         {
        	 con=connect.getConnection();
             stmt = con.createStatement();
             String str[];
             query = "select * from customer where customerID='"+id+"'";
             str = new String[4];
             rs = stmt.executeQuery(query);
             if(rs.next())
             {
                 for(int i = 0 ; i<str.length ; i++)
                 {
                     str[i]=rs.getString(i+2);
                 }
             }
             return str;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,e.getMessage());
             return null;
         }
     }

     public static String []getBrandData(String id)
     {
         try
         {
        	 con=connect.getConnection();
             stmt = con.createStatement();
             String str[];
             query = "select * from brand where brandid='"+id+"'";
             str = new String[1];
             rs = stmt.executeQuery(query);
             if(rs.next())
             {
                 for(int i = 0 ; i<str.length ; i++)
                 {
                     str[i]=rs.getString(i+2);
                 }
             }
             return str;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,e.getMessage());
             return null;
         }
     }
     public static String []getTypeData(String id)
     {
         try
         {
        	 con=connect.getConnection();
             stmt = con.createStatement();
             String str[];
             query = "select * from type where typeid='"+id+"'";
             str = new String[1];
             rs = stmt.executeQuery(query);
             if(rs.next())
             {
                 for(int i = 0 ; i<str.length ; i++)
                 {
                     str[i]=rs.getString(i+2);
                 }
             }
             return str;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null,e.getMessage());
             return null;
         }
     } 



     public static void deleteRecord(String tbName,String id)
     {
         int returnvalue = 0 ;
         String query = "";
         if(tbName.equals("supplier"))
         {
             query = "delete from supplier where supplierid = '"+id+"' ";
         }
         if(tbName.equals("customer"))
         {
             query = "delete from customer where customerid = '"+id+"' ";
         }
         try{
             stmt = con.createStatement();
             if(!query.equals("")&&stmt.executeUpdate(query)==1)
                 JOptionPane.showMessageDialog(null, "The record is deleted successfully in"+tbName+"table.");
             else
                 JOptionPane.showMessageDialog(null,"The specified ID does not found in the table .","Delete Fail",JOptionPane.ERROR_MESSAGE);
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
         }

     }

     public static String[] getItemData(String id)
     {
         try{
             stmt = con.createStatement();
             String str[]= new String[6];
             query = "select * from itemdetail where itemID='"+id+"'";
             rs=stmt.executeQuery(query);
             if(rs.next())
             {
                 str[0]=rs.getString(1);//id
                 str[1]=rs.getString(3);//name
                 str[2]=rs.getString(4);//price
                 str[3]=rs.getString(2);//merid
                 str[4]=rs.getString(5);//remark
                 str[5]=rs.getString(6);//qty


             }
             return str;
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage(),"SQLException",JOptionPane.ERROR_MESSAGE);
             return null;
         }
     }
     
     public static void main(String[] args) 
     {
    	 try {
    		 mySQLQueries q=new mySQLQueries();
    		 System.out.print(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }


     public static void P_updateitemquantity ( String tbname , String id , String nprice , String data )
     {
         int r1=0,price=0;
        // mySQLQueries msql = new mySQLQueries();
         String q = mySQLQueries.getItemData(id)[5];//qty(now)
         System.out.println("Save Qty ="+data);
         System.out.println("Save curQuantity="+q);
         if(tbname.equals("purchasedetail"))
         {
             r1=Integer.parseInt(q)+Integer.parseInt(data);
             price = Integer.parseInt(nprice)+(int)(Integer.parseInt(nprice)*0.1);
             System.out.println(price);
         }

         query1 = "update itemdetail set curSalePrice ="+price+", totalQty="+r1+" where itemID='"+id+"'";
         try{
        	 con=connect.getConnection();
             stmt = con.createStatement();
             if(stmt.executeUpdate(query1)==1)
             {
                 System.out.println("One Record is Updated Successfully");
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Update Not Successful.", "Update Fail", JOptionPane.ERROR_MESSAGE);
             }
         }catch(SQLException e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException",JOptionPane.ERROR_MESSAGE);
         }

     }

     public static void S_updateitemquantity ( String tbname ,String id ,String data )
    {
        int r1=0;
        //mySQLQueries msql = new mySQLQueries();
       String q = mySQLQueries.getItemData(id)[5];//qty(now)
       // System.out.println("curQuantity="+q);
      //  System.out.println("Sale Qty =" + data );
         if(tbname.equals("itemdetail"))
        {
            r1=Integer.parseInt(q)-Integer.parseInt(data);
          // System.out.println(r1);

        }

        query1 = "update itemdetail set totalQty="+r1+" where itemID='"+id+"'";
        try{
        	con=connect.getConnection();
            stmt = con.createStatement();
            if(stmt.executeUpdate(query1)==1)
            {
               // System.out.println("One Record is Updated Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Update Not Successful.", "Update Fail", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException",JOptionPane.ERROR_MESSAGE);
        }

    }
     public static String[]getItemIDForSale(String tbName)
     {
         try{
             if(tbName.equals("itemdetail"))
            	 con=connect.getConnection();
             stmt = con.createStatement();
             rs = stmt.executeQuery("SELECT itemid from itemdetail where totalqty>0");
             int rowcount = 0 ;
             while(rs.next())
             {
                 rowcount++;
             }
             String []temp = new String[rowcount];
             rs.beforeFirst();
             int i = 0 ;
             while(rs.next())
             {
                 temp[i]=rs.getString(1);
                 i++;
             }
             return temp;
         }
         catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }
         catch(Exception e)
         {
             e.printStackTrace();
             return null;
         }
     }


//     public static int Condition(int b)
//     { int c = 0;
//     	 if (b==0)
//     	 {
//     		 c =1;
//     	 }
//     	 return c;
//     }

	
     

     public static String[]getMerID(String brandid , String typeid)
     {
         int count = 0 ;
         try
         {
             if(brandid != null && typeid != null)
                 query = "select merid from merchandise where brandid='"+brandid+"'and typeid='"+typeid+"'";
             else if(brandid!=null)
                 query = "select merid from merchandise where brandid='"+brandid+"'";
             else if(typeid!=null)
                    query = "select merid from merchandise where typeid='"+typeid+"'";
             stmt = con.createStatement();
             rs = stmt.executeQuery(query);
             while(rs.next())
                 count++;
             if(count==0)
                 JOptionPane.showMessageDialog(null,"No Item FOUND!!!");

             String merID[]=new String[count];
             rs = stmt.executeQuery(query);
             while(rs.next())
             {
                 for(int i=0 ; i<count ; i++)
                 {
                     merID[i]=rs.getString(1);
                     rs.next();
                 }
             }
             return merID;
         }catch(SQLException sqle)
         {
             System.out.println(sqle);
             return null;
         }
     }






}

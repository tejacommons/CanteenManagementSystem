package cms_project.DataBaseCode;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.management.Query;

import cms_project.gettersandsetters.Customer;
import cms_project.gettersandsetters.Menu;
import cms_project.gettersandsetters.OrderDetails;
import cms_project.gettersandsetters.Vendor;

public class DbAccess 
{
    static Scanner scan=new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/CMS_PROJECT";

    //----------------------------------1----------------------------
    public static Customer[] fetchDb(){
        Customer cust[]=null;
        try{  

            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107");
            Statement stmt=con.createStatement();
            //type sql Query here.........................................!       
            ResultSet rs=stmt.executeQuery("select*from Customer");  

            ArrayList<Customer> list=new ArrayList<Customer>();  

            while(rs.next()) 
            {  
                Customer data =  new Customer
                (
                    rs.getString("Customer_id"),
                    rs.getString("Customer_name"),
                    rs.getInt("Customer_walletbal"),
                    rs.getInt("Login_id"),
                    rs.getString("Pasword")
                );
                list.add(data);
            }
                cust=new Customer[list.size()];
                cust= list.toArray(cust);
                  
        }catch(Exception e)
        { 
            System.out.println(e);
        }  
            
        return cust;      
        }

        public static Object insertOrderDb( String venderId, String customerId, int foodId, int quantity,Date datetime,int orderValue, String orderStatus)
        {        
            
                Object i=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                   Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107"); 
         PreparedStatement stmt=con.prepareStatement("insert into OrderDetails(Vendor_id,Customer_id,Food_Id,Quantity,DateandTime,Order_Value,Order_Status) values(?,?,?,?,?,?,?)");  
                // stmt.setInt(1,Order_No);
                stmt.setString(1,venderId);  
                stmt.setString(2,customerId);
                stmt.setInt(3,foodId);   
                stmt.setInt(4,quantity);
                stmt.setDate(5,datetime);
                stmt.setInt(6,orderValue);
                stmt.setString(7,orderStatus);
                i=stmt.executeUpdate();  
                System.out.println(i+" records inserted");  
                }catch(Exception e)
                {
                     System.out.println(e);
                }  
            return i;
            }

            // Insert into customer or user registration............!

            public static Object CustomerRegistrationDb(String Customer_id ,String Customer_name , int Customer_walletbal, int Login_id ,String Pasword )
        {        
            
                Object i=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                   Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107"); 
         PreparedStatement stmt=con.prepareStatement("insert into Customer values(?,?,?,?,?)");  
                stmt.setString(1,Customer_id);  
                stmt.setString(2,Customer_name);
                stmt.setInt(3,Customer_walletbal);   
                stmt.setInt(4,Login_id);
                stmt.setString(5,Pasword);
                i=stmt.executeUpdate();  
                System.out.println(i+" Registration Successfull");  
                }catch(Exception e)
                {
                     System.out.println(e);
                }  
            return i;
            }


            //Food Items insert by vendor
            public static Object AddToMenu(String Food_Name,int Food_Price,String Vendor_id)
            {        
                
                    Object i=null;
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");  
                       Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107");   
             PreparedStatement stmt=con.prepareStatement("insert into Menu(Food_Name,Food_Price,Vendor_id) values(?,?,?)");  
                    stmt.setString(1,Food_Name);
                    stmt.setInt(2,Food_Price);   
                    stmt.setString(3,Vendor_id);  
                    i=stmt.executeUpdate();  
                    System.out.println(i+" Item Added To The Menu");  
                    }catch(Exception e)
                    {
                         System.out.println(e);
                    }  
                return i;
                }

            //  VENDOR REGISTRATION

            public static Object VendorRegistrationDb(String Vendor_id ,String Vendor_name , String Vendor_Specs, int VloginId ,String Vpassword )
        {        
            
                Object i=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                   Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107"); 
         PreparedStatement stmt=con.prepareStatement("insert into Vendor values(?,?,?,?,?)");  
                stmt.setString(1,Vendor_id);  
                stmt.setString(2,Vendor_name );
                stmt.setString(3,Vendor_Specs);   
                stmt.setInt(4,VloginId);
                stmt.setString(5,Vpassword);
                i=stmt.executeUpdate();  
                System.out.println(i+" Registration Successfull");  
                }catch(Exception e)
                {
                     System.out.println(e);
                }  
            return i;
            }







            public static Object Accept_RejectDb(  String Order_Status,int Order_No)
        {        
            
                Object i=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                   Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107"); 
                //    String query="UPDATE OrderDetails
                //    SET Order_Status="Rejected" 
                //    WHERE Order_No=1";
                 PreparedStatement stmt=con.prepareStatement("UPDATE OrderDetails SET Order_Status=?  WHERE Order_No=?");  
                 stmt.setString(1,Order_Status);            
                 stmt.setInt(2,Order_No);
                i=stmt.executeUpdate();   
                }catch(Exception e)
                {
                     System.out.println(e);
                }  
            return i;
        }


        // customer wallet balance updation method by the vendor after rejecting the order....!
        public static Object Refund(int Customer_walletbal,String Customer_id )
        {        
            
                Object i=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");  
                   Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107"); 
                //    String query="UPDATE OrderDetails
                //    SET Order_Status="Rejected" 
                //    WHERE Order_No=1";
                 PreparedStatement stmt=con.prepareStatement("UPDATE Customer SET Customer_walletbal=?  WHERE Customer_id=?");  
                 stmt.setInt(1,Customer_walletbal);            
                 stmt.setString(2,Customer_id);
                i=stmt.executeUpdate();   
                }catch(Exception e)
                {
                     System.out.println(e);
                }  
            return i;
        }

        public static OrderDetails RefundDetails( int Order_No )
        {
            OrderDetails c = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " Select * from OrderDetails where Order_No= ? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,Order_No);
                ResultSet rs = stmt.executeQuery();
                if ( rs.next () )
                {
                    c = new OrderDetails(
                        rs.getInt("Order_No"),
                        rs.getString("Vendor_id"),
                        rs.getString("Customer_id"),
                        rs.getInt("Food_id"),
                        rs.getInt("Quantity"),
                        rs.getDate("DateandTime"),
                        rs.getInt( "Order_value"),
                        rs.getString("Order_status") 
                        );
                }
                stmt.close();
                con.close();
            } catch(Exception e)
            {
                System.out.println( e );
            }
            return c;
       }



         public static Object Cust_Wallet_Update( int Customer_walletbal,String  Customer_id )
        {
            Object c =null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = "UPDATE Customer SET  Customer_walletbal=?  WHERE Customer_id=? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, Customer_walletbal);
                stmt.setString(2, Customer_id);
                c = stmt.executeUpdate();
            } 
            catch(Exception e)
            {
                System.out.println( e );
            }
            return c;
       }




       public static OrderDetails Cust_Wallet_Update1( String Customer_id )
        {
            OrderDetails c = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " Select Order_value from OrderDetails where Customer_id= ? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1,Customer_id);
                ResultSet rs = stmt.executeQuery();
                if ( rs.next () )
                {
                    c = new OrderDetails(
                        rs.getString("Customer_id"),
                        rs.getInt("Order_value")
                        );
                }
                stmt.close();
                con.close();
            } catch(Exception e)
            {
                System.out.println( e );
            }
            return c;
       }


        //------->It grabs all the data from menu..!

        public static Menu[] fetchMenuDb()
        {
            Menu m[]=null;
            try{  
    
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107");
                Statement stmt=con.createStatement();
                //type sql Query here.........................................!       
                ResultSet rs=stmt.executeQuery("select*from Menu");  
    
                ArrayList<Menu> list=new ArrayList<Menu>();  
    
                while(rs.next()) 
                {  
                    Menu data =  new Menu(
                        rs.getInt("Food_id"),
                        rs.getString("Food_Name"),
                        rs.getInt("Food_Price"),
                        rs.getString("Vendor_id")
                         );
                    list.add(data);
                }
                    m=new Menu[list.size()];
                    m= list.toArray(m);
                      
            }catch(Exception e)
            { 
                System.out.println(e);
            }  
                
            return m;      
            }
        //-----------------------------2------------------------------------

        // --------------> It Authenticates the customer with id and password


        public static Customer CustomerLogin( int Login_id, String Pasword )
        {
            Customer c = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " Select*from Customer where Login_id= ? and Pasword= ? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,Login_id);
                stmt.setString(2, Pasword);
                
                ResultSet rs = stmt.executeQuery();
                if ( rs.next () )
                {
                    c = new Customer(
                        rs.getString("Customer_id"),
                        rs.getString("Customer_name"),
                        rs.getInt("Customer_walletbal"),
                        rs.getInt("Login_id"),
                        rs.getString("Pasword")
                        );
                }
                stmt.close();
                con.close();
            } catch(Exception e)
            {
                System.out.println( e );
            }
            return c;
       }

// --------------> It grabs all data of Customer based of Customer ID

       public static Customer Customer(  String Customer_id )
       {
           Customer c = null;
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");  
               Connection con=DriverManager.getConnection(  
               url,"root","Moh@n$0107");
                
               String sql = " Select*from Customer where Customer_id= ? ";
               PreparedStatement stmt = con.prepareStatement(sql);
               stmt.setString(1,Customer_id);
               ResultSet rs = stmt.executeQuery();
               if ( rs.next () )
               {
                   c = new Customer(
                       rs.getString("Customer_id"),
                       rs.getString("Customer_name"),
                       rs.getInt("Customer_walletbal"),
                       rs.getInt("Login_id"),
                       rs.getString("Pasword")
                       );
               }
               stmt.close();
               con.close();
           } catch(Exception e)
           {
               System.out.println( e );
           }
           return c;
      }


// --------------> It grabs all data based of menu based of Food Name

public static Menu MenuInputsDb( String FoodName )
        {
            Menu m = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                PreparedStatement stmt = con.prepareStatement(" Select * from Menu where Food_Name= ? ");
                stmt.setString(1, FoodName);
                ResultSet rs = stmt.executeQuery();
                if ( rs.next () )
                {
                    m = new Menu(
                        rs.getInt("Food_id"),
                        rs.getString("Food_Name"),
                        rs.getInt("Food_Price"),
                        rs.getString("Vendor_id")
                        );
                }
                stmt.close();
                con.close();
            } catch(Exception e)
            {
                System.out.println( e );
            }
            return m;
       }

// -----------> It prints Menu Available from various Canteens Or Vendors

       public static Menu MenuDb(){
        Menu m=null;
        try{  

            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  url,"root","Moh@n$0107");
            Statement stmt=con.createStatement();
            //type sql Query here.........................................!       
            ResultSet rs=stmt.executeQuery("select*from Menu");  

            ArrayList<Menu> list=new ArrayList<Menu>();  

            if(rs.next()) 
            {  
                Menu data =  new Menu(
                    rs.getInt("Food_id"),
                    rs.getString("Food_Name"),
                    rs.getInt("Food_Price"),
                    rs.getString("Vendor_id")
                     );
                list.add(data);
            }
               
                  
        }catch(Exception e)
        { 
            System.out.println(e);
        }  
            
        return m;      
        }
    
   


    public static OrderDetails[] CustomerOrderDetailsDb(String Customer_id)
        {
            
            OrderDetails[] od = null;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " Select * from OrderDetails where Customer_id= ? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, Customer_id);
                ResultSet rs = stmt.executeQuery();
                ArrayList<OrderDetails> list=new ArrayList<OrderDetails>();
                if(rs.next())
                {
                    System.out.println("Obtained data is");
               do
                {
                  OrderDetails  o = new OrderDetails
                    (
                        rs.getInt("Order_No"),
                        rs.getString("Vendor_id"),
                        rs.getString("Customer_id"),
                        rs.getInt("Food_id"),
                        rs.getInt("Quantity"),
                        rs.getInt( "Order_value"),
                        rs.getString("Order_status")
                    );
                        list.add(o); 
                } while(rs.next ());
                od=new OrderDetails[list.size()];
                od= list.toArray(od); 
            }else{
                System.out.println("No orders Placed for the Customer");
                System.exit(0);
            }
            stmt.close();
            con.close();
     } catch(Exception e)
            {
               
                System.out.println( e );
            }
            return od;
    }
       

//________________________________VENDOR IMPLEMENTATION________________________


//VENDOR LOGIN---> It authonticate vendor based on login creditionals.....!

public static Vendor VendorLoginDb( int Login_id, String Pasword )
        {
            Vendor ven = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " select Vendor_id,Vendor_Name,Vendor_Specs from Vendor where VloginId=? and Vpassword=? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1,Login_id);
                stmt.setString(2, Pasword);
                
                ResultSet rs = stmt.executeQuery();
                if ( rs.next () )
                {
                    ven = new Vendor(
                        rs.getString("Vendor_id"),
                        rs.getString("Vendor_name"),
                        rs.getString("Vendor_Specs"));
                }
                stmt.close();
                con.close();
            } catch(Exception e)
            {
                System.out.println( e );
            }
            return ven;
            
            
        }

//VENDOR ORDER DETAILS ----------> It shows all the orders by based on the vendor ID

public static OrderDetails[] VendorOrderDetailsDb(String Vendor_id)
        {
            
            OrderDetails[] od = null;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                url,"root","Moh@n$0107");
                 
                String sql = " Select Order_No,Vendor_id,Customer_id,Food_id,Quantity,Order_value,Order_status from OrderDetails where Vendor_id=? ";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, Vendor_id);
                ResultSet rs = stmt.executeQuery();
                ArrayList<OrderDetails> list=new ArrayList<OrderDetails>();
                if(rs.next())
                {
                    System.out.println("Obtained data is");
                while(rs.next ())
                {
                  OrderDetails  o = new OrderDetails
                    (
                        rs.getInt("Order_No"),
                        rs.getString("Vendor_id"),
                        rs.getString("Customer_id"),
                        rs.getInt("Food_id"),
                        rs.getInt("Quantity"),
                        rs.getInt( "Order_value"),
                        rs.getString("Order_status")
                    );
                        list.add(o); 
                }
                od=new OrderDetails[list.size()];
                od= list.toArray(od); 
            }else{
                System.out.println("No orders Placed for the vendor");
                System.exit(0);
            }
        
     } catch(Exception e)
            {
               
                System.out.println( e );
            }
            return od;
    }

}

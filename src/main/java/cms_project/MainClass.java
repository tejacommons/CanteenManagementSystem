package cms_project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Vector;

import javax.lang.model.util.SimpleAnnotationValueVisitor9;



import cms_project.DataBaseCode.DbAccess;
import cms_project.DbMainLinker.Connector;
import cms_project.gettersandsetters.Customer;
import cms_project.gettersandsetters.Menu;
import cms_project.gettersandsetters.OrderDetails;
import cms_project.gettersandsetters.Vendor;




//mvn exec:java -D exec.mainClass=cms_project.MainClass
//mvn exec:java -D exec.mainClass=cms_project.MainClass
public class MainClass 
{
  static Scanner sc=new Scanner(System.in);
   Customer cobj=new Customer();
    //Starting page of the application
    public static  void startPage() throws IOException
    {
        System.out.println("Welcome To Canteen Management System");
        System.out.println("1--  Show Food Items");
        System.out.println("2--  For Customers");
        System.out.println("3--  Vendor Log-in ");
        System.out.println("4--  Vendor Registration");
        int option=sc.nextInt();
        switch(option)
        {
            case(1) : FoodItems();// Food Items CODE IS ORDERED AND ITS APPROVED FOR SUBMISSION
            break;
            case(2) : Customers(); //Customer CODE IS ORDERED AND ITS APPROVED FOR SUBMISSION new customer 
            //order history shown to be no values found yet to be done..!
            break;
            case(3) : LoginAsVendor(); // VENDOR CODE IS ORDERED AND ITS APPROVED FOR SUBMISSION

            break;
            case(4) :Vendor_Registration_Main();
            default :System.out.println("Invalid Option");
            System.exit(0);
        }
    }
    //_______________________FOOD ITEMS___________________________________

    public static  void FoodItems() throws IOException
    {
        System.out.println("Available Food Items ");
        // Show food items
        MenuAccess();
        //Customer login after food items view...!
        System.out.println();
        Customers();
           // --press 1 to place order
               //Switch() 
                //--Sign in Customer
                //Register user
          //display the message order successful or show order details.
         //main ppage
         startPage(); 
    }

    public static void Customers() throws IOException
    {
        
        System.out.println("press ::- 1---For Login to Customer");
        System.out.println();
        System.out.println("press ::- 2---For Register the Customer");
        int input=sc.nextInt();
        switch(input){
            case(1): LoginAsCustomer();
            break;
            case(2): Cust_Registration_Main();
            break;
            default : System.out.println("Invalid Option");
            System.exit(0);
            break;
        }
        
        
        
    }
    public void Vendors() throws NumberFormatException, IOException
    {
        // System.out.println("Vendor Development page");
        // //login to vendors
        LoginAsVendor();
        //see orders
        //Accept or Reject order(deposite money into the benifiesary account)
        //main page
        //startPage();
    }


//------------------1-------------------------------

// __________________CUSTOMER DATA ACCESS METHOD_______________________
        public static void customerdataAccess()
    {
        Customer cu[]=Connector.fetchCustomer();
        for ( Customer data : cu )
        {
            System.out.println( data);
        }
    }



       public static void MenuAccess()
        {
        Menu m[]=Connector.ConnectorMenu();
        for ( Menu data : m )
        {
            System.out.println( data);
        }

       }

       // _______________________Customer Registration_______________________
       public static void Cust_Registration_Main() throws NumberFormatException, IOException
       {
           BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter the CustomerId");
           String Customer_id = reader.readLine();
           System.out.println("Enter the Name");
           String Customer_name = reader.readLine();
           System.out.println("Customer walletbalance");
           int Customer_walletbal= Integer.parseInt(reader.readLine());
           System.out.println("enter the Login Id");
           int Login_id = Integer.parseInt(reader.readLine());
           System.out.println("Enter the password");
           String Pasword = reader.readLine();
           Connector.ConnectorCustomerRegistration(Customer_id, Customer_name, Customer_walletbal, Login_id, Pasword);
           System.out.println();
           System.out.println("enter the login details");
           LoginAsCustomer();
       }


       public static void Vendor_Registration_Main() throws NumberFormatException, IOException
       {
           BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter the Vendor_Id");
           String Vendor_id = reader.readLine();
           System.out.println("Enter the Name");
           String Vendor_name = reader.readLine();
           System.out.println("Vendor Specs Veg/Non-Veg");
           String  Vendor_Specs= reader.readLine();
           System.out.println("enter the Login Id");
           int VloginId = Integer.parseInt(reader.readLine());
           System.out.println("Enter the password");
           String Vpassword = reader.readLine();
           Connector.ConnectorVendorRegistration(Vendor_id, Vendor_name, Vendor_Specs, VloginId, Vpassword);
           System.out.println();
           
       }
       //Adding item to the menu

       public static void Add_Item_Main(String vendorId) throws NumberFormatException, IOException
       {
           BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Enter the Food Name");
           String Food_Name = reader.readLine();
           String Vendor_id = vendorId;
           System.out.println("enter the Item Cost");
           int Food_Price = Integer.parseInt(reader.readLine());
           Connector.ConnectorAddItem(Food_Name, Food_Price, Vendor_id);
           System.out.println();
           
       }


//__________________CUSTOMER ORDER DATA ACCESS METHOD_____________________
       public static void orderdataAccess(String Customer_id)
       {
           OrderDetails od[]= Connector.connectorCusOrderDetails(Customer_id);
          
           for(OrderDetails data :od)
           {
               System.out.println(data);
           }
       }
//-------------------2-------------------------------
public static void CustomerValidation(int login,String password) throws IOException
{
    Customer cu=Connector.ConnecterCustLogin(login, password);

    String custid=cu.getCustomer_id();
    int cusloginId=cu.getLogin_id();
    String cusPassword=cu.getPasword();
    int wallet_amount=cu.getCustomer_walletbal();
     
    System.out.println( "Cust_ID           :  "+custid);  
    System.out.println( "Cust_name         :  "+cu.getCustomer_name());
    System.out.println( "Cust_walletbaance :  "+cu.getCustomer_walletbal());

    System.out.println();
    System.out.println();
    System.out.println("Choose your Option from ");
    System.out.println();
    System.out.println("1 --> for place order");
    System.out.println("2 --> for order history");
    System.out.println("3 --> for checkbalance");
    System.out.println("4 --> Go to Main Menu");
    System.out.println();
    Scanner input=new Scanner(System.in);
    int read=input.nextInt();
    switch(read)
    {
        case(1) :insertMain(custid,wallet_amount);//placing order
        break;
        case(2) :orderdataAccess(custid);//order details of the customer
        break;
        case(3):checkbalance(cusloginId,cusPassword);//you can check wallet amount here
        break;
        case(4):Customers();// from here you can go to main menu
        break;
    }
    
}


// -----------------------3----------------------------
//___________CUSTOMER LOGIN DATA FORM__________________
public static void LoginAsCustomer() throws IOException
{ 
   Scanner input=new Scanner(System.in);
  Scanner input2=new Scanner(System.in);
  System.out.println("Enter The Login ID");
  int id=input.nextInt();
  System.out.println("Enter The Password");
  String pasword=input2.nextLine();
  CustomerValidation(id,pasword);
}
//----------------------------4---------------------------
///____________CUSTOMER CHECK BALANCE METHOD______________

public static void checkbalance(int id,String password)
{
    Customer cu=Connector.ConnecterCustLogin(id, password);

    String custid=cu.getCustomer_id();
    int cusloginId=cu.getLogin_id();
    String cusPassword=cu.getPasword();

    System.out.println( "Cust_ID           :  "+cu.getCustomer_id());  
    System.out.println( "Cust_name         :  "+cu.getCustomer_name());
    System.out.println( "Cust_walletbaance :  "+cu.getCustomer_walletbal());
}
//----------------------------5-------------------------
public static void placeOrderInputs()
{
}


// VENDOR METHODS HERE
public static void LoginAsVendor() throws NumberFormatException, IOException
{
    Scanner venlogin=new Scanner(System.in);
    Scanner venpasword=new Scanner(System.in);
    System.out.println("Enter the Vendor Login ID");
    int login=venlogin.nextInt();
    System.out.println("Enter the Vendor Login Password");
    String pasword=venpasword.nextLine();
    vendorValidation(login,pasword);
    
}

public static void vendorOrderHistory(String id)
{
    OrderDetails od[]= Connector.connectorVenOrderDetails(id);
    
           for(OrderDetails data :od)
           {
               System.out.println(data);
           }
        
}

public static void vendorValidation(int l,String p) throws NumberFormatException, IOException
{
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    Vendor v= Connector.ConnecterVenLogin(l, p);
    String vendorId=v.getVendor_id();
    System.out.println( "Vendor_name           :  "+v.getVendor_Name());  
    System.out.println( "Vendor_ID             :  "+v.getVendor_id());
    System.out.println( "Vendor_Specs          :  "+v.getVendor_Specs());
    System.out.println("1   for  see order history");
    System.out.println("2   for  Accept or Reject Order");
    System.out.println("3   for Adding Food Item to the Menu");
    Scanner input=new Scanner(System.in);
    int choice=input.nextInt();
    switch(choice)
    {
        case(1) : vendorOrderHistory(vendorId);
        System.exit(0);
        break;
        case(2) :vendorOrderHistory(vendorId);
        System.out.println("Enter the Customer ID");
        String Customer_id=b.readLine();
        OrderAuthorizerInputs(vendorId,Customer_id);
        break;
        case(3) : Add_Item_Main(vendorId);
        break;
        default : System.out.println("Invaldi Choice");
        System.exit(0);
    }
    
   

}
public static void insertMain(String custid,int wallet_amount) throws IOException 
{
    MenuAccess();
    
    InputStreamReader r=new InputStreamReader(System.in);    
    BufferedReader br=new BufferedReader(r);
    System.out.println("Enter the Food Name");
    String FoodName=br.readLine();
    Menu m=Connector.ConnectorMenuInputs(FoodName); 
    int price=m.getFood_Price();
    String venId=m.getVendor_id();
    int FoodId=m.getFood_id();
    
    
    System.out.println("Enter the quantity");
    int quantity=sc.nextInt(); 
    String customerId=custid;
    String venderId=venId;
    int foodId=FoodId;
    String orderStatus="Accepted";
    java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
    int orderValue=price;
    orderValue=orderValue*quantity;
    wallet_amount=wallet_amount-orderValue;
    if(wallet_amount<orderValue)
    {
        System.out.println("Insufficient balance");
    }else{
        Connector.InsertConnector(  venderId, customerId,  foodId, quantity,   date, orderValue, orderStatus);
        //Cust_Wallet_Update(customerId);
        Connector.Connecter_Wallet_Update(wallet_amount, customerId);
        System.out.println("place another order ");
        System.out.println();
        System.out.println("press-->1  place another order");
        System.out.println("press-->2  GO TO Main Menu");
        int res=Integer.parseInt(br.readLine());
        switch(res)
        {
            case(1) :insertMain(custid,wallet_amount);
            break;
            case(2) : startPage();
            break;

        }
    }
   
}



public static void CustomerData(int Order_No,String Customer_id)
{
    Customer c=Connector.ConnectorCustData(Customer_id);
    int Customer_walletbal=c.getCustomer_walletbal();
    mainRefund(Order_No,Customer_walletbal);
}

public static void mainRefund(int Order_No,int Customer_walletbal)
{
    OrderDetails o=Connector.connectorRefundDetails(Order_No);
    String Order_Status="Rejected";
    OrderAuthorizer(Order_Status, Order_No);
    int refund_total=o.getOrder_value();
    String Customer_id=o.getCustomer_id();
    Customer_walletbal=Customer_walletbal+refund_total;
    Object obj=Connector.ConnectorRefund(Customer_walletbal, Customer_id);
}

public static void OrderAuthorizer(String Order_Status,int Order_No)
{
    Object o=Connector.AcceptRejectConnector( Order_Status,Order_No);
}
public static void RejectOrder(int Order_No,String Customer_id) throws IOException
{
    
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    CustomerData( Order_No, Customer_id);

}

public static void OrderAuthorizerInputs(String id,String Customer_id) throws NumberFormatException, IOException
{ 
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    Scanner scan=new Scanner(System.in);
    System.out.println("Enter the order no");
    int Order_No=scan.nextInt();
    System.out.println("order status Accepted or Rejected");
    String Order_Status=reader.readLine();
    switch(Order_Status){
        case("Accepted") : OrderAuthorizer( Order_Status,Order_No);
        break;
        case("Rejected") : RejectOrder(Order_No,Customer_id);
        //For reject a method --1)update customer wallet balance with the amount of ordered value
        break;
    }
    System.out.println("updated Successfully");
    System.exit(0);
}




    public static void main(String[] args) throws IOException
    {
        //Canteen Management starting Page.......
        MainClass mc=new MainClass();
        mc.startPage();
    }
}
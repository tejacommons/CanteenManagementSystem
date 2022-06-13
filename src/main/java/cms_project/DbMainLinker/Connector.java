package cms_project.DbMainLinker;

import java.sql.Date;
import java.time.LocalDate;

import cms_project.DataBaseCode.DbAccess;
import cms_project.gettersandsetters.Customer;
import cms_project.gettersandsetters.Menu;
import cms_project.gettersandsetters.OrderDetails;
import cms_project.gettersandsetters.Vendor;

public class Connector
{
    // ---1----
    public static Customer[] fetchCustomer()
    {
        Customer customer[]=DbAccess.fetchDb();
        return customer;
    }

    public static Menu[] ConnectorMenu()
    {
        Menu menu[]=DbAccess.fetchMenuDb();
        return menu;
    }
    public static Menu getMenuConnector()
    {
        Menu menu=DbAccess.MenuDb();
        return menu;
    }
    public static Object InsertConnector( String venderId, String customerId, int foodId, int quantity,  Date datetime,int orderValue, String orderStatus){
        Object o=DbAccess.insertOrderDb(venderId, customerId, foodId, quantity, datetime, orderValue, orderStatus);
        return o; 
    }
    public static Object ConnectorCustomerRegistration( String Customer_id ,String Customer_name , int Customer_walletbal, int Login_id ,String Pasword){
        Object o=DbAccess.CustomerRegistrationDb(Customer_id ,Customer_name ,  Customer_walletbal, Login_id ,Pasword);
        return o; 
    }
//Adding Menu
    public static Object ConnectorAddItem( String Food_Name,int Food_Price,String Vendor_id){
        Object o=DbAccess.AddToMenu(Food_Name, Food_Price, Vendor_id);
        return o; 
    }
    // String Vendor_id ,String Vendor_name , String Vendor_Specs, int VloginId ,String Vpassword 

    public static Object ConnectorVendorRegistration( String Vendor_id ,String Vendor_name , String Vendor_Specs, int VloginId ,String Vpassword )
    {
        Object o=DbAccess.VendorRegistrationDb(Vendor_id, Vendor_name, Vendor_Specs, VloginId, Vpassword);
        return o; 
    }

    public static Object AcceptRejectConnector(String Order_Status,int Order_No){
        Object o=DbAccess.Accept_RejectDb(Order_Status,Order_No);
        return o;
    }
    public static Object ConnectorRefund(int Customer_walletbal,String Customer_id){
        Object r=DbAccess.Refund(Customer_walletbal,Customer_id);
        return r;
    }
    public static Customer ConnectorCustData(String Customer_id){
        Customer r=DbAccess.Customer(Customer_id);
        return r;
    }
    public static OrderDetails connectorRefundDetails(int Order_No){
        OrderDetails rd=DbAccess.RefundDetails(Order_No);
        return rd;
    }
    //---2----
    public static Customer ConnecterCustLogin(int Login_id, String Pasword)
    {
        Customer c=DbAccess.CustomerLogin(Login_id, Pasword);
        return c;
    }

    public static Object Connecter_Wallet_Update(int wallet_amount, String Customer_id)
    {
        Object c=DbAccess.Cust_Wallet_Update(wallet_amount, Customer_id);
        return c;
    }
    
    public static Menu ConnectorMenuInputs(String FoodName)
    {
        Menu m=DbAccess.MenuInputsDb(FoodName);
        return m;
    }

    //--3----
    public static Vendor ConnecterVenLogin(int Login_id, String Pasword)
    {
        Vendor v=DbAccess.VendorLoginDb(Login_id, Pasword);
        return v;
    }
    
    //----4----
    public static OrderDetails[] connectorCusOrderDetails(String Customer_id)
    {
        OrderDetails[] od=DbAccess.CustomerOrderDetailsDb(Customer_id);
        return od;
    }
    //---5-----
    public static OrderDetails[] connectorVenOrderDetails(String Vendor_id)
    {
        OrderDetails[] od=DbAccess.VendorOrderDetailsDb(Vendor_id);
        return od;
    }

    
}

package cms_project.gettersandsetters;

import java.sql.Date;

public class OrderDetails 
{
private int Order_No;
private String Vendor_id;
private String Customer_id;
private int Food_id; 
private int Quantity;
private Date DateandTime;
private int Order_value;
private String Order_status;
public OrderDetails(String customer_id, int order_value) {
    Customer_id = customer_id;
    Order_value = order_value;
}

public OrderDetails(int order_No, String vendor_id, String customer_id, int food_id, int quantity, int order_value,String order_status)
{
    Order_No = order_No;
    Vendor_id = vendor_id;
    Customer_id = customer_id;
    Food_id = food_id;
    Quantity = quantity;
    Order_value = order_value;
    Order_status = order_status;
}

public OrderDetails(int order_No, String vendor_id, String customer_id, int food_id, int quantity, Date dateandTime,int order_value, String order_status){
    Order_No = order_No;
    Vendor_id = vendor_id;
    Customer_id = customer_id;
    Food_id = food_id;
    Quantity = quantity;
    DateandTime = dateandTime;
    Order_value = order_value;
    Order_status = order_status;
     }
public OrderDetails() {
}
public int getOrder_No() {
    return Order_No;
}
public void setOrder_No(int order_No) {
    Order_No = order_No;
}
public String getVendor_id() {
    return Vendor_id;
}
public void setVendor_id(String vendor_id) {
    Vendor_id = vendor_id;
}
public String getCustomer_id() {
    return Customer_id;
}
public void setCustomer_id(String customer_id) {
    Customer_id = customer_id;
}
public int getFood_id() {
    return Food_id;
}
public void setFood_id(int food_id) {
    Food_id = food_id;
}
public int getQuantity() {
    return Quantity;
}
public void setQuantity(int quantity) {
    Quantity = quantity;
}
public Date getDateandTime() {
    return DateandTime;
}
public void setDateandTime(Date dateandTime) {
    DateandTime = dateandTime;
}
public int getOrder_value() {
    return Order_value;
}
public void setOrder_value(int order_value) {
    Order_value = order_value;
}
public String getOrder_status() {
    return Order_status;
}
public void setOrder_status(String order_status) {
    Order_status = order_status;
}
@Override
public String toString() {
    return "OrderDetails [Customer_id=" + Customer_id + ", DateandTime=" + DateandTime + ", Food_id=" + Food_id
            + ", Order_No=" + Order_No + ", Order_status=" + Order_status + ", Order_value=" + Order_value
            + ", Quantity=" + Quantity + ", Vendor_id=" + Vendor_id + "]";
}
    
}

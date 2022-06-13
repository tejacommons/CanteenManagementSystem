package cms_project.gettersandsetters;

public class Customer
{
    private String Customer_id;
    private String Customer_name;
    private int Customer_walletbal;
    private int Login_id;
    private String Pasword;

   
    public Customer(String customer_id, int customer_walletbal) {
        Customer_id = customer_id;
        Customer_walletbal = customer_walletbal;
    }
    public Customer(String customer_id, String customer_name, int customer_walletbal, int login_id, String pasword)
     {
        Customer_id = customer_id;
        Customer_name = customer_name;
        Customer_walletbal = customer_walletbal;
        Login_id = login_id;
        Pasword = pasword;
    }
    public Customer() {
    }
    public String getCustomer_id() {
        return Customer_id;
    }
    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }
    public String getCustomer_name() {
        return Customer_name;
    }
    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }
    public int getCustomer_walletbal() {
        return Customer_walletbal;
    }
    public void setCustomer_walletbal(int customer_walletbal) {
        Customer_walletbal = customer_walletbal;
    }
    public int getLogin_id() {
        return Login_id;
    }
    public void setLogin_id(int login_id) {
        Login_id = login_id;
    }
    public String getPasword() {
        return Pasword;
    }
    public void setPasword(String pasword) {
        Pasword = pasword;
    }
    @Override
    public String toString() {
        return "Customer [Customer_id=" + Customer_id + ", Customer_name=" + Customer_name + ", Customer_walletbal="
                + Customer_walletbal + ", Login_id=" + Login_id + ", Pasword=" + Pasword + "]";
    }
    
}

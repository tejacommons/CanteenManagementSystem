package cms_project.gettersandsetters;

public class Menu 
{
    
    private int Food_id;
    private String Food_Name; 
    private int Food_Price;
    private String Vendor_id;

    public Menu(int food_id, String food_Name, int food_Price, String vendor_id) 
    {
        Food_id = food_id;
        Food_Name = food_Name;
        Food_Price = food_Price;
        Vendor_id = vendor_id;
    }
    public Menu() {
    }
    public int getFood_id() {
        return Food_id;
    }
    public void setFood_id(int food_id) {
        Food_id = food_id;
    }
    public String getFood_Name() {
        return Food_Name;
    }
    public void setFood_Name(String food_Name) {
        Food_Name = food_Name;
    }
    public int getFood_Price() {
        return Food_Price;
    }
    public void setFood_Price(int food_Price) {
        Food_Price = food_Price;
    }
    public String getVendor_id() {
        return Vendor_id;
    }
    public void setVendor_id(String vendor_id) {
        Vendor_id = vendor_id;
    }
    @Override
    public String toString() {
        return "Menu [Food_Price=" + Food_Price +" ,Vendor=" + Vendor_id  +",Food_Name=" + Food_Name +"]";
    }
    
}

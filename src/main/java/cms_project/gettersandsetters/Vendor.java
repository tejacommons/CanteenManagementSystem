package cms_project.gettersandsetters;

public class Vendor 
{
   private String Vendor_id;
   private String  Vendor_Name; 
   private String Vendor_Specs; 
   private int VloginId;
   private String Vpassword;

public Vendor(String vendor_id, String vendor_Name, String vendor_Specs) {
    Vendor_id = vendor_id;
    Vendor_Name = vendor_Name;
    Vendor_Specs = vendor_Specs;
}
public Vendor(String vendor_id, String vendor_Name, String vendor_Specs, int vloginId, String vpassword) {
    Vendor_id = vendor_id;
    Vendor_Name = vendor_Name;
    Vendor_Specs = vendor_Specs;
    VloginId = vloginId;
    Vpassword = vpassword;
}
public Vendor() {
}
public String getVendor_id() {
    return Vendor_id;
}
public void setVendor_id(String vendor_id) {
    Vendor_id = vendor_id;
}
public String getVendor_Name() {
    return Vendor_Name;
}
public void setVendor_Name(String vendor_Name) {
    Vendor_Name = vendor_Name;
}
public String getVendor_Specs() {
    return Vendor_Specs;
}
public void setVendor_Specs(String vendor_Specs) {
    Vendor_Specs = vendor_Specs;
}
public int getVloginId() {
    return VloginId;
}
public void setVloginId(int vloginId) {
    VloginId = vloginId;
}
public String getVpassword() {
    return Vpassword;
}
public void setVpassword(String vpassword) {
    Vpassword = vpassword;
}
@Override
public String toString() 
{
    return "Menu [Vendor_Name=" + Vendor_Name + ", Vendor_Specs=" + Vendor_Specs + ", Vendor_id=" + Vendor_id + ", VloginId=" + VloginId + ", Vpassword=" + Vpassword + "]";
}
}

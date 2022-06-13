package cms_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Wipro 
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {
       
    }
        


    //program ----1 (kpit)
    public static void numberDouble(){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        Scanner s=new Scanner(System.in);
        int num=scan.nextInt();
        String numberOnly=str.replaceAll("[^0-9]","");
        int n=Integer.parseInt(numberOnly);
        StringBuffer str_buff=new StringBuffer();
        for(int i=0;i<n;i++){
            str_buff.append(str);
        }
        str=str_buff.toString();
        System.out.println(str.charAt(num));
    }

    // wipro program on ordering and calculating price based on distance
    
    public static void orders() throws NumberFormatException, IOException
    {
        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the no of Orders");
        int a=Integer.parseInt(b.readLine());
        // for order price
        int[] array1=new int[a];
        for(int i=0;i<a;i++)
        {
            System.out.println("Enter the order for "+ array1[i]);
            int s=scan.nextInt();
            array1[i]=s;
        }
        // for order box number > 0 
        int[] array2=new int[a];
        for(int j=0;j<a;j++)
        {
            System.out.println("Enter the box Number for "+ array2[j]);
            int t=scan.nextInt();
            array2[j]=t;
        }

        // for distance registration
        int[] array3=new int[a];
        for(int k=0;k<a;k++){
            System.out.println("Enter the Distance  for "+ array3[k]);
            int u=scan.nextInt();
            array3[k]=u;
        }
        for(int l=0;l<a;l++)
        {
            if(array2[l]>0)
            {
                int discount=array1[l]*array3[l];
                System.out.println(discount);
            }

        }
    
}
}

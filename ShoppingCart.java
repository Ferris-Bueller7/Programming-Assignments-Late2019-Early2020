/**
  *   This is a Java class that creates an object called Catalog that used to store Item 
    objects and manipulate them for a shopping cart class 
  
  *  @Author  Ethan Covert
  *  @Version October 27, 2019 
  */
import java.util.ArrayList;
import java.util.Iterator;
public class ShoppingCart
{
   ArrayList<ItemOrder> order;
   boolean discount = false;
   private double total = 0;
   
/**
  * This is a constructor that constructs a shopping cart
  */   
   public ShoppingCart()
   {
      order = new ArrayList<ItemOrder>();
   }
   
/**
  * This method adds an ItemOrder to the shopping cart
  
  * @param temp is the ItemOrder you wish to add
  */   
   public void add(ItemOrder temp)
   {
      boolean TORF = false;
      double removeMe = 0;
      String test = temp.getItem().getName();
      for(int i = 0; i < order.size(); i++)
      {
         ItemOrder temp2 = order.get(i);
         if(temp2.getItem().getName().equals(test))
         {
            TORF = true;
            removeMe = temp2.getPrice();
            
         }
      }
      if(TORF)
      {
         total = total - removeMe; 
      }
      order.add(temp);
      total = total + temp.getPrice();
   }

/**
  * This method activates or deactivates the discount
  
  * @param is determines if you want the discount or not
  */   
   public void setDiscount(boolean TORF)
   {
      if(TORF)
      {
         discount = true;
      }
      else
      {
         discount = false;
      }
   }

/**
  * This method returns the total price
  
  * @return returns the total price
  */   
   public double getTotal()
   {
      if(discount)
      {
         return total /10;
      }
      else
      {
         return total;
      }
   }
   
/**
  * This method formats the shopping cart to print it
  
  * @return returns the list in a printable form
  */   
   public String toString()
   {
      String temp = "";
      for(int i = 0; i < order.size(); i++)
      {
         ItemOrder temp2 = order.get(i);
         temp = temp + temp2.getItem().toString();
      }
      return temp;
   }   
}
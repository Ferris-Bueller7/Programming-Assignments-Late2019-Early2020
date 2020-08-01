/**
  *   This is a Java class that creates an object called Item that used to store prices 
    and names of items that might end up on your shopping cart 
  
  *  @Author  Ethan Covert
  *  @Version October 27, 2019 
  */
import java.lang.IllegalArgumentException;
import java.text.NumberFormat;
public class Item
{
   String name;
   double price;
   int quantity;
   double bulkPrice;
   boolean hasBulkPrice = false;

/**
  * @param name is the name of item you are adding
  * @param price is the price of item you are adding
    
  * This constructor is used if the user only passes in
   name and price when creating an item
  */   
   public Item(String name, double price)
   {
      if(price < 0)
      {
         throw new IllegalArgumentException();
      }
      this.name = name;
      this.price = price;
   }

/**
  * @param name is the name of item you are adding
  * @param price is the price of item you are adding
  * @param quantity the amount of items in bulk
  * @param bulkPrice is the price for bulk items
    
  * This constructor is used if the user passes in name, price, 
   quantity, and price in bulk when creating an item
  */
   public Item(String name, double price, int quantity, double bulkPrice)
   {
      if(price < 0 || quantity <= 0 || bulkPrice <0)
      {
         throw new IllegalArgumentException();
      }
      this.name = name;
      this.price = price;
      this.bulkPrice = bulkPrice;
      this.quantity = quantity;
      hasBulkPrice = true;
   }
   
/**
  * @param quantity the amount of items in bulk
    
  * @return returns price for given item
  
  * This method determines if an item has bulk price and 
   calculates price accordingly
  */
     
   public double priceFor(int quantity)
   {
      if(quantity < 0)
      {
         throw new IllegalArgumentException();
      }
      else if(quantity == 0)
      {
         return 0;
      }
      else
      {
         if(hasBulkPrice)
         {
            int multiplyer = quantity/this.quantity;        
            int remainder = quantity % this.quantity;
            return (multiplyer*bulkPrice)+(remainder*price);
         }
         else
         {
            return quantity*price;
         }
         
      }
   }            
   
/**    
  * @return returns name of the item
  
  * This method returns the name of the item
  */    
   public String getName()
   {
      return name;
   }
/**    
  * @return returns a string describing price and item name
  
  * This method formats and returns the item and name
  */    
   public String toString()
   {
      NumberFormat nf = NumberFormat.getCurrencyInstance();
      if(quantity != 0)
      {
         return name + ", " + nf.format(price) + " (" + quantity + " for " + nf.format(bulkPrice)+")\n";
      }
      else
      {
         return name + ", " + nf.format(price)+"\n";
      }
   }
}
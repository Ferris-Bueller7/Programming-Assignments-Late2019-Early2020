/**
  *   This is a Java class that creates an object called ItemOrder that used to store Items 
    and manipulate them for a shopping cart class 
  
  *  @Author  Ethan Covert
  *  @Version October 27, 2019 
  */
public class ItemOrder
{
   int quantity;
   Item itm;

/**
  * This is a constructor constructing an item order
  */   
   public ItemOrder(Item itm, int quantity)
   {
      this.quantity = quantity;
      this.itm = itm;
   }
   
/**
  * This method is used to get a price of an item 
  accounting for the quantity of item
  
  * @return returns the price of item
  */   
   public double getPrice()
   {
      return itm.priceFor(quantity);
   }
   
/**
  * This method is used to return an item
  
  * @return returns an item
  */   
   public Item getItem()
   {
      return itm;
   }
}
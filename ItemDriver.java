/**
  *   This is a Java class that creates an Array of type Item that manipulates the data 
    such as addding and removing items 
  
  *  @Author  Ethan Covert
  *  @Version October 4, 2019 
  */
import java.util.Arrays;
public class ItemDriver
{
   public static void main(String[] args)
   {
      Item[] list = new Item[1];
      int numberOfItems = 0;
      
      System.out.println("Adding to List: ");
      numberOfItems++;
      list = addItem(list,numberOfItems,"Apples",3.00);     
      System.out.println();
      System.out.println();
      printList(numberOfItems,list);      
      System.out.println();
      System.out.println();
      System.out.println("Adding to List: ");
      numberOfItems++;
      list = addItem(list,numberOfItems,"pineapples",6.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"watermelon",8.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"turkey",12.00);            
      numberOfItems++;
      list = addItem(list,numberOfItems,"pizza",15.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"candy",1.50,10,12.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"water",12.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"grapes",2.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"cherries",5.00,2,8.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"mangos",2.00);
      System.out.println();
      System.out.println();
      printList(numberOfItems,list);
      System.out.println();
      System.out.println();
      System.out.println("Removing from the List:");
      System.out.println("You have: "+removeItem("Chips",list,numberOfItems)+" items on your list");
      numberOfItems = removeItem("grapes",list,numberOfItems);
      numberOfItems = removeItem("candy",list,numberOfItems);
      numberOfItems = removeItem("Apples",list,numberOfItems);
      numberOfItems = removeItem("PineApples",list,numberOfItems);
      numberOfItems = removeItem("turkey",list,numberOfItems);
      numberOfItems = removeItem("pizza",list,numberOfItems);
      numberOfItems = removeItem("watermelon",list,numberOfItems);
      numberOfItems = removeItem("water",list,numberOfItems);                              
      numberOfItems = removeItem("cherries",list,numberOfItems);
      numberOfItems = removeItem("mangos",list,numberOfItems);
      System.out.println("You have: "+removeItem("tortillas",list,numberOfItems)+" items on your list");
      printList(numberOfItems, list);            
      System.out.println();
      System.out.println();
      numberOfItems++;
      list = addItem(list,numberOfItems,"peach",2.00,6,10.00);
      numberOfItems++;
      list = addItem(list,numberOfItems,"pasta",8.00,3,20.00);
      System.out.printf("The price of a %s is : %.2f \n",list[0].getName(),list[0].priceFor(1));
      System.out.printf("The price of 3 %ses is : %.2f \n",list[0].getName(),list[0].priceFor(3));
      System.out.printf("The price of 12 %ses is : %.2f \n",list[0].getName(),list[0].priceFor(12));
   }

/**
  * @param itemList is the array of Items
  * @param numOfItems number of items in array of items
  * @param name is the name of item you are adding
  * @param price is the price of item you are adding
  
  * @return returns the new list with the added item
  
  * This method adds items that don't have a bulk option
  */   
   public static Item[] addItem(Item[] itemList, int numOfItems, String name, double price)
   {
      Item[] newList = itemList;
      if(itemList.length < numOfItems)
      {
         newList = doubleLength(itemList);
      }
      newList[numOfItems-1] = new Item(name, price);
      System.out.printf("Added %s $%.2f\n",name,price);

      
      return newList;   
   }

/**
  * @param itemList is the array of Items
  * @param numOfItems number of items in array of items
  * @param name is the name of item you are adding
  * @param price is the price of item you are adding
  * @param quantity is the amount in the bulk option
  * @param bulkPrice is the price of item you are adding in bulk
 
  * @return returns the new list with the added item
  
  * This method adds items that have a bulk option
  */   
   public static Item[] addItem(Item[] itemList, int numOfItems, String name, double price, int quantity, double bulkPrice)
   {
      Item[] newList = itemList;
      if(itemList.length < numOfItems)
      {
         newList = doubleLength(itemList);
      }
      newList[numOfItems-1] = new Item(name, price, quantity, bulkPrice);
      System.out.printf("Added %s $%.2f bulk item @ $%.2f for %d\n",name,price,bulkPrice,quantity);
      
      return newList;   
   }  
   
/**
  * @param itemList is the array of Items
  * @param numOfItems number of items in array of items
  * @param name is the name of item you are adding

  * @return returns the new number of items on the list
  
  * This method removes items from the list
  */   
   public static int removeItem(String name, Item[] itemList, int numOfItems)
   {
      boolean TORF = false;
      int location = 0;
      for(int i = 0; i < numOfItems; i++)
      {
         if(itemList[i].getName().equalsIgnoreCase(name))
         {
            location = i;
            TORF = true;
         }
      }
      if(TORF)
      {
         itemList[location] = null;
         for(int i = location; i < itemList.length-1; i++)
         {
            Item temp = itemList[i]; 
            itemList[i] = itemList[i+1];
            itemList[i+1] = temp;
         } 
         System.out.println("Removed "+name);
         numOfItems--; 
      }
      else
      {
         System.out.printf("%s is not on the list \n",name);
         int temp = 0;
      }
      return numOfItems;
   } 

/**
  * @param itemList is the array of Items

  * @return returns the new list twice the size of the old list
  
  * This method doubles the length of the list
  */   
   public static Item[] doubleLength(Item[] itemList)
   {
      Item[] newList = new Item[itemList.length*2];
      for(int i = 0; i < itemList.length; i++)
      {
         newList[i] = itemList[i];
      }
      return newList;
   }

/**
  * @param itemList is an array of Items
  * @param numOfItems number of items in array of items
  
  * This method prints the list
  */   
   public static void printList(int numOfItems, Item[] itemList)
   {
      if(numOfItems == 0)
      {
         System.out.println("List is empty");         
      }
      else
      {
         System.out.println("List:");
         for(int i = 0; i < numOfItems; i++)
         {
            System.out.println(itemList[i].toString());
         }
      }
   }
}
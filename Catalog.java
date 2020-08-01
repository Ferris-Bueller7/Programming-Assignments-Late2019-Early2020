/**
  *   This is a Java class that creates an object called Catalog that used to store Item 
    objects and manipulate them for a shopping cart class 
  
  *  @Author  Ethan Covert
  *  @Version October 27, 2019 
  */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
public class Catalog
{
   String title;
   ArrayList<Item> list = new ArrayList<Item>();

/** This is a constructor used to title the catalog
  */   
   public Catalog(String name)
   {  
      title = name;
   }

/**
  * This method is used to add items to the catalog
  
  * @param temp is the item you wish to add
  */   
   public void add(Item temp)
   {
      list.add(temp);
   }

/**
  * This method is find the size of the catalog
  
  * @return int returns the size of the list
  */   
   public int size()
   {
      return list.size();
   }

/**
  * This method is used to return an item you wish to see
  
  * @param place is the index of the item you wish to get
  * @return returns item you requested
  */   
   public Item get(int place)
   {
      Scanner kb = new Scanner(System.in);
      if(place > list.size()-1)
      {
         throw new IndexOutOfBoundsException();
      }
      return list.get(place);
   }
   
/**
  * This method is used to return the name of the catalog
  
  * @return returns the name of the catalog
  */   
   public String getName()
   {
      return title;
   }
   
/**
  * This method is used to print everything on the list
  
  * @return prints the list to the console
  */   
   public String toString()
   {
      Iterator<Item> itr = list.iterator();
      String temp2 = "";
      while(itr.hasNext())
      {
         Item temp = itr.next();
         temp2 = temp2 + temp.toString();
      }
      return temp2;
   }
   
}
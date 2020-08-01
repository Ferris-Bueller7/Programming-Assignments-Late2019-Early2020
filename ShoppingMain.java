// ShoppingMain provides method main for a simple shopping program.

public class ShoppingMain 
{    
   public static void main(String[] args) 
   {
        Catalog list = new Catalog("CS Gift Catalog");
        list.add(new Item("silly putty", 3.95, 10, 19.99));
        list.add(new Item("silly string", 3.50, 10, 14.95));
        list.add(new Item("bottle o bubbles", 0.99));
        list.add(new Item("Nintendo Wii system", 389.99));
        list.add(new Item("Mario Computer Science Party 2 (Wii)", 49.99));
        list.add(new Item("Don Knuth Code Jam Challenge (Wii)", 49.99));
        list.add(new Item("Computer Science pen", 3.40));
        list.add(new Item("Rubik's cube", 9.10));
        list.add(new Item("Computer Science Barbie", 19.99));
        list.add(new Item("'Java Rules!' button", 0.99, 10, 5.0));
        list.add(new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95));
        ShoppingFrame f = new ShoppingFrame(list);
        f.setVisible(true);

//       Test Code for item class
//       Item itm = new Item("Grapes",3.05,2,5.50);
//       System.out.println("price of grapes for 0 bags: "+itm.priceFor(0));
//       System.out.println("price of grapes for 1 bags: "+itm.priceFor(1));
//       System.out.println("price of grapes for 4 bags: "+itm.priceFor(4));
//       System.out.println("name: "+itm.getName());
//       System.out.println(itm);
//       System.out.println();
//       
//       Item i = new Item("apples",.5);
//       System.out.println("price of 0 apple: "+i.priceFor(0));
//       System.out.println("price of 1 apple: "+i.priceFor(1));
//       System.out.println("price of 4 apples: "+i.priceFor(4));
//       System.out.println("name: "+i.getName());
//       System.out.println(i);
//       System.out.println();
//       
//       Test Code for Catalog class
//       Catalog cat = new Catalog("Test");
//       cat.add(itm);
//       cat.add(i);
//       cat.add(new Item("fish",5.50,3,15));
//       cat.add(new Item("chicken",3,2,5));
//       cat.add(new Item("beef",4,3,11));
//       System.out.println(cat);
//       
//       cat.add(new Item("catfood",5.50,2,10));
//       System.out.println(cat);
//       System.out.println("size of list: "+cat.size());
//       
//       System.out.println(cat.get(0));
//       try
//       {
//          cat.get(7);
//       }
//       catch(IndexOutOfBoundsException e)
//       {
//          System.out.println("No such element in list");
//       }
//       
//       System.out.println(cat.getName());
//       
//       Test Code for ItemOrder
//       ItemOrder ito = new ItemOrder(i,6);
//       System.out.println(ito.getPrice());
//       System.out.println(ito.getItem());
//       
//       Test Code for Shopping Cart
//       ShoppingCart shop = new ShoppingCart();
//       shop.add(ito);
//       shop.add(new ItemOrder(itm,3));
//       shop.add(new ItemOrder(new Item("Shark",20,2,35),3));
//       System.out.println(shop);
//       correct total is 66.55
//       System.out.println(shop.getTotal());
//       
//       shop.add(new ItemOrder(new Item("Shark",20,2,35),4));
//       System.out.println(shop);      
//       System.out.println(shop.getTotal());
    }
}

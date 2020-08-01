
public class MainClass 
{
	public static void main(String[] args)
	{
		Node tmp = new Node(4,"hello");
		BinaryTree temp = new BinaryTree();
		temp.add(tmp.key(),tmp.value());
		temp.add(5, "World");
		System.out.println(temp.about());
		temp.add(100, "test");
		temp.add(120, "Where");
		temp.add(50, "yikes");
		temp.add(90, "check");
		temp.add(3, "YOOOOOOO");
		System.out.println();
		temp.remove(120);		
		temp.printTree();
		temp.clear();		
		temp.printTree();
		//temp.remove(100);
	}
	
}

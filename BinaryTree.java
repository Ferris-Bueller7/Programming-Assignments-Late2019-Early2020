// Ethan Covert Assignment2 3/18/20
public class BinaryTree 
{
	Node root;
	int count = 0;
	public BinaryTree()
	{
		root = null;
	}
	
	public void add(int key, String value)
	{
		if(root == null)
		{
			root = new Node(key,value);
		}
		else
		{
			root.add(key,value);
		}
	}
	
	public boolean contains(int key)
	{
		return root.contains(key);
	}
	
	public void remove(int key)
	{
		//root.remove(key);
		if(root.remove(key,root))
		{
			System.out.printf("Your key %d has successfully been removed\n",key);
		}
		else
		{
			System.out.printf("There was an error and your key %d wasn't removed (may or may not exist)\n",key);
		}
	}
	
	public void clear()
	{
		root = null;
	}
	
	public String about()
	{
		return "Ethan Covert";
	}
	
	public void printInfix()
	{
		root.printInfix();
	}
	
	public void printTree()
	{
		if(root == null)
		{
			System.out.println("Sorry no can do!");
		}
		else
		{
			root.printTree(count);
		}
	}
}

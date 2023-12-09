package pack;

public class BinarySearchTree {
	private Node Root;
	
	public BinarySearchTree()
	{
		this.Root = null;
	}
	
	public Node Search(int value)
	{
		//Go to root node
		Node node = this.Root;
		while(node != null)
		{
			//Compare the value of the node
			if(node.Data == value)
			{
				//matches return node
				return node;
			}
			else if(value < node.Data)
			{
				node = node.leftNode;
			}
			else if(value > node.Data)
			{
				node = node.rightNode;
			}
		}
			return null;		
	}
	
	public void Insert(int value)
	{
		Node newNode = new Node(value);
		Node node = this.Root;
		if(node == null)
		{
			this.Root = newNode;
			return;
		}
		while(node != null)
		{
			if(value <= node.Data)
			{
				if(node.leftNode == null)
				{
					node.leftNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node = node.leftNode;
			}
			else if(value > node.Data)
			{
				if(node.rightNode == null)
				{
					node.rightNode = newNode;
					newNode.parentNode = node;
					return;
				}
				node = node.rightNode;
			}
		}
	}
	public void Remove(int value) {
	    Root = removeRecursive(Root, value);
	}

	private Node removeRecursive(Node root, int value) {
	    if (root == null) {
	        return root;
	    }

	    if (value < root.Data) {
	        root.leftNode = removeRecursive(root.leftNode, value);
	    } else if (value > root.Data) {
	        root.rightNode = removeRecursive(root.rightNode, value);
	    } else {
	        if (root.leftNode == null) {
	            return root.rightNode;
	        } else if (root.rightNode == null) {
	            return root.leftNode;
	        }

	        root.Data = minValue(root.rightNode);

	        root.rightNode = removeRecursive(root.rightNode, root.Data);
	    }
	    return root;
	}

	private int minValue(Node node) {
	    int minValue = node.Data;
	    while (node.leftNode != null) {
	        minValue = node.leftNode.Data;
	        node = node.leftNode;
	    }
	    return minValue;
	}

	public void PrintStructure() {
	    printStructure(Root, "");
	}

	private void printStructure(Node root, String prefix) {
	    if (root != null) {
	        System.out.println(prefix + "└── " + root.Data);
	        printStructure(root.rightNode, prefix + "    │");
	        printStructure(root.leftNode, prefix + "    ");
	    }
	}
}

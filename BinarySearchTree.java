class BinarySearchTree {

  class Node {
    int key;
    Node left, right;

    public Node(int item) {
      key = item;
      left = right = null;
    }
  }

  Node root; //Root of Binary Search Tree
  
  //Creating a Constructor
  BinarySearchTree() { 
    root = null;
  }
  
  //This method mainly calls insertKey()
  void insert(int key) {
    root = insertKey(root, key);
  }

  //Recursive function to  insert a new key in Binary Search Tree
  Node insertKey(Node root, int key) { 
	
	//If the tree is empty, return a new node
    if (root == null) {
      root = new Node(key);
      return root;
    }
    
    //Otherwise, recur down the tree
    if (key < root.key)
      root.left = insertKey(root.left, key);
    else if (key > root.key)
      root.right = insertKey(root.right, key);

    //return the node pointer 
    return root;
  }
  
  //This method mainly calls inorderRec()
  void inorder() {
    inorderRec(root);
  }
  //The function of this is to do an inorder traversal of Binary Search Tree
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " -> ");
      inorderRec(root.right);
    }
  }
  
  //This method mainly calls deleteRec()
  void deleteKey(int key) {
    root = deleteRec(root, key);
  }
  
  //Recursive function to  delete an existing key in Binary Search Tree
  Node deleteRec(Node root, int key) {
	  
	//If the tree is empty
    if (root == null)
      return root;
    
    //Otherwise, recur down the tree 
    if (key < root.key)
      root.left = deleteRec(root.left, key);
    else if (key > root.key)
      root.right = deleteRec(root.right, key);
    //if key is same as root's key, then This is the node to be deleted
    else {
      // node with only one child or no child
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;
      
      //This if for node with two children: Get the inorder successor (smallest in the right subtree)
      root.key = minValue(root.right);
      
      // Delete the inorder successor
      root.right = deleteRec(root.right, root.key);
    }

    return root;
  }

  int minValue(Node root) {
    int minv = root.key;
    while (root.left != null) {
      minv = root.left.key;
      root = root.left;
    }
    return minv;
  }

  public static void main(String[] args) {
	  
	//Creating a new object
    BinarySearchTree tree = new BinarySearchTree();
    
    //Inserting values
    tree.insert(50);
    tree.insert(17);
    tree.insert(12);
    tree.insert(9);
    tree.insert(14);
    tree.insert(23);
    tree.insert(72);
    tree.insert(54);
    tree.insert(67);
    tree.insert(76);
    
    System.out.println("Inorder Traversal: ");
    tree.inorder();
    System.out.println("");
    
    System.out.println("\nDeleting 9");
    System.out.println("");
    tree.deleteKey(9);
    System.out.println("Inorder traversal of the modified tree:");
    tree.inorder();
    System.out.println("");
    
    System.out.println("\nDeleting 54");
    System.out.println("");
    tree.deleteKey(54);
    System.out.println("Inorder traversal of the modified tree:");
    tree.inorder();
    
  }
}
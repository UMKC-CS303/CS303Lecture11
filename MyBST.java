import java.util.*;

public class MyBST<E extends Comparable<E>> implements MyTree<E> {

  private TreeNode<E> root;
  private int size = 0; // Number of elements in the list
  
  /** Create an empty list */
  public MyBST() {
  }

  /** Create a list from an array of objects */
  public MyBST(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      insert(objects[i]); 
  }

  public int getSize(){return size;}

  public boolean isEmpty(){return size == 0;}

  @Override
  //TASK 1: SEARCH
  //PRE:  accepts an element to find in the tree
  //POST: if tree is found return true, else return false

  public boolean search(E e){
    System.out.println("\tTASK 1: Code search method");
    return false;
  }


  @Override
  //TASK 2: INSERT
  //PRE:  accepts an element to add into the tree
  //POST: if tree is empty, sets root to new node, 
  //           update size, returns true
  //      else searches for a place to insert
  //      if element is already in the tree, return false
  //      else add the node to the correct 'side' of parent
  //      update size and return true

  public boolean insert(E e){
    if (root == null){
      root = createNewNode(e);
      size ++;
      return true;
    }
    System.out.println("\tTASK 2: Code insert method");
    //find point of insertion tracking
    //parent & current nodes

    return false;
  }
    

  //PRE:  none
  //POST: prints tree inOrder
  public void inOrder(){
    inOrder(root);
  }

  public void inOrder(TreeNode<E> root){
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.element + " ");
    inOrder(root.right);
  }

  //TASK 3: PREORDER
  //PRE:  none
  //POST: prints tree preOrder
  public String preOrderString(){
    return ("TASK 3: Code preOrder");
    //return preOrder(root);
  }

    public String preOrder(TreeNode<E> root){
    if (root == null) 
        return "";

    return root.element + " " + preOrder(root.left) + preOrder(root.right);
  }

  //TASK 4: POSTORDER
  //PRE:  none
  //POST: prints tree postOrder
  public String postOrderString(){
    return ("TASK 4: Code postOrder");
    //return postOrder(root);
  }
    public String postOrder(TreeNode<E> root){
    if (root == null) 
        return "";

    return  postOrder(root.left) + postOrder(root.right) + root.element + " ";
  }
  //TASK 5: DELETE METHOD
  //PRE:  accepts an element to delete in the tree
  //POST: if element is found, delete & return true,
  //      else return false

  public boolean delete(E e){

    //find the element
    TreeNode<E> parent = null;
    TreeNode<E> current = root;

    while (current != null){
      if (e.compareTo(current.element) < 0){
        parent = current;
        current = current.left;
      }
      else if (e.compareTo(current.element) > 0){
        parent = current;
        current = current.right;
      }
      else
        break;
    }
    
    //case 1:  item not found
    if (current == null)
      return false;

    //case 2: current has 0 or 1 child
    if (current.left == null || current.right == null){
      TreeNode<E> child;
      if (current.left != null)
        child = current.left;
      else
        child = current.right;

      if (parent == null)
        root = child;
      else {
        if (parent.left == current)
          parent.left = child;
        else
          parent.right = child;
      }
      size --;
      return true;
    }

    //case 3: current has 2 children
    //        swap with the inorder predecessor
    //        (the rightmost node in left child) & swap
    TreeNode<E> parentofRightMost = current;
    TreeNode<E> rightMost = current.left;

    while (rightMost.right != null){
      parentofRightMost = rightMost;
      rightMost = rightMost.right;
    }
    current.element = rightMost.element;
    if (parentofRightMost.right == rightMost)
      parentofRightMost.right = rightMost.left;
    else
      parentofRightMost.left = rightMost.left;
  
    size --;
    return true;

  }

  public void clear(){
    root = null;
    size = 0;
  }

  //PRE:  none
  //POST: prints tree in order *generic
  //      using recursive calls
  public String inOrderString() {
      StringBuilder sb = new StringBuilder();
      inOrderString(root, sb);
      return sb.toString().trim();
  }

  private void inOrderString(TreeNode<E> root, StringBuilder sb) {
      if (root == null) return;

      inOrderString(root.left, sb);
      sb.append(root.element).append(" ");
      inOrderString(root.right, sb);
  }



  //TASK 6: ISLEAF
  //PRE:  accepts an element to find in the tree
  //POST: returns true if this is a leaf, false otherwise

  public boolean isLeaf(E e){
    TreeNode<E> current = root;
    System.out.println("\tTASK 6: code isLeaf method");
    return false;

  }

  //TASK 7: heightWrapper
  //PRE:  none - start at root
  //POST: returns the height of the tree

  public int heightWrapper(){
    TreeNode<E> current = root;
    return height(current) - 1;
  }

  private int height(TreeNode<E> root){
    System.out.println("\tTASK 7: code height method");
    return 0;
  }

  //TASK 8: Depth
  //PRE:  accepts an element to find in the tree
  //POST: returns the depth of the node in the tree
  //      or -1 if not found

  public int depth(E e){
    TreeNode<E> current = root;
    int depthCount = 0;
    System.out.println("\tTASK 8: code depth method");
    return -1;
  }

  
  //TASK 9: MINIMUM
  //PRE:  none
  //POST: returns the minimum element in the BST

  public E findMin(){
    TreeNode<E> current = root;
    System.out.println("\tTASK 9: code minimum method");
      
    return null;
  }

  //TASK 9: MAXIMUM
  //PRE:  none
  //POST: returns the maximum element in the BST

  public E findMax(){
    TreeNode<E> current = root;
    System.out.println("\tTASK 9: code maximum method");
      
    return null;
  }

  //TASK 10: UPDATE
  //PRE:  accepts original element value & new value
  //POST: updates the original value in the BST

  public boolean update(E origE, E newE){

    System.out.println("\tTASK 10: code update method");
    return false;
  }


  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new BSTTreeIterator();
  }
  
  private class BSTTreeIterator implements java.util.Iterator<E>{
    private ArrayList<E> BSTList = new ArrayList<>();
    private int current = 0;

    public BSTTreeIterator(){
      fillBSTList();
    }

    private void fillBSTList(){ 
      fillBSTList(root);
    }

    private void fillBSTList(TreeNode<E> root){
      if (root == null) return;
      fillBSTList(root.left);
      BSTList.add(root.element);
      fillBSTList(root.right);
    }

    @Override
    public boolean hasNext(){
      if (current < BSTList.size()) return true;
      return false;
    }

    @Override
    public E next(){
      return BSTList.get(current++);
    }

    @Override 
    public void remove(){
      delete (BSTList.get(current));
      BSTList.clear();
      fillBSTList();
    }

  }
  
  private TreeNode<E> createNewNode(E e){
    return new TreeNode<E>(e);
  }

  private static class TreeNode<E extends Comparable<E>> {
     private E element;
     private TreeNode<E> left;
     private TreeNode<E> right;

    private TreeNode(E element) {
      this.element = element;
    }
  }
  

}


import java.util.*;

public class MyBST<E extends Comparable<E>> implements MyTree<E> {

  protected TreeNode<E> root;
  protected int size = 0; // Number of elements in the list
  
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
        return false;  //e is in the tree
    }

    if (e.compareTo(parent.element) < 0)
      parent.left = createNewNode(e);
    else
      parent.right = createNewNode(e);
  
    size ++;
    return true;
  }
    
  @Override
  //TASK 1: SEARCH
  //PRE:  accepts an element to find in the tree
  //POST: if tree is found return true, else return false

  public boolean search(E e){
    TreeNode<E> current = root;
    System.out.println("TASK 1: Code search method");
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

  //TASK 2: PREORDER
  //PRE:  none
  //POST: prints tree preOrder
  public void preOrder(){
    System.out.println("TASK 2: Code preOrder");
  }


  //TASK 3: POSTORDER
  //PRE:  none
  //POST: prints tree postOrder
  public void postOrder(){
    System.out.println("TASK 3: Code postOrder");
  }


  //TASK 4: DELETE METHOD
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

    //case 2: current has no left child
    if (current.left == null){
      if (parent == null)
        root = current.right;
      else{
        if (parent.left == current)
          parent.left = current.right;
        else
          parent.right = current.right;
      }
      size --;
      return true;
    }

    //case 3: current has a left child
    //        find rightmost node in left child & swap
    TreeNode<E> parentofRightMost = current;
    TreeNode<E> rightMost = current.left;

    while (rightMost.right != null){
      parentofRightMost = rightMost;
      rightMost = rightMost.right;
    }

    //swap element at current with rightmost value
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

  //TASK 5: ISLEAF
  //PRE:  accepts an element to find in the tree
  //POST: returns true if this is a leaf, false otherwise

  public boolean isLeaf(E e){
    TreeNode<E> current = root;
    System.out.println("TASK 5: code isLeaf method");
    return false;
  }

  //TASK 6: heightWrapper
  //PRE:  none - start at root
  //POST: returns the height of the tree

  public int heightWrapper(){
    TreeNode<E> current = root;
    return height(current);
  }

  private int height(TreeNode<E> root){
    System.out.println("TASK 6: code height method");
    return 0;
  }

  //TASK 7: Depth
  //PRE:  accepts an element to find in the tree
  //POST: returns the depth of the node in the tree
  //      or -1 if not found

  public int depth(E e){
    TreeNode<E> current = root;
    int depthCount = -1;
    System.out.println("TASK 6: code depth method");
    return -1;
  }

  
  //TASK 8: MINIMUM
  //PRE:  none
  //POST: returns the minimum element in the BST

  public E findMin(){
    TreeNode<E> current = root;
    System.out.println("TASK 8: code minimum method");
      
    return null;
  }

  //TASK 8: MAXIMUM
  //PRE:  none
  //POST: returns the maximum element in the BST

  public E findMax(){
    TreeNode<E> current = root;
    System.out.println("TASK 8: code maximum method");
      
    return null;
  }

  //TASK 9: UPDATE
  //PRE:  accepts original element value & new value
  //POST: updates the original value in the BST

  public boolean update(E origE, E newE){

    System.out.println("TASK 9: code update method");
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
  
  protected TreeNode<E> createNewNode(E e){
    return new TreeNode<E>(e);
  }

  private static class TreeNode<E extends Comparable<E>> {
     protected E element;
     protected TreeNode<E> left;
     protected TreeNode<E> right;

    public TreeNode(E element) {
      this.element = element;
    }
  }
  

}


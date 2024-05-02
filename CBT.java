// Student Name Fernando Perez
// Date 04/10/2023
// CSCI 3302 Section 001
//
// Files: CBT.java
//
// Description: This program builds a complete binary tree using the methods size(), goLeft(), add(), and contains()

public class CBT<T> {

  private T item; // the item stored at root of this tree
  private int size; // the number of nodes in the subtree
  private CBT<T> leftChild; // reference to the left subtree
  private CBT<T> rightChild; // reference to the right subtree

  /**
   * This constructor adds the new item, sets both children to
   * null and the size (of the subtree rooted at this node) to 1.
   *
   * @param newItem - item stored at root of tree
   * A reference to the tree is returned.
   */
  public CBT(T newItem) {
      this.item = newItem;
      this.size = 1;
      this.leftChild = null;
      this.rightChild = null;
  } // end constructor

  /**
   * This method returns the number of items within the subtree
   * rooted at this node. This method should execute in constant
   * time; i.e. O(1).
   * @return - returns an integer representing the number of elements in the tree
   */
  public int size() {
      return size;
    } // end size

  /**
   * This method is a helper function used by the add method that
   * determines, at a given CBT node, whether the next traversal
   * should occur on the left subtree or not.
   * @return - true if we should traverse left and false otherwise
   *
   */
  private boolean goLeft() {
      if(this.leftChild == null){
        return false;
      }
      if(this.rightChild == null){
        return true;
      }

      int leftSize = this.leftChild.size();
      int rightSize = this.rightChild.size();
      return leftSize < rightSize;
    
  } // end goLeft

  /**
   * This method creates a new CBT node containing the newItem and
   * adds it to the complete tree as a leaf in the next available
   * location.
   * This method should execute in O(log n) where n is
   * the number of elements in the tree
   *
   * @param - given the item to add to the tree
   *
   */
  public void add(T newItem) {
      if(this.leftChild == null){
        this.leftChild = new CBT<>(newItem);
      } else if(this.rightChild == null){
        this.rightChild = new CBT<>(newItem);
      } else {
          if(goLeft()){
            this.leftChild.add(newItem);
          } else {
            this.rightChild.add(newItem);
          }

      }
      size++;
    
  } // end add

  /**
   * This method determines whether or not checkItem is in the tree.
   * This method should execute in O(n) where n is the number of
   * elements in the tree.
   * @param checkItem - reference to item to determine if in the tree
   * @return true if given item is in the tree, false otherwise
   */
  public boolean contains(T checkItem) {
    if(this.item.equals(checkItem)){
      return true;
    } else if (this.leftChild != null && this.leftChild.contains(checkItem)){
      return true;
    } else if (this.rightChild != null && this.rightChild.contains(checkItem)){
      return true;
    } else {
      return false;
    }
  }
   // end contains
 } // end CBT





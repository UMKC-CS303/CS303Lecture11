public interface MyTree<E> extends Iterable<E> {

    //abstract methods
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete(E e);
    public int getSize();
    public boolean isEmpty();


    //default methods
    public default void inOrder(){}
    public default void preOrder(){}
    public default void postOrder(){}

}


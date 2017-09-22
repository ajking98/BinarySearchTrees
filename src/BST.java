import java.util.Collection;
import java.util.List;


/**
 * Your implementation of a binary search tree.
 *
 * @author YOUR NAME HERE
 * @userid YOUR USER ID HERE (i.e. gburdell3)
 * @GTID YOUR GT ID HERE (i.e. 900000000)
 * @version 1.0
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty BST.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
        size = 0;
    }

    /**
     * Initializes the BST with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        size = 0;
        for (T t : data) {
            dataIsNullCheck(t);
            add(t);
        }
    }

    @Override
    public void add(T data) {
        dataIsNullCheck(data);
        if (root == null) {
            root = new BSTNode<T>(data);
            size++;
        } else {
            add(data);
        }
    }

    @Override
    public T remove(T data) {
        return data;
    }

    @Override
    public T get(T data) {
        dataIsNullCheck(data);
        if (root == null) {
            throw new java.util.NoSuchElementException("Element does not " +
                    "exist");
        }
        return data;

    }

    @Override
    public boolean contains(T data) {
        dataIsNullCheck(data);
        return false;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    @Override
    public List<T> preorder() {
        return null;
    }

    @Override
    public List<T> postorder() {
        return null;
    }

    @Override
    public List<T> inorder() {
        return null;
    }

    @Override
    public List<T> levelorder() {
        return null;
    }

    @Override
    public List<T> listLeavesDescending() {
        return null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return 0;
    }


    @Override
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     *
     * @param data the data to check if it is null or not
     */
    private void dataIsNullCheck(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
    }
}

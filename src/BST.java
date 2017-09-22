import java.util.Collection;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


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
        root = add(data, root);
    }

    /**
     *
     * @param data
     * @param curr
     * @return
     */
    private BSTNode<T> add(T data, BSTNode<T> curr) {
        if (curr == null) {
            BSTNode<T> nodeData = new BSTNode<T>(data);
            size++;
            return nodeData;
        } else if (curr.getData().compareTo(data) > 0) {
            curr.setLeft(add(data, curr.getLeft()));
        } else if (curr.getData().compareTo(data) < 0) {
            curr.setRight(add(data, curr.getRight()));
        }
        return curr;
    }
    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        } else {
            BSTNode<T> dummy = new BSTNode<T>(null);
            root = removeHelper(data, root, dummy);
            return dummy.getData();
        }
    }

    /**
     * Remove helper function
     * @param data T data
     * @param curr current node
     * @param dummy dummy node
     * @return BST node
     */
    private BSTNode<T> removeHelper(T data, BSTNode<T> curr, BSTNode<T> dummy) {
        if (curr == null) {
            throw new NoSuchElementException("The data is not in the BST");
        }
        if (data.equals(curr.getData())) {
            dummy.setData(curr.getData());
            size--;
            if (curr.getLeft() == null && curr.getRight() == null) {
                return null;
            }

            if (curr.getLeft() != null && curr.getRight() != null) {
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                curr.setLeft(removePred(curr.getLeft(), dummy2));
                curr.setData(dummy2.getData());
            } else if (curr.getLeft() != null || curr.getRight() != null) {
                if (curr.getLeft() != null) {
                    return curr.getLeft();
                } else {
                    return curr.getRight();
                }
            }
        } else if (curr.getData().compareTo(data) < 0) {
            curr.setRight(removeHelper(data, curr.getRight(), dummy));
        } else if (curr.getData().compareTo(data) > 0) {
            curr.setLeft(removeHelper(data, curr.getLeft(), dummy));
        }
        return curr;
    }

    /**
     *  Finds the predecessor
     * @param curr current node
     * @param dummy dummy node
     * @return BST node
     */
    private BSTNode<T> removePred(BSTNode<T> curr, BSTNode<T> dummy) {
        if (curr.getRight() == null) {
            dummy.setData(curr.getData());
            return curr.getLeft();
        }
        curr.setRight(removePred(curr.getRight(), dummy));
        return curr;
    }

    @Override
    public T get(T data) {

        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        } else if (root == null) {
            throw new NoSuchElementException("Element does not " +
                    "exist");
        }
        return get(data, root);

    }

    /**
     *
     * @param data
     * @param curr
     * @return
     */
    private T get(T data, BSTNode<T> curr) {
        if (curr == null) {
            throw new NoSuchElementException("Data not found");
        }
        if (curr.getData().equals(data)) {
            return curr.getData();
        } else if (curr.getData().compareTo(data) < 0) {
            return get(data, curr.getRight());
        } else {
            return get(data, curr.getLeft());
        }
    }
    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        try {
            get(data);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
//        return (get(data, root)) != null;
    }

    @Override
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    @Override
    public List<T> preorder() {
        List<T> list = new ArrayList<T>();
        if (root == null) {
            return list;
        }
        preorder(list, root);
        return list;
    }

    /**
     *
     * @param list
     * @param curr
     * @return
     */
    private List<T> preorder(List<T> list, BSTNode<T> curr) {
        list.add(curr.getData());
        if (curr.getLeft() != null) {
            preorder(list, curr.getLeft());
        }
        if (curr.getRight() != null) {
            preorder(list, curr.getRight());
        }
        return list;
    }
    @Override
    public List<T> postorder() {
        List<T> list = new ArrayList<T>();
        if (root == null) {
            return list;
        }
        postorder(list, root);
        return list;
    }

    /**
     *
     * @param list
     * @param curr
     * @return
     */
    private List<T> postorder(List<T> list, BSTNode<T> curr) {
        if (curr.getLeft() != null) {
            postorder(list, curr.getLeft());
        }
        if (curr.getRight() != null) {
            postorder(list, curr.getRight());
        }
        list.add(curr.getData());
        return list;
    }

    @Override
    public List<T> inorder() {
        List<T> list = new ArrayList<T>();
        if (root == null) {
            return list;
        }
        inorder(list, root);
        return list;
    }

    /**
     *
     * @param list
     * @param curr
     * @return
     */
    private List<T> inorder(List<T> list, BSTNode<T> curr) {
        if (curr.getLeft() != null) {
            inorder(list, curr.getLeft());
        }
        list.add(curr.getData());
        if (curr.getRight() != null) {
            inorder(list, curr.getRight());
        }

        return list;
    }

    @Override
    public List<T> levelorder() {
        List<T> list = new ArrayList<T>();
        Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            list.add(queue.peek().getData());
            BSTNode<T> curr = queue.poll();
            if (curr.getLeft() != null) {
                queue.add(curr.getLeft());
            }
            if (curr.getRight() != null) {
                queue.add(curr.getRight());
            }
        }
        return list;
    }

    @Override
    public List<T> listLeavesDescending() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        listLeavesDescending(root, list);
        return list;
    }

    /**
     *
     * @param curr
     * @param list
     * @return
     */
    private List<T> listLeavesDescending(BSTNode<T> curr, List<T> list) {
        if (curr.getRight() != null) {
            listLeavesDescending(curr.getRight(), list);
        }
        if (curr.getLeft() == null && curr.getRight() == null) {
            list.add(curr.getData());
        }
        if (curr.getLeft() != null) {
            listLeavesDescending(curr.getLeft(), list);
        }
        return list;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return height(root);
    }

    /**
     *
     * @param root
     * @return
     */
    private int height(BSTNode<T> root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
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

    /**
     *
     * @param curr
     */
    private void checkForNoSuchElement(BSTNode<T> curr) {
        if (curr == null) {
            throw new java.util.NoSuchElementException("Element does not " +
                    "exist");
        }
    }
}


//
//
//    @Override
//    public boolean contains(T data) {
//        dataIsNullCheck(data);
//        if (root == null) {
//            return false;
//        }
//        return find(data, root) != null;
////        return false;
//    }
//
//    private T find(T data, BSTNode<T> cur) {
//        int comparison = data.compareTo(cur.getData());
//        if (comparison > 0) {
//            if (cur.getRight() == null) {
//                return null;
//            } else {
//                return find(data, cur.getRight());
//            }
//        } else if (comparison < 0) {
//            if (cur.getLeft() == null) {
//                return null;
//            } else {
//                return find(data, cur.getLeft());
//            }
//        } else {
//            return cur.getData();
//        }
//    }
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Sample JUnit test cases for BST.
 *
 * @version 1.0
 * @author Sanath Nagaraj
 */
public class BSTTestsSanath {
    private BSTInterface<Integer> bst;
    public static final int TIMEOUT = 200;
    private Integer[] binaryArray1
            = {8, 6, 12, 2, 7, 11, 14, 1, 5, 3, 4, 9, 13, 15, 10};
    private Integer[] binaryArray2
            = {8, 6, 12, 2, 7, 11, 14, 1, 4, 3, 5, 9, 13, 15, 10};

    @Before
    public void setup() {
        bst = new BST<Integer>();
    }

    @Test(timeout = TIMEOUT)
    public void testArgsConstructor() {
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {8, 6, 2, 1, 5, 3, 4, 7,12, 11, 9, 10, 14, 13, 15};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));

        assertEquals(list, bst.preorder());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArgsConstructorException1() {
        bst = new BST<>(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testArgsConstructorException2() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 140, 10, 50, 30, 40, 90
                , 130, 150, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        coll.add(6, null);
        bst = new BST<>(coll);
    }
    @Test(timeout = TIMEOUT)
    public void testArgsConstructorException3() {
        // Making sure no object is created if an exception is thrown
        Integer[] treeArray = {80, 60, 120, 20, 70, 140, 10, 50, 30, 40, 90
                , 130, 150, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        coll.add(6, null);
        try {
            bst = new BST<>(coll);
        } catch(IllegalArgumentException e) {

        }
        assertEquals(0, bst.size());
    }

    @Test(timeout = TIMEOUT)
    public void testAdd() {
        assertEquals(0, bst.size());

        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        Integer[] array2 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90, 100
                , 140, 130, 150};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));
        assertEquals(15, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(15);
        Integer[] array3 = {80, 60, 20, 10, 15, 50, 30, 40, 70, 120, 110, 90, 100
                , 140, 130, 150};
        list = new LinkedList<>(Arrays.asList(array3));
        assertEquals(16, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(35);
        Integer[] array4 = {80, 60, 20, 10, 15, 50, 30, 40, 35, 70, 120, 110, 90
                , 100, 140, 130, 150};
        list = new LinkedList<>(Arrays.asList(array4));
        assertEquals(17, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(20);
        Integer[] array5 = {80, 60, 20, 10, 15, 50, 30, 40, 35, 70, 120, 110, 90
                , 100, 140, 130, 150};
        list = new LinkedList<>(Arrays.asList(array5));
        assertEquals(17, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(110);
        Integer[] array6 = {80, 60, 20, 10, 15, 50, 30, 40, 35, 70, 120, 110, 90
                , 100, 140, 130, 150};
        list = new LinkedList<>(Arrays.asList(array6));
        assertEquals(17, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(125);
        Integer[] array7 = {80, 60, 20, 10, 15, 50, 30, 40, 35, 70, 120, 110, 90
                , 100, 140, 130, 125, 150};
        list = new LinkedList<>(Arrays.asList(array7));
        assertEquals(18, bst.size());
        assertEquals(list, bst.preorder());

        bst.add(115);
        Integer[] array8 = {80, 60, 20, 10, 15, 50, 30, 40, 35, 70, 120, 110, 90
                , 100, 115, 140, 130, 125, 150};
        list = new LinkedList<>(Arrays.asList(array8));
        assertEquals(19, bst.size());
        assertEquals(list, bst.preorder());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testAddException() {
        bst.add(10);
        bst.add(20);
        bst.add(null);
    }

    @Test(timeout = TIMEOUT)
    public void testRemove() {
        assertEquals(0, bst.size());

        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        Integer[] array2 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90, 100
                , 140, 130, 125, 150, 160};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));
        assertEquals(17, bst.size());
        assertEquals(list, bst.preorder());

        // Remove node with 0 children
        assertEquals((Integer) 125, bst.remove(125));
        assertEquals(16, bst.size());
        Integer[] array3 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90, 100
                , 140, 130, 150, 160};
        list = new LinkedList<>(Arrays.asList(array3));
        assertEquals(list, bst.preorder());

        // Remove node with 1 child
        assertEquals((Integer) 150, bst.remove(150));
        assertEquals(15, bst.size());
        Integer[] array4 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90, 100
                , 140, 130, 160};
        list = new LinkedList<>(Arrays.asList(array4));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 140, bst.remove(140));
        assertEquals(14, bst.size());
        Integer[] array5 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90, 100
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array5));
        assertEquals(list, bst.preorder());

        // Remove node with 0 children
        assertEquals((Integer) 100, bst.remove(100));
        assertEquals(13, bst.size());
        Integer[] array6 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 110, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array6));
        assertEquals(list, bst.preorder());

        // Remove node with 1 child
        assertEquals((Integer) 110, bst.remove(110));
        assertEquals(12, bst.size());
        Integer[] array7 = {80, 60, 20, 10, 50, 30, 40, 70, 120, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array7));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 120, bst.remove(120));
        assertEquals(11, bst.size());
        Integer[] array8 = {80, 60, 20, 10, 50, 30, 40, 70, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array8));
        assertEquals(list, bst.preorder());

        // Adding a node
        bst.add(55);
        Integer[] array9 = {80, 60, 20, 10, 50, 30, 40, 55, 70, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array9));
        assertEquals(12, bst.size());
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 60, bst.remove(60));
        assertEquals(11, bst.size());
        Integer[] array10 = {80, 55, 20, 10, 50, 30, 40, 70, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array10));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 55, bst.remove(55));
        assertEquals(10, bst.size());
        Integer[] array11 = {80, 50, 20, 10, 30, 40, 70, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array11));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 50, bst.remove(50));
        assertEquals(9, bst.size());
        Integer[] array12 = {80, 40, 20, 10, 30, 70, 90
                , 130, 160};
        list = new LinkedList<>(Arrays.asList(array12));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 40, bst.remove(40));
        assertEquals(8, bst.size());
        Integer[] array13 = {80, 30, 20, 10, 70, 90, 130, 160};
        list = new LinkedList<>(Arrays.asList(array13));
        assertEquals(list, bst.preorder());

        // Remove node with 2 children
        assertEquals((Integer) 30, bst.remove(30));
        assertEquals(7, bst.size());
        Integer[] array14 = {80, 20, 10, 70, 90, 130, 160};
        list = new LinkedList<>(Arrays.asList(array14));
        assertEquals(list, bst.preorder());

        // Remove node with 1 child
        assertEquals((Integer) 130, bst.remove(130));
        assertEquals(6, bst.size());
        Integer[] array15 = {80, 20, 10, 70, 90, 160};
        list = new LinkedList<>(Arrays.asList(array15));
        assertEquals(list, bst.preorder());

        // Remove root node with 2 child
        assertEquals((Integer) 80, bst.remove(80));
        assertEquals(5, bst.size());
        Integer[] array16 = {70, 20, 10, 90, 160};
        list = new LinkedList<>(Arrays.asList(array16));
        assertEquals(list, bst.preorder());

        // Remove root node with 2 child
        assertEquals((Integer) 70, bst.remove(70));
        assertEquals(4, bst.size());
        Integer[] array17 = {20, 10, 90, 160};
        list = new LinkedList<>(Arrays.asList(array17));
        assertEquals(list, bst.preorder());

        // Remove node with 0 children
        assertEquals((Integer) 10, bst.remove(10));
        assertEquals(3, bst.size());
        Integer[] array18 = {20, 90, 160};
        list = new LinkedList<>(Arrays.asList(array18));
        assertEquals(list, bst.preorder());

        // Remove root node with 1 children
        assertEquals((Integer) 20, bst.remove(20));
        assertEquals(2, bst.size());
        Integer[] array19 = {90, 160};
        list = new LinkedList<>(Arrays.asList(array19));
        assertEquals(list, bst.preorder());

        // Remove root node with 1 children
        assertEquals((Integer) 90, bst.remove(90));
        assertEquals(1, bst.size());
        Integer[] array20 = {160};
        list = new LinkedList<>(Arrays.asList(array20));
        assertEquals(list, bst.preorder());

        // Remove root node with 1 children
        assertEquals((Integer) 160, bst.remove(160));
        assertEquals(0, bst.size());
        Integer[] array21 = {};
        list = new LinkedList<>(Arrays.asList(array21));
        assertEquals(list, bst.preorder());
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveException1() {
        bst.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testRemoveException2() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.remove(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveException3() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.remove(69);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testRemoveException4() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.remove(200);
    }

    @Test(timeout = TIMEOUT)
    public void testGet() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        assertEquals((Integer) 40, bst.get(40));
        assertEquals((Integer) 80, bst.get(80));
        assertEquals((Integer) 110, bst.get(110));
        assertEquals((Integer) 50, bst.get(50));
        assertEquals((Integer) 90, bst.get(90));
        assertEquals((Integer) 125, bst.get(125));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetException1() {
        bst.get(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testGetException2() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.get(null);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetException3() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.get(111);
    }

    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void testGetException4() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.get(69);
    }

    @Test(timeout = TIMEOUT)
    public void testContain() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        assertTrue((bst.contains(40)));
        assertTrue(bst.contains(80));
        assertTrue(bst.contains(110));
        assertTrue(bst.contains(50));
        assertTrue(bst.contains(90));
        assertTrue(bst.contains(125));

        assertFalse(bst.contains(41));
        assertFalse(bst.contains(81));
        assertFalse(bst.contains(111));
        assertFalse(bst.contains(51));
        assertFalse(bst.contains(91));
        assertFalse(bst.contains(126));
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainException1() {
        bst.get(null);
    }

    @Test(timeout = TIMEOUT, expected = IllegalArgumentException.class)
    public void testContainException2() {
        Integer[] treeArray = {80, 60, 120, 20, 70, 110, 140, 10, 50, 30, 40, 90
                , 130, 150, 125, 160, 100};
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(treeArray));
        bst = new BST<>(coll);
        bst.get(null);
    }


    @Test(timeout = TIMEOUT)
    public void testLevelorder() {
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {8, 6, 12, 2, 7, 11, 14, 1, 5, 9, 13, 15, 3, 10, 4};
        List<Integer> levelorder = new LinkedList<>(Arrays.asList(array2));

        assertEquals(levelorder, bst.levelorder());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        Integer[] array3 = {8, 6, 12, 2, 7, 11, 14, 1, 4, 9, 13, 15, 3, 5, 10};
        levelorder = new LinkedList<>(Arrays.asList(array3));

        assertEquals(levelorder, bst.levelorder());
    }

    @Test(timeout = TIMEOUT)
    public void testInorder() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        assertEquals(emptyList, bst.inorder());

        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));

        assertEquals(list, bst.inorder());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        Integer[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        list = new LinkedList<>(Arrays.asList(array3));

        assertEquals(list, bst.inorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPreorder() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        assertEquals(emptyList, bst.preorder());

        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {8, 6, 2, 1, 5, 3, 4, 7,12, 11, 9, 10, 14, 13, 15};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));

        assertEquals(list, bst.preorder());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        Integer[] array3 = {8, 6, 2, 1, 4, 3, 5, 7, 12, 11, 9, 10, 14, 13, 15};
        list = new LinkedList<>(Arrays.asList(array3));

        assertEquals(list, bst.preorder());
    }

    @Test(timeout = TIMEOUT)
    public void testPostorder() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        assertEquals(emptyList, bst.postorder());

        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {1, 4, 3, 5, 2, 7, 6, 10, 9, 11, 13, 15, 14, 12, 8};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));

        assertEquals(list, bst.postorder());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        Integer[] array3 = {1, 3, 5, 4, 2, 7, 6, 10, 9, 11, 13, 15, 14, 12, 8};
        list = new LinkedList<>(Arrays.asList(array3));

        assertEquals(list, bst.postorder());
    }

    @Test(timeout = TIMEOUT)
    public void testLeavesDescending() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        assertEquals(emptyList, bst.listLeavesDescending());

        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        Integer[] array2 = {15, 13, 10, 7, 4, 1};
        List<Integer> list = new LinkedList<>(Arrays.asList(array2));
        assertEquals(list, bst.listLeavesDescending());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        Integer[] array3 = {15, 13, 10, 7, 5, 3, 1};
        list = new LinkedList<>(Arrays.asList(array3));
        assertEquals(list, bst.listLeavesDescending());
    }

    @Test(timeout = TIMEOUT)
    public void testHeight() {
        ArrayList<Integer> coll = new ArrayList<>(Arrays.asList(binaryArray1));
        bst = new BST<>(coll);

        assertEquals(5, bst.height());

        coll = new ArrayList<>(Arrays.asList(binaryArray2));
        bst = new BST<>(coll);

        assertEquals(4, bst.height());
    }


    @Test(timeout = TIMEOUT, expected = NoSuchElementException.class)
    public void getEmpty() {
        bst.get(20);
    }
}
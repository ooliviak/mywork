import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinaryTreeTest {
    @Test
    public void treeFormatTest() {
        BinarySearchTree<String> x = new BinarySearchTree<String>();
        x.add("C");
        x.add("A");
        x.add("E");
        x.add("B");
        x.add("D");

        assertTrue(x.contains("C"));
        assertFalse(x.contains("F"));

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outContent));
        BinaryTree.print(x, "x");
        System.setOut(oldOut);
        assertEquals("x in preorder\nC A B E D \nx in inorder\nA B C D E \n\n".trim(),
                     outContent.toString().trim());


        BinarySearchTree<String> y = new BinarySearchTree<String>();
        y.add("Q");
        y.add("A");
        y.add("F");
        y.add("E");
        y.add("C");
        y.add("D");
        assertTrue(x.contains("C"));
        assertTrue(x.contains("F"));


    }
}
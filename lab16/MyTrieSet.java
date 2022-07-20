import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyTrieSet implements TrieSet61BL {

    private TreeNode root;

    static class TreeNode {

        // from previous year's slides
        private char letter;
        private boolean exists;

        // character = key, TreeNode = value
        private HashMap<Character, TreeNode> charTree;

        private TreeNode() {
            charTree = new HashMap<>();
        }

        private TreeNode(char ch, boolean key) {
            letter = ch;
            exists = key;
            charTree = new HashMap<>();
        }
    }

    public MyTrieSet() {
        root = new TreeNode();
    }


    @Override
    public void clear() {
        root = new TreeNode();
    }

    @Override
    public boolean contains(String key) {
        if (root == null) {
            return false;
        } else {
            TreeNode node = root;
            for (int i = 0; i < key.length(); i++) {
                if (node.charTree.containsKey(key.charAt(i))) {
                    node = node.charTree.get(key.charAt(i));
                    node.exists = true;
                } else {
                    node.exists = false;
                    break;
                }
            }
            return node.exists;
        }
    }

    public void add(String key) {
        if (key == null) {
            return;
        } else if (key.length() == 0) {
            return;
        } else {
            TreeNode node = root;
            for (int i = 0; i < key.length(); i++) {
                // check if this character is already in hashmap
                if (node.charTree.containsKey(key.charAt(i))) {
                    node = node.charTree.get(key.charAt(i));
                } else {
                    node.charTree.put(key.charAt(i), new TreeNode(key.charAt(i), false));
                    node = node.charTree.get(key.charAt(i));
                }
            }
            node.exists = true;
        }
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {

        List<String> keys = new LinkedList<String>();
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i ++) {
            if (!node.charTree.containsKey(prefix.charAt(i))) {
                return keys;
            } else {
                node = node.charTree.get(prefix.charAt(i));
            }
        }
        return keys;
    }

    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }


}

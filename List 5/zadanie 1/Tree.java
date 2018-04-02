
public class Tree <K extends Comparable <K>> {
    //constructors
    private class Node
    {
        K val;
        Node left,right;
        Node parent;

        Node(K k,Node parent)
        {
            val = k;
            left = null;
            right = null;
            this.parent = parent;
        }
    }

    private Node core = new Node(null,null); //empty root. Do not iterate through it.
    Node root;

    public Tree(K val) {
        if(root == null) root = new Node(val,null);
        core.left = root;
        core.right = root;
        root.parent = core;
    }

    /*we use core as we need a link between left and right leaf of root.
     * we switch nodes using 'parent' field
     *
     */

    //add new node
    private void a(K val, Node root, Node parent) {

        if(root.val.compareTo(val) <  0)
            if(root.right == null) root.right = new Node(val,root);
            else a(val,root.right,root);
        else
        if(root.left == null) root.left = new Node(val,root);
        else a(val,root.left,root);

    }

    public void add(K val) {
        if(root == null) {  		   // make sure we renew the root node in case it was removed from the tree during
            root = new Node(val,core); // the previous iteration
            core.left = root;
            core.right = root;
            return;
        }
        a(val,root,null);
    }

    //get value
    private K gv(Node root) {
        if(root.left == null) {

            if(root.right != null) {
                root.parent.left = root.right;
                root.parent.left.parent = root.parent;
                root.right = null;


            } else {
                root.parent.left = null;
            }

            return root.val;
        }
        else return gv(root.left);
    }
    public K getVal() {
        if(core.left == null) {
            root = null;
            System.out.println("Tree is empty!");
            return null;
        }
        return gv(core.left);
    }

    //toString
    private String p(Node root) {
        if(root == null) return "";
        return p(root.left)+ " "+ root.val + " " + p(root.right);
    }

    public String print() {
        return p(root);
    }
}
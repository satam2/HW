public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if p and q > root.val, their LCA is to the right of root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // if p and q < root.val, their LCA is to the left of root
        else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if neither are true, we found the LCA
        else {
            return root;
        }
    }

    public static void main(String[] args) {
        // make the BST
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3, n1, null);
        TreeNode n5 = new TreeNode(5);
        TreeNode n9 = new TreeNode(9);
        TreeNode n8 = new TreeNode(8, n5, n9);
        TreeNode n4 = new TreeNode(4, n3, n8); // root node

        // calculate the LCA test cases
        TreeNode lca1 = n4.lowestCommonAncestor(n4, n3, n1);
        TreeNode lca2 = n4.lowestCommonAncestor(n4, n1, n5);
        TreeNode lca3 = n4.lowestCommonAncestor(n4, n5, n9);

        System.out.println("the lca of 3 and 1 is: " + lca1.val); // expected: 3
        System.out.println("the lca of 1 and 5 is: " + lca2.val); // expected: 4
        System.out.println("the lca of 5 and 9 is: " + lca3.val); // expected: 8
    }
}

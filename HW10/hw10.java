import java.util.*;

public class hw10 extends TreeNode {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ordered = new ArrayList<>();
        helper(root, ordered, 0);
        return ordered;
    }

    private void helper(TreeNode n, List<List<Integer>> list, int lvl) {
        if (n == null) // base case
            return;
        if (lvl >= list.size()) // if lvl does not exist yet, add to the list
            list.add(new ArrayList<>());

        list.get(lvl).add(n.val); // add node val to respective lvl
        helper(n.left, list, lvl + 1); // traverse left
        helper(n.right, list, lvl + 1); // traverse right
    }

    public static void main(String[] args) {
        // create the tree
        TreeNode n9 = new TreeNode(9);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n8 = new TreeNode(8, n5, n9);
        TreeNode n3 = new TreeNode(3, n1, null);
        TreeNode n4 = new TreeNode(4, n3, n8);

        // test the tree
        hw10 test = new hw10();
        List<List<Integer>> r = test.levelOrder(n4); // expected: 4 3 8 1 5 9
        for (List<Integer> lvlList : r)
            System.out.print(lvlList + " ");
    }
}

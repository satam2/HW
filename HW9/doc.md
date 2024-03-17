NOTES

I decided that approaching this recursively would be easier because we already know for any node in a BST, the left side’s values are less than the node and the right side’s values are greater. Also, since in this scenario there are no duplicate values, we don’t need to worry about dealing with them.

 Assuming we know nodes ‘p’ and ‘q’ exist in the BST, if both p.val and q.val > current_node.val, it would then be obvious that they would be on the right subtree of the current node. if both p.val and q.val < current_node.val, then their LCA must be in the left subtree. However, whenever the paths of p and q diverge, we know we found their LCA and therefore we return the current node. This happens if one node is on the left and one is on the right or if either p or q are equal to the current node.

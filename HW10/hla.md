I knew I had to do this problem using recursion because it requires traversal of the tree. The base case would be if we reached the end of a branch and the node is null. 

I needed a way to keep track of the current level to make sure the nodes were in level order, so I created a helper function with three parameters: a TreeNode, a list that contains a list, and an integer called lvl. Basically, whenever we reached a new level for the tree, the code would make a new list for that specific level. Then, the node would added to the current level and it would then recursive call its children with the lvl parameter incremented, leading to all its children being on the same level.

This effectively simulates level order traversal on the tree. 

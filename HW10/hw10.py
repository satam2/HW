from typing import Optional, List

class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class hw10(TreeNode):
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        ordered = []
        self.helper(root, ordered, 0)
        return ordered
    
    def helper(self, n: TreeNode, l: List[List[int]], lvl: int):
        if n is None: # base case
            return     
        if lvl >= len(l): # if lvl's list dne yet, make one
            l.append([])
        l[lvl].append(n.val) # add node to respective lvl
        self.helper(n.left, l, lvl+1) # traverse left
        self.helper(n.right, l, lvl+1) # traverse right
        
# create tree
n9 =  TreeNode(9)
n5 =  TreeNode(5)
n1 =  TreeNode(1)
n8 =  TreeNode(8, n5, n9)
n3 =  TreeNode(3, n1, None)
n4 =  TreeNode(4, n3, n8)

# test method
test = hw10()
r = test.levelOrder(n4) # expected: 4 3 8 1 5 9

for list in r:
    for number in list:
        print(number, end=" ")

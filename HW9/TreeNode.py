class TreeNode(object):
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
     # if p and q > root.val, their LCA is to the right of root
        if p.val > root.val and q.val > root.val:
            return lowestCommonAncestor(self, root.right, p, q)
     # if p and q < root.val, their LCA is to the left of root
        elif p.val < root.val and q.val < root.val:
            return lowestCommonAncestor(self, root.left, p, q)
     # if neither are true, we found the LCA
        else:
            return root
        
# make the BST
n1 = TreeNode(1)
n3 = TreeNode(3, n1, None)
n5 = TreeNode(5)
n9 = TreeNode(9)
n8 = TreeNode(8, n5, n9)
n4 = TreeNode(4, n3, n8) # root node

lca1 = lowestCommonAncestor(n4, n4, n3, n1)
lca2 = lowestCommonAncestor(n4, n4, n1, n5) 
lca3 = lowestCommonAncestor(n4, n4, n5, n9)

print("the lca of 3 and 1 is: " + str(lca1.val)) # expected: 3
print("the lca of 3 and 1 is: " + str(lca2.val)) # expected: 4
print("the lca of 3 and 1 is: " + str(lca3.val)) # expected: 8

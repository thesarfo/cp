class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def sufficientSubset(self, root, limit):
        """
        :type root: TreeNode
        :type limit: int
        :rtype: TreeNode
        """
        def dfs(node, current_sum):
            if not node:
                return None, False

            current_sum += node.val

            if not node.left and not node.right:
                return node, current_sum >= limit

            left_node, left_sufficient = dfs(node.left, current_sum)
            right_node, right_sufficient = dfs(node.right, current_sum)

            if not left_sufficient:
                node.left = None
            if not right_sufficient:
                node.right = None

            return node if left_sufficient or right_sufficient else None, left_sufficient or right_sufficient

        result, _ = dfs(root, 0)
        return result
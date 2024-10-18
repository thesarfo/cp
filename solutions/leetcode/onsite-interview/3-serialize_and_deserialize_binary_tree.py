# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """

        if root is None:
            return ''
        res = []

        def preorder(root):
            if root is None:
                res.append("#,")
                return
            res.append(str(root.val) + ",")
            preorder(root.left)
            preorder(root.right)

        preorder(root)
        return ''.join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        vals = data.split(',')

        def inner():
            first = vals.pop(0)
            if first == '#':
                return None
            return TreeNode(int(first), inner(), inner()) 
            # seems using a constructor __init__(val, left, right)

        return inner()


# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))

############

from collections import deque

# bfs, each level based
class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        ret = []
        queue = deque([root])
        while queue:
            top = queue.popleft()
            if not top:
                ret.append("None")
                continue
            else:
                ret.append(str(top.val))
            queue.append(top.left)
            queue.append(top.right)
        return ",".join(ret)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        data = data.split(",")
        if data[0] == "None":
            return None
        root = TreeNode(int(data[0]))
        queue = deque([root])
        i = 0
        while queue and i < len(data):
            top = queue.popleft()
            i += 1
            left = right = None
            if i < len(data) and data[i] != "None":
                left = TreeNode(int(data[i]))
                queue.append(left)
            i += 1
            if i < len(data) and data[i] != "None":
                right = TreeNode(int(data[i]))
                queue.append(right)

            top.left = left
            top.right = right

        return root
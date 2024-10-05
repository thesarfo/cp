class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeZeroSumSublists(self, head):
        dummy = ListNode(0)
        dummy.next = head
        prefix_sum = 0
        sum_map = {}
        current = dummy

        while current:
            prefix_sum += current.val
            if prefix_sum in sum_map:
                temp = sum_map[prefix_sum].next
                running_sum = prefix_sum + temp.val
                while running_sum != prefix_sum:
                    del sum_map[running_sum]
                    temp = temp.next
                    running_sum += temp.val
                sum_map[prefix_sum].next = current.next
            else:
                sum_map[prefix_sum] = current
            current = current.next

        return dummy.next

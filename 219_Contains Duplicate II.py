class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        index = {}
        for current, numbers in enumerate(nums):
            if numbers in index and current - index[numbers] <= k:
                return True
            index[numbers] = current      
        return False

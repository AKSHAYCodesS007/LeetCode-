class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        number=0
        for num in nums:
            if nums.count(num)==1:
                number=num

        return number

        
        
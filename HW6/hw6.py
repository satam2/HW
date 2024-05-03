from typing import List

class hw6():
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort() 
        result = []

        for i in range(len(nums) - 2):
            # skip dupes
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left, right = i + 1, len(nums) - 1
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                if current_sum == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1

                    # skip dupes
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                elif current_sum < 0:
                    left += 1  # needs larger num
                else:
                    right -= 1  # needs smaller num

        return result
    
# test = hw6()
# #n = [10,-10,0,0,20, -20, -5, -15]
# n = [0, 1, 1]
# result = test.threeSum(n)

# print(result)

import java.util.*;

public class hw6 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // sort the nums to avoid dupes
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // skip dupes
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // skip dupes
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args){
        hw6 test = new hw6();
        int[] nums = {0,1,1};
        List<List<Integer>> result = test.threeSum(nums);
        System.out.println(result);
    }
}

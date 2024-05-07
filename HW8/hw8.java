import java.util.*;

public class hw8 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        int maxLength = 0;
        boolean hasOdd = false;
        
        // Calculate the maximum length of the palindrome
        for (int count : countMap.values()) {
            if (count % 2 == 0) {
                maxLength += count;
            } else {
                maxLength += count - 1; // Add the largest even number less than count
                hasOdd = true; // There's at least one character with an odd count
            }
        }
        
        // If there's at least one character with an odd count, we can place exactly one character in the middle
        if (hasOdd) {
            maxLength += 1;
        }
        
        return maxLength;
    }

    public static void main(String[] args){
        // hw8 test = new hw8();
        // String s = "abccccdd";
        // String t = "speediskey";
        // System.out.println(test.longestPalindrome(t));
    }
}

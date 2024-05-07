from collections import Counter

class hw8():
    def longestPalindrome(self, s: str) -> int:
        char_counts = Counter(s)
        palindrome_length = 0
        odd_found = False
        
        for count in char_counts.values():
            if count % 2 == 0:
                palindrome_length += count
            else:
                palindrome_length += count - 1  # use all except one to make it even
                odd_found = True  # at least one odd count character exists
        
        # if there odd count character, one can be the center
        if odd_found:
            palindrome_length += 1
        
        return palindrome_length
    
# test = hw8()
# s = "abccccdd"
# t ="speediskey"
# print(test.longestPalindrome(t))

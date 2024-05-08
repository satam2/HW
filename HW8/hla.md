I decided to use a hashmap to store the frequency of each character and if they are even, we can definitely include them within the palindrome string. For any character that appears an odd amount of times like 7, we can use every letter - 1, so 6 in this case. The last step is adding an odd number character as the center of the palindrome because that is the only time where one single character can be used by itself.

This approach uses O(n) time because it has to iterate through the hashmap for each character.

# 191. Number of 1 Bits

# Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).

class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        binary = format(n, 'b')

        for bit in binary:
            if bit == '1':
                count += 1

        return count
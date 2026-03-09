// 804. Unique Morse Code Words

// International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

// 'a' maps to ".-",
// 'b' maps to "-...",
// 'c' maps to "-.-.", and so on.
// For convenience, the full table for the 26 letters of the English alphabet is given below:

// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
// Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

// For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
// Return the number of different transformations among all words we have.

import java.util.*;

public class Solution804 {

    public static int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
        };

        HashSet<String> set = new HashSet<>();

        for(String word : words){
            StringBuilder transformation = new StringBuilder();

            for(char c : word.toCharArray()){
                transformation.append(morse[c - 'a']);
            }

            set.add(transformation.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {

        String[] words = {"gin","zen","gig","msg"};

        int result = uniqueMorseRepresentations(words);

        System.out.println("Number of unique transformations: " + result);
    }
}
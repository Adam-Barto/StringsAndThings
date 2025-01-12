package io.zipcoder;

import java.util.Arrays;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int counter = 0;
        String[] list = input.split(" "); //Decided not to use a string Builder, would be unnecessarily complex
        for (int i = 0;i < list.length;i++){
            if ((list[i].charAt(list[i].length()-1) == 'y') || ((list[i].charAt(list[i].length()-1) == 'z'))){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        StringBuilder text = new StringBuilder(base.replace(remove,""));
        return text.toString();
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */

    private int contains(String input, String word){
        int starting_length = input.length();
        int ending_length = input.replace(word,"").length();
        return ((starting_length - ending_length) / word.length()); // How many instances of the word there where
    }
    public Boolean containsEqualNumberOfIsAndNot(String input){
        return contains(input, "not") == contains(input, "is");
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        int gg = contains(input, "gg");
        return (gg == (contains(input, "g")-gg));
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {//Can't use contains() for this without calling it a LOT, not worth it
        int count = 0; //What we will return
        for (int i = 0; i < input.length()-2; i++) { // we count up to 2, don't want to go out of bounds
            char c = input.charAt(i); //Save the char, then we can jump forward from that
            if (c == input.charAt(i + 1) && c == input.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }
}

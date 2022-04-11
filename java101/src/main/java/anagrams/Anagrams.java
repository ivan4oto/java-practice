package anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    public static boolean areAnagrams(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);
        
        return Arrays.equals(charsA, charsB);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        scanner.close();

        if (areAnagrams(a, b)) {
            System.out.println("ANAGRAMS");
        } else {
            System.out.println("NOT ANAGRAMS");
        }
    }
}
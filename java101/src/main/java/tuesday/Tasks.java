package tuesday;

import java.util.HashMap;
import java.util.Map;

public class Tasks {
    public static boolean isNumberOdd(int number){
        return number%2==0;
    }

    public static boolean isNumberPrime(int number){
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) return false;
        double boundary = Math.floor(Math.sqrt(number));

        for (int i = 3; i <= boundary; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int factorialRecursion(int number){
        if (number <= 1 ) {
            return 1;
        }
        return number * factorialRecursion(number-1);
    }

    public static int factorialDigits(int number){
        String strNumber = String.valueOf(number);
        char[] chars = strNumber.toCharArray();
        int result = 0;
        for (char ch: chars) {
            result += factorialRecursion(Character.getNumericValue(ch));
        }
        return result;
    }


   public static int fibonacciRecursion(int number){
        if (number <= 1 ) {
            return number;
        }
        return fibonacciRecursion(number-2) + fibonacciRecursion(number-1);
    }

    public static int[] fibonacciSequence(int number) {
        int[] arr = new int[number];
        for (int i = 0; i < number; i ++){
            int fib = fibonacciRecursion(i+1);
            arr[i] = fib == 0 ? 1 : fib;
        }
        return arr;
    }
    public static String flipString(String toFlip) {
        String flippedStr = "";
        for (int i=toFlip.length()-1; i>=0; i--) {
            flippedStr += toFlip.charAt(i);
        }
        return flippedStr;
    }

    public static boolean isPalindrome(int number){
        String intStr = String.valueOf(number);
        String flippedStr = flipString(intStr);
        System.out.println(flippedStr + " " + intStr);
        return Integer.parseInt(flippedStr) == Integer.parseInt(intStr);
    }

    public static String reverseOddWords(String sentence) {
        String[] splitted = sentence.split("\\s+");
        for (int i=1; i < splitted.length; i+=2) {
            splitted[i] = flipString(splitted[i]);
        }
        return String.join(" ", splitted);
    }


    public static boolean isVowel(char c) {
        return "AEIOU".indexOf(Character.toUpperCase(c)) != -1;
    }

    public static boolean isConsonant(char c) {
        return "BCDFGJKLMNPQSTVXZHRWY".indexOf(Character.toUpperCase(c)) != -1;
    }

    public static Map<String, Integer> vowelsConsonantsDigits(String sentence) {
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("Vowels", 0);
        resultMap.put("Consonants", 0);
        resultMap.put("Digits", 0);
        
        for (int i=0; i < sentence.length(); i++) {
            Character currChar = sentence.charAt(i);
            if (Character.isAlphabetic(currChar)){
                if (isVowel(currChar)){
                    resultMap.put("Vowels", resultMap.get("Vowels")+1);
                } else {
                    resultMap.put("Consonants", resultMap.get("Consonants")+1);
                }
            } else if (Character.isDigit(currChar)){
                resultMap.put("Digits", resultMap.get("Digits")+1);
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        
    }
    
}

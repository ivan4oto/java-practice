package nokiakeypad;

import java.util.ArrayList;
import java.util.Scanner;

public class NokiaKeypad {
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter digits: ");

        String digits = myObj.nextLine();
        myObj.close();

        final ArrayList<String> buttonOne = new ArrayList<String>() {
            {
                add("!");
            }
        };

        final ArrayList<String> buttonTwo = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };

        final ArrayList<String> buttonThree = new ArrayList<String>() {
            {
                add("d");
                add("e");
                add("f");
            }
        };

        final ArrayList<String> buttonFour = new ArrayList<String>() {
            {
                add("g");
                add("h");
                add("i");
            }
        };

        final ArrayList<String> buttonFive = new ArrayList<String>() {
            {
                add("j");
                add("k");
                add("l");
            }
        };

        final ArrayList<String> buttonSix = new ArrayList<String>() {
            {
                add("m");
                add("n");
                add("o");
            }
        };
        final ArrayList<String> buttonSeven = new ArrayList<String>() {
            {
                add("p");
                add("q");
                add("r");
                add("s");
            }
        };
        final ArrayList<String> buttonEight = new ArrayList<String>() {
            {
                add("t");
                add("u");
                add("v");
            }
        };
        final ArrayList<String> buttonNine = new ArrayList<String>() {
            {
                add("w");
                add("x");
                add("y");
                add("z");
            }
        };
        final ArrayList<String> buttonZero = new ArrayList<String>() {
            {
                add(" ");
            }
        };

        ArrayList<ArrayList<String>> keyboardList = new ArrayList<ArrayList<String>>() {
            {
                add(buttonOne);
                add(buttonTwo);
                add(buttonThree);
                add(buttonFour);
                add(buttonFive);
                add(buttonSix);
                add(buttonSeven);
                add(buttonEight);
                add(buttonNine);
                add(buttonZero);
            }
        };

        ArrayList<String> message = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        Boolean isCapital = false;
        for (int i = 0; i < digits.length(); i++) {

            int intString = Integer.parseInt(String.valueOf(digits.charAt(i)));

            if (intString == 0) {
                message.add(" ");
                continue;
            };

            if (intString == 1) {
                isCapital = true;
                continue;
            }

            tempList.add(intString);

            if (i == digits.length() - 1 || digits.charAt(i + 1) != digits.charAt(i)) {
                Integer theNumber = tempList.get(0);
                ArrayList<String> buttonNumbers = keyboardList.get(theNumber - 1);
                System.out.println(buttonNumbers);
                ;
                String theLetter = (tempList.size() > buttonNumbers.size())
                        ? buttonNumbers.get((tempList.size() % buttonNumbers.size()) - 1)
                        : buttonNumbers.get(tempList.size() - 1);
                ;
                if (isCapital) {
                    message.add(theLetter.toUpperCase());
                    tempList.clear();
                    isCapital = false;
                    continue;
                } else {
                    message.add(theLetter);
                    tempList.clear();
                    continue;
                }

            }
        }
        String result = String.join("", message);
        System.out.println("The message you entered is: " + result);
    }

}

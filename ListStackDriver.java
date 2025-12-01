// ListStackDriver.java
// Starter file for the Stack portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runS4_ReverseWord).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListStackDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runS1_BrowserBackButton();
        //runS2_TextEditorUndo();
        //runS3_BalancedParentheses();
        //runS4_ReverseWord();
        //runS5_DirectoryNavigation();
        //runS6_CalculatorHistory();
        runS7_PalindromeChecker();
        //runS8_FunctionCallStack();
        //runS9_StackOfPlates();
    }

    // S1 – Browser Back Button
    private static void runS1_BrowserBackButton() {
        // TODO: Implement task S1 here.
        System.out.println("-----BrowserBackButton-----");
        ListStack<String> urlStack = new ListStack<>();
        //Imported scanner to help with more variety and easier way to add "Back" function
        Scanner sc = new Scanner(System.in);
        while (true) {
            //Reads input
            String url = sc.nextLine();
            //Our "Back" button
            if (url.equals("Back") || url.equals("back")) {
                urlStack.pop();
            }
            //Stop program
            else if(url.equals("End") || url.equals("end")) {
                break;
            }
            //Push URL
            else{
                urlStack.push(url);
            }
            //Prints current url
            System.out.println("Current Website: " + urlStack.peek());
        }
    }

    // S2 – Undo in a Text Editor
    private static void runS2_TextEditorUndo() {
        // TODO: Implement task S2 here.
        System.out.println("-----TextEditorUndo-----");
        ListStack<String> editor = new ListStack<>();
        editor.push("Hello, this is a text editor");
        System.out.println("Current Text: " + editor.peek());
        editor.push(editor.peek() + " with an undo button");
        System.out.println("Current Text: " + editor.peek());
        editor.push(editor.peek() + " that hardly works");
        System.out.println("Current Text: " + editor.peek());
        editor.pop();
        System.out.println("Current Text: " + editor.peek());
        editor.pop();
        System.out.println("Current Text: " + editor.peek());
        System.out.println();
    }

    // S3 – Checking Balanced Parentheses
    private static void runS3_BalancedParentheses() {
        // TODO: Implement task S3 here.
        System.out.println("-----BalancedParentheses-----");
        ListStack<String> balancedParentheses = new ListStack<>();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int i = 0;
        for(char c : text.toCharArray()) {
            if(c == '(') {
                balancedParentheses.push(text);
            }
            else if(c == ')') {
                balancedParentheses.pop();
            }
        }
        if(balancedParentheses.isEmpty()) {
            System.out.println("Balanced Parenthesis Found");
        }
        else {
            System.out.println("No Balanced Parenthesis Found");
        }
        System.out.println();
    }

    // S4 – Reversing a Word Using a Stack
    private static void runS4_ReverseWord() {
        // TODO: Implement task S4 here.
        System.out.println("-----ReverseWord-----");
        ListStack<String> reverseWord = new ListStack<>();
        String word = "hello";
        System.out.println("Normal: " + word);
        for(char c : word.toCharArray()) {
            reverseWord.push(String.valueOf(c));
        }
        System.out.print("Reversed: ");
        while (!reverseWord.isEmpty()) {
            System.out.print(reverseWord.pop());
        }
    }

    // S5 – Directory Navigation (cd / cd ..)
    private static void runS5_DirectoryNavigation() {
        // TODO: Implement task S5 here.
        System.out.println("-----DirectoryNavigation-----");
        ListStack<String> directory = new ListStack<>();
        //User
        System.out.println(directory.push("cd User"));
        directory.pop();
        directory.push("User");
        System.out.println("Current Directory: " + directory.peek());
        //Archives
        System.out.println(directory.push("cd Archives"));
        directory.pop();
        directory.push("Archives");
        System.out.println("Current Directory: " + directory.peek());
        //Documents
        System.out.println(directory.push("cd Documents"));
        directory.pop();
        directory.push("Documents");
        System.out.println("Current Directory: " + directory.peek());
        //School
        System.out.println(directory.push("cd School"));
        directory.pop();
        directory.push("School");
        System.out.println("Current Directory: " + directory.peek());
        //Back to Documents
        System.out.println(directory.push("cd .."));
        directory.pop();
        directory.pop();
        System.out.println("Current Directory: " + directory.peek());
        //Back to Archives
        System.out.println(directory.push("cd .."));
        directory.pop();
        directory.pop();
        System.out.println("Current Directory: " + directory.peek());
    }

    // S6 – History of Calculator Operations
    private static void runS6_CalculatorHistory() {
        // TODO: Implement task S6 here.
        System.out.println("-----CalculatorHistory-----");
        ListStack<String> history = new ListStack<>();
        history.push("1 + 4 = 5");
        history.push("5 * 2 = 10");
        history.push("10 / 5 = 2");
        history.push("2 * 10 = 20");
        history.pop();
        System.out.println("Most Recent Calculation: " + history.peek());
    }

    // S7 – Palindrome Checker
    private static void runS7_PalindromeChecker() {
        // TODO: Implement task S7 here.
        System.out.println("-----PalindromeChecker-----");
        ListStack<String> palindrome = new ListStack<>();
        //Added scanner for less need to change starting variable
        Scanner sc  = new Scanner(System.in);
        String text = sc.nextLine();
        //Added a reverse string to compare
        String reverse = "";
        //Split original text to characters to add into stack
        for(char c : text.toCharArray()) {
            palindrome.push(String.valueOf(c));
        }
        //Pop each character out, confirming it to be in reverse order
        while(!palindrome.isEmpty()) {
            //added reversed characters to reverse string
            reverse += palindrome.pop();
        }
        //Comparison
        if (text.equals(reverse)){
            System.out.println("Palindrome: " + text);
        }
        else{
            System.out.println("Not Palindrome: " + text);
        }
    }

    // S8 – Function Call Stack Simulator
    private static void runS8_FunctionCallStack() {
        // TODO: Implement task S8 here.
    }

    // S9 – Stack of Plates (Capacity-Limited Stack)
    private static void runS9_StackOfPlates() {
        // TODO: Implement task S9 here.
    }
}

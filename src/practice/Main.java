package practice;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static boolean isCorrectBrackets(String str) {
        Deque<Character> deq = new ArrayDeque<>();

        for (char bracket : str.toCharArray()) {
            switch (bracket) {
                case '(':
                case '{':
                case '[':
                case '<':

                    deq.push(bracket);
                    break;
                case ')':
                case '}':
                case ']':
                case '>':
                    if (deq.isEmpty() || !isCorrectMatch(deq.pop(), bracket)) {
                        return false;
                    }
                    break;
                default:
                    // Ignore other characters in the string
                    break;
            }
        }

        return deq.isEmpty();
    }
//    public static boolean <КОРРЕКТНЫЕ-ли СКОБКИ В СТРОКЕ>(String str) {
//        Deque<Character> D = new ArrayDeque<>();
//    for (char bracket : brackets.toCharArray()) {
//        if ( <метод скобка открывающая >) {
//            D.push(bracket);
//        } else if (<метод скобка закрывающая >) {
//            if (D.isEmpty() || ! метод <скобки корректно согласованы (D.pop(), bracket)>) {
//                return false;
//            }
//        }
//    }
//
//        return D.isEmpty();
//}



    private static boolean isOpen(char bracket) {
        return bracket == '(' ||
               bracket == '{' ||
               bracket == '<' ||
               bracket == '[';
    }

    private static boolean isClose(char bracket) {
        return bracket == ')' ||
               bracket == '}' ||
               bracket == '>' ||
               bracket == ']';
    }

    private static boolean isCorrectMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '<' && close == '>') ||
               (open == '[' && close == ']');
    }
    public static void main(String[] args) {
        String valid = "<({[d]})>";
        String invalid = "({[})";
        String invalid1 = "(<{[d])}";
        String valid1 = "{(ss[d]ggg)}";

        System.out.println("Valid brackets: " + isCorrectBrackets(valid)); // Выводит "Valid brackets: true"
        System.out.println("Invalid brackets: " + isCorrectBrackets(invalid)); // Выводит "Invalid brackets: false"
        System.out.println("Invalid brackets: " + isCorrectBrackets(invalid1));
        System.out.println("Invalid brackets: " + isCorrectBrackets(valid1));
    }

}

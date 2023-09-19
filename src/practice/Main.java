package practice;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static boolean isCorrectBrackets(String brackets) {
        Deque<Character> deq = new ArrayDeque<>();
//        if (brackets.length()%2 != 0)
//            {return false;}

        for (char bracket : brackets.toCharArray()) {
            if (isOpenBracket(bracket)) {
                deq.push(bracket);
            } else if (isCloseBracket(bracket)) {
                if (deq.isEmpty() || !isCorrectMatch(deq.pop(), bracket)) {
                    return false;
                }
            }
        }

        return deq.isEmpty();
    }
//    public static boolean isValid(String brackets) {
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


    private static boolean isOpenBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }

    private static boolean isCloseBracket(char bracket) {
        return bracket == ')' || bracket == '}' || bracket == ']';
    }

    private static boolean isCorrectMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String valid = "({[d]})";
        String invalid = "({[})";
        String invalid1 = "({[d])}";


        System.out.println("Valid brackets: " + isCorrectBrackets(valid)); // Выводит "Valid brackets: true"
        System.out.println("Invalid brackets: " + isCorrectBrackets(invalid)); // Выводит "Invalid brackets: false"
        System.out.println("Invalid brackets: " + isCorrectBrackets(invalid1));
    }

}

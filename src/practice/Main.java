/**
 * Пусть есть массив, принимающий три вида скобок : '(' ,')' ,'{', '}','[', ']'  ( 6 различных символов).
 *     Нужно написать метод, определяющий является ли порядок
 *     скобок в массиве корректным.
 *     {}([]) - корректный порядок
 *     {}([]{()}) - корректный порядок
 *     {(] - некорректный порядок
 *     {}([])} - некорректный порядок
 *     {}([])( - некорректный
 *     {(})
 *     Использовать  деку при решении


    АРХИТЕКТУРА И ОСНОВНОЙ ПРИНЦИП ПРЕДЛАГАЕМОГО РЕШЕНИЯ

    Основной метод:
    public static boolean <КОРРЕКТНЫЕ-ли СКОБКИ В СТРОКЕ>(String str) {
        Deque<Character> deqOfBrackets = new ArrayDeque<>();
    for (char bracket : str.toCharArray()) { // предполагаемая скобка
        if ( метод bool <это скобка открывающая?>) {
            deqOfBrackets.push(bracket);
        } else if (метод bool <это скобка закрывающая?>) {
 (тогда удаляем  и проверяем 'парность\непарность'
 только-что удалённой скобки с текущей )
            if (deqOfBrackets.isEmpty() || ! метод bool <скобки корректно согласованы?(deqOfBrackets.pop(), bracket)>) {
                return false;
            }
        }
    }
        return deqOfBrackets.isEmpty();
    }
 */
package practice;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static boolean isValidBrackets(String str) {
        Deque<Character> deqOfBrackets = new ArrayDeque<>();
        for (char bracket : str.toCharArray()) {
            switch (bracket) {
                case '(':
                case '{':
                case '[':
                case '<':
                    deqOfBrackets.push(bracket);
                    break;
                case ')':
                case '}':
                case ']':
                case '>':
                    if (deqOfBrackets.isEmpty() ||
                       !isCorrectMatch(deqOfBrackets.pop(), bracket)) {
                        return false;
                    }
                    break;
                default:
                    // ignore any other chars
                    break;
            }
        }

        return deqOfBrackets.isEmpty();
    }
    private static boolean isCorrectMatch(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '<' && close == '>') ||
               (open == '[' && close == ']');
    }
    public static void main(String[] args) {
        String Str0 = "({<[d];>})";
        String Str1 = "({[}>);";
        String Str2 = "(<{[d]);}";
        String Str3 = "{(JS[i])}<iframe>";
        String Str4 = "})JS]i[({>iframe<";

        System.out.println("Validity of string '"+ Str0 + "' is:" + isValidBrackets(Str0));
        System.out.println("Validity of string '"+ Str1 + "' is:" + isValidBrackets(Str1));
        System.out.println("Validity of string '"+ Str2 + "' is:" + isValidBrackets(Str2));
        System.out.println("Validity of string '"+ Str3 + "' is:" + isValidBrackets(Str3));
        System.out.println("Validity of string '"+ Str4 + "' is:" + isValidBrackets(Str4));
    }

}

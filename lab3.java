//Проверка пароля на надёжность.

import java.util.regex.*;
import java.util.Scanner;

public class lab3 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String pattern = "[a-zA-Z0-9_]+";
        String pattern_2 = "[0-9]";
        String pattern_3 = "[a-z]";
        String pattern_4 = "[A-Z]";
        System.out.print("Введите пароль: ");
        String text = in.nextLine();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        Pattern p_2 = Pattern.compile(pattern_2);
        Matcher m_2 = p_2.matcher(text);
        Pattern p_3 = Pattern.compile(pattern_3);
        Matcher m_3 = p_3.matcher(text);
        Pattern p_4 = Pattern.compile(pattern_4);
        Matcher m_4 = p_4.matcher(text);


        if (text.length() >= 8)
            if (m.find() && text.substring(m.start(), m.end()).equals(text))
                if (m_2.find() && m_3.find() && m_4.find())
                    System.out.print("Пароль является надёжным");
                else {
                    System.out.println("Пароль не является надёжным");
                    System.out.print("Пароль должен содержать хотя бы одну заглавную букву, одну маленькую букву и одну цифру.\n");
                }
            else {
                System.out.println("Пароль не является надёжным");
                System.out.print("Символом может быть только цифра, английская буква, знак подчеркивания");
            }
        else {
            System.out.println("Пароль не является надёжным");
            System.out.print("Пароль должен содержать 8 или более символов");
        }

        in.close();
    }
}
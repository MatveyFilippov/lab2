import java.util.Scanner;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Чтобы начать нажмите ENTER");
        String ENTER = in.nextLine();
        System.out.println();
        System.out.print("Введите пароль: ");
        String password = in.nextLine();
        Pattern letter = Pattern.compile("[a-z]");
        Matcher OK1 = letter.matcher(password);
        Pattern LETTER = Pattern.compile("[A-Z]");
        Matcher OK2 = LETTER.matcher(password);
        Pattern number = Pattern.compile("[0-9]");
        Matcher OK3 = number.matcher(password);
        Pattern mustnt = Pattern.compile("[^0-9_a-zA-Z]+");
        Matcher problem = mustnt.matcher(password);
        Pattern eight = Pattern.compile(".{8}");
        Matcher less = eight.matcher(password);
        do{
            if(!OK1.find() || !OK2.find() || !OK3.find()){
                System.out.println();
                System.out.println("Пароль обязательно должен содержать заглавную и маленькую буквы и цыфру");
                System.out.print("Повторите ввод: ");
                password = in.nextLine();
            }
            problem = mustnt.matcher(password);
            less = eight.matcher(password);
            while (problem.find()) {
                System.out.println();
                System.out.println("Можно использовать только цифры, английские буквы и знак подчеркивания");
                System.out.print("Повторите ввод: ");
                password = in.nextLine();
                while (!less.find()){
                    System.out.println();
                    System.out.println("Пароль должен содержать 8 или больше символов");
                    System.out.print("Повторите ввод: ");
                    password = in.nextLine();
                    less = eight.matcher(password);
                }
                problem = mustnt.matcher(password);
            }
            less = eight.matcher(password);
            while (!less.find()){
                System.out.println();
                System.out.println("Пароль должен содержать 8 или больше символов");
                System.out.print("Повторите ввод: ");
                password = in.nextLine();
                problem = mustnt.matcher(password);
                while (problem.find()) {
                    System.out.println();
                    System.out.println("Можно использовать только цифры, английские буквы и знак подчеркивания");
                    System.out.print("Повторите ввод: ");
                    password = in.nextLine();
                    problem = mustnt.matcher(password);
                }
                less = eight.matcher(password);
            }
            OK1 = letter.matcher(password);
            OK2 = LETTER.matcher(password);
            OK3 = number.matcher(password);
        } while(!OK1.find() || !OK2.find() || !OK3.find());
        System.out.println("Ваш пароль " + "'" + password + "'" +" надёжен!");
    }
}
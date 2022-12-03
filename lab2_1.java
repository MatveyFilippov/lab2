import java.util.Scanner;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Чтобы начать нажмите ENTER");
        String ENTER = in.nextLine();
        System.out.println();
        System.out.print("Введите дату формата дд/мм/гггг: ");
        String date = in.nextLine();
        Pattern letter = Pattern.compile("[^0-9/]+");
        Matcher problem = letter.matcher(date);
        while (problem.find()) {
            System.out.print("Упс, давйте ещё раз, но без посторонних символов: ");
            date = in.nextLine();
            while (date == "") {
                System.out.print("Ой, вы ничего не ввели, повторите попытку: ");
                date = in.nextLine();
            }
            problem = letter.matcher(date);
        }
        while (date == "") {
            System.out.print("Ой, вы ничего не ввели, повторите попытку: ");
            date = in.nextLine();
            problem = letter.matcher(date);
            while (problem.find()) {
                System.out.print("Упс, давйте ещё раз, но без посторонних символов: ");
                date = in.nextLine();
                problem = letter.matcher(date);
            }
        }
        System.out.println();
        Pattern right = Pattern.compile("." + "." + "/" + "." + "." + "/" + "." + "." + "." + ".");
        Matcher format = right.matcher(date);
        if (format.find()) {
            Pattern X = Pattern.compile("[0-9]+");
            Pattern xxX = Pattern.compile("[0-9]{1,2}" + "[/]");
            Matcher day = xxX.matcher(date);
            String dateD = null;
            if (day.find()) {
                dateD = date.substring(day.start(), day.end());
            }
            Matcher onlyD = X.matcher(dateD);
            if (onlyD.find()) {
                dateD = dateD.substring(onlyD.start(), onlyD.end());
            }
            double D = Double.parseDouble(dateD);

            Pattern XxxX = Pattern.compile("[/]+[0-9]+[/]");
            Matcher month = XxxX.matcher(date);
            String dateM = null;
            if (month.find()) {
                dateM = date.substring(month.start(), month.end());
            }
            Matcher onlyM = X.matcher(dateM);
            if (onlyM.find()) {
                dateM = dateM.substring(onlyM.start(), onlyM.end());
            }
            double M = Double.parseDouble(dateM);

            Pattern Xxx = Pattern.compile("[/]" + "[0-9]{4}");
            Matcher year = Xxx.matcher(date);
            String dateY = null;
            if (year.find()) {
                dateY = date.substring(year.start(), year.end());
            }
            Matcher onlyY = X.matcher(dateY);
            if (onlyY.find()) {
                dateY = dateY.substring(onlyY.start(), onlyY.end());
            }
            double Y = Double.parseDouble(dateY);

            if(1990 <= Y && Y <= 9999 && M <= 12 && D <= 31){
                System.out.println(dateD + "/" + dateM + "/" + dateY + " является датой в диапозоне 1990-9999гг");
            }
            else {
                System.out.println(dateD + "/" + dateM + "/" + dateY + " не является датой в диапозоне 1990-9999гг");
            }
        }
        else {
            System.out.println(date + " не является датой формата дд/мм/гггг");
        }
    }
}
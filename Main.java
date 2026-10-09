import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int DIVIDER14 = 14;
        final int DIVIDER2 = 2;
        final int DIVIDER7 = 7;
        final int NOT_FOUND = -1;

        // максимумы среди уже прочитанных чисел
        int maxAll = -1; // максимальный элемент
        int maxEven = -1; // максимальное чётное число
        int maxDiv7 = -1; // максимальное число, кратное 7

        int r = NOT_FOUND; // максимальное подходящее произведение (результат)

        Scanner scanner = new Scanner(new File("singlePass.txt")); // открываем файл

        // считываем числа по одному
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            // случай 1: число делится на 14
            if (num % DIVIDER14 == 0) {
                if (maxAll != -1) { // проверка, есть ли у нас уже одно число, с которым можно умножить текущее
                    r = Math.max(r, num * maxAll); // метод выбирает максимальное число
                }
            }
            // случай 2: число чётное, но не кратно 7
            else if (num % DIVIDER2 == 0) {
                if (maxDiv7 != -1) {
                    r = Math.max(r, num * maxDiv7);
                }
            }
            // случай 3: число нечётное, но кратно 7
            else if (num % DIVIDER7 == 0) {
                if (maxEven != -1) {
                    r = Math.max(r, num * maxEven);
                }
            }

            // обновляем максимумы после проверки пар
            maxAll = Math.max(maxAll, num);
            if (num % DIVIDER2 == 0) {
                maxEven = Math.max(maxEven, num);
            }
            if (num % DIVIDER7 == 0) {
                maxDiv7 = Math.max(maxDiv7, num);
            }
        }
        System.out.println("Максимальное произведение: " + r); // вывод результата
    }
}
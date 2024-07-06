import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            File res = new File("results.txt");
            int x =0;// Число из файла
            String fileName = "results.txt";
            File file = new File(fileName);
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) x = scanner.nextInt();
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка чтения файла");
            }
            int number = (int) (100 * Math.random());
            out.println("Введите число:");
            int i = 1;//Число попыток
            try (Scanner console = new Scanner(in)) {
                int num1;//Ввод с клавиатуры
                while (i >= 1) {
                    if (console.hasNext("result")) {
                        out.println("Попыток:" + i);
                        out.println("Лучший результат:" + x);
                        return;
                        } else {
                            try {
                                num1 = console.nextInt();
                                if (number == num1) {
                                    out.println("Вы угадали!");
                                    break;
                                } else if (num1 < number) {
                                    out.println("Я сам в шоке, но, загаданное число больше, брат");
                                } else {
                                    out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                                }
                                i++;
                            } catch (InputMismatchException eo) {
                                out.println("Неизвестная команда.");
                                return;
                            }
                        }
                    }
                }
                out.println("Попыток:" + i);
                if (i < x || x == 0) {
                    FileWriter write = new FileWriter(res);
                    String a= String.valueOf(i);
                    write.write(a);
                    out.println("Лучший результат:" + i);
                    write.flush();
                    write.close();
                } else {
                    out.println("Лучший результат:" + x);
                }
        } catch (IOException e) {
            out.println("Ошибка");
        }

    }
        }



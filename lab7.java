/*С использованием инструментов языка Java необходимо реализовать собственный класс простых дробей (имеют числитель и знаменатель).
    Реализованный класс должен имплементировать следующие основные операции:

        Создание простой дроби (с заданным числителем и знаменателем)
        Создание простой дроби по умолчанию (числитель 1, знаменатель 1)
        Операция сложения (2 варианта: в первом - функция возвращает результат сложения двух дробей,
            указанных как аргументы, во втором - аргумент только один)
        Операция вычитания (2 варианта: в первом - функция возвращает результат вычитания двух дробей,
            указанных как аргументы, во втором - аргумент только один)
        Операция умножения (2 варианта: в первом - функция возвращает результат умножения двух дробей,
            указанных как аргументы, во втором - аргумент только один)
        Операция деления (2 варианта: в первом - функция возвращает результат деления двух дробей,
            указанных как аргументы, во втором - аргумент только один)

        В функции main должна быть полная и наглядная демонстрация работы класса, всех случаев.*/

import java.util.InputMismatchException;
import java.util.Scanner;

//Класс дроби
class simple_fraction{
    int numerator;
    int denominator;

    //Создание дроби в виде двухэлементного массива
    public int[] create_fraction() {
        int array[], arraySize = 2;
        array = new int[arraySize];
        array[0] = numerator;
        array[1] = denominator;
        return array;
    }

    public simple_fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Отображение созданной дроби
    public String display_fraction() {
        return numerator + "/" + denominator;
    }
}

//Класс дроби с конструктором по умолчанию
class default_simple_fraction{
    //Создание дроби в виде двухэлементного массива
    public int[] create_fraction() {
        int array[], arraySize = 2;
        array = new int[arraySize];
        array[0] = 1;
        array[1] = 1;
        return array;
    }

    //Отображение созданной дроби
    public String display_fraction() {
        return 1 + "/" + 1;
    }
}

//Класс операций
class operations{
    int[] first_fr;
    int[] second_fr;

    public operations(int[] first_fr, int[] second_fr) {
        this.first_fr = first_fr;
        this.second_fr = second_fr;
    }

    //Вычисление суммы двух дробей
    public String addition_result() {
        int local_numerator;
        int local_denominator;
        local_denominator = 1;
        local_numerator = 1;
        if (first_fr[1] == second_fr[1]) {
            local_denominator = first_fr[1];
            local_numerator = first_fr[0] + second_fr[0];
        }
        else {
            //Приведение к общему знаменателю
            if (second_fr[1] > first_fr[1])
                for (int i = 1; i < second_fr[1]; i++){
                    if ((i * second_fr[1]) % first_fr[1] == 0) {
                        local_denominator = i * second_fr[1];
                        local_numerator = i * second_fr[0] + ((i * second_fr[1]) / first_fr[1]) * first_fr[0];
                        break;
                    }
                }
            else {
                for (int i = 1; i < first_fr[1]; i++){
                    if ((i * first_fr[1]) % second_fr[1] == 0) {
                        local_denominator = i * first_fr[1];
                        local_numerator = i * first_fr[0] + ((i * first_fr[1]) / second_fr[1]) * second_fr[0];
                        break;
                    }
                }
            }
        }
        return local_numerator + "/" + local_denominator;
    }

    //Вычисление суммы дроби с дробью по умолчанию
    public String default_addition_result() {
        int local_numerator;
        int local_denominator;
        local_denominator = first_fr[1];
        local_numerator = first_fr[0] + first_fr[1];
        return local_numerator + "/" + local_denominator;
    }

    //вычисление разности
    public String subtraction_result() {
        int local_numerator;
        int local_denominator;
        local_denominator = 1;
        local_numerator = 1;
        if (first_fr[1] == second_fr[1]) {
            local_denominator = first_fr[1];
            local_numerator = first_fr[0] + second_fr[0];
        }
        else {
            //Приведение к общему знаменателю
            if (second_fr[1] > first_fr[1])
                for (int i = 1; i < second_fr[1]; i++){
                    if ((i * second_fr[1]) % first_fr[1] == 0) {
                        local_denominator = i * second_fr[1];
                        local_numerator = ((i * second_fr[1]) / first_fr[1]) * first_fr[0] - i * second_fr[0];
                        break;
                    }
                }
            else {
                for (int i = 1; i < first_fr[1]; i++){
                    if ((i * first_fr[1]) % second_fr[1] == 0) {
                        local_denominator = i * first_fr[1];
                        local_numerator = i * first_fr[0] - ((i * first_fr[1]) / second_fr[1]) * second_fr[0];
                        break;
                    }
                }
            }
        }
        return local_numerator + "/" + local_denominator;
    }

    //Вычисление разности дроби с дробью по умолчанию
    public String default_subtraction_result() {
        int local_numerator;
        int local_denominator;
        local_denominator = first_fr[1];
        local_numerator = first_fr[1] - first_fr[0];
        return local_numerator + "/" + local_denominator;
    }

    //Вычисление произведения двух дробей
    public String multiplication_result() {
        int local_numerator;
        int local_denominator;
        local_denominator = first_fr[1] * second_fr[1];
        local_numerator = first_fr[0] * second_fr[0];
        return local_numerator + "/" + local_denominator;

    }

    //Вычисление произведения дроби с дробью по умолчанию
    public String default_multiplication_result() {
        return first_fr[0] + "/" + first_fr[1];
    }

    //Вычисление частного
    public String division_result() {
        int local_numerator;
        int local_denominator;
        if (second_fr[0] != 0) {
            local_denominator = first_fr[1] * second_fr[0];
            local_numerator = first_fr[0] * second_fr[1];
            return local_numerator + "/" + local_denominator;
        }
        else {
            return "Ошибка! Частное не может быть построенно, так как вторая дробь равна нулю.";
        }

    }

    //Вычисление частного дроби
    public String default_division_result() {
        return first_fr[1] + "/" + first_fr[0];
    }
}


public class lab7 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите числитель первой дроби: ");
            int num1 = in.nextInt();
            System.out.print("Введите знаменатель первой дроби: ");
            int num2 = in.nextInt();
            if (num2 == 0) {
                System.out.println("Ошибка! Знаменатель дроби не должен быть равен нулю.");
                System.exit(0);
            }
            System.out.print("Введите числитель второй дроби: ");
            int num3 = in.nextInt();
            System.out.print("Введите знаменатель второй дроби: ");
            int num4 = in.nextInt();
            if (num4 == 0) {
                System.out.println("Ошибка! Знаменатель дроби не должен быть равен нулю.");
                System.exit(0);
            }
            in.close();

            //Создание классов дробей и операций над ними
            default_simple_fraction default_fraction = new default_simple_fraction();
            simple_fraction first_fraction = new simple_fraction(num1, num2);
            simple_fraction second_fraction = new simple_fraction(num3, num4);
            operations operations = new operations(first_fraction.create_fraction(), second_fraction.create_fraction());


            //Вывод результата операций с двумя дробями
            System.out.println();
            System.out.println("Первая дробь: " + first_fraction.display_fraction());
            System.out.println("Вторая дробь: " + second_fraction.display_fraction());
            System.out.println("Сумма дробей: " + operations.addition_result());
            System.out.println("Разность дробей: " + operations.subtraction_result());
            System.out.println("Произведение дробей: " + operations.multiplication_result());
            System.out.println("Частное дробей: " + operations.division_result());

            //Вывод результата операций с дробью по умолчанию
            System.out.println();
            System.out.println("Дробь по умолчанию: " + default_fraction.display_fraction());
            System.out.println("Первая дробь: " + first_fraction.display_fraction());
            System.out.println("Сумма дробей: " + operations.default_addition_result());
            System.out.println("Разность дробей: " + operations.default_subtraction_result());
            System.out.println("Произведение дробей: " + operations.default_multiplication_result());
            System.out.println("Частное дробей: " + operations.default_division_result());
        }
        //Обработка ошибки ввода
        catch (InputMismatchException exception) {
            System.out.println("Ошибка! Дроби должны быть заданы целыми числами!");
        }
    }
}

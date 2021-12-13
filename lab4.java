import java.util.Scanner;

/*
Написать программу, удаляющую из целочисленного массива A размерности N элементы, равные
целому числу X. В результате должен получиться массив не большей размерности. На экран должны
выводиться как оригинальное состояние массива, так и итоговое.
*/

public class lab4 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        //Объявление
        int array[], arraySize = 0;

        System.out.print("Введите размерность массива: ");
        while (!in.hasNextInt()) {
            System.out.println("Ошибка! Размерность должна быть числом!");
            System.out.print("Введите размерность массива: ");
            in.next();
        }
        arraySize = in.nextInt();


        //Определение
        array = new int[arraySize];
        int count_x = 0;

        //Инициализация
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите " + i + "-й элемент массива: ");
            while (!in.hasNextInt()) {
                System.out.println("Ошибка! Элемент должен быть числом!");
                System.out.print("Введите " + i + "-й элемент массива: ");
                in.next();
            }
            array[i] = in.nextInt();
        }

        System.out.print("Введите значение, которое нужно исключить: ");
        while (!in.hasNextInt()) {
            System.out.println("Ошибка! Значение должно быть числом!");
            System.out.print("Введите значение, которое нужно исключить: ");
            in.next();
        }
        int X = in.nextInt();


        //Оригинальное состояние массива
        System.out.print("Массив до исключения всех элементов " + X + ": ");
        for (int elem : array) {
            System.out.print(elem + " ");
            if (elem == X) {
                count_x++;
            }
        }
        System.out.println();



        //Преобразования
        int[] copy = new int[array.length - count_x];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != X) {
                copy[index] = array[i];
                index++;
            }
        }

        //Итоговое состояние массива
        System.out.print("Массив после исключения всех элементов " + X + ": ");
        for (int elem : copy)
            System.out.print(elem + " ");
        System.out.println();

        in.close();
    }
}
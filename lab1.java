import java.util.Scanner;

public class lab1 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = in.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = in.nextInt();
        System.out.print("Введите третье число: ");
        int num3 = in.nextInt();
        System.out.print("Введите четвёртое число: ");
        int num4 = in.nextInt();
        int max_num = num1;
        int max_num_count = 1;

        if (num2 >= max_num)
                if (num2 == max_num)
                    max_num_count++;
                else {
                    max_num = num2;
                    max_num_count = 1;
                }
        if (num3 >= max_num)
            if (num3 == max_num)
                max_num_count++;
            else {
                max_num = num3;
                max_num_count = 1;
            }
        if (num4 >= max_num)
            if (num4 == max_num)
                max_num_count++;
            else {
                max_num = num4;
                max_num_count = 1;
            }

        System.out.print("Количество максимальных элементов: ");
        System.out.print(max_num_count);
    }
}

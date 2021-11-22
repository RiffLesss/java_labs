import java.util.Scanner;

public class lab2 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите X: ");
        int x = in.nextInt();
        System.out.print("Введите N: ");
        int n = in.nextInt();
        int new_x_for = x;
        int new_x_while = x;

        for (int i = 1; i < n; i++){

            new_x_for = new_x_for * x;

        }

        while (n > 1){

            new_x_while = new_x_while * x;
            n--;

        }


        System.out.print("X в степени N с помощью цикла for = ");
        System.out.println(new_x_for);
        System.out.print("X в степени N с помощью цикла while = ");
        System.out.print(new_x_while);
    }
}
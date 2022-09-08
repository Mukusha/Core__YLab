package task1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int N = 5; // размер массива
        int[][] matrix = randomMatrix(N);//создать матрицу
        double[] d = MinMaxSr(matrix);//найти мин, макс, среднее
        printInfo(matrix,d);//вывести
    }

    /**
     * Заполняет случайными числами матрицу размера NxN. Используется линейный конгруэнтный метод.
     * @param N - размер заполняемой матрицы
     * @return матрица заполненная случайными числами
     * */
    private static int[][] randomMatrix(int N){
       /* m — модуль (0 < M);
        k — множитель (0 ≤ k < M);
        b — приращение (0 ≤ b < M);
        seed — начальное значение (0 ≤ r0 < M).
        числа b и M взаимно простые;
        k – 1 кратно p для каждого простого p, являющегося делителем M;
        */

        int k = 35, b =7, m = 111;
        Date date = new Date();
        int seed = (int) (date.getTime()%10000); // начальное время задается в зависимости от времени, что бы при каждом старте системы были разные наборы случайных чисел
        int[][] MathRandom = new int[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                seed = (k * seed + b) % m;
                MathRandom[i][j] = seed;
            }
        }

        return MathRandom;
    }

    /**
     * Находит в матрице минимальный и минимальный элемент, а так же среднее значение переменных в матрице.
     * @param mass целочисленная матрица
     * @return возвращает массив, где первый элемент - минимальный, второй максимальный, а третий - среднее значение.
     * */
    private static double[] MinMaxSr(int[][] mass){
        int min = mass[0][0];
        int max = mass[0][0];
        double avg=0;
        for (int[] ints : mass) {
            for (int j = 0; j < mass.length; j++) {
                avg += ints[j];
                if (ints[j] < min) min = ints[j];
                if (ints[j] > max) max = ints[j];
            }
        }
        avg/=mass.length*mass.length;

        double[] res = new double[3];
        res[0]=min;
        res[1]=max;
        res[2]=avg;

        return res;
    }

    /**
     * Выводит на экран информацию о массиве
     * @param mass массив случайных чисел
     * @param date массив с данными
     * */
    private static void printInfo(int[][] mass,double[] date){
        for (int[] ints : mass) {
            for (int j = 0; j < mass.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("Наименьший элемент: "+(int) date[0]+"\nНаибольший элемент: "+ (int) date[1]+"\nСреднее значение: "+date[2]);
    }
}
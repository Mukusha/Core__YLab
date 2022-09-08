package task2;

//Отсортируйте массив [5,6,3,2,5,1,4,9]

public class Main {
    public static void main(String[] args) {
        int[] mass = {5,6,3,2,5,1,4,9};
        int[] res = sortMass(mass); //сортировка массива
        printInfo(mass,res);
    }

    /**
     * Сортирует массив по возрастанию
     * @param mass целочисленная матрица
     * @return возвращает отсортированный массив
     * */
    private static int[] sortMass(int[] mass){
        int[] sortMass = new int[mass.length];
        System.arraycopy(mass, 0, sortMass, 0, mass.length);
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < sortMass.length; i++) {
                if (sortMass[i] < sortMass[i - 1]) {
                    int tmp = sortMass[i];
                    sortMass[i] = sortMass[i-1];
                    sortMass[i-1] = tmp;
                    needIteration = true;
                }
            }
        }
        return sortMass;
    }

    /**
     * Выводит на экран информацию о массиве
     * @param mass массив случайных чисел
     * @param res массив с данными
     * */
    private static void printInfo(int[] mass,int[] res) {
        System.out.println("Заданный массив: ");
        for (int j : mass) {
            System.out.print(j + " ");
        }
        System.out.println("\nОтсортированный массив:");
        for (int re : res) {
            System.out.print(re + " ");
        }
    }


}

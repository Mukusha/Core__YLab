package homework;

import java.util.*;
import java.util.stream.Collectors;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }

        public String toString(){
            return name+" ("+id+")";
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),

    };

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени:");
        System.out.println();

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */

        Map<String, List<Person>>  personSortMap = Arrays.stream(RAW_DATA)
                .distinct()
                .filter(x-> x.getName() != null)
                .sorted(Comparator.comparingInt(Person::getId))
                .collect(Collectors.groupingBy(Person::getName,TreeMap::new, Collectors.toList()));

        personSortMap.forEach((k, v) -> System.out.println("Key: " + k + "\nValue: " + v.size()));
        System.out.println();
        /*
        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
                */

        for (Map.Entry<String, List<Person>> pair : personSortMap.entrySet()) {
            String key = pair.getKey();
            List<Person> value = pair.getValue();
            int iter = 1;
            System.out.println(key);
            for (Person p : value) {
                System.out.println(iter + " - " + p);
                iter++;
            }

        }

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
         */
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("На вход дается массив и число. Вывести пару чисел, которые дают сумму - заданное число.");
        System.out.println();

        System.out.println(findSum(Arrays.asList(3, 4, 2,7),10));

        assert Arrays.asList(3, 7).equals(findSum(Arrays.asList(3, 4, 2,7),10 ));
        assert Arrays.asList(6, 4).equals(findSum(Arrays.asList(6, 2, 5,4,1),10 ));
        assert List.of().equals(findSum(Arrays.asList(103, 71, 22,65,89,90, 13),120 ));
        assert Arrays.asList(65, 70).equals(findSum(Arrays.asList(65,33,70,-152),135 ));
        assert Arrays.asList(28, -8).equals(findSum(Arrays.asList(37,28,-14,25,-8),20 ));
        assert Arrays.asList(-5, -8).equals(findSum(Arrays.asList(-5,28,-14,-8,1),-13 ));
        assert List.of().equals(findSum(null,13 ));

    }

    /**
     * Находит пару чисел в списке mas, которая в сумме дает sum.
     * @param mas - список чисел
     * @param sum - искомая сумма
     * @return пара чисел в сумме дающая sum
     * */
    public static  List<Integer> findSum( List<Integer> mas, int sum) {
        if (mas == null ) {
            return new ArrayList<>();
        }
        Set<Integer> s = new HashSet<>();

        for (Integer m : mas) {
            int numberFind = sum - m;
            if (s.contains(numberFind)) {
                return Arrays.asList(numberFind, m);
            }
            s.add(m);
        }
        return new ArrayList<>();
    }
}



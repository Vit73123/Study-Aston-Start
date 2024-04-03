package aston.start.hw1_collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        Пустой CustomArrayList
        CustomArrayList<Integer> list1 = new CustomArrayList<>();

        System.out.println("Создание пустого CustomArrayList:");
        System.out.println(list1);

        System.out.println("Добавить элементы (5, 4, 3, 2, 1):");
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        System.out.println(list1);

        System.out.println("Получить элемент с указанным индексом (3):");
        System.out.println(list1.get(3));

        System.out.println("Добавить элемент (10) с указанным индексом (2):");
        list1.add(2, 10);
        System.out.println(list1);

        System.out.println("Заменить на элемент (11) с указанным индексом (0):");
        list1.set(0, 11);
        System.out.println(list1);

        System.out.println("Удалить элемент с указанным индексом (3):");
        list1.remove(3);
        System.out.println(list1);

        System.out.println("Отсортировать список");
        list1.sort();
        System.out.println(list1);

        System.out.println("Очистить список без удаления элементов");
        list1.clear();
        System.out.println(list1);

        System.out.println("Очистить список с удалением всех элементов");
        list1.clearToNew();
        System.out.println(list1);


        //        CustomArrayList из массива
        Integer[] a = {1, 2, 3, 4, 5};
        CustomArrayList<Integer> listFromArray = new CustomArrayList<>(a);

        System.out.println("\nCustomArrayList из массива {1, 2, 3, 4, 5} (listFromArray):");
        System.out.println(listFromArray);

//        CustomArrayList из ArrayList
        List<Integer> l = new ArrayList<>();
        Collections.addAll(l, 1, 2, 3, 4, 5);
        CustomArrayList<Integer> listFromArrayList = new CustomArrayList<>(l);

        System.out.println("\nCustomArrayList из ArrayList [1, 2, 3, 4, 5] (listFromArrayList):");
        System.out.println(listFromArrayList);

//        CustomArrayList из Set
        Set<Integer> s = new HashSet<>();
        Collections.addAll(s, 7, 7, 5, 5, 3);
        CustomArrayList<Integer> listFromSet = new CustomArrayList<>(s);

        System.out.println("\nCustomArrayList из Set {7, 7, 5, 5, 3} (listFromSet):");
        System.out.println(listFromSet);

        System.out.println("Добавить к списку (listFromArray) коллекцию Set {7, 7, 5, 5, 3}:");
        listFromArray.addAll(s);
        System.out.println(listFromArray);

//        Отсортировать статическим CustomArrayList.sort()
        List<Integer> sortList = new ArrayList<>() {{
            add(5);
            add(4);
            add(3);
            add(2);
            add(1);
        }};
        System.out.println("Отсортировать статическим CustomArrayList.sort() список [5, 4, 3, 2, 1]:");
        System.out.println(sortList);
        CustomArrayList.sort(sortList);
        System.out.println(sortList);

    }
}
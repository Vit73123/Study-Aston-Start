package aston.start.hw1_collections;

import java.util.Collection;

@SuppressWarnings("unchecked")
public class CustomArrayList<E extends Comparable<E>> {
    private static int INIT_CAPACITY = 10;

    private Object[] elements;

    private int capacity;
    private int size;

    //    Создать пустой список
    public CustomArrayList() {
        capacity = INIT_CAPACITY;
        this.elements = new Object[INIT_CAPACITY];
    }

    //    Создать список из коллекции либого типа
    public CustomArrayList(Collection<? extends E> c) {
        Object[] newElements = c.toArray();
        int newSize = newElements.length;

        capacity = newSize > INIT_CAPACITY ? newSize + (newSize << 1) : INIT_CAPACITY;
        elements = new Object[capacity];
        System.arraycopy(newElements, 0, elements, 0, newSize);
        size = newSize;
    }

    //    Создать список из массива
    public CustomArrayList(E[] a) {
        int newSize = a.length;

        capacity = newSize > INIT_CAPACITY ? newSize + (newSize << 1) : INIT_CAPACITY;
        elements = new Object[capacity];
        System.arraycopy(a, 0, elements, 0, newSize);
        size = newSize;
    }

    //    Получить элемент коллекции по индексу
    public E get(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        return (E) elements[index];
    }

    //    Добавить элементв конец списка
    public void add(E e) {
        if (size == capacity) {
            elements = grow();
        }
        elements[size] = e;
        size++;
    }

    //    Добавить элемент в позицию, заданную индексом
    public void add(int index, E e) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            elements = grow();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
    }

    //    Установить значение (заменить) элемент списка, заданный индексом
    public E set(int index, E element) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    //    Добавить к списку элементы переданной коллекции
    public void addAll(Collection<? extends E> c) {
        Object[] newElements = c.toArray();
        int newElementsSize = newElements.length;
        int newSize = size + newElementsSize;

        if (newSize > capacity) {
            elements = grow(newSize + 1);
        }
        System.arraycopy(newElements, 0, elements, size, newElementsSize);
        size = newSize;
    }

    //    Удалить элемент списка, заданный индексом
    public E remove(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) elements[index];
        final int newSize = size - 1;
        if (index < newSize) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }
        elements[size] = null;
        size = newSize;
        return oldValue;
    }

    //    Очистить список и сохранить вместимость (capacity)
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
            size = 0;
        }
    }

    //    Очистить список и иницилизровать вместимость по умолчанию (INIT_CAPACITY)
    public void clearToNew() {
        capacity = INIT_CAPACITY;
        elements = new Object[INIT_CAPACITY];
        size = 0;
    }

    //    Сортировать элементы в данном списке
    public void sort() {
        sort(elements, size);
    }

    //    Утильный метод: Сортировать элементы в переданной коллекции
    public static <T extends Comparable<T>> void sort(Collection<T> c) {
        Object[] a = c.toArray();
        sort(a, null);
        c.clear();
        for (Object e : a) {
            c.add((T) e);
        }
    }

    //    Служебный метод: Сортировка пузырьком с выходом, если массив отсортирован
    private static <T extends Comparable<T>> void sort(Object[] a, Integer l) {
        int size = l != null ? l : a.length;
        for (int i = 0; i < size - 1; i++) {
            boolean stop = true;
            for (int j = 0; j < size - i - 1; j++) {
                T e1 = (T) a[j];
                T e2 = (T) a[j + 1];
                if (e1 != null && (e2 == null || e1.compareTo(e2) > 0)) {
                    Object temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    stop = false;
                }
            }
            if (stop) {
                break;
            }
        }
    }

    //    Служебный метод: Увеличение текущей вместимости массива (хранилища элементов списка)
    private Object[] grow() {
        return grow(capacity);
    }

    //    Служебный метод: Увеличение вместимости массива с заданной минимальной размерностью
    private Object[] grow(int capacity) {
        this.capacity = capacity + (capacity >> 1);
        Object[] copy = new Object[capacity];
        System.arraycopy(elements, 0, copy, 0, size);
        return copy;
    }

    //    Служебный метод: Проверка индекса, что он находится в диапозоне размера списка
    private boolean checkIndex(int index) {
        return (index >= 0 && index < size);
    }

    //    Вывод элементов списка в строку в формате [1, 2, 3, ...]
    @Override
    public String toString() {
        if (elements == null)
            return "null";

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(elements[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}

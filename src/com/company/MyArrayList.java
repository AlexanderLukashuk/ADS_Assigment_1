package com.company;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }


    public void add(T item) {
        if (length == capacity)
            increaseCapacity();

        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (length == capacity)
            increaseCapacity();

        if (index >= 0)
            System.arraycopy(arr, index, arr, index+1, length - index);
        arr[index] = item;
        length++;
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, length - index - 1);
            length--;
            arr[length] = null;
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
//        if (index > length) {
//            System.out.println("There is not such element with " + index + " index!");
//            throw new IndexOutOfBoundsException();
//        }
//        T removeItem = (T) arr[index];
//        if (index >= 0)
//            System.arraycopy(arr, index + 1, arr, index, length - index - 1);
//        length--;
//        return removeItem;

        T removeItem = (T) arr[index];
        Object[] newArr = new Object[capacity];
        for (int i = 0, j = 0; i < capacity; i++) {
            if (i == index) {
                continue;
            }
            newArr[j] = arr[i];
            j++;
        }
        length--;
        arr = newArr;
        return removeItem;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == o) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public void sort() {
        if (length < 2) {
            return;
        }

        Object temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (((Comparable<T>)arr[j]).compareTo((T)arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; i++) {
            if(o == arr[i]){
                return true;
            }
        }
        return false;
    }

    public void ShowArray() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

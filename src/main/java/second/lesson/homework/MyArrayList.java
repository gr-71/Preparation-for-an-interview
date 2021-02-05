package second.lesson.homework;

public class MyArrayList <E extends Comparable <? super E>> implements ListSpecimen<E> {

    private E [] array;
    private  int size;

    private static final int CAPACITY = 12;

    public MyArrayList(int capacity) {
        this.array = (E[]) new Comparable[capacity];
        this.size = 0;
    }

    public MyArrayList (){
        this (CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        return array [index];
    }

    @Override
    public E set(int index, E essence) {
        if (index < size){
            array [index] = essence;
            return essence;
        }
        return null;
    }

    @Override
    public boolean add(E essence) {
        if (array.length == size){
            E [] temp = (E[]) new Comparable[size * 2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[size] = essence;
        size++;
        return true;
    }

    @Override
    public boolean delete(E essence) {
        for (int i = 0; i < size; i++) {
            if (essence.equals(array[i])){
                System.arraycopy(array, i + 1, array, i, size - i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E essence) {
        for (E element : array) {
            if (essence.equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

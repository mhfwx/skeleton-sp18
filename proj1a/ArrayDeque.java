
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity = 4;

    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        size = 0;
    }

    private void resize(int capacity){

        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    private void relocate(){
        T[] a = (T[]) new Object[items.length+1];
        System.arraycopy(items, 0, a, 1, items.length);
        items = a;
    }

    public void addFirst(T x){
        relocate();
        items[0] = x;
        size += 1;


    }

    public void addLast(T x){
        if (size == items.length){
            resize(size * 2);
        }

        items[size] = x;
        size +=1;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return(size == 0);
    }


}



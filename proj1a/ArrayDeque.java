
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start;
    private int last;
    private int capacity;

    public ArrayDeque(){
        capacity = 8;
        items = (T[]) new Object[capacity];
        start = 0;
        last = 0;
        size = 0;
    }

    private void resize(int newSize){
        T[] a = (T[]) new Object[newSize];

        if(start >= last ){
            int len1 = items.length - start;
            int len2 = last;
            if(len1>0){
                System.arraycopy(items, start, a , 0, len1);
            }
            if(len2>0){
                System.arraycopy(items, 0, a, len1, len2);
            }
        }else {
            System.arraycopy(items, start, a, 0, size);
        }
        items = a;
        start = 0;
        last = size;
    }


    public void addFirst(T x){
        if(size == items.length){
            resize(size * 2);
        }
        start = (start - 1 + items.length) % items.length;
        items[start] = x;
        size += 1;

    }

    public void printDeque(){

    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        if(items.length > capacity && size * 4 < items.length){
            resize(capacity / 2);
        }
        T popItem = items[start];
        start = (start + 1)%items.length;
        size --;
        return popItem;

    }

    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        if(items.length > capacity && size * 4 < items.length){
            resize(capacity / 2);
        }
        T popItem = items[last];
        start = (start - 1 + items.length)%items.length;
        size --;
        return popItem;
    }

    public T get(int index){
        if(index >= size ){
            return null;
        }
        return items[(index + start)%items.length];
    }


    public void addLast(T x){
        if (size == items.length){
            resize( size * 2);
        }


        items[last] = x;
        size +=1;
        last = (last + 1 ) % items.length;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return(size == 0);
    }


}



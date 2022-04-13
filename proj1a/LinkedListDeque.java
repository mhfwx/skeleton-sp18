public class LinkedListDeque<T> {
    private class IntNode{
        public T Item;
        public IntNode Next;
        public IntNode Prev;
        public IntNode (T i){
            Item = i;
        }

        public IntNode (T i, IntNode n, IntNode p){
            Item = i;
            Next = n;
            Prev =p;
        }
        public T helper(int Index){
            if(Index <= 0){
                return Item;
            }
            return Next.helper(Index - 1);
        }
    }


    private int size;
    private IntNode sentinel;
    /* create sentinel.next*/


    public LinkedListDeque (){
        sentinel = new IntNode(null);
        sentinel.Prev=sentinel;
        sentinel.Next=sentinel;
        size = 0;
    }

    public void addFirst(T x) {
        IntNode p = sentinel;
        IntNode firstNode = new IntNode(x, p.Next,p);

        p.Next = firstNode;
        firstNode.Next.Prev = firstNode;

        size += 1;

    }

    public void addLast(T x) {
        IntNode p = sentinel;
        IntNode lastNode = new IntNode(x, p,p.Prev);

        p.Prev = lastNode;
        lastNode.Prev.Next=lastNode;
        size += 1;

    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        IntNode removeNode = sentinel.Prev;
        removeNode.Prev.Next=sentinel;
        sentinel.Prev = removeNode.Prev;
        size -= 1;
        return removeNode.Item;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        IntNode removeNode = sentinel.Next;
        removeNode.Next.Prev=sentinel;
        sentinel.Next = removeNode.Next;
        size -= 1;
        return removeNode.Item;

    }

    public void printDeque(){
        IntNode p = sentinel.Next;

        for (int count = 0; count < size; count++){
            String separator = (count < size - 1) ? " " : "";
            System.out.print(p.Item + separator);
            p = p.Next;
        }
    }

    public T get(int index){
        if (index >= size){
            return null;
        }
        IntNode p = sentinel.Next;
        for (int count = 0; count <= index; count++){
            if (count < index){
                p = p.Next;
            }
        }
        return p.Item;
    }

    public T getRecursive(int index){
        IntNode p = sentinel.Next;

        return p.helper(index);
    }







    public boolean isEmpty() {
        return (size == 0);
    }

    public int size(){
        return size;
    }

}

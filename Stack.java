import java.util.Iterator;

public class Stack<E> implements Iterable<E>
{
    private Node first = null;
    private class Node {
        private E item;
        private Node next;
    } 
    public boolean isEmpty() {
        return first == null;
    }
    public void push(E item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }
    public E pop() {
        E item = first.item;
        first = first.next;
        return item;
    }
    public E getFirst() {
        return first.item;
    }
    public E grab(int current){
        Node nextnode = first.next;
        for (int i = 1; i < current; i++){
            nextnode = nextnode.next;
        }
        return nextnode.item;
    }
    // To make this data structure work with for-each loops
    public Iterator<E> iterator() {
        return new MyIterator();
    }
    public class MyIterator implements Iterator<E> {

        private Node n = first;

        public boolean hasNext() {
            return n != null;
        }

        public E next() {
            E item = n.item;
            n = n.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

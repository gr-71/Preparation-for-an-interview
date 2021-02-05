package second.lesson.homework;

public class MyLinkedList <E> implements ListSpecimen <E>{

    class Node <V>{
        V value;
        Node <V> next;
        Node <V> previous;

        public Node(V value, Node<V> next, Node<V> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public V getValue() {
            return value;
        }

        public Node<V> getNext() {
            return next;
        }

        public Node<V> getPrevious() {
            return previous;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Node<V> next) {
            this.next = next;
        }

        public void setPrevious(Node<V> previous) {
            this.previous = previous;
        }
    }


    private Node <E> first;
    private Node <E> last;
    private int size;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Node <E> node = getNode(index);
        if (node == null){
            return null;
        }
        return node.getValue();
    }

    private Node <E> getNode (int index){
        if (index >= size){
            return null;
        }
        Node <E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public E set(int index, E entry) {
        Node <E> node = getNode(index);
        if (node == null){
            return null;
        }
        node.setValue(entry);
        return entry;
    }

    @Override
    public boolean add(E entry) {
        if (last == null){
            last = new Node<>(entry, null, null);
            first = last;
        } else {
            Node <E> temp = last;
            last = new Node<>(entry, null, temp);
            temp.setNext(last);
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E entry) {
        Node <E> node = searchForNode(entry);
        if (node == null){
            return false;
        }
        if (!(node.equals(first) || node.equals(last))){
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }
        if (node.equals(first)){
            first = node.getNext();
        }
        if (node.equals(last)){
            last = node.getPrevious();
        }
        size--;
        return true;
    }

    private Node<E> searchForNode (E entry){
        if (size == 0){
            return null;
        }
        Node<E> current = first;
        while (current != null){
            if (current.getValue().equals(entry)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E entry) {
        Node <E> node = searchForNode(entry);
        return node != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

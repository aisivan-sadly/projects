public class MyLinkedList<T> implements IMyCollection<T> {

    private Node<T> head;
    private int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void addAll(T[] items) {
        for (T item : items) add(item);
    }

    public void add(T item) {
        if (size == 0) head = new Node(item);
        else if (size == 1){
            Node<T> node = new Node(item);
            head.next = node;
            head.prev = node;
            node.next = head;
            node.prev = head;
        }
        else {
            Node<T> node = new Node(item);
            head.prev.next = node;
            node.prev = head.prev;
            head.prev = node;
            node.next = head;
        }
        // односвязный не кольцевой не узнать
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> resNode = head;
        for (int i = 0; i < index; i++) {
            resNode = resNode.next;
        }
        return resNode.value;
    }

    public void remove(int index) {
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    public void print() {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();

    }



}
// спросить про альтернативные варианты

class Node<T> {
    Node<T> prev;
    Node<T> next;
    T value;

    public Node(T value) {
        this.value = value;
    }
}

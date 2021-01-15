
public class ArrayCollection<T> implements IMyCollection<T> {
    private T[] array;
    private int capacity;
    private int size;

    public ArrayCollection(){
        this(4);
    }

    public ArrayCollection(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(T item) {
        if (size == capacity) {
            T[] temp = array;
            int new_capacity = capacity*2;
            array = (T[]) new Object[new_capacity];
            System.arraycopy(temp,0,array,0, capacity);
            capacity = new_capacity;
        }
        array[size++] = item;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void addAll(T[] array) {
        for (T item : array) {
            add(item);
        }
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++ ) {
            array[i] = array[i+1];
        }
        size -= 1;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

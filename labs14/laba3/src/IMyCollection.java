public interface IMyCollection<T> {
    void add(T item);
    void addAll(T[] items);
    T get(int index);
    void remove(int index);
    void print();

}
// проверь альтернативные на гите
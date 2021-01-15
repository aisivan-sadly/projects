public class Lab3 {
    public static void main(String[] args){
        ArrayCollection<Integer> arr = new ArrayCollection<>();
        // Проверка коллекции на основе словаря
        System.out.println("----- Коллекция на основе массива -----");
        testCollection(arr);
        // Проверка коллекции на основе связного списка
        System.out.println("----- Связный список -----");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        testCollection(list);
    }

    public static void testCollection(IMyCollection<Integer> arr) {
        Integer[] testArr = new Integer[] { 2, 3 , 1 ,7 , 10 };
        System.out.println("проверяем возможность добавления");
        arr.addAll(testArr);
        System.out.print("Вывод результата"); arr.print();
        System.out.println("Результат - " + arr.get(2));
        try {
            // проверка не обязательна
   //         System.out.println(arr.get(5)); // макс индекс
   //     } catch (IndexOutOfBoundsException e) {
   //         System.out.println("ошибка");
        }
        arr.remove(1);
        System.out.println("тест удаления");
        System.out.print("результат"); arr.print();
    }
}

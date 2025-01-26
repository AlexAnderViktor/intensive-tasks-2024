package com.walking.intensive.chapter4.task18;


/**
 * Восемнадцатилетний Емеля едет в соседнюю деревню на печи искать себе невесту-ровесницу.
 * В каждой избушке в ряд живут невесты, каждая следующая старше
 * предыдущей на неизвестное количество лет. Будучи человеком ленивым и не желая заходить
 * в каждую избушку подряд и интересоваться возрастом невесты,
 * используя алгоритмическую сложность О(n), Емеля решил воспользоваться
 * алгоритмом бинарного поиска — это алгоритм поиска индекса нужного элемента (ключа)
 * в отсортированном массиве состоящим из неповторяющихся целых чисел путем деления массива на половины.
 *
 * <p> Если Емеля не сможет найти ровесницу - он предпочитает, чтобы девушка была младше.
 * Но все еще как можно ближе к возрасту Емели. Если подходящих девушек все еще нет - значит, не судьба
 * (верните из метода -1).
 *
 * <p>Реализуйте метод find(), используя алгоритм бинарного поиска. Суть алгоритма описана ниже.
 *
 * <p>Фактически, это последняя задача в интенсиве. Следующая глава содержит
 * еще два практических задания повышенной сложности - попробуйте свои силы,
 * но не стоит расстраиваться, если что-то не получится!
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task18 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11, 13};
        int target = 8;
        System.out.println(find(arr, target));
    }

    /**
     * Метод вернет значение по индексу среднего индекса массива, если ключ совпадет с полученным значением.
     * Если ключ меньше значения, то поиск повторится в левой половине массива, иначе в правой.
     * Другая часть массива в поиске дальше не участвует.
     * Процесс продолжится до тех пор, пока не будет найдено искомое значение
     * или дробящийся массив не станет пустым.
     *
     * <p>Пример:
     *
     * <p>Входные данные: [1,2,5,7,12,13,18,49,56,72,106], 18
     *
     * <p>Возвращаемое значение: 18
     *
     * <p>Пояснение: Средний элемент с индексом 5 является число 13, которое меньше 18.
     * Левая половина массива отбрасывается, дальше в поиске участвует только
     * правый массив: [18,49,56,72,106]. Средний элемент 56 больше 18.
     * Останется массив [18,49]. Поскольку в данном массиве всего два элемента
     * и нет среднего для порядка будем округлять в меньшую сторону. Это элемент 18.
     *
     * <p>Сравнение эффективности алгоритмов:
     *
     * <ul>
     * <li>Если массив будет содержать 1024 элемент бинарный поиск справится с задачей
     *      за 11 сравнений (O(log(n))) против 1024 сравнений перебором O(n).
     * <li>Если массив будет содержать 1 000 000 элементов бинарный поиск справится с
     *      задачей за 21 сравнение (O(log(n))) против 1 000 000 сравнений перебором O(n).
     * </ul>
     */
    static int find(int[] girlAges, int targetAge) {
        quickBySort(girlAges);

        int result = binarySearch(girlAges, targetAge);

        return result;
    }

    private static int[] quickBySort(int[] array) {
        if (array == null) {
            return new int[0];
        }

        quickSort(array, 0, array.length - 1);

        return array;
    }

    private static void quickSort(int[] array, int left, int right) {

        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int bestValue = -1;

        while (left <= right) {
            int middlElement = left + (right - left) / 2;

            if (array[middlElement] == target) {
                return array[middlElement];
            } else if (array[middlElement] < target) {
                bestValue = array[middlElement];
                left = middlElement + 1;
            } else {
                right = middlElement - 1;
            }
        }

        return bestValue;
    }
}

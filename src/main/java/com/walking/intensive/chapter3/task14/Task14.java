package com.walking.intensive.chapter3.task14;

import java.util.Arrays;

/**
 * Необходимо разработать программу, которая определяет количество объектов на радарах.
 *
 * <p>Реализуйте метод getObjectCounts(), который произведет указанный расчет.
 *
 * <p>Входящие параметры метода:
 *
 * <ol>
 * <li>Двумерный массив с координатами объектов, где любой objectLocations[i]
 *      содержит массив из двух точек - координат объекта по осям X и по Y соответственно;
 * <li>Двумерный массив с параметрами радаров, где любой radars[j] содержит массив со следующими данными:
 *      radars[j][0] - координата радара по оси X, radars[j][1] - координата радара по оси Y,
 *      radars[j][2] - радиус действия радара
 * </ol>
 *
 * <p>Возвращаемое значение метода - количество объектов, видимых на каждом из радаров:
 * objectCounts[j] должен содержать информацию о числе объектов, видимых на радаре radars[j].
 *
 * <p>Если объект находится точно на границе действия радара, считается,
 * что он попадает в зону действия этого радара.
 *
 * <p>Пример:
 *
 * <p>Входящие параметры: objectLocations[][] = [[1,3],[3,3],[5,3],[2,2]], radars[][] = [[2,3,1],[4,3,1],[1,1,2]].
 *
 * <p>Возвращаемое значение: objectCounts[] = [3,2,2].
 *
 * <p>Пояснение (для radars[0]):
 *
 * <ul>
 * <li>objectCounts[0] = 3, потому что радар с координатами (2;3) и радиусом действия 1 видит объекты с координатами
 * (1;3), (2;2) и (3;3). Всего 3 объекта.
 * </ul>
 *
 * <p>При наличии некорректных входных данных верните из метода пустой массив.
 *
 * <p>P.S. Решение не должно использовать сортировки, коллекции, Stream API и иной материал, выходящий за рамки
 * пройденного курса.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task14 {
    public static void main(String[] args) {
        int[][] objectLocations = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int[][] radars = {{1, 2, 3}, {2, 2, -5}, {4, 3, -1}, {4, 3, -6}};
        int[] result = getObjectCounts(objectLocations, radars);

        System.out.println(Arrays.toString(result));
    }

    static int[] getObjectCounts(int[][] objectLocations, int[][] radars) {
        if (objectLocations == null || radars == null) {
            return new int[]{};
        }

        int[] objectCounts = new int[radars.length];

        for (int j = 0; j < radars.length; j++) {
            if (radars[j].length != 3) {
                return new int[]{};
            }

            for (int k = 0; k < radars[j].length; k++) {
                if (radars[j][k] < 0) {
                    return new int[]{};
                }
            }

            int radarX = radars[j][0];
            int radarY = radars[j][1];
            int radarRadius = radars[j][2];

            for (int i = 0; i < objectLocations.length; i++) {
                if (objectLocations[i].length < 2) {
                    return new int[]{};
                }

                int objectX = objectLocations[i][0];
                int objectY = objectLocations[i][1];

                int distanceSquared = (radarX - objectX) * (radarX - objectX) + (radarY - objectY) * (radarY - objectY);
                int radiusSquared = radarRadius * radarRadius;

                if (distanceSquared <= radiusSquared) {
                    objectCounts[j]++;
                }
            }
        }

        return objectCounts;
    }
}

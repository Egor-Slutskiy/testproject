package com.testproj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        String[] input_array = {"K1\\SK2",
                                "K1\\SK1",
                                "K1\\SK1\\SSK1",
                                "K1\\SK1\\SSK2",
                                "K2",
                                "K2\\SK1\\SSK1",
                                "K2\\SK1\\SSK2"}; // Изначальный массив данных
        System.out.println(Arrays.toString(input_array));
        for(int i = 0; i < input_array.length; i++){ // Цикл for, который заменяет \ на точки для удобства
            input_array[i] = input_array[i].replace("\\", ".");
        }
        ArrayList<String> result_array = new ArrayList<>(); // создаем переменную результата в виде arraylist
        for (String value : input_array) { // Проходим по каждой строке импута
            String[] d = value.split("\\."); // сплит строки по точке ("K1.SK1" -> ("K1", "SK1")
            StringBuilder res = new StringBuilder(d[0]); // Записываем в переменную начальную точку

            /*
            Этот цикл генерирует все возможные пути, например у нас есть на вход значение
            "K1","SK1","SSK1"
            На выход мы получаем значения
            "K1"
            "K1/SK1"
            "K1/SK1/SSK1"
            Каждое полученое значение он проверяет на наличие в result_array и если его там нет - добавляет
            */
            for (int k = 0; k < d.length; k++) {
                if (k != 0) {
                    int val = k;
                    while (val != 0) {
                        res.append("\\").append(d[val]);
                        val = 0;
                        if (!result_array.contains(res.toString())) {
                            result_array.add(res.toString());
                        }
                    }
                } else {
                    if (!result_array.contains(res.toString())) {
                        result_array.add(res.toString());
                    }
                }
            }
        }
        System.out.println("Result:");
        Collections.sort(result_array); // сортируем результат и выводим построчно
        for (String s : result_array) {
            System.out.println(s);
        }
        /*
        Пример вывода в консоль:

        [K1\SK2, K1\SK1, K1\SK1\SSK1, K1\SK1\SSK2, K2, K2\SK1\SSK1, K2\SK1\SSK2]
        Result:
        K1
        K1\SK1
        K1\SK1\SSK1
        K1\SK1\SSK2
        K1\SK2
        K2
        K2\SK1
        K2\SK1\SSK1
        K2\SK1\SSK2

        Process finished with exit code 0
         */
    }
}

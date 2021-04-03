package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;

import static java.util.Arrays.fill;

public class PrymMethod {
    // к-сть вершин
    private static final int V = 8;

    //функція для пошуку вершини за мін вартістю
    int minKey(int key[], Boolean mstSet[])
    {
        // Ініціалізуємо мінімальне значення
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // друку побудованого MST, що зберігається в parent[]
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    // Функція побудови та друку MST для представленого графіка
    // з використанням  матриці суміжності
    void primMST(int graph[][])
    {
        // Масив для зберігання побудованого MST
        int parent[] = new int[V];

        // Ключові значення, що використовуються для вибору краю мінімальної ваги
        int key[] = new int[V];

        // Для представлення набору вершин, включених до MST
        Boolean mstSet[] = new Boolean[V];

        //Ініціалізуємо всі ключі
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Завжди включати першу 1-ю вершину в MST.
        key[0] = 0; // 0 , щоб ця вершина була  вибраний першою вершиню
        parent[0] = -1; // First node is always root of MST

        // MST матиме V вершин
        for (int count = 0; count < V - 1; count++) {
            // Виберає мінімальну ключову вершину з набору вершин , які ще не включені в MST
            int u = minKey(key, mstSet);

            // Додаємо вибрану вершину до набору MST
            mstSet[u] = true;

            // Оновлення значення ключа та батьківського індексу сусідньої
            // вибраної вершини. Розглянемо лише ті
            // вершини, які ще не включені в MST
            for (int v = 0; v < V; v++)

                // графік [u] [v] не дорівнює нулю лише для сусідніх вершин m
                // mstSet [v] є хибним для вершин, які ще не включені до MST
                // Оновлює ключ, лише якщо графік [u] [v] менший за ключ [v]
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // друкуємо побудований MST
        printMST(parent, graph);
    }
}

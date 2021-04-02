package com.company;

import java.io.*;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) throws IOException {
        FileWorker fileWorker = new FileWorker();
        PrymMethod prym = new PrymMethod();

        int [][] array = fileWorker.FileWorkerMethod();
        System.out.println("зчитаний файл вгорі___________ масив з файлу внизу");
       fileWorker.printArrayInt(array);
        System.out.println("___________Алгоритм Прима___________");
       prym.primMST(array);
    }
}
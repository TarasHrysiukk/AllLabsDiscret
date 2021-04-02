package com.company;

import java.io.*;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) throws IOException {
        FileWorker fileWorker = new FileWorker();
        PrymMethod prym = new PrymMethod();
        System.out.println("зчитаний файл_________________________");
        int [][] array = fileWorker.FileWorkerMethod();
        System.out.println("масив з файлу_________________________");
       fileWorker.printArrayInt(array);
        System.out.println("Алгоритм Прима_________________________");
       prym.primMST(array);
    }
}
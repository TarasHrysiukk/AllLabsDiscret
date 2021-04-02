package com.company;

import java.io.*;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) throws IOException {
        FileWorker fileWorker = new FileWorker();
        int [][] array = fileWorker.FileWorkerMethod();
        System.out.println("----------------------------------------");
       fileWorker.printArrayInt(array);
    }
}
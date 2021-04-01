package com.company;

import java.io.*;

public class Main {
    // построчное считывание файла
    public static void main(String[] args) throws IOException {
       // File lab1File = new File("D:\\NULP\\DiscretMoelLabs\\Lab1Prym\\lab1.txt");
        FileWorker fileWorker = new FileWorker();
        int [][] array = fileWorker.FileWorkerMethod();
        System.out.println("----------------------------------------");
       fileWorker.printArrayInt(array);


       //метод зчитування файлу таке саме в класі файлВоркер
       /* try {
            File file = new File("D:\\NULP\\DiscretMoelLabs\\Lab1Prym\\lab1.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //кінець методі зчитування файлу
    }
}

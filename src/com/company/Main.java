package com.company;

import lab1.FileWorker;
import lab1.PrymMethod;
import lab2.*;
import lab2.tools.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException , CloneNotSupportedException{
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String labNumber;

        System.out.println("******************* Введіть номер лабораторної яку слід показати *******************");
        System.out.println("1 - 1 лабораторна робота \n2 - 2 лабораторна робота \n3 - 3 лабораторна робота " +
                "\n4 - 4 лабораторна робота");
        System.out.print("Ваш вибір: ");
        labNumber = br.readLine();
        switch (labNumber){
            case ("1"):{
                FileWorker fileWorker = new FileWorker();
                PrymMethod prym = new PrymMethod();
                System.out.println("зчитаний файл_________________________");
                int [][] array = fileWorker.FileWorkerMethod();
                System.out.println("масив з файлу_________________________");
                fileWorker.printArrayInt(array);
                System.out.println("Алгоритм Прима_________________________");
                prym.primMST(array);

            }
            case ("2"):{
                System.out.println("Input full path to file: ");

                String path = br.readLine();
                MatrixOperations matrix = new MatrixOperations();
                int [][] array = matrix.readingMatrixFromFile(path);
                List<List<Integer>> list = matrix.returnData(array);
                matrix.printListInt(list);
                List<List<String>> list_string = matrix.convertListIntToString(list);
                matrix.printListString(list_string);
                ArrayList<Edge> graph_structure = new ArrayList<>();
                graph_structure = matrix.makeGraphStructure(list_string);
                Graph graph = new Graph(graph_structure);
                System.out.println("Алгоритм рішення задачі листоноші");
                System.out.println("Вхідний граф:");
                System.out.println(graph);
                EulerianPath eulerian_path = new EulerianPath(graph);

                System.out.println("Результат:");
                System.out.println(eulerian_path.getPath());

            }
            case("3"):{

            }
        }

    }
}
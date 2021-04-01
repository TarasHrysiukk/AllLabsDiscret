package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWorker {

    File lab1File = new File("lab1.txt");
    public int[][] FileWorkerMethod() throws IOException {
      ///  List<String> listNumb = new ArrayList<>();
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(lab1File);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);

        // считаем сначала первую строку
        int number_of_points = Integer.parseInt(reader.readLine());
        int i = 0;
        String[][] str = new String[number_of_points][number_of_points];
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            String [] str_row = line.split(" ");


                for(int j = 0; j < str[i].length; j++)
                {
                    str[i][j] = str_row[j];
                }
            // считываем остальные строки в цикле
            //System.out.println(Arrays.toString(str) + " array");

            line = reader.readLine();
            i++;
        }

        int[][] array = new int[str.length][str[0].length];

        for(int k = 0; k < array.length; k++)
        {
            for(int j = 0; j < array[k].length; j++)
            {
                array[k][j] = Integer.parseInt(str[k][j]);
            }
        }

        return array;
    }

    public void printArrayInt(int[][] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

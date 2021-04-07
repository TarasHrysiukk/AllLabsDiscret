package lab1;

import java.io.*;

public class FileWorker {

    File lab1File = new File("lab1.txt");
    public int[][] FileWorkerMethod() throws IOException {
        //створюємо об'єкт FileReader для об'екта File
        FileReader fr = new FileReader(lab1File);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        int number_of_points = Integer.parseInt(reader.readLine());
        int i = 0;
        String[][] str = new String[number_of_points][number_of_points];

        String line = reader.readLine();            // зчитуємо з початку перший рядок
        while (line != null) {  //проходимо по файли коли лініє != null
            System.out.println(line);
            String [] str_row = line.split(" "); //розділяємо наш зчитаний стрінг пропуском  створюючи масив
                for(int j = 0; j < str[i].length; j++) // проходимо по зчитаномому рядку (масив)
                {
                    str[i][j] = str_row[j];            // рахуємо к-сть елементів та даємо їх в масив
                }
            line = reader.readLine();               // зчитуємо наступні рядки з фалу
            i++;
        }

        int[][] array = new int[str.length][str[0].length]; //створюємо двовимірний масив
        for(int k = 0; k < array.length; k++)
        {
            for(int j = 0; j < array[k].length; j++)
            {
                array[k][j] = Integer.parseInt(str[k][j]); // записуємо в наш масив матрицю
            }
        }
        return array;
    }

    public void printArrayInt(int[][] array)  //проходимо по символьно та друкуємо масив
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

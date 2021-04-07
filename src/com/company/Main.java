package com.company;

import lab1.FileWorker;
import lab1.PrymMethod;
import lab2.*;
import lab2.tools.*;
import lab3.Grapha;
import lab3.MatrixWorker;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static class Node{
        public int num;
        public int nextIndex;
        public boolean isStartPoint;
        public Node prev;

        public Node(Node prev,int point){
            this.prev=prev;
            num=point;
            isStartPoint=false;
        }
        public Node(Node prev,int point,boolean start){
            this.prev=prev;
            num=point;
            isStartPoint=start;
        }

        public int calculateLength(Grapha grapha){
            Node current=this;
            int sum=0;

            while(current.prev!=null){
                sum+= grapha.getEdge(current.prev.num,current.num);
                current=current.prev;
            }

            return sum;
        }

        @Override
        public String toString(){
            if(prev==null)return Integer.toString(num);
            else{
                return prev.toString()+" "+Integer.toString(num);
            }
        }
    }

    public static void main(String[] args) throws IOException , CloneNotSupportedException{
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String labNumber;

        System.out.println("******************* Введіть номер лабораторної яку слід показати *******************");
        System.out.println("1 - 1 лабораторна робота \n2 - 2 лабораторна робота \n3 - 3 лабораторна робота " +
                "\n4 - 4 лабораторна робота( поки нема)");
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
                System.out.println("Input full path to file: ");
                ;
                String path = br.readLine();
                MatrixWorker matrix = new MatrixWorker();
                int [][] array = matrix.readingMatrixFromFile(path);

                Grapha grapha = Grapha.load(array);

                Stack<Node> nodes=new Stack<>();

                System.out.println("Вхідна матриця:");
                System.out.println(grapha);
                Node node = null;
                node = new Node(node,0,true);
                nodes.push(node);
                grapha.enter(node.num);
                Node shortest=null;

                node=nodes.pop();

                while(!node.isStartPoint||!(node.nextIndex>= grapha.getCount())){
                    int index=node.nextIndex++;

                    if(index>= grapha.getCount()){
                        grapha.leave(node.num);
                        node=nodes.pop();
                    }else if(grapha.hasEdge(node.num,index)&& grapha.enter(index)){
                        nodes.push(node);
                        node=new Node(node,index);
                    }

                    if(grapha.allVisited()){
                        if(shortest==null){
                            shortest=node;

                        }else{
                            if(shortest.calculateLength(grapha)>node.calculateLength(grapha)){
                                shortest=node;
                            }
                        }
                    }
                }

                String result  = shortest.toString();

                System.out.println("Результат:");
                for (String s : result.split(" ")){
                    System.out.print((char) (Integer.parseInt(s) + 65) + " ");
                }


            }
        }

    }
}
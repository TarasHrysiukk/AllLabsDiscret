package lab3;
import java.io.IOException;

public class Grapha {
    private int count;
    private int[][] matrix;
    private boolean[] marks;

    public Grapha(int count){
        this.count=count;
        matrix=new int[count][count];
        marks=new boolean[count];
    }

    public void setEdge(int a,int b,int weight){
        matrix[a][b]=weight;
    }

    public int getEdge(int a,int b){
        return matrix[a][b];
    }

    public boolean hasEdge(int a,int b){
        return matrix[a][b]!=0;
    }

    public static Grapha load(int [][] array) throws IOException {

        Grapha grapha =new Grapha(array.length);

        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[i].length; j++)
            {
                int a = i;
                int b = j;
                int weight = array[i][j];

                grapha.setEdge(a, b, weight);
            }
        }
        return grapha;
    }


    public boolean enter(int pos){
        if(marks[pos]){
            return false;
        }else{
            marks[pos]=true;
            return true;
        }
    }

    public void leave(int pos){
        marks[pos]=false;
    }

    public int getCount(){
        return count;
    }

    public boolean allVisited(){
        for(int i=0;i<marks.length;i++){
            if(!marks[i])return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j] + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}

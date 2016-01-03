import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class IllegalConstructorArguments extends Exception{
    //Dummy exception only name is important
}

public class MatrixThreadMultiplication {
    /*-------------------------------*/
    private Double a[][]; // First operand
    private Double b[][]; // Second operand
    private Double c[][]; // Result of multiplication
    private int rowSyncronizer =0;
    private int columnSyncronizer =0;
    private Object initiateLock = new Object();
    private Object setLock = new Object();
    /*-------------------------------*/
    //Initiates thread with its own matrix element with synchronization
    private int[] getRowAndColumn(){
        synchronized (initiateLock) {
            if (columnSyncronizer == b[0].length) {
                columnSyncronizer = 0;
                rowSyncronizer++;
            }
            int[] result = {rowSyncronizer, columnSyncronizer++};
            return result;
        }
    }
    //Synchronized set of result value
    private void setResultValue(int i, int j, Double result){
        synchronized (setLock){
            c[i][j] = result;
        }
    }
    /*-------------------------------*/
    //Thread class
    private class Processor implements Runnable{
        //Each thread calculates its own element
        @Override
        public void run() {
            int[] rowAndColumn = getRowAndColumn();
            int i = rowAndColumn[0];
            int j = rowAndColumn[1];
            Double temp = 0d;
            for(int k=0; k<a[0].length; k++)
                temp+=a[i][k]*b[k][j];
            setResultValue(i,j,temp);
        }
    }
    /*-------------------------------*/
    //Calculation of result
    private void calculate(){
        int resultRows = a.length;
        int innerRowsColumns = a[0].length; // which is equals to b.length
        int resultColumns = b[0].length;

        c = new Double[resultRows][resultColumns];

        for(int i=0; i<resultRows; i++)
            for(int j=0; j<resultColumns; j++)
                c[i][j]=0d;


        for(int i=0; i<resultRows; i++)
            for(int j=0; j<resultColumns; j++)
                for(int k=0; k<innerRowsColumns; k++)
                    c[i][j]+=a[i][k]*b[k][j];
    }
    /*-------------------------------*/
    //Calculation of result with threads
    private void calculateWithThreads(){
        int resultRows = a.length;
        int resultColumns = b[0].length;
        int numberOfThreads = resultRows*resultColumns;

        c = new Double[resultRows][resultColumns];

        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        for(int i=0; i< numberOfThreads; i++)
            service.submit(new Processor());
        service.shutdown();
    }
    /*-------------------------------*/
    //Main method
    public Double[][] getResult(){
        //If result calculation is lazy and happens only once
        if(c==null)
            calculate();
        return c;
    }
    /*-------------------------------*/
    //Print array
    private String printArray(Double[][] array){
        String result = "";
        for(int i=0; i<array.length; i++) {
            result+="[";
            for (int j = 0; j < array[0].length; j++)
                result +=array[i][j] + ";";
            result+="]";
        }
        return result;
    }
    /*-------------------------------*/
    //To String
    @Override
    public String toString(){
        if(c==null)
            return "a= " + printArray(a) + "; b= " + printArray(b);
        return "a= " + printArray(a) + "; b= " + printArray(b)+ "; c= " + printArray(c);
    }
    /*-------------------------------*/
    //Double arguments constructor
    public MatrixThreadMultiplication(Double[][] a, Double[][] b) throws IllegalConstructorArguments, NullPointerException{
        //If dimensions not satisfy matrix multiplication rule throw IllegalConstructorArguments exception (also throws NullPointerException if a or b is null)
        if(a[0].length!=b.length) throw new IllegalConstructorArguments();

        this.a=a;
        this.b=b;
    }
    /*-------------------------------*/
    //Float arguments constructor
    public MatrixThreadMultiplication(Float[][] a, Float[][] b) throws IllegalConstructorArguments, NullPointerException{
        //If dimensions not satisfy matrix multiplication rule throw IllegalConstructorArguments exception (also throws NullPointerException if a or b is null)
        if(a[0].length!=b.length) throw new IllegalConstructorArguments();

        this.a=new Double [a.length][a[0].length];
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++)
                this.a[i][j] =  a[i][j].doubleValue();

        this.b=new Double [b.length][b[0].length];
        for(int i=0; i<b.length; i++)
            for(int j=0; j<b[0].length; j++)
                this.b[i][j] =  b[i][j].doubleValue();
    }
    /*-------------------------------*/
    //Long arguments constructor
    public MatrixThreadMultiplication(Long[][] a, Long[][] b) throws IllegalConstructorArguments, NullPointerException{
        //If dimensions not satisfy matrix multiplication rule throw IllegalConstructorArguments exception (also throws NullPointerException if a or b is null)
        if(a[0].length!=b.length) throw new IllegalConstructorArguments();

        this.a=new Double [a.length][a[0].length];
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++)
                this.a[i][j] =  a[i][j].doubleValue();

        this.b=new Double [b.length][b[0].length];
        for(int i=0; i<b.length; i++)
            for(int j=0; j<b[0].length; j++)
                this.b[i][j] =  b[i][j].doubleValue();
    }
    /*-------------------------------*/
    //Integer arguments constructor
    public MatrixThreadMultiplication(Integer[][] a, Integer[][] b) throws IllegalConstructorArguments, NullPointerException{
        //If dimensions not satisfy matrix multiplication rule throw IllegalConstructorArguments exception (also throws NullPointerException if a or b is null)
        if(a[0].length!=b.length) throw new IllegalConstructorArguments();

        this.a=new Double [a.length][a[0].length];
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a[0].length; j++)
                this.a[i][j] =  a[i][j].doubleValue();

        this.b=new Double [b.length][b[0].length];
        for(int i=0; i<b.length; i++)
            for(int j=0; j<b[0].length; j++)
                this.b[i][j] =  b[i][j].doubleValue();
    }
    /*-------------------------------*/
}

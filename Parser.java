import java.lang.reflect.Array;

public class Parser{
    int Capacity;
    int Nsize;
    int Values[];
    int Weights[];

    public Parser(){ }

    public void setCapacity(int C){
        Capacity = C;
    }
    public int getCapacity(){
        return Capacity;
    }

    public void setNSize(int N){
        Nsize = N;
    }
    public int getNSize(){
        return Nsize;
    }

    public void setValues(int V[]){
        Values = new int[Nsize];
        for (int i=0; i< Nsize; i++){
            Values[i] = V[i];
        }
    }
    public int[] getValues(){
        return Values;
    }

    public void setWeights(int W[]){
        Weights = new int [Nsize];
        for (int i=0; i<Nsize; i++){
            Weights[i] = W[i];
        }
    }
    public int[] getWeights(){
        return Weights;
    }
}
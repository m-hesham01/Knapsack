import java.util.ArrayList;

public class GAFitness{
    Knapsack K;
    int Weights[];
    int Values[];
    ArrayList<Boolean> knapItems = new ArrayList<Boolean>();

    public GAFitness(int size, int W[], int V[]){
        Weights = new int[size];
        Values = new int[size];
        for (int i=0; i<size; i++){
            Weights[i]=W[i];
            Values[i]=V[i];
        }
      }
    
    public int fitnessEval(Knapsack K){
        knapItems = K.getItems();
        int Fitness = 0;
        for (int i=0; i < K.getNumberOfItems(); i++){
            if (knapItems.get(i) == true){
                Fitness = Fitness + Values[i];
            }
        }
        K.setFitness(Fitness);
        return Fitness;
    }

    public int weightCalc(Knapsack K){
        knapItems = K.getItems();
        int Weight = 0;
        for (int i=0; i < K.getNumberOfItems(); i++){
            if (knapItems.get(i) == true){
                Weight = Weight + Weights[i];
            }
        }
        K.setTotalWeight(Weight);
        return Weight;
    }
}
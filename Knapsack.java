import java.util.ArrayList;
import java.util.Random;

public class Knapsack{
    int Capacity;
    int numberOfItems;
    ArrayList<Boolean> Items = new ArrayList<Boolean>();
    int totalWeight;
    int fitness; //total value

    public Knapsack(){ }
    
    public void setCapacity(int capacity){
        Capacity = capacity;
    }
    public int getCapacity(){
        return Capacity;
    }

    public void setNumberOfItems(int N) {
        numberOfItems = N;
    }
    public int getNumberOfItems() {
        return numberOfItems;
    }
    
    public void setItems(){
        Random rd = new Random();
        for (int i = 0; i < numberOfItems; i++){
            Items.add(rd.nextBoolean());
        }
    }
    public ArrayList<Boolean> getItems(){
        return Items;
    }

    public void setTotalWeight(int W){
        totalWeight = W;
    }
    public int getTotalWeight(){
        return totalWeight;
    }

    public void setFitness(int F){
        fitness = F;
    }
    public int getFitness(){
        return fitness;
    }
}
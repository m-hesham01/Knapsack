import java.util.ArrayList;

public class GACrossover {
    ArrayList<Knapsack> Population = new ArrayList<Knapsack>();
    int popSize;
    int parentsIndex[];
    int crossoverStart = 41;  // 1-40 -> no crossover, 41-100 -> crossover occurs
    ArrayList<Knapsack> Parents = new ArrayList<Knapsack>();
    ArrayList<Knapsack> Children = new ArrayList<Knapsack>(); //stores the child knapsacks produced by applying crossover

    public GACrossover(ArrayList<Knapsack> P, int Psize, int[] PIndex){
        parentsIndex = new int [PIndex.length];
        Population = P;
        popSize = Psize;
    }

    public ArrayList<Knapsack> crossover(){
        for (int i=0; i<parentsIndex.length; i++){
            Knapsack k = Population.get(parentsIndex[i]);
            Parents.add(k); //got 2 parents that got chosen from selection phase
        }

        
        return Children;
    }
    
}

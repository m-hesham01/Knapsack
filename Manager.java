import java.util.ArrayList;

public class Manager{
    int Capacity;
    int Nsize;
    int Values[];
    int Weights[];
    int popSize = 6;
    int popFitness[] = new int[popSize];
    int popWeight[] = new int[popSize];
    int parentsIndex[] = new int[popSize];

    ArrayList<Knapsack> Population = new ArrayList<Knapsack>();

    public Manager(){ }

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

    public void createKnapSacks(){
        for (int i=0; i < popSize; i++){   //create instances of knapsacks and put their fitness values in an array
            Knapsack K = new Knapsack();
            K.setCapacity(Capacity);
            K.setNumberOfItems(Nsize);
            K.setItems();
            Population.add(K);
        }
    }

    public ArrayList<Knapsack> getPopulation(){
        return Population;
    }

    public void calculateFitness(){
        GAFitness gf = new GAFitness(Nsize, Weights, Values);
        for (int i=0; i<popSize; i++){
            int w = gf.weightCalc(Population.get(i));
           if(w>Capacity){          //if the total weight of a given knapsack exceeds the max capacity, its fitness will be set to 0 since it is an infeasible result
                popFitness[i] = 0;
            }
            else{
                popFitness[i] = gf.fitnessEval(Population.get(i));
            }
        }
    }

    public void selectParents(){
        int j = 0;
        for(int i=0; i<(popSize/2); i++){
            GASelect gs = new GASelect(popSize, popFitness);
            int twoParents[] = new int[2];
            twoParents = gs.select();
            for (int k = 0; k<2; k++){
                parentsIndex[j] = twoParents[k];
                j++;
            }
        }
    }
    public int[] getParents(){
        return parentsIndex;
    }

    public void startCrossover(){
        GACrossover gc = new GACrossover(Population, popSize, parentsIndex, Capacity, Nsize);
        Population = gc.crossover();
    }

    public void performMutation(){
        for (int i=0; i<popSize; i++){
            GAMutation gm = new GAMutation(Population.get(i));
            gm.mutate();
        }
    }
}
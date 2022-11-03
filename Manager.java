import java.util.ArrayList;

public class Manager{
    int genSize = 3;        //number of generations
    int popSize = 6;        //population size
    int Capacity;           //knapsack max capacity
    int Nsize;              //number of items to choose from
    int testCaseIndex;
    int Values[];
    int Weights[];
    int popFitness[] = new int[popSize];
    int popWeight[] = new int[popSize];
    int parentsIndex[] = new int[popSize];
    ArrayList<Knapsack> Population = new ArrayList<Knapsack>();
    Knapsack Winner = new Knapsack();

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

    public void setTestCaseIndex(int TCI) {
    testCaseIndex = TCI;
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
                Population.get(i).setFitness(0);
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
    
    public void produceOutput(){
        calculateFitness();
        int max = 0;
        for (int i=0; i<popSize; i++){
            if(Population.get(i).getFitness()>max){
                max = Population.get(i).getFitness();
                Winner = Population.get(i);
            }
        }
        int NSelected = 0;
        for (int i=0; i<Winner.getNumberOfItems();i++){
            if(Winner.getItems().get(i) == true){
                NSelected++;
            }       
        }
        int winnerValues[] = new int[NSelected];
        int winnerWeights[]= new int[NSelected];
        int j = 0;
        for (int i=0; i<Winner.getNumberOfItems(); i++){
            if(Winner.getItems().get(i)==true){
                winnerValues[j]=Values[i];
                winnerWeights[j]=Weights[i];
                j++;
            }
        }
        System.out.println("----- TEST CASE INDEX: "+ testCaseIndex + " -----");
        System.out.println("-> number of selected items: "+ NSelected);
        System.out.println();
        for (int i=0; i<NSelected; i++){
            System.out.println("* weight of Item "+ (i+1) + ":    "+ winnerWeights[i]+" *");
            System.out.println("* value  of Item "+ (i+1)+ ":    " + winnerValues[i]+" *");
        }
        System.out.println();
        System.out.println("----- total weight: "+ Winner.getTotalWeight()+" ----");
        System.out.println("---- total fitness: "+ Winner.getFitness()+" ----");

        System.out.println("----------------------------------------------------------");
    }
    public void createGenerations(){
        createKnapSacks();
        for(int i=0; i<genSize; i++){
        calculateFitness();
        selectParents();
        startCrossover();
        performMutation();
        }
        produceOutput();
    }
}
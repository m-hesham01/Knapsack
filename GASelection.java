import java.lang.Math;
import java.util.Arrays;
public class GASelection{
    int popSize;
    int Fitness[];
    int Ranks[];
    int cumulativeFitness[];
    int parentsIndex[] = new int[2];
    //int crossoverStart = 41;
    //int mutationStart = 100;

    public GASelection(int Psize, int F[]){
        popSize = Psize;
        Fitness = new int[popSize];
        for (int i=0; i<popSize; i++){
            Fitness[i] = F[i];
        }
    }
    
    public int[] select(){
        Ranks = new int[popSize];
        int rankValue = popSize;
        int sortedFitness[] = Fitness.clone();
        Arrays.sort(sortedFitness);
        for (int i=popSize-1; i>=0; i--){
            for (int j=0; i<popSize; i++){
                if (sortedFitness[i]==Fitness[j]){
                    if (i!=(popSize-1)){
                        if((sortedFitness[i]!=sortedFitness[i+1])){  //checks for knapsacks with similar fitness values to set the same ranking for the both of them
                            rankValue--;
                        } 
                    }
                    Ranks[j]=rankValue;
                    Fitness[j]=-1;                                  //to make sure that if a fitness value exists twice, the 2nd instance doesnt get ignored
                }
            }
        }
        int CF = 0;
        cumulativeFitness = new int[popSize];
        for (int i=0; i< popSize; i++){                              //calculate cumulative fitness
            CF = CF + Ranks[i];
            cumulativeFitness[i] = CF;
        }
        int min = 1;
        int max = cumulativeFitness[popSize-1];
        int random1 = (int)Math.floor(Math.random()*(max-min+1)+min); //generate random number
        for (int i=0; i<popSize; i++){
            if(random1<=cumulativeFitness[i]){
                parentsIndex[0] = i;                                  //stores index of first parent
            }
        }
        
        int ili = 3;
        while (ili>2){                                                   //to make sure doesnt exit until exit condition is met (a second unique parent)
            int random2 = (int)Math.floor(Math.random()*(max-min+1)+min); //generate second random number
            for (int i=0; i<popSize; i++){
                if(random2<=cumulativeFitness[i]){
                    if(i!=parentsIndex[0]){                             //parent cant crossover with itself so this makes sure that it picks a different parent from the population
                        parentsIndex[1]=i;
                        ili=1;
                    }
                }
            }   
        }
        System.out.println("p1: "+ parentsIndex[0]);
        parentsIndex[1]= 9;
        System.out.println("p2: "+ parentsIndex[1]);
        return parentsIndex;
    }
}
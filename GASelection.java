import java.lang.Math;
import java.util.Arrays;
public class GASelection{
    int popSize;
    int Fitness[];
    int Ranks[];
    int cumulativeFitness[];
    //int crossoverStart = 41;
    //int mutationStart = 100;

    public GASelection(int Psize, int F[]){
        popSize = Psize;
        Fitness = new int[popSize];
        for (int i=0; i<popSize; i++){
            Fitness[i] = F[i];
        }
    }
    
    public void select(){
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
                    Fitness[j]=-1;
                }
            }
        }
        
        
        int CF = 0;
        cumulativeFitness = new int[popSize];
        for (int i=0; i< popSize; i++){     //calculate cumulative fitness
            CF = CF + Fitness[i];
            cumulativeFitness[i] = CF;
        }
        int min = 1;
        int max = cumulativeFitness[popSize-1];
        int rouletteResult = (int)Math.floor(Math.random()*(max-min+1)+min);
        
    }
}
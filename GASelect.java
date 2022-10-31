import java.util.Arrays;
import java.util.Random;

public class GASelect{
    int popSize;
    int Fitness[];
    int Ranks[];
    int cumulativeFitness[];
    int parentsIndex[] = new int[2];

    public GASelect(int Psize, int F[]){
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
        for(int i = (popSize-1); i>=0; i--){
            for(int j=0; j<popSize; j++){
                if (sortedFitness[i]==Fitness[j]){
                    Ranks[j]=rankValue;
                    Fitness[j]=-1;
                }
            }
            rankValue--;
        }

        int CF = 0;
        cumulativeFitness = new int[popSize];
        for (int i=0; i< popSize; i++){                              //calculate cumulative fitness
            CF = CF + Ranks[i];
            cumulativeFitness[i] = CF;
        }
        int min = 1;
        int max = cumulativeFitness[popSize-1]+1;
        Random random = new Random(); //generate random number
        int random1 = random.nextInt(max - min)+min;
        for (int i=0; i<popSize; i++){
            if(random1<=cumulativeFitness[i]){
                parentsIndex[0] = i;
                break;                                 //stores index of first parent
            }
        }
        
        for(int i=0; i<1; i++){
            int random2 = random.nextInt(max-min)+min;
            for (int j=0; j<popSize; j++){
                if(random2<=cumulativeFitness[j]){
                    if(j==parentsIndex[0]){
                        i--;
                        continue;
                    }
                    else{
                        parentsIndex[1]=j;
                        break;
                    }
                }
            }
        }
        
        return parentsIndex;
    }
}
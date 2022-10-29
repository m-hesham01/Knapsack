import java.lang.Math;
public class GASelection{
    int popSize;
    int Fitness[];
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
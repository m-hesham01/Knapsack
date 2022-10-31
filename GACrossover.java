import java.util.ArrayList;
import java.util.Random;

public class GACrossover {
    int crossoverStart = 40;  // 1-40 -> no crossover, 41-100 -> crossover occurs
    int crossoverPoint = 2; // crossover occurs after 2 bits
    int Capacity;
    int Nsize;
    ArrayList<Knapsack> Population = new ArrayList<Knapsack>();
    int popSize;
    int parentsIndex[];
    ArrayList<Knapsack> Parents = new ArrayList<Knapsack>();
    ArrayList<Knapsack> Children = new ArrayList<Knapsack>(); //stores the child knapsacks produced by applying crossover

    public GACrossover(ArrayList<Knapsack> P, int Psize, int[] PIndex, int C, int S){
        parentsIndex = new int [PIndex.length];
        for (int i=0; i<parentsIndex.length; i++){
            parentsIndex[i] = PIndex[i];
        }
        Population = P;
        popSize = Psize;
        Capacity = C;
        Nsize = S;
    }

    public ArrayList<Knapsack> crossover(){
        System.out.println("Parents Index:");
        for (int i=0; i<parentsIndex.length; i++){
            System.out.println(parentsIndex[i]);
        }

        System.out.println("Population:");
        for (int i=0; i<parentsIndex.length; i++){
            System.out.println(i);
            for (int j=0; j<Nsize; j++){
                System.out.println(Population.get(i).getItems().get(j));
            }
        }

        System.out.println("Parents:");
        for (int i=0; i<parentsIndex.length; i++){
            Knapsack k = Population.get(parentsIndex[i]);
            Parents.add(k); //got 2 parents that got chosen from selection phase
            System.out.println(i);
            for (int j=0; j<Nsize; j++){
                System.out.println(Parents.get(i).getItems().get(j));
            }
        }

        int j = 0;
        for(int i=0; i<(popSize/2); i++){
            Knapsack p1 = Parents.get(j);
            j++;
            Knapsack p2 = Parents.get(j);
            j++;

            int min = 1;
            int max = 101;
            Random random = new Random(); //generate random number
            int crossoverChance = random.nextInt(max - min)+min;

            if(crossoverChance > crossoverStart){
                System.out.println(crossoverChance + " crossover occurs");
                Knapsack c1 = new Knapsack();
                c1.setCapacity(Capacity);
                c1.setNumberOfItems(Nsize);
                Knapsack c2 = new Knapsack();
                c2.setCapacity(Capacity);
                c2.setNumberOfItems(Nsize);
                for (int x=0; x<crossoverPoint; x++){
                    c1.getItems().add(p1.getItems().get(x));
                    c2.getItems().add(p2.getItems().get(x));
                }
                for (int x=crossoverPoint; x<Nsize; x++){
                    c1.getItems().add(p2.getItems().get(x));
                    c2.getItems().add(p1.getItems().get(x));
                }
                Children.add(c1);
                Children.add(c2);
            }
            else{
                System.out.println(crossoverChance + " NO Crossover");
                Children.add(p1);
                Children.add(p2);
            }
        }        
        return Children;
    }
    
}

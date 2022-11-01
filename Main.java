import java.util.ArrayList;

public class Main{
    public static void main(String args[]){
        int C = 10;
        int N = 5;
        int V[] = {4, 4, 1, 7, 6};
        int W[] = {5, 4, 2, 2, 4};
        Manager m = new Manager();
        m.setCapacity(C);
        m.setNSize(N);
        m.setValues(V);
        m.setWeights(W);
        m.createKnapSacks();
        m.calculateFitness();
        m.selectParents();
        m.startCrossover();
        ArrayList<Knapsack> test =  m.getPopulation();
        for (int i=0; i<6; i++){
            System.out.println("child number " + (i+1));
            for (int j=0; j<N; j++){
                System.out.println(test.get(i).getItems().get(j));
            }
        }
        m.performMutation();
    }
}
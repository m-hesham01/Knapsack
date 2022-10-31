import java.util.ArrayList;

public class Main{
    public static void main(String args[]){
        int C = 10;
        int N = 5;
        int V[] = {4, 4, 1, 7, 6};
        int W[] = {5, 4, 2, 2, 4};
        System.out.println("test1");
        Manager m = new Manager();
        m.setCapacity(C);
        m.setNSize(N);
        m.setValues(V);
        m.setWeights(W);
        m.createKnapSacks();
        m.calculateFitness();
        ArrayList<Knapsack> popCopy = new ArrayList<Knapsack>();
        popCopy = m.getPopulation();
        for (int i=0; i < 6; i++){
            Knapsack x = new Knapsack();
            x = popCopy.get(i);
            ArrayList<Boolean> KnapItems = new ArrayList<Boolean>();
            KnapItems= x.getItems();
            //for (int j=0; j<N; j++){
                //System.out.println(KnapItems.get(j));
            //}
            System.out.println("fitness: "+ (x.getFitness()));
        }
        m.selectTwoParents();
        System.out.println("test2");
        int parentsIndex[] = new int[2];
        parentsIndex = m.getParentsIndex();
        System.out.println("parent 1: "+ parentsIndex[0]+ " ,parent 2: "+ parentsIndex[1]);
        System.out.println("test3");

    }
}
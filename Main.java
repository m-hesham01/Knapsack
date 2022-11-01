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
        m.performMutation();
        m.produceOutput();
        //m.createGenerations();
    }
}
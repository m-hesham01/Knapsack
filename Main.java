public class Main{
    public static void main(String args[]){
        int TC = 0;
        int C = 14;
        int N = 5;
        int V[] = {1, 7, 22, 23, 6};
        int W[] = {4, 7, 1, 3, 3};
        Manager m = new Manager();
        m.setTestCaseIndex(TC);
        m.setCapacity(C);
        m.setNSize(N);
        m.setValues(V);
        m.setWeights(W);
        m.createGenerations();

        int TC1 = 1;
        int C1 = 28;
        int N1 = 5;
        int V1[] = {27, 27, 12, 28, 23};
        int W1[] = {10, 9, 8, 8, 3};
        Manager m1 = new Manager();
        m1.setTestCaseIndex(TC1);
        m1.setCapacity(C1);
        m1.setNSize(N1);
        m1.setValues(V1);
        m1.setWeights(W1);
        m1.createGenerations();

        int TC2 = 2;
        int C2 = 25;
        int N2 = 5;
        int V2[] = {35, 12, 32, 34, 29};
        int W2[] = {4, 11, 7, 4, 8};
        Manager m2 = new Manager();
        m2.setTestCaseIndex(TC2);
        m2.setCapacity(C2);
        m2.setNSize(N2);
        m2.setValues(V2);
        m2.setWeights(W2);
        m2.createGenerations();
    }
}
import java.util.Random;

public class GAMutation{
    Knapsack Child;
    int mutationChance = 1;

    public GAMutation(Knapsack k){
        Child = k;
    }
    public Knapsack mutate(){
        int min = 1;
        int max = 101;
        Random random = new Random(); //generate random number
        int mutChance = random.nextInt(max - min)+min;
        if (mutChance == 1){


            System.out.println("MUTATED");
            System.out.println("was: ");
            for (int i = 0; i<Child.getNumberOfItems();i++){
                System.out.println(Child.getItems().get(i));
            }


            int minPos = 1;
            int maxPos = Child.getNumberOfItems();
            int mutPosition = random.nextInt(maxPos - minPos)+minPos;
            System.out.println("mutPosition: "+ mutPosition);

            for (int i=0;i<Child.getNumberOfItems();i++){
                if (mutPosition == i){
                    if(Child.getItems().get(i) == true){
                        Child.getItems().set(i, false);
                    }
                    else {Child.getItems().set(i, true);}
                }
            }
            System.out.println("became: ");
            for (int i = 0; i<Child.getNumberOfItems();i++){
                System.out.println(Child.getItems().get(i));
            }
        }

        return Child;
    }
}
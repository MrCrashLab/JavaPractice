package Practic_2;

public class DogKennel {
    private Dog[] kennel;
    private int count = 0;

    public DogKennel(int number){
        kennel = new Dog[number];
    }

    public void addDog(String name, int dog_age){
        kennel[count] = new Dog(name, dog_age);
        count++;
    }

    public void removeLastDog(int num_dog){
        kennel[count] = null;
        count--;
    }

    public Dog[] getKennel() {return kennel;}
    public void setKennel(Dog[] kennel) {this.kennel = kennel;}

    public int getCount() {return count;}

    @Override
    public String toString() {
        String tmp;
        tmp = "Количество собак в питомнике " + count;
        for (int i = 0; i<count; i++){
            tmp += "\n" + kennel[i].toString() ;
        }
        return tmp;
    }
}
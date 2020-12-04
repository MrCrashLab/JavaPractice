package Practic_02;

public class Dog {
    String name = "default";
    int dog_age = -1;
    int people_age = -1;

    public Dog(String name, int dog_age){
        this.dog_age = dog_age;
        this.people_age = dog_age * 7;
        this.name = name;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setDog_age(int dog_age){
        this.dog_age = dog_age;
        people_age = 7 * dog_age;
    }
    public int getDog_age(){return dog_age;}

    public int getPeople_age() {return people_age;}

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dog_age=" + dog_age +
                ", people_age=" + people_age +
                '}';
    }
}
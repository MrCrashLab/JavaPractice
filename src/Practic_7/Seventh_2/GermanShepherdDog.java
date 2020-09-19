package Practic_7.Seventh_2;

public class GermanShepherdDog extends Dog {

    public GermanShepherdDog(String name, int dog_age, String gender){
        super(name, dog_age, gender);
    }

    @Override
    public String toString() {
        return "Я немецкая овчарка\nМеня зовут " + getName() +
                "\nЯ " + getGender() +
                "\nМне " + getDog_age() +
                ", a на человеческие года мне "+ getPeople_age() +
                "\nИ я " + (getDesireToWalk()?"":"не ") + "хочу гулять";
    }

    @Override
    public void walkToDog() {
        System.out.println("Я погулял и теперь хочу домой!");
        setDesireToWalk(false);
    }

    @Override
    public void wantToWalk() {
        System.out.println("Я хочу гулять!");
        setDesireToWalk(true);
    }
}


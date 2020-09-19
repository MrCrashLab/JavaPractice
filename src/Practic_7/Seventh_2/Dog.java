package Practic_7.Seventh_2;

public abstract class Dog {
    private String name = "default";
    private int dog_age = -1;
    private int people_age = -1;
    private String gender = "default";
    private boolean DesireToWalk = true;

    public Dog(String name, int dog_age, String gender){
        this.name = name;
        this.dog_age = dog_age;
        this.gender = gender;
        setPeopleAge();
    }

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setDog_age(int dog_age) {this.dog_age = dog_age;}
    public int getDog_age() {return dog_age;}

    public void setGender(String gender) {this.gender = gender;}
    public String getGender() {return gender;}

    public void setPeopleAge(){this.people_age = dog_age * 7;}
    public int getPeople_age() {return people_age;}

    public void setDesireToWalk(boolean desireToWalk) {DesireToWalk = desireToWalk;}
    public boolean getDesireToWalk(){return DesireToWalk;}

    public abstract void walkToDog();
    public abstract void wantToWalk();

}

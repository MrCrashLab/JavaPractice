package Practic_13;

public class Animal {
    private String name;
    private int age;
    private int idAnimal;

    public Animal(String name, int age, int idAnimal) {
        this.name = name;
        this.age = age;
        this.idAnimal = idAnimal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addAge(int age) throws AnimalException, BigAnimalAgeException {
        if (age < 0)
            throw new AnimalException();
        else if(age>100)
            throw new BigAnimalAgeException();
        this.age += age;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) throws Exception {
        if(idAnimal<0)
            throw new Exception();
        this.idAnimal = idAnimal;
    }
}

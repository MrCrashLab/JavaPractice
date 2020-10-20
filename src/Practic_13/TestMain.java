package Practic_13;

public class TestMain {
    public static void main(String[] args){
        Animal giraffe = new Animal("Giraffe", 0, 0);
        try {
            giraffe.addAge(10);
            giraffe.setIdAnimal(123);

            giraffe.addAge(50);
            giraffe.setIdAnimal(12);
        } catch (AnimalException aex) {
            System.out.println("\u001B[31m" + "Animal age must be more 0" + "\u001B[0m");
        } catch (BigAnimalAgeException baae) {
            System.out.println("\u001B[31m" + "Animal age must be less 100" + "\u001B[0m");
        } catch (Exception ex) {
            System.out.println("\u001B[31m" + "Incorrect ID animal" + "\u001B[0m");
        } finally {
            System.out.println(giraffe.getName() + " age: " + giraffe.getAge());
            System.out.println("ID " + giraffe.getName() + " " + giraffe.getIdAnimal());
        }
        throw new BigAnimalAgeException();
    }
}

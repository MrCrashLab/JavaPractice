package Practic_21_22;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        User user = new User();
        ItemsStore localStore = new LocalJsonItemsStore();
        ItemsStore hhtpStore = new HttpJsonItemsStore();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        int change = 0;
        while (change != 3) {
            System.out.print(user.printChangeJson().toString());
            change = scanner.nextInt();
            switch (change) {
                case 1:
                        while (change != 6) {
                            System.out.print(user.printChangeLocalJson().toString());
                            change = scanner.nextInt();
                            switch (change) {
                                case 1:
                                    System.out.print(user.printGetAllItem());
                                    System.out.println("\u001B[36m" + localStore.getAllItem());
                                    break;
                                case 2:
                                    System.out.print(user.printGetItem());
                                    change = scanner.nextInt();
                                    System.out.println("\u001B[36m" +
                                            (localStore.getItem(change) != null
                                                    ? localStore.getItem(change)
                                                    : user.printGetError().toString()));
                                    break;
                                case 3:
                                    System.out.println(user.printAddItem());
                                    scanner.nextLine();
                                    line = scanner.nextLine();
                                    System.out.println("\u001B[36m" +
                                            (localStore.addItem(new Item(Integer.parseInt(line.split(" ")[0]),
                                                    line.split(" ")[1],
                                                    Boolean.parseBoolean(line.split(" ")[2]),
                                                    line.split(" ")[3]))
                                                    ? user.printAddSuccessful().toString()
                                                    : user.printAddError().toString()));
                                    break;
                                case 4:
                                    System.out.println(user.printEditItem());
                                    scanner.nextLine();
                                    line = scanner.nextLine();
                                    System.out.println("\u001B[36m" +
                                            (localStore.editItem(
                                                    Integer.parseInt(line.split(" ")[0]),
                                                    new Item(Integer.parseInt(line.split(" ")[1]),
                                                            line.split(" ")[2],
                                                            Boolean.parseBoolean(line.split(" ")[3]),
                                                            line.split(" ")[4]))
                                                    ? user.printEditSuccessful().toString()
                                                    : user.printEditError().toString()));
                                    break;
                                case 5:
                                    System.out.println(user.printDeleteItem());
                                    change = scanner.nextInt();
                                    System.out.println("\u001B[36m" +
                                            (localStore.deleteItem(change)
                                                    ? user.printDeleteSuccessful().toString()
                                                    : user.printDeleteError().toString()));
                                    break;
                                case 6:
                                    System.out.println(user.printExit().toString());
                                    break;
                                default:
                                    System.out.println(user.printError().toString());
                                    break;
                            }
                        }
                    change = 0;
                    break;
                case 2:
                    while (change != 6) {
                        System.out.print(user.printChangeHttpJson().toString());
                        change = scanner.nextInt();
                        switch (change) {
                            case 1:
                                System.out.print(user.printGetAllItem());
                                System.out.println("\u001B[36m" + hhtpStore.getAllItem());
                                break;
                            case 2:
                                System.out.print(user.printGetItem());
                                change = scanner.nextInt();
                                System.out.println("\u001B[36m" +
                                        (localStore.getItem(change) != null
                                                ? hhtpStore.getItem(change)
                                                : user.printGetError().toString()));
                                break;
                            case 3:
                                System.out.println(user.printAddItem());
                                scanner.nextLine();
                                line = scanner.nextLine();
                                System.out.println("\u001B[36m" +
                                        (hhtpStore.addItem(new Item(Integer.parseInt(line.split(" ")[0]),
                                                line.split(" ")[1],
                                                Boolean.parseBoolean(line.split(" ")[2]),
                                                line.split(" ")[3]))
                                                ? user.printAddSuccessful().toString()
                                                : user.printAddError().toString()));
                                break;
                            case 4:
                                System.out.println(user.printEditItem());
                                scanner.nextLine();
                                line = scanner.nextLine();
                                System.out.println("\u001B[36m" +
                                        (hhtpStore.editItem(
                                                Integer.parseInt(line.split(" ")[0]),
                                                new Item(Integer.parseInt(line.split(" ")[1]),
                                                        line.split(" ")[2],
                                                        Boolean.parseBoolean(line.split(" ")[3]),
                                                        line.split(" ")[4]))
                                                ? user.printEditSuccessful().toString()
                                                : user.printEditError().toString()));
                                break;
                            case 5:
                                System.out.println(user.printDeleteItem());
                                change = scanner.nextInt();
                                System.out.println("\u001B[36m" +
                                        (hhtpStore.deleteItem(change)
                                                ? user.printDeleteSuccessful().toString()
                                                : user.printDeleteError().toString()));
                                break;
                            case 6:
                                System.out.println(user.printExit().toString());
                                break;
                            default:
                                System.out.println(user.printError().toString());
                                break;
                        }
                    }
                    change = 0;
                    break;
                case 3:
                    System.out.println(user.printExit().toString());
                    break;
                default:
                    System.out.println(user.printError().toString());
                    break;
            }
        }
    }
}

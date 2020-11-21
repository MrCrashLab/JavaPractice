package Practic_21_22;

public class User {
    public StringBuilder printChangeJson(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m////////// \u001B[35mОбработка JSON\u001B[32m //////////\n");
        sb.append             ("///////////// \u001B[35mВыберите \u001B[32m/////////////\n");
        sb.append             ("\u001B[36m1.Изменить локальный файл          \u001B[32m/\n");
        sb.append             ("\u001B[36m2.Изменить данные на сервере       \u001B[32m/\n");
        sb.append             ("\u001B[36m3.Выйти                            \u001B[32m/\n");
        sb.append                                 ("////////////////////////////////////\n");
        sb.append   ("\u001B[91mВыберите действие: ");
        return sb;
    }

    public StringBuilder printChangeLocalJson(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m////\u001B[35m Обработка локального .json \u001B[32m////\n");
        sb.append             ("///////////// \u001B[35mВыберите \u001B[32m/////////////\n");
        sb.append(printUserChange());
        return sb;
    }

    public StringBuilder printChangeHttpJson(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m////\u001B[35m Обработка .json на сервере \u001B[32m////\n");
        sb.append             ("///////////// \u001B[35mВыберите \u001B[32m/////////////\n");
        sb.append(printUserChange());
        return sb;
    }

    private StringBuilder printUserChange(){
        StringBuilder sb = new StringBuilder();
        sb.append             ("\u001B[36m1.Получить список всех объектов    \u001B[32m/\n");
        sb.append             ("\u001B[36m2.Получить объект                  \u001B[32m/\n");
        sb.append             ("\u001B[36m3.Добавить объект                  \u001B[32m/\n");
        sb.append             ("\u001B[36m4.Изменить объект                  \u001B[32m/\n");
        sb.append             ("\u001B[36m5.Удалить объект                   \u001B[32m/\n");
        sb.append             ("\u001B[36m6.Выйти                            \u001B[32m/\n");
        sb.append                                 ("////////////////////////////////////\n");
        sb.append   ("\u001B[91mВыберите действие: ");
        return sb;
    }

    public StringBuilder printGetAllItem(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m///////\u001B[35m Список всех объектов \u001B[32m///////\n");
        return sb;
    }

    public StringBuilder printGetItem(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m//////////////\u001B[35m Объект \u001B[32m//////////////\n");
        sb.append   ("\u001B[91mВведите id: ");
        return sb;
    }

    public StringBuilder printAddItem(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m////////\u001B[35m Добавление объекта \u001B[32m////////\n");
        sb.append   ("\u001B[91mВведите данные объекта: ");
        return sb;
    }

    public StringBuilder printEditItem(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m////////\u001B[35m Изменение объекта \u001B[32m/////////\n");
        sb.append   ("\u001B[91mВведите id объекта и измененный объект: ");
        return sb;
    }

    public StringBuilder printDeleteItem(){
        StringBuilder sb = new StringBuilder();
        sb.append   ("\u001B[32m/////////\u001B[35m Удаление объекта \u001B[32m/////////\n");
        sb.append   ("\u001B[91mВведите id объекта, который хотите удалить: ");
        return sb;
    }

    public StringBuilder printError(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mНЕВЕРНОЕ ДЕЙСТВИЕ!!!\u001B[0m");
        return sb;
    }

    public StringBuilder printGetError(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mОбъекта с таким id не найдено!");
        return sb;
    }

    public StringBuilder printAddError(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mОбъект не добавлен!");
        return sb;
    }

    public StringBuilder printEditError(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mОбъект не был изменен!");
        return sb;
    }

    public StringBuilder printDeleteError(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mОбъект не был удален!");
        return sb;
    }

    public StringBuilder printExit(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[31mВы вышли!\u001B[0m");
        return sb;
    }

    public StringBuilder printAddSuccessful(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[92mОбъект успешно добавлен!");
        return sb;
    }

    public StringBuilder printEditSuccessful(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[92mОбъект был успешно изменен!");
        return sb;
    }
    public StringBuilder printDeleteSuccessful(){
        StringBuilder sb = new StringBuilder();
        sb.append("\u001B[92mОбъект был успешно удален!");
        return sb;
    }

}

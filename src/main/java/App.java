import developers.DeveloperService;
import storage.DataBaseInitService;
import storage.Storage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

//DBMS - H2 (https://www.h2database.com/html/main.html)

public class App {

    public static void main(String[] args) throws SQLException, IOException {

        Storage storage = Storage.getInstance();
        new DataBaseInitService().initDb(storage);

        DeveloperService developerService = new DeveloperService(storage);

        //developerService.createNewDeveloper("John", "Boorish", 55, "male");
        //developerService.selectDevelopersByLanguage("Java");
        //developerService.selectDevelopersByLevel("Middle");
        //developerService.selectDevelopersByProject("Chew deliciously");
        //developerService.removeTheDeveloper("Boorish");
        developerService.printAllDevelopers();


//      Витягти дані
//        String selectSql = "SELECT name, birthday FROM test_table ";//зробив команду
//        Statement statement = storage.getConnection().createStatement();//згодував Statement
//        ResultSet result = statement.executeQuery(selectSql);//зберіг результат
//        if (result.next()) {
//            String name = result.getString("name");
//            LocalDate birthday = LocalDate.parse(result.getString("birthday"));
//            System.out.println(name + "\n" + birthday);
//        } else {
//            System.out.println("Нема такого в базі!!!");
//        }
//        result.close();
//        statement.close();//вивів і закрив все

//        String url = "jdbc:h2:./test";
//        System.out.println(url);
//        Connection connection = DriverManager.getConnection(url,"sa","");
//        Statement statement = connection.createStatement();
        //statement.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");
        // statement.executeUpdate("DROP TABLE test_table");

    }
}

/*
Необходимо создать консольное приложение на основе БД из домашнего задания 3, которое:
соединяется с БД✅
позволяет выполнять CRUD (CREATE✅, READ, UPDATE✅, DELETE✅) операции;

вывести на консоль:
зарплату(сумму) всех разработчиков отдельного проекта;
список разработчиков отдельного проекта;✅
список всех Java разработчиков;✅
список всех middle разработчиков;✅
список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.

создать заготовки операций(закомментированные query) для создания новых проектов, разработчиков✅, клиентов.
! Не забывать о правильных связях между таблиц !

додати до вашого репозиторію також .sql файли з яких я зможу створити та заповнити базу данних.✅
в коментарях напищіть яку СУБД використовували✅
 */
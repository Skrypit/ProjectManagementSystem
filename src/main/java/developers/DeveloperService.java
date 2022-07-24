package developers;

import storage.Storage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperService {
    private Storage storage;


    public DeveloperService(Storage storage) {
        this.storage = storage;
    }

    public void printAllDevelopers() throws SQLException {
        try (Statement statement = storage.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT first_name, last_name FROM developers")) {
                while (rs.next()) {
                    String developerFirstName = rs.getString("first_name");
                    String developerLastName = rs.getString("last_name");
                    System.out.println(developerFirstName + " " + developerLastName);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void createNewDeveloper(String first_name, String last_name, int age, String sex) {
        String newDeveloperInfo = String.format(
                "INSERT INTO developers (first_name, last_name, age,sex) VALUES ('%s', '%s', '%s', '%s')",
                first_name, last_name, age, sex);
        storage.executeUpdate(newDeveloperInfo);
    }

    public void removeTheDeveloper(String last_name) {
        String developerInfo = String.format(
                "DELETE FROM developers WHERE last_name = '%s' ",
               last_name);
        storage.executeUpdate(developerInfo);
    }

    public void selectDevelopersByLanguage(String language) throws SQLException {
        try (Statement statement = storage.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT first_name, last_name " +
                    "FROM developers " +
                    "JOIN developer_skills ON developers.developer_id = developer_skills.developer_id " +
                    "JOIN skills ON skills.skill_id = developer_skills.skill_id " +
                    //"\nWHERE skills.language = 'Java'")) {
                    "WHERE skills.language = '" + language + "'")) {
                while (rs.next()) {
                    String developerFirstName = rs.getString("first_name");
                    String developerLastName = rs.getString("last_name");
                    System.out.println(developerFirstName + " " + developerLastName);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void selectDevelopersByLevel(String level) throws SQLException {
        try (Statement statement = storage.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT first_name, last_name " +
                    "FROM developers " +
                    "JOIN developer_skills ON developers.developer_id = developer_skills.developer_id " +
                    "JOIN skills ON skills.skill_id = developer_skills.skill_id " +
                    //"\nWHERE skills.level = 'Middle'")) {
                    "WHERE skills.level = '" + level + "'")) {
                while (rs.next()) {
                    String developerFirstName = rs.getString("first_name");
                    String developerLastName = rs.getString("last_name");
                    System.out.println(developerFirstName + " " + developerLastName);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void selectDevelopersByProject(String projectName) throws SQLException {
        try (Statement statement = storage.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery("SELECT first_name, last_name " +
                            "FROM developers " +
                            "JOIN developers_projects ON developers.developer_id = developers_projects.developer_id " +
                            "JOIN projects ON projects.project_id = developers_projects.project_id " +
                    "WHERE projects.project_name= '" + projectName + "'")) {
                while (rs.next()) {
                    String developerFirstName = rs.getString("first_name");
                    String developerLastName = rs.getString("last_name");
                    System.out.println(developerFirstName + " " + developerLastName);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



}
//Todo переробити на PrepareStatements - ін'єкції
//TODO видалити розробника✅
//TODO список разработчиков отдельного проекта;✅
//TODO список всех Java разработчиков;✅
//TODO список всех middle разработчиков;✅
//TODO создать заготовки операций(закомментированные query) для создания новых  разработчиков✅

//TODO можливо точно скоригувати операції вибору по ТЗ. але це хардкод


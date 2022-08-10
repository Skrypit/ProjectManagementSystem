//package service.developers;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import storage.DatabaseInitService;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//class DeveloperDaoServiceTest {
//
//    private DeveloperDaoService service;
//    private Connection connection;
//
//    @BeforeEach
//    public void beforeEach() throws SQLException {
//        final String connectionUrl = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
//        new DatabaseInitService().initDb(connectionUrl);
//        connection = DriverManager.getConnection(connectionUrl, "sa", "");
//        service = new DeveloperDaoService(connection);
//    }
//
//    @AfterEach
//    public void afterEach() throws SQLException {
//        connection.close();
//    }
//
//
//    //Can create valid developer
//    @Test
//    public void testThatDeveloperCreatedCorrectly() throws SQLException {
//        Developer original = new Developer();
//        original.setFirstName("TestFirstName");
//        original.setLastName("TestLastName");
//        original.setAge(30);
//        original.setSex(Developer.Sex.female);
//
//        long id = service.create(original);
//        Developer saved = service.getById(id);
//
//        Assertions.assertEquals(id, saved.getId());
//        Assertions.assertEquals(original.getFirstName(), saved.getFirstName());
//        Assertions.assertEquals(original.getLastName(), saved.getLastName());
//        Assertions.assertEquals(original.getAge(), saved.getAge());
//        Assertions.assertEquals(original.getSex(), saved.getSex());
//    }
//
//}
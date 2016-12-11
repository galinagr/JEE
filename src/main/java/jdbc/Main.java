package jdbc;

import jdbc.controllers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private DevelopersController developersController;
    private CompaniesController companiesController;
    private CustomersController customersController;
    private ProjectsController projectsController;
    private SkillsController skillsController;


    public static void main(String[] args) throws SQLException {
        Driver driver = new oracle.jdbc.OracleDriver();
        try {
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            LOGGER.error("ERROR IN Driver REGISTRATION");
        }
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "galina", "galina");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Main main = context.getBean(Main.class);
        main.start();
        DriverManager.deregisterDriver(driver);
    }

    public void setDevelopersController(DevelopersController developersController) {
        this.developersController = developersController;
        System.out.println("RESULT OF DEVELOPERS SQL: SELECT DEVELOPERS BY ID 1001: " + developersController.getDevelopersById(1001));
    }

    public void setCompaniesController(CompaniesController companiesController) {
        this.companiesController = companiesController;
        System.out.println("RESULT OF COMPANIES SQL: SELECT COMPANIES BY COMP_ID SOFT_PLUS: " + companiesController.getCompaniesByName("SOFT_PLUS"));
    }

    public void setCustomersController(CustomersController customersController) {
        this.customersController = customersController;
        System.out.println("RESULT OF CUSTOMERS SQL: " + customersController.changeCustomersExpenses(3, 5001));
    }

    public void setProjectsController(ProjectsController projectsController) {
        this.projectsController = projectsController;
        System.out.println("RESULT OF PROJECTS SQL: " + projectsController.updateProject("BANK6","FINE", 80, 10000, 80000,2006));
    }

    public void setSkillsController(SkillsController skillsController) throws SQLException {
        this.skillsController = skillsController;
        System.out.println("RESULT OF SKILLS SQL: " + skillsController.changeSkillDescription("NEW", 3003));
    }

    private void start() {
        developersController.getAllDevelopers().forEach(System.out::println);
        companiesController.getAllCompanies().forEach(System.out::println);
        customersController.getAllCustomers().forEach(System.out::println);
        skillsController.getAllSkills().forEach(System.out::println);
        projectsController.getAllProjects().forEach(System.out::println);

    }
}

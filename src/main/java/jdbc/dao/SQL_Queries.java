package jdbc.dao;

public class SQL_Queries {
    private SQL_Queries() {
    }

    static final String SQL_SELECT_ALL_DEVELOPERS = "SELECT * FROM DEVELOPERS";
    static final String SQL_SELECT_ALL_CUSTOMERS = "SELECT * FROM CUSTOMERS";
    static final String SQL_SELECT_ALL_COMPANIES = "SELECT * FROM COMPANIES";
    static final String SQL_SELECT_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    static final String SQL_SELECT_ALL_SKILLS = "SELECT * FROM SKILLS";
    static final String SQL_SELECT_ALL_FROM_DEVELOPERS_BY_ID = "SELECT * FROM DEVELOPERS WHERE DEV_ID = ?";

    static final String SQL_SELECT_ALL_FROM_PROJECTS_BY = "SELECT * FROM PROJECTS WHERE ? = ?";
    static final String SQL_SELECT_ALL_FROM_COMPANIES_BY_NAME = "SELECT * FROM COMPANIES WHERE COMP_NAME = ?";
    static final String SQL_SELECT_ALL_FROM_SKILLS_BY = "SELECT * FROM SKILLS WHERE ? = ?";

    static final String SQL_UPDATE_DEVELOPERS = "UPDATE * FROM ? ";
    static final String SQL_UPDATE_CUSTOMERS = "UPDATE * FROM ? ";
    public static final String SQL_UPDATE_PROJECTS = "UPDATE PROJECTS SET PROJECT_NAME = ?,PROJECT_DESC = ?,QUANTITY_DEV = ?, PROFIT = ?, COSTS = ? WHERE PROJ_ID = ?";
    public static final String SQL_UPDATE_CUSTOMERS_EXPENSES = "UPDATE CUSTOMERS SET CUST_EXPENSES = (CUST_EXPENSES * ?) WHERE CUST_ID = ? ";
    public static final String SQL_UPDATE_SKILLS_DESCR_BY_ID = "UPDATE SKILLS SET SKILL_DESCR = ? WHERE SKILL_ID = ?";

    static final String SQL_INSERT_DEVELOPERS = "";
    static final String SQL_INSERT_CUSTOMERS = "";
    static final String SQL_INSERT_PROJECTS = "INSERT INTO PROJECTS (PROJ_ID,PROJECT_NAME,PROJECT_DESC, QUANTITY_DEV,PROFIT,COSTS) VALUES(?,?,?,?,?,?)";
    static final String SQL_INSERT_COMPANIES = "";
    static final String SQL_INSERT_SKILLS = "";

    static final String SQL_COUNT_ALL_SALARIES_IN_PROJECT = "";
    static final String SQL_MAX_PROFIT_FROM_COMPANIES = "";
    static final String SQL_COUTN_ALL_DEVELOPERS_FOR_PROJECT = "";
}
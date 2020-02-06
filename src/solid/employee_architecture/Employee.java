package solid.employee_architecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employee {

    private int id;
    private String name;
    private String department;
    private boolean working;

    public Employee(int id, String name, String department, boolean working) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.working = working;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", working=" + working +
                '}';
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Andrey", "surgery", true);
        ClientModule.hireNewEmployee(employee1);
        ClientModule.printEmployeeReport(employee1, FormatType.CSV);
    }
}

class EmployeeDao {
    void saveEmployee(Employee employee) {
        System.out.println(employee + " saved");
    }

    void deleteEmployee(Employee employee) {
        System.out.println(employee + " deleted");
    }
    public static void printEmployeeReport(Employee employee, FormatType formatType){
        EmployeeReportFormatter formatter = new EmployeeReportFormatter(employee, formatType);
        System.out.println(formatter.getFormattedEmployee());
    }
}

class DatabaseConnectionManager {
    private Connection connection;

    private static DatabaseConnectionManager connectionManager = new DatabaseConnectionManager();

    private DatabaseConnectionManager() {

    }

    void connect() throws SQLException {
        connection = DriverManager.getConnection("Database URL");
        System.out.println("Connection established");
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() throws SQLException{
        connection.close();
        System.out.println("Disconnect from DB");
    }
}
class ClientModule{

    public static void hireNewEmployee(Employee employee){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.saveEmployee(employee);
    }
    public static void terminateEmployee(Employee employee) {
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.deleteEmployee(employee);
    }
    public static void printEmployeeReport(Employee employee, FormatType formatType){
        EmployeeReportFormatter formatter = new EmployeeReportFormatter(employee, formatType);
        System.out.println(formatter.getFormattedEmployee());
    }
}
class ReportFormatter {
    String formatterOutput;

    public ReportFormatter(Object o, FormatType formatType) {
        switch (formatType){
            case XML: formatterOutput = convertObjectToXML(o);
            break;
            case CSV: formatterOutput = convertObjectToCSV(o);
            break;
        }
    }

    private String convertObjectToXML(Object o){
        return "converted to XML" + o.toString();
    }
    private String convertObjectToCSV(Object o){
        return "converted to CSV" + o.toString();
    }
}
enum FormatType{
    XML, CSV
}
class EmployeeReportFormatter extends ReportFormatter{
    public EmployeeReportFormatter(Object o, FormatType formatType) {
        super(o, formatType);
    }
    public String getFormattedEmployee(){
        return formatterOutput;
    }
}
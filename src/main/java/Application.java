import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class Application {

    public static void main(String[] args)  {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("First Name", "Last Name", "male", 44, 2);
        //Добавление в БД созданного employee
        employeeDAO.create(employee);

        //Поиск в БД employee
        employeeDAO.getById(13);

        //Просмотр всех имеющихся в БД employee
        System.out.println(employeeDAO.getAllEmployees());

        //Меняем одно поле в объекте employee
        employee.setGender("female");
        //Обновляем сведения по этому employee в БД
        employeeDAO.updateEmployee(employee);

        //Удаляем employee
        employeeDAO.deleteEmployee(employee);
    }
}
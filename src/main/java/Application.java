import dao.CityDAO;
import dao.CityDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.City;
import model.Employee;

public class Application {

    public static void main(String[] args)  {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city1 = new City("FIRST CITY");
        cityDAO.create(city1);

        //При запуске приложения обе таблицы - employee и city - пустые
        //И, добавляя город, мы не указываем его id - он устанавливается БД самостоятельно
        //Значит, мы можем получить его id, чтобы этот город (как объект) - указать как поле класса Employee

        City cityForEmployee = cityDAO.getById(1);

        //Создаем объект employee
        Employee employee = new Employee("Sven", "Svensson", "male", 35);
        //Заполняем поле city в объекте employee
        employee.setCity(cityForEmployee);

        //Добавим employee в БД
        employeeDAO.create(employee);

        //Удалим cityForEmployee
        cityDAO.deleteCity(cityForEmployee);
    }
}
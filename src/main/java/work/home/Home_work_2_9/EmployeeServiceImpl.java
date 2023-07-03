package work.home.Home_work_2_9;


import org.springframework.stereotype.Service;
import work.home.Home_work_2_9.exeption.exception.CheckException;
import work.home.Home_work_2_9.exeption.exception.controller.EmployeeService;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }


    @Override
    public EmployeeService addEmployee(String firsName, String lastName) {

        if (!validateInput(firsName, lastName)) {
            throw new CheckException();
        }

        Employee employee = new Employee(firsName, lastName);
        if (employeeList.contains(employee)) {
            throw new CheckException();
        }
        employeeList.add(employee);
        return (EmployeeService) employee;
    }

 private boolean validateInput (String firsName, String lastName) {
        return isAlpha(firsName) && isAlpha(lastName);

 }



}
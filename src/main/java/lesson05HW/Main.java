package lesson05HW;

public class Main {
    public static Employee[] employeesArr = new Employee[5];

    public static void main(String[] args) {
        setArrValues();
        filterInfo(40);
    }

    //set array values
    public static void setArrValues() {
        employeesArr[0] = new Employee("Ivan Ivanov", "Senior Software Engineer", "iivanov@something.com", "+71234567890", 200000, 43);
        employeesArr[1] = new Employee("Petr Petrov", "Software Engineer", "ppetrov@something.com", "+72345678901", 100000, 35);
        employeesArr[2] = new Employee("Sidor Sidorov", "Software Tester", "ssidorov@something.com", "+73456789012", 30000, 28);
        employeesArr[3] = new Employee("Maxim Maximov", "Senior Software Tester", "mmaximov@something.com", "+74567890123", 50000, 33);
        employeesArr[4] = new Employee("Nikita Nikitin", "Head of Software Testing Department", "nnikitin@something.com", "+75678901234", 120000, 45);
    }

    //print info based on a condition
    public static void filterInfo (int ageConstraint) {
        for (Employee employee : employeesArr) {
            if (employee.getAge() > ageConstraint) {
                employee.printEmployeeInfo();
            }
        }
    }
}
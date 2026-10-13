abstract class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(int id, String name, double amount) {
        super(id, name);
        salary = amount;
    }

    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    int hr;
    double rate;

    PartTime(int id, String name, int hr, double rate) {
        super(id, name);
        this.hr = hr;
        this.rate = rate;
    }

    double monthlySalary() {
        return hr * rate;
    }
}

class Intern extends Employee {
    double stipened;

    Intern(int id, String name, double stipened) {
        super(id, name);
        this.stipened = stipened;
    }

    double monthlySalary() {
        return stipened;
    }
}

class PayRoll {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new FullTime(1, "john", 15000);
        employees[1] = new PartTime(2, "Carl", 15, 120);
        employees[2] = new Intern(3, "Mat", 6000);
        employees[3] = new FullTime(4, "Max", 17000);

        double total = 0;
        for (Employee i : employees) {
            System.out.println(i.monthlySalary());
            total += i.monthlySalary();
            if(i instanceof Intern) {
                System.out.println("This Employee is an Intern ");
            }
        }
        System.out.println("Total Salary Budget :" + total);
    }
}
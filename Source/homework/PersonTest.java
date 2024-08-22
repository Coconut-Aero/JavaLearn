package homework;

public class PersonTest {

}
class Person {
    String name;
    int age;
    String address;
    String phone;
    String email;
    public Person(String name, int age, String address, String phone, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone+ ", email=" + email + "]";
    }
}

class Student extends Person {
    String classStatus;
    public Student(String name, int age, String address, String phone, String email) {
        super(name, age, address, phone, email);
    }
    public Student(String name, int age, String address, String phone, String email, String classStatus) {
        super(name, age, address, phone, email);
        this.classStatus = classStatus;
    }
    public String getClassStatus() {
        return classStatus;
    }
    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone
                + ", email=" + email + ", classStatus=" + classStatus + "]";
    }
}

class Employee extends Person {
    String office;
    int salary;
    Date dateEmploy = new Date();
    public Employee(String name, int age, String address, String phone, String email) {
        super(name, age, address, phone, email);
    }
    public Employee(String name, int age, String address, String phone, String email, String office, int salary) {
        super(name, age, address, phone, email);
        this.office = office;
        this.salary = salary;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Date getDateEmploy() {
        return dateEmploy;
    }
    public void setDateEmploy(Date dateEmploy) {
        this.dateEmploy = dateEmploy;
    }
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + ", email=" + email +
                ", office="+ office  + ", salary=" + salary  + "]";
    }
}

class Faculty extends Employee {
    String level;
    long officeTime;
    public Faculty(String name, int age, String address, String phone, String email) {
        super(name, age, address, phone, email);
    }
    public Faculty(String name, int age, String address, String phone, String email, String office, int salary) {
        super(name, age, address, phone, email, office, salary);
    }
    public Faculty(String name, int age, String address, String phone, String email, String office, int salary,String level, long officeTime) {
        super(name, age, address, phone, email, office, salary);
        this.level = level;
        this.officeTime = officeTime;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public long getOfficeTime() {
        return officeTime;
    }
    public void setOfficeTime(long officeTime) {
        this.officeTime = officeTime;
    }
    public String toString() {
        return "Faculty [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + ", email=" + email +
                ", office="+ office  + ", salary=" + salary  + ", level="+ level + "office time= "+ officeTime+"]";
    }
}

class Staff extends Employee {
    String title;
    public Staff(String name, int age, String address, String phone, String email) {
        super(name, age, address, phone, email);
    }
    public Staff(String name, int age, String address, String phone, String email, String office, int salary) {
        super(name, age, address, phone, email, office, salary);
    }
    public Staff(String name, int age, String address, String phone, String email, String office, int salary,String title) {
        super(name, age, address, phone, email, office, salary);
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String toString() {
        return " Staff [name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone + ", email=" + email +
                ", office="+ office  + ", salary=" + salary  + ", title= "+ title+"]";
    }
}

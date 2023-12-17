import java.util.Comparator;

public class Employee implements Comparable<Employee> {

  private String name;
  private String surname;
  private String city;
  private int age;
  private int salary;

  public Employee(String name, String surname, String city, int age, int salary) {
    this.name = name;
    this.surname = surname;
    this.city = city;
    this.age = age;
    this.salary = salary;
  }


  @Override
  public int compareTo(Employee other) {
    int nameCompare = this.name.compareToIgnoreCase(other.name);
    if (nameCompare != 0) {
      return nameCompare;
    } else {
      return Integer.compare(this.age, other.age);
    }
  }

  public static final Comparator<Employee> AGE_SALARY_COMPARATOR = Comparator
          .comparingInt(Employee::getAge)
          .thenComparingInt(Employee::getSalary);

  public static final Comparator<Employee> PASSPORT_COMPARATOR = Comparator
          .comparing(Employee::getName)
          .thenComparing(Employee::getSurname)
          .thenComparing(Employee::getCity);

  public static final Comparator<Employee> FULL_COMPARATOR = Comparator
          .comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER)
          .thenComparing(Employee::getSurname, String.CASE_INSENSITIVE_ORDER)
          .thenComparing(Employee::getCity, String.CASE_INSENSITIVE_ORDER)
          .thenComparingInt(Employee::getAge)
          .thenComparingInt(Employee::getSalary);


  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCity() {
    return city;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

}

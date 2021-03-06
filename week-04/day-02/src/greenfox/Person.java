package greenfox;

public class Person
{
    private String name;
    private int age;
    private String gender;

    public Person() {
        this("Jane Doe", 30, "female");
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public void introduce() {
        System.out.println("Hi, I'm " + getName() + ", a " + getAge() + " year old  " + getGender() + ".");
    }
    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }
    public String getName() {
        return name;
    }

}
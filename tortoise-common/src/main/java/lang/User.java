package lang;


import java.util.ArrayList;
import java.util.List;

public class User {


    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private Integer age;

    private String name;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = age.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name +this.age;
    }

    public static void main(String[] args) {
        List a=new ArrayList();


    }

}

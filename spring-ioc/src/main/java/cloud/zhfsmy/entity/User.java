package cloud.zhfsmy.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private Mobile mobile;
    private String[] hobbies;
    private List<User> friends;
    private Map<String, User> telBook;

    public User() {

    }

    public User(String name, Integer age, Mobile mobile, String[] hobbies, List<User> friends, Map<String, User> telBook) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.hobbies = hobbies;
        this.friends = friends;
        this.telBook = telBook;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, Mobile mobile) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }

    public User(String name, Integer age, Mobile mobile, String[] hobbies) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.hobbies = hobbies;
    }

    public Map<String, User> getTelBook() {
        return telBook;
    }

    public void setTelBook(Map<String, User> telBook) {
        this.telBook = telBook;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mobile=" + mobile +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", friends=" + friends +
                ", telBook=" + telBook +
                '}';
    }
}
package Generic;

import java.util.Objects;

public class ClientDomain extends GenericDomain<String>{
    private String name;
    private int age;

    public ClientDomain(String id, int age, String name) {
        super(id);
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientDomain that = (ClientDomain) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, age);
    }

    @Override
    public String toString() {
        return "ClientDomain{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

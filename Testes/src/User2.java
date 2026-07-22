import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.isNull;

public class User2 /*implements Comparable*/{
    private int id;
    private String name;


    public User2(int id, String name){
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public  String toString(){
        return String.format("{'id': %d, 'name': %s}", this.id, this.name);
    }

    @Override
    public boolean equals(final Object obj){
        if (obj == this) return true;
        if (isNull(obj) || (!(obj instanceof User2 user))) return false;
        return this.id == user.getId() && Objects.equals(user.getName(), this.name);
    }

    @Override
    public int hashCode() {
        return hash(this.id, this.name);
    }

    /*@Override
    public int compareTo(Object o) {
        int compareResult = 0;
        try {
            User2 user = (User2) o;

            if (user.id > this.id) compareResult--;
            if (user.id < this.id) compareResult++;
            return compareResult;
        }catch (ClassCastException e){
            System.out.println("O objeto inserido não é uma instância de User2");
        }
        return compareResult;
    }*/


}

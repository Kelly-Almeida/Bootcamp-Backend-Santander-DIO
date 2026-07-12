package Generic;

public class Main2 {
    private final static GenericDao<Integer, UserDomain> dao = new UserDAO();

    public static void main(String[] args){
        var user = new UserDomain(1, 23, "Karol");
        System.out.println(dao.count());
        System.out.println(dao.save(user));
        System.out.println(dao.findAll());
        System.out.println(dao.find(d -> d.getId().equals(1)));
        System.out.println(dao.findAll());
        System.out.println(dao.count());
        System.out.println(dao.delete(new UserDomain(-1, -1, "")));
        System.out.println(dao.delete(user));
        System.out.println(dao.findAll());
        System.out.println(dao.count());


        dao.delete(new UserDomain(-1 , -1, ""));
        dao.delete(user);
    }
}

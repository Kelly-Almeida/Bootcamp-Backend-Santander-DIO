public record User3(String name, int age, SexEnum sex) {

    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public String getSex(){return this.sex.getSexo();}
}

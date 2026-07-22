public enum SexEnum {
    Masculino("Masculino"),
    Feminino("Feminino"),
    Intersexo("Intersexo"),
    NaoDeclarar("Não declarado");

    final private String returnName;

    SexEnum(String returnName) {

        this.returnName = returnName;
    }

    public String getSexo(){return this.returnName;}
}

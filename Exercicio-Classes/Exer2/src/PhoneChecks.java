import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface PhoneChecks {

    public static Map isPhoneNumber(String phone){

        boolean isNumber = false;
        boolean isFixed = false;
        boolean withDDD = false;
        boolean hasLetras = true;
        boolean possibleNumber = false;

        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        if(matcher.matches()){
            hasLetras = false;
            int quantNum = phone.length();

            if (quantNum <= 11 && quantNum >= 8){
                isNumber = true;

                if(quantNum == 8 || quantNum == 10){
                    isFixed = true;
                    if(quantNum == 10){withDDD = true;}

                }else{
                    if(quantNum == 11){withDDD = true;}
                }
            }
        }else {
            int quantNumber = Math.toIntExact(phone.chars()
                    .filter(Character::isDigit)
                    .count());

            if (quantNumber <= 11 && quantNumber >= 8){
                possibleNumber = true;

                if(quantNumber == 8 || quantNumber == 10){
                    isFixed = true;
                    if(quantNumber == 10){withDDD = true;}

                }else{
                    if(quantNumber == 11){withDDD = true;}
                }
            }
        }



        Map mapInfor = new HashMap<>();
        mapInfor.put("IsNumber", isNumber);
        mapInfor.put("IsFixedPhone", isFixed);
        mapInfor.put("WithDDD", withDDD);
        mapInfor.put("HasLetra", hasLetras);
        mapInfor.put("possibleNumber", possibleNumber);

        return mapInfor;
    }

    public static String formatPhoneNumber(Map info, String number){
        StringBuilder phoneFormatado = new StringBuilder();
        String phone  = number.replaceAll("\\D", "");//\\D é tudo que não for número

        System.out.println(phone);

        //Em caso de ser um número
        if ((boolean) info.get("IsNumber") || (boolean) info.get("possibleNumber")){

            //Em caso de ter DDD
            if((boolean) info.get("WithDDD")){
                //Em caso de ser um telefone fixo
                if((boolean) info.get("IsFixedPhone")){
                    //"(XX) XXXX-XXXX"
                    phoneFormatado.append("(").append(phone, 0, 2).append(") ").append(phone, 2, 6).append("-").append(phone, 6, 10);

                }
                //Em caso de não ser um telefone fixo
                else {
                    //(XX) XXXXX-XXXX
                    phoneFormatado.append("(").append(phone, 0, 2).append(") ").append(phone,2, 8).append("-").append(phone,7, 11);

                }
            }
            //Em caso de não ter DDD
            else{
                //Em caso de ser um telefone fixo
                if((boolean) info.get("IsFixedPhone")){
                    //"XXXX-XXXX"
                    phoneFormatado.append(phone, 0, 4).append("-").append(phone,4, 8);
                }
                //Em caso de não ser um telefone fixo
                else {
                    //XXXXX-XXXX
                    phoneFormatado.append(phone, 0, 5).append("-").append(phone, 5, 9);
                }
            }


        }
        //Em caso de não ser um número
        else{
           //Em caso de não ser um número possível
            System.out.println("Digite um número de telefone válido!!");
            return "";
        }
        return String.join("", phoneFormatado);
    }
}

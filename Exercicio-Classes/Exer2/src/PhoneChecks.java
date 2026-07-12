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


}

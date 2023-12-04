public class Main {

    public static void main(String[] args){

        //Using the switch statement is usually just a matter of style or preference.
        //The break statement will take you out of the switch statement once code is run before it.
        //Using the switch statement could be useful when testing one variable repeatedly.
        //Switch value types are limited in what they can use.
        //Valid types are byte,short,int,char,Byte,Short,Integer,Character,String,enum.
        //Cannot use long, float, double, or boolean or their wrappers.

        //Fall through can happen in a switch statement if you forget a break.
        //This results in the next line being run (Could go to default).
        
        int switchValue = 3;

        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:  //<------------------This is a good example of quickly adding multiple test cases.
                System.out.println("Was a 3, 4, or a 5");
                System.out.println("Actually was a " + switchValue);
                break;
            default:
                System.out.println("Was not 1,2,3,4, or 5");
                break;
        }


        //Below is an enhanced switch statement.

        switch(switchValue){

            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> {

                System.out.println ("Was a 3, a 4, or a 5");
                System.out.println("Actually was a " + switchValue);
            }
            default -> System.out.println("Was not 1, 2, 3, 4, or 5");

        }

        String month = "OCTOBER";
        System.out.println(month + " is in the " + getQuarter(month) + " quarter");

    }

    //Traditional switch layout:
    public static String getQuarter(String month){

        switch (month){

            case "JANUARY":
            case "FEBRUARY":
            case "MARCH":
                return "1st";
            case "APRIL":
            case "MAY":
            case "JUNE":
                return "2nd";
            case "JULY":
            case "AUGUST":
            case "SEPTEMBER":
                return "3rd";
            case "OCTOBER":
            case "NOVEMBER":
            case "DECEMBER":
                return "4th";


        }
        return "bad";

    }


// Below is the same switch statement but in it's enhanced version.

    public static String getQuarter(String month, int placeHolder){

        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default -> {
                String badResponse = month + " is bad";
                yield badResponse;  // <------------- We have to use a different keyword, "yield" in this case.
            }                       //This is because using a code block within the switch expression cannot resolve
        };                          //a "return" statement.
        //yield is used in the following conditions:
        //1. If the switch statement is being used as a switch expression returning a value.
        //2. If the case label uses a code block, with opening and closing curly braces.
    }



}

package flightreservationsystem.Helper;

public class ValidationHelper {
    public static boolean ValidDigit(String str){
        boolean check = false;
        for (char ch: str.toCharArray()) {
            check = Character.isDigit(ch);
            if (!check) {
                System.out.println("\n.-------------------------------.");
                System.out.println("|   Please enter number only.   |");
                System.out.println("'-------------------------------'\n");
                return check;
            }
        }
        return check;
    }

    public static boolean ValidDouble(String str){
        boolean check = false;
        for (char ch: str.toCharArray()) {
            // skip to check dot
            if (ch == '.'){
                continue;
            }
            check = Character.isDigit(ch);
            if (!check) {
                System.out.println("\n.-------------------------------.");
                System.out.println("|   Please enter number only.   |");
                System.out.println("'-------------------------------'\n");
                return check;
            }
        }
        return check;
    }

    public static boolean ValidAlpha(String str){
        boolean check = false;
        for (char ch: str.toCharArray()) {
            check = Character.isLetter(ch);
            if (!check) {
                System.out.println("\n.---------------------------------.");
                System.out.println("|   Please enter alphabet only.   |");
                System.out.println("'---------------------------------'\n");
                return check;
            }
        }
        return check;
    }

    public static boolean ValidAlphaNum(String str){
        boolean check = false;
        for (char ch: str.toCharArray()) {
            check = Character.isLetterOrDigit(ch);
            if (!check) {
                System.out.println("\n.-----------------------------------------.");
                System.out.println("|   Please enter alphabet & number only.  |");
                System.out.println("'-----------------------------------------'\n");
                return check;
            }
        }
        return check;
    }

    public static boolean ValidName(String str){
        boolean check =  str.matches("[A-Za-z @,'.\\-/]+"); //special characters that allowed in name
        if (!check){
            System.out.println("\n.----------------------------------------------.");
            System.out.println("|   Please do not include invalid characters.  |");
            System.out.println("'----------------------------------------------'\n");
        }
        return check;
    }
}

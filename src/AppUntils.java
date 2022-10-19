package src;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUntils {
    static Scanner scanner =new Scanner(System.in);

    public static int retryChoice(int max, int min){
        int option;
        do {
            System.out.println("==>  ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min){
                    System.out.println("Syntax Error! Input again");
                    System.out.println("==>  ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Wrong input, Input again");
            }
        }while (true);
        return option;
    }

    public static double retryParseDouble(){
        double result;
        do {
            System.out.println("==>  ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Wrong input, Input again");
            }
        }while (true);
    }

    public static String retryString(String fieldName){
        String result;
        System.out.println("==>  ");
        while ((result = scanner.nextLine()).isEmpty()){
            System.out.printf("%s Not Empty\n", fieldName);
            System.out.println("==>  ");
        }
        return result;
    }


    public static String doubleToVND(double value) {
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static void exit() {
        System.out.println("\tTạm biệt. Hẹn gặp lại!");
        System.exit(5);
    }
}

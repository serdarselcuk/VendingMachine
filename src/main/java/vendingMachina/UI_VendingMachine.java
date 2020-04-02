package vendingMachina;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI_VendingMachine {

    static int penny;
    static int nickel;
    static int dime;
    static int quarter;
    static String product;


    public static void screen() throws InputMismatchException {

            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the number of coin you insert! ");
            System.out.println("Penny:");
            penny =scan.nextInt();
            System.out.println("nickel:");
            nickel =scan.nextInt();
            System.out.println("dime:");
            dime =scan.nextInt();
            System.out.println("quarter:");
            quarter =scan.nextInt();
            scan.nextLine();
            System.out.println("the product you want (Coke(25), Pepsi(35), Soda(45)) or for canceling write \"cancel\":");
            product = scan.nextLine();

    }

    public static void cancel(){
        System.out.println("transaction canceled you can get your coins back");
        System.out.println( "" +"penny: "+penny+" nickel: "+nickel+ " dime: "+ dime+" quarter: "+ quarter);
    }

    public static void main(String[] args) {

        try {
            screen();
        }
        catch (InputMismatchException e){
            System.out.println("You insert something wrong Operation cancelled!");
            System.exit(0);
        }

        if (!product.equalsIgnoreCase("cancel")){
            VendingMachine vm = new VendingMachine();
            System.out.println("Here your "+product+" and your change is "+vm.transaction(product.toLowerCase(), penny, nickel, dime, quarter)+" cents");
        }
        else{
            cancel();
        }

    }

}

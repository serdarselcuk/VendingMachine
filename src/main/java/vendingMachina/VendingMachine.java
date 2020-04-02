package vendingMachina;

import java.util.HashMap;
import java.util.Map;


public class VendingMachine {
    //    Vending which Machine
    //1.     Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
    //2.     Allow user to select products Coke(25), Pepsi(35), Soda(45)
    //3.     Allow user to take refund by canceling the request.
    //4.     Return selected product and remaining change if any
    //5.     Allow reset operation for vending machine supplier.

    static final int MAX_CAPACITY = 30;
    static final int DEFAULT_N_COINS = 10;
    static final int COKE_PRICE = 25;
    static final int PEPSI_PRICE = 35;
    static final int SODA_PRICE = 45;

    private HashMap<String, Integer> drinks;
    private HashMap<String, Integer> prices;
    private HashMap<Integer, Integer> coins;


    public VendingMachine() { // install machine with max capacity
        drinks = new HashMap<String, Integer>() {
            {
                put("coke", MAX_CAPACITY);
                put("pepsi", MAX_CAPACITY);
                put("soda", MAX_CAPACITY);
            }
        };

        coins = new HashMap<Integer, Integer>() {
            {
                put(1, DEFAULT_N_COINS);
                put(5, DEFAULT_N_COINS);
                put(10, DEFAULT_N_COINS);
                put(25, DEFAULT_N_COINS);
            }
        };

        prices = new HashMap<String, Integer>() {
            {
                put("coke", COKE_PRICE);
                put("pepsi", PEPSI_PRICE);
                put("soda", SODA_PRICE);
            }
        };
    }


    private int calculateChange(int payment, int price) {

        // Calculates and returns the change if we have enough coin
        // to pay it. Otherwise returns -1.

        int change = payment - price;
        int k_change = change;
        int needed;
        int amount;

        int[] coin_iterator = {25, 10, 5, 1};
        int[] results = {0, 0, 0, 0};

        int i = -1;

        for (int coin: coin_iterator) {

            i += 1;
            amount = getNumCoins(coin);

            results[i] = amount;

            if (coin > change) {
                continue;
            }

            needed = change / coin;

            if (needed > amount) {
                needed = amount;
            }

            change -= needed * coin;
            results[i] -=  needed;
        }

        if (change > 0) {
            return -1;
        }

        i = 0;
        for (int coin: coin_iterator) {
            setNumCoins(coin, results[i]);
            i += 1;
        }
        return k_change;
    }

    public int calculatePrice(int penny,int nickel,int dime,int quarter){
        return (penny + nickel*5 + dime*10 + quarter*25);//total coins
    }



    public int transaction(String choice, int penny, int nickel, int dime, int quarter) {

        int cur_penny = getNumCoins(1);
        int cur_nickel = getNumCoins(5);
        int cur_dime = getNumCoins(10);
        int cur_quarter = getNumCoins(25);

        setNumCoins(1, cur_penny + penny);
        setNumCoins(5, cur_nickel + nickel);
        setNumCoins(10, cur_dime + dime);
        setNumCoins(25, cur_quarter + quarter);

        // Executes transaction if we have the drink of choice in stocks
        // and money to payback the change.
        // Returns the change or -1 if transaction cancelled.


        if (prices.get(choice) <= calculatePrice( penny, nickel, dime, quarter) && getNumDrinks(choice) > 0) {

            int change = calculateChange(calculatePrice( penny, nickel, dime, quarter), prices.get(choice));

            if (change > -1) {

                setNumDrinks(choice, getNumDrinks(choice) - 1);

                return change;
            }
        }

        setNumCoins(1, cur_penny);
        setNumCoins(5, cur_nickel);
        setNumCoins(10, cur_dime);
        setNumCoins(25, cur_quarter);

        return -1;
    }

    public void setNumDrinks(String choice, int num) {
        // for testing
        drinks.replace(choice, num);
    }

    public void setNumCoins(Integer coin, int num) {
        // for testing
        coins.replace(coin, num);
    }

    public int getNumDrinks(String choice) {
        // for testing
        return drinks.get(choice);
    }

    public int getNumCoins(int coin) {
        // for testing
        return coins.get(coin);
    }

    public void reset() {

        for (Map.Entry <String, Integer> entry: drinks.entrySet()) {
            entry.setValue(MAX_CAPACITY);
        }
        for (Map.Entry <Integer, Integer> entry: coins.entrySet()) {
            entry.setValue(0);
        }
    }

}
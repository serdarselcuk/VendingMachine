
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vendingMachina.VendingMachine;

public class Testing_VM {
/*
as dependency for testNG / maven I imported this dependency


   <!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.1.0</version>
    <scope>test</scope>
</dependency>
=======================================================================================

    // sell pepsi: decrements number of cokes & correct coins, correctly
    // sell soda: decrements number of cokes & correct coins, correctly
    // cannot sell a drink if it is not in stocks
    // vm.setNumDrinks("coke", 0); vm.transaction("coke", 25) == -1
    // cannot complete transaction if does not have enough money to give change
    // vm.setNumCoins(1, 0); vm.transaction("coke", 26) == -1
*/

    private VendingMachine vm ;

    @BeforeMethod(description = "sell coke: decrements number of cokes & correct coins, correctly")
    public void defaultTransaction(){

        vm = new VendingMachine();
        vm.transaction("coke", 2,2,2,2);

    }

    //getNumDrinks("coke") == 29
    @Test(description = "check about the machine if it gave the right product and the remaining amount")
    public void test1(){

        Assert.assertEquals(29,vm.getNumDrinks("coke"));
}

    @Test(description = "for penny = 1 thereshould be :10 ")
    public void test2(){

        Assert.assertEquals(vm.getNumCoins(1),10);
    }

    @Test(description = "for nickel = 5 thereshould be :11")
    public void test3(){

        Assert.assertEquals(vm.getNumCoins(5),11);
    }

    @Test(description = "for dime = 10 thereshould be :12")
    public void test4(){

        Assert.assertEquals(vm.getNumCoins(10),12);
    }

    @Test(description = "for quarter = 25 thereshould be :10")
    public void test5(){

        Assert.assertEquals(vm.getNumCoins(25),10);
    }


}

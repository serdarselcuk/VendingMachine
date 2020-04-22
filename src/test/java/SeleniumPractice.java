import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.stream.FactoryConfigurationError;
import java.security.DrbgParameters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeleniumPractice {
    String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    public String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;


public static void main(String[] args)  {
//        WebDriverManager.iedriver().setup();
//        InternetExplorerOptions ds = new InternetExplorerOptions();
//
//        InternetExplorerDriver driver = new InternetExplorerDriver(ds);
//        driver.get("https://amazon.com");
//        System.out.println(driver.findElement(By.linkText("See more from Prime Video")).isDisplayed());
//        System.out.println(driver.findElementByXPath("//*[text()='See more from Prime Video']").isDisplayed());
////        driver.findElement(By.name("q")).sendKeys("serdar", Keys.ENTER);
////        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement e = driver.findElement(By.linkText("See more from Prime Video"));
////        wait.until((p)->driver.getTitle()!="Google");
////        System.out.println(driver.getTitle());
////
//            Select slc = new Select(e);
//
//
//        ArrayDeque<Integer> arr = new ArrayDeque<>();
//        arr.addAll(Arrays.asList(1, 2, 3, 4, 8, 2, 0, 5, 6, 7));
//        System.out.println(arr.peekFirst());


//        int[] scores= {100, 100, 50, 40, 40, 20, 10};
//        int[] alice = {5, 25, 50, 120};
//        System.out.println(Arrays.toString(climbingLeaderboard(scores,alice)));


        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);

        String s=in.nextLine();

        //String ip="\\b(25[0-5]| 2[0-4][0-9]|[01]?[0-9][0-9]?)\\.b(25[0-5]| 2[0-4][0-9]|[01]?[0-9][0-9]?)\\.b(25[0-5]| 2[0-4][0-9]|[01]?[0-9][0-9]?)\\.b(25[0-5]| 2[0-4][0-9]|[01]?[0-9][0-9]?)\\.b";
        //String ip="^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."+"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."+"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.$";

        String reg =   "((2)[0-4][0-9]|(0|1)\\d{1,2}|(25)[0-5]|\\d)";
        String ip = String.format("(%\\.){3}(%)",reg);
        System.out.println(ip);
//        Pattern pat=Pattern.compile(ip);
//        Matcher mat=pat.matcher(s);
//
//            System.out.println(mat.matches());



    }





    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        int[] scoresc = Arrays.stream(scores).distinct().toArray();

        int i = scoresc.length-1;
        for (int j = 0; j < alice.length; j++) {

            for (; i >= 0; ) {
                if (alice[j] <= scoresc[i]) {
                    if(alice[j]<scoresc[i]){
                        result[j] = i+2;
                    }else if (alice[j] == scoresc[i]){
                        result[j] =i+1;
                    }
                    break;
                }else{
                    if(i==0){
                        result[j] =i+1;
                        break;
                    }
                    i--;
                }
            }
        }
        return result;
    }
}

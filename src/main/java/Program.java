import java.lang.reflect.Method;

public class Program {


        public static void main(String[] args) throws Exception {
            Class c = Demo.class;
            Demo obj = (Demo)c.newInstance();
            Method[] m = c.getDeclaredMethods();
            for(Method x:m){
                x.setAccessible(true);
                x.invoke(obj);
            }
        }
    }
    class Demo{
        private void display(){
            System.out.println("I'm display method");
        }
        private void show(){
            System.out.println("I'm show method");
        }

}

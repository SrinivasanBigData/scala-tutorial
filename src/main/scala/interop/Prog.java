package interop;

/**
 * Created by jubin on 6/26/2017.
 */
public class Prog {
    public static void main(String[] args) {
        new Test().func1();// instance method
        Test.func2(); // static method
        Test$.MODULE$.func1(); //hidden static method in companion object
    }
}

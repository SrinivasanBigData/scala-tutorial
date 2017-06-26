package interop;

/**
 * Created by jubin on 6/26/2017.
 */
public class TraitImpl implements Printable {
    @Override
    public void print(String s) {

    }

    @Override
    public void println() {

    }

    @Override
    public void println(String s) {
        Printable$class.println(this,s); //Printable$class is how to access the traits methods in scala
    }

    public static void main(String[] args) {
        new TraitImpl().println("hi");
    }
}

package buoi2.dependecy;

public class denpenApp {
    public static void main(String[] args) {
        B bRemote = new B();
        A aRemote = new A();
        aRemote.setbRemote(bRemote);
    }

}

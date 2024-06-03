package buoi2.dependecy;

public class A {
    A(){

    }
    A(B bRemote){
        bRemote.methodB();
    }
    void setbRemote(B bRemote){
        bRemote.methodB();
    }
    public void methodA(){
        B bRemote = new B();
        bRemote.methodB();

    }

}

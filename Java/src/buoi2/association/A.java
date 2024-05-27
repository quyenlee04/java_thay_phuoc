package buoi2.association;

public class A {
    B bRemote;
    A(){

    }
    A(B bRemote){
        this.bRemote= bRemote;
    }
    public void methodA(){
        bRemote.methodB();

    }

}

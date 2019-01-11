package net.jcip.examples;

/**
 * StuffIntoPublic
 * <p/>
 * Unsafe publication
 *
 * @author Brian Goetz and Tim Peierls
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
class MyThread extends Thread{
    private int i;
    private  StuffIntoPublic intoPublic;
    MyThread(int i,StuffIntoPublic intoPublic){
        this.i=i;
        this.intoPublic=intoPublic;
    }
    @Override
    public void run(){
        intoPublic.initialize();
    }
}
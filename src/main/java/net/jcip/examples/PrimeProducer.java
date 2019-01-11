package net.jcip.examples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * PrimeProducer
 * <p/>
 * Using interruption for cancellation
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue=new ArrayBlockingQueue<BigInteger>(10);
    PrimeProducer() {

    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
            consumed.printStackTrace();
            /* Allow thread to exit */
        }
    }

    public void cancel() {
        interrupt();
    }
    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeProducer generator = new PrimeProducer();
        try {
            generator.start();
            generator.sleep(4000);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(queue);
    }
    public static void main(String[] args) {
        try {
            System.out.println(aSecondOfPrimes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

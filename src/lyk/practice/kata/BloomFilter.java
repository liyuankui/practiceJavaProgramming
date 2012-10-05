package lyk.practice.kata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: kyle
 * Date: 10/5/12
 * Time: 9:18 PM
 * The BloomFilter class is intended to fulfil some duties.
 */
public class BloomFilter {
    private int prime;
    private byte[] array;
    private int bytesize;

    public BloomFilter() {
        new BloomFilter(10000);
    }

    public BloomFilter(int size) {
        prime = BigInteger.probablePrime((int) (Math.log(size) / Math.log(2)) + 1, new Random()).intValue();
        bytesize = prime / 8 + 1;
        bytesize *= (int) (1.44 * 7);
        array = new byte[bytesize];
        System.out.println("Prime" + prime);
        System.out.println("Size" + bytesize);
    }

    //1.44*log(1/e)/log2
    public void setBit(int key) {
        key = Math.abs(key % prime);
        int n = key / 8;
        int i = key % 8;
        byte orx = (byte) (1 << i);
        array[n] |= orx;
    }

    public boolean getBit(int key) {
        key = Math.abs(key % prime);
        int n = key / 8;
        int i = key % 8;
        byte andx = (byte) (1 << i);
        byte r = (byte) (array[n] & andx);
        return (r != 0);
    }


    public void put(String str) {
        setBit(hash1(str));
        setBit(hash2(str));
        setBit(hash3(str));
    }


    public boolean contains(String str) {
        return getBit(hash1(str)) && getBit(hash2(str)) && getBit(hash3(str));
    }

    private int hash1(String str) {
        return HashAlgorithms.APHash(str);
    }

    private int hash2(String str) {
        return HashAlgorithms.BKDRHash(str);
    }

    private int hash3(String str) {
        return HashAlgorithms.rotatingHash(str, prime);
    }

    public static void wordlistBenchmark() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("wordlist.txt"));
            String line = "";
            int count = 0;
            int falseCount = 0;

            BloomFilter bf = new BloomFilter(46000);
            while ((line = reader.readLine()) != null) {
                if (bf.contains(line)) {
                    //System.out.println(line+" "+count);
                    falseCount++;
                }
                bf.put(line);
                count++;
            }

            System.out.println("\n-- Total " + count + " false alarm" + falseCount);
            System.out.println("False alarm rate: " + falseCount / (double) count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dictlistBenchmark() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("english-words.80"));
            String line = "";
            int count = 0;
            int falseCount = 0;

            BloomFilter bf = new BloomFilter(140000);
            while ((line = reader.readLine()) != null) {
                if (bf.contains(line)) {
                    //System.out.print(line);
                    falseCount++;
                }
                bf.put(line);
                count++;
            }

            System.out.println("\n-- Total " + count + " false alarm" + falseCount);
            System.out.println("False alarm rate: " + falseCount / (double) count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void numberBenchmark() {
        int i = 9999;
        int count = i;
        int falseCount = 0;
        BloomFilter bf = new BloomFilter(i);
        while (i-- > 0) {
            String x = i + "";
            if (bf.contains(x)) {
                falseCount++;
                System.out.print(x);
            }
            bf.put(x);
        }
        System.out.println("\n-- Total " + count + " false alarm" + falseCount);
        System.out.println("False alarm rate: " + falseCount / (double) count);

    }

    public static void randomStringBenchmark() {

        int i = 9999;
        int count = i;
        int falseCount = 0;
        BloomFilter bf = new BloomFilter(i);
        while (i-- > 0) {
            String x = new Random().nextInt() + "";
            if (bf.contains(x)) {
                falseCount++;
                System.out.print(x);
            }
            bf.put(x);
        }
        System.out.println("\n-- Total " + count + " false alarm" + falseCount);
        System.out.println("False alarm rate: " + falseCount / (double) count);
    }

    public static void main(String[] args) {
        wordlistBenchmark();
    }

}

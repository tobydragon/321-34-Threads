package edu.ithaca.dragon.concurrency.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayUtilTest{
    
    @Test
    public void genRandArrayTest(){
        System.out.println("Number of processors available:" + Runtime.getRuntime().availableProcessors());

        SequentialArrayUtil seqArrayUtil = new SequentialArrayUtil();
        System.out.println("\nSequential:");
        System.out.println(Arrays.toString(seqArrayUtil.genRandArray(16, 16)));
        System.out.println(Arrays.toString(seqArrayUtil.genRandArray(15, 15)));
        System.out.println(Arrays.toString(seqArrayUtil.genRandArray(128, 100)));
        System.out.println(Arrays.toString(seqArrayUtil.genRandArray(127, 50)));

        // ThreadedArrayUtil threadedArrayUtil = new ThreadedArrayUtil(); 
        // System.out.println("\nThreaded:");
        // System.out.println(Arrays.toString(threadedArrayUtil.genRandArray(16, 16)));
        // System.out.println(Arrays.toString(threadedArrayUtil.genRandArray(15, 15)));
        // System.out.println(Arrays.toString(threadedArrayUtil.genRandArray(128, 100)));
        // System.out.println(Arrays.toString(threadedArrayUtil.genRandArray(127, 50)));
    }

    @Test
    public void genRandArrayTimingTest(){
        int [] seqRandArray = genRandArrayTimingTest(new SequentialArrayUtil());
        // int [] threadedRandArray = genRandArrayTimingTest(new ThreadedArrayUtil());
        // assertEquals(seqRandArray.length, threadedRandArray.length);
    }

    public int[] genRandArrayTimingTest(ArrayUtil utilToTest){
        long startTime = System.nanoTime();
        int[] array = utilToTest.genRandArray(10000000, 10000000);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println(utilToTest.getClass().getSimpleName() + " finished in: "+duration);
        return array;
    }

}
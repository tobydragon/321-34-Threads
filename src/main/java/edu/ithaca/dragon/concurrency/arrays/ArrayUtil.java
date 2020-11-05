package edu.ithaca.dragon.concurrency.arrays;

public interface ArrayUtil {
    
    public int[] genRandArray(int size, int maxValue);

    public int countOccurences(int[] array, int itemToFind);

    public int[] allItemsAbove(int[] array, int threshold);
}
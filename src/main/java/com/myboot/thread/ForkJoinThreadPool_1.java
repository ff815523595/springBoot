package com.myboot.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by a on 2017/10/13.
 */
public class ForkJoinThreadPool_1 {

    private static int MAX = 100000;
    private static int inits[] = new int[MAX];

    static {
        Random r = new Random();
        for(int index = 1 ; index <= MAX ; index++) {
            inits[index - 1] = r.nextInt(10000000);
        }
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        MyTask task = new MyTask(inits);
        ForkJoinTask<int[]> taskResult = pool.submit(task);
        try {
            taskResult.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime - beginTime));
    }

    static class MyTask extends RecursiveTask<int[]> {
        private int source[];
        public MyTask(int source[]){
            this.source = source;
        }

        @Override
        protected int[] compute() {
            int sourceLen = source.length;
            if(sourceLen > 2) {
                int midIndex = sourceLen / 2;
                MyTask task1 = new MyTask(Arrays.copyOf(source, midIndex));
                task1.fork();
                MyTask task2 = new MyTask(Arrays.copyOfRange(source, midIndex , sourceLen));
                task2.fork();

                int result1[] = task1.join();
                int result2[] = task2.join();
                int mer[] = joinInts(result1 , result2);
            }else{
                if(sourceLen == 1 || source[0] <= source[1]){
                    return source;
                }
                int targetp[] = new int[sourceLen];
                targetp[0] = source[1];
                targetp[1] = source[0];
                return targetp;
            }
            return new int[0];
        }

        private int[] joinInts(int[] arr1, int[] arr2) {
            int left = 0;
            int right = 0;
            int[] mergeArr = new int[arr1.length + arr2.length];
            if(mergeArr.length == 0) return null;
            for (int i = 0; i < arr1.length + arr2.length; i++) {
                if(arr1.length == left) {
                    mergeArr[i] = arr2[right];
                    right++;
                    continue;
                }else if(arr2.length == right) {
                    mergeArr[i] = arr1[left];
                    left++;
                    continue;
                }
                if(arr1[left] <= arr2[right]){
                    mergeArr[i] = arr1[left];
                    left++;
                }else{
                    mergeArr[i] = arr2[right];
                    right++;
                }
            }
            return mergeArr;
        }
    }
}

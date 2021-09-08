package com.alibaba.otter.canal.server;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 *
 *
 * 有序有重复的int数组，找出最后一个值等于给定value的元素下标，public int findIndex(int[] a, int value)
 */
public class DataSearchTest {

    public static void main(String[]args){
        int[]a =  new int[10];
        for(int i = 0 ; i < a.length; i++){
            a[i] = new Random().nextBoolean() ? i : i+1;
        }
        System.out.println("a = " + JSONObject.toJSONString(a));

//        int value = a[new Random().nextInt(a.length)];
        int value = a[a.length - 1];
        System.out.println("value = " + value);
        System.out.println("result = " + findIndex(a , value));
    }

    /**
     * 查询最后一个等于给定value值的(默认为递增的数组)
     * @param a
     * @param value
     * @return -1代表没找到
     */
    public static int findIndex(int[] a, int value){
        if(a == null || a.length == 0){
            return -1;
        }

        int low = 0 ;
        int high = a.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            System.out.println("low = " + low + ",high = " + high + ",mid = " + mid);
            if(a[mid] == value){
                //代表中间元素等于value
                if(mid >= a.length - 1){
                    return  mid;
                }
                if(a[mid +1] > a[mid]){
                    return mid;
                }else {
                    low =  mid + 1;
                }
            }else if(a[mid] > value){
                high = mid - 1 ;
            }else{
                low =  mid + 1;
            }
        }
        return -1;
    }
}

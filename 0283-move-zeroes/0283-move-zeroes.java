import java.util.*;
class Solution {
    static void moveZeroes(int[] nums) {
        int n=nums.length;
        int l=0;
        for(int r=0;r<n;r++){
            if(nums[r]!=0){
                swap(nums,l,r);
                l++;
            }
        }
    }
    static void swap(int[]nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
    static void printArr(int[]nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            System.out.println(nums[i]);
        }
        System.out.println();
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt();
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Original Array:");
        printArr(nums);
        moveZeroes(nums);
        System.out.println("Sorted array:");
        printArr(nums);
    }
}
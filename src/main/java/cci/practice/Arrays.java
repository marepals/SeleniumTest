package cci.practice;

import org.apache.xpath.SourceTree;

import java.util.Scanner;

/**
 * Created by srikanth on 3/3/2016.
 */
public class Arrays {


    public static void main( String[] args) {
        Scanner scan = new Scanner(System.in);
 /*       int[] numbers = {1,3,4,6,7,9};
        int input = 11;
        BinarySearch(numbers, input);

        System.out.println("Enter 6 numbers for the array");
        for(int i = 0; i<numbers.length;i++) {
            numbers[i] = scan.nextInt();
        }
        System.out.println("Enter the number to search for - ");

        int input = scan.nextInt();
       */
        System.out.println(reverseWords("This is a test statement"));
        System.out.println(reverseWords("This is srikanth's test laptop. This contains all special characters as %, $, #, and who are you?"));
    }

    public static StringBuffer reverseWords( String input){

        String[] sentence = input.split(" ");
        StringBuffer reversedSentence = new StringBuffer();
        for (String word: sentence){
            char[] chars = reverseWord(word.toCharArray());
            reversedSentence.append(chars);
            reversedSentence.append(' ');
        }
        reversedSentence.trimToSize();
        return reversedSentence;
    }

    public static char[] reverseWord(char[]  word){
        char temp;
        for(int i = 0; i<word.length/2; i ++){
            temp = word[i];
            word[i] = word[word.length-1-i];
            word[word.length-1-i] = temp;
        }
        return word;
    }

    static void BinarySearch (int[] numbers, int input) {
        int end = numbers.length - 1;
        int start = 0;
        int mid = (start + end) / 2;
        boolean found = false;

        while (start <= end) {
            if (numbers[mid] == input) {
                found = true;
                break;
            } else if (numbers[mid] > input) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        System.out.println("Number found ? = " + found);

        for (int j = 1; j < 10; j++) {
            if (j == 5) {
                break;
            } else
                System.out.println("number - " + j);

        }
    }

}

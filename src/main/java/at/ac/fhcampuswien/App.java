package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    //Task 1
    public static void oneMonthCalendar(int days, int startOfMonth){

        int currentDay = 1;
        int weekday = 1;

        do {
            System.out.print("   ");

            weekday++;
        }while(weekday < startOfMonth);

        while(currentDay<=days)
        {
            //if (weekday!=1)System.out.print(" ");



            if (currentDay<10)System.out.print(" ");

            System.out.print(currentDay+" ");
            currentDay++;

            if (weekday==7)
            {
                System.out.println();
                weekday=1;
            }else weekday++;
        }
        if (weekday!=1)System.out.println();
    }
    //Task 2
    public static long[] lcg(long seed){

        long[] randAr = new long[10];


        long m =(long) Math.pow(2,31);
        long a = 1103515245;
        long c = 12345;

        randAr[0]= (a * seed + c)%m;

        for (int i = 0; i <= 8; i++) {
            randAr[i+1]= (randAr[i]*a+c)%m;
        }
        return randAr;
    }

    //Task 3
    public static void guessingGame(int numberToGuess)
    {
        Scanner scan =  new Scanner(System.in);
        int input;
        boolean lose=true;

        for (int i = 0; i < 10; i++) {
            System.out.print("Guess number "+(i+1)+": ");
            input = scan.nextInt();
            if (i==9) break;
            if (input<numberToGuess) System.out.println("The number AI picked is higher than your guess.");
            else if (input>numberToGuess) System.out.println("The number AI picked is lower than your guess.");
            else
            {
                System.out.println("You won wisenheimer!");
                lose=false;
                break;
            }
        }
        if(lose)System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random rand =new Random();
        return rand.nextInt(1,100);

    }



    //Task 4
    public static boolean swapArrays(int[] array1, int[] array2)
    {
        if (array1.length!=array2.length) return false;
        int store;
        for (int i=0;i< array1.length;i++) {
            store=array1[i];
            array1[i]=array2[i];
            array2[i]=store;
        }
        return true;
    }


    //Task 5
    public static String camelCase(String eingabe){
        char[] inArr = eingabe.toCharArray();

        char[] outArr = new char[inArr.length];

        String outString="";

        int outLength=0;
        boolean oldBlanck=true;

        for (int i = 0; i < inArr.length; i++) {

            if (inArr[i]==' ')oldBlanck=true;

            if (inArr[i]>='A'&&inArr[i]<='Z')
            {
                if (oldBlanck)outArr[outLength]=inArr[i];
                else outArr[outLength]=(char)((int)inArr[i]+32);
                oldBlanck=false;
                outLength++;
            }
            if (inArr[i]>='a'&&inArr[i]<='z') {
                if (oldBlanck) outArr[outLength]=(char)((int)inArr[i]-32);
                    else outArr[outLength]=inArr[i];
                oldBlanck=false;
                outLength++;
            }
        }
        //outString = String.valueOf(outArr);

        for (int i = 0; i < outLength; i++) {
           outString=outString + outArr[i];
        }
        return outString;
    }

    //Task 6
    public static int checkDigit(int[] input)
    {
        int sum=0;


        for (int i=0;i< input.length;i++)
        {
               sum+= input[i]*(i+2);
        }

        sum = sum % 11;
        sum = 11-sum;

        if (sum==10)return 0;
        else if (sum==11)return 5;
        return sum;

    }




    // Implement all methods as public static

    public static void main(String[] args) {



        System.out.println(camelCase("asdfs'Adsf fgh?"));

        int[] intArr = {1,2,3,4,5};
        checkDigit(intArr);

        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}
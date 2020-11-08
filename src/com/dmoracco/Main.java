package com.dmoracco;
import static com.dmoracco.GetCpuTime.getCpuTime;
import static com.dmoracco.IsPrime.isPrime;

public class Main {

    public static void main(String[] args) {
	// write your code

        long timeStampBefore;
        long timeStampAfter;

        // Do nothing
        timeStampBefore = getCpuTime();
        timeStampAfter = getCpuTime();

        System.out.println("Do Nothing Time: " + (timeStampAfter - timeStampBefore));

        // println
        timeStampBefore = getCpuTime();
        System.out.println("Absolutely not hello world");

        timeStampAfter = getCpuTime();

        System.out.println("Println Time: " + (timeStampAfter - timeStampBefore));

        // a terrible sexy prime finder, prime pairs that are 6 apart
        timeStampBefore = getCpuTime();
        for (int n = 1000; n > 8; n--){
            if (isPrime(n) && isPrime(n-6)){
                System.out.print("(" + n + "," + (n-6) + ") ");
            }
        }
        System.out.println("");
        timeStampAfter = getCpuTime();
        System.out.println("Sexy Prime Time: " + (timeStampAfter - timeStampBefore));

        int MAX_SIZE = 1000000000;
        long NL1 = 0;
        long NL2 = 0;
        long NL3 = 0;
        long temp = 0;

        System.out.printf("N\t\t\t\tSingle Loop\t\t\t\t\tDouble Loop\t\t\t\t\tTriple Loop\n");
        for (int ITERATION_SIZE = 100; ITERATION_SIZE < MAX_SIZE; ITERATION_SIZE = ITERATION_SIZE*2 ){

            // Single Nested Loop
            timeStampBefore = getCpuTime();
            for (int i = 1; i < ITERATION_SIZE; i++){
                temp = i * i;
            }
            timeStampAfter = getCpuTime();

            NL1 = timeStampAfter - timeStampBefore;

            // Double Nested Loop
            timeStampBefore = getCpuTime();
            for (int i = 1; i < ITERATION_SIZE; i++){
                for (int j = 1; j < ITERATION_SIZE; j++) {
                    temp = j * j;
                }
            }
            timeStampAfter = getCpuTime();

            NL2 = timeStampAfter - timeStampBefore;

            // Triple Nested Loop
            timeStampBefore = getCpuTime();
            for (int i = 1; i < ITERATION_SIZE; i++){
                for (int j = 1; j < ITERATION_SIZE; j++){
                    for (int k = 1; k < ITERATION_SIZE; k++){
                        temp = k * k;
                    }
                }
            }
            timeStampAfter = getCpuTime();

            NL3 = timeStampAfter - timeStampBefore;

            System.out.printf("%-8d\t\t%-15d\t\t\t\t%-15d\t\t\t\t%-15d\n", ITERATION_SIZE, NL1, NL2, NL3);
        }

    }
}

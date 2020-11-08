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

        int MAX_SIZE = Integer.MAX_VALUE;
        long maxTime = 200000000;
        long NL1 = -1;
        long NL2 = -1;
        long NL3 = -1;
        long temp = 0;

        boolean loopOne = true, loopTwo = true, loopThree = true;
        long lastNL1 = maxTime, lastNL2 = maxTime, lastNL3 = maxTime;

        String nl1Out, nl2Out, nl3Out;

        System.out.printf("\n\nN\t\t\t\tSingle Loop\t\t\t\t\tDouble Loop\t\t\t\t\tTriple Loop\n");
        for (int ITERATION_SIZE = 1; ITERATION_SIZE < MAX_SIZE; ITERATION_SIZE = ITERATION_SIZE*2 ){

            if (ITERATION_SIZE < 0) break;

            // Single Nested Loop
            if (loopOne){
                timeStampBefore = getCpuTime();
                for (int i = 1; i < ITERATION_SIZE; i++){
                    temp = (int) Math.sin(i);
                }
                timeStampAfter = getCpuTime();

                NL1 = (timeStampAfter - timeStampBefore)/1000;
                lastNL1 = NL1;
            }
            if (lastNL1 >= maxTime){
                loopOne = false;
                NL1 = -1;
            }

            // Double Nested Loop
            if (loopTwo){

                timeStampBefore = getCpuTime();
                for (int j = 1; j < ITERATION_SIZE; j++){
                    for (int k = 1; k < ITERATION_SIZE; k++) {
                        temp = (int) Math.sin(k);
                    }
                }
                timeStampAfter = getCpuTime();

                NL2 = (timeStampAfter - timeStampBefore)/1000;
                lastNL2 = NL2;
            }
            if (lastNL2 >= maxTime){
                loopTwo = false;
                NL2 = -1;
            }

            // Triple Nested Loop
            if (loopThree){

                timeStampBefore = getCpuTime();
                for (int l = 1; l < ITERATION_SIZE; l++){
                    for (int m = 1; m < ITERATION_SIZE; m++){
                        for (int n = 1; n < ITERATION_SIZE; n++){
                            temp = (int) Math.sin(n);
                        }
                    }
                }
                timeStampAfter = getCpuTime();

                NL3 = (timeStampAfter - timeStampBefore)/1000;
                lastNL3 = NL3;
            }
            if (lastNL3 >= maxTime){
                loopThree = false;
                NL3 = -1;
            }

            // NL formatting
            if (NL1 == -1){
                nl1Out = "na";
            } else {
                nl1Out = Long.toString(NL1);
            }
            if (NL2 == -1){
                nl2Out = "na";
            } else {
                nl2Out = Long.toString(NL2);
            }
            if (NL3 == -1){
                nl3Out = "na";
            } else {
                nl3Out = Long.toString(NL3);
            }


            System.out.printf("%-8d\t\t%-15s\t\t\t\t%-15s\t\t\t\t%-15s\n", ITERATION_SIZE, nl1Out, nl2Out, nl3Out);
        }

    }
}

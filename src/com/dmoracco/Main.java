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
        long lastNL1 = 1, lastNL2 = 1, lastNL3 = 1;
        long previousNL1 = 0, previousNL2 = 0, previousNL3 = 0 ;

        String nl1Out, nl2Out, nl3Out, nl1Ratio = "na", nl2Ratio = "na", nl3Ratio = "na";
;
        System.out.printf("\n\n %16s%-32s     %-32s     %-32s\nN", "", "Single Loop", "Double Loop", "Triple Loop");
        System.out.printf("%16s%-14s%-8s%-8s", "", "Time", "Ratio", "Ex.Ratio");
        System.out.printf("       %-14s%-8s%-8s", "Time", "Ratio", "Ex.Ratio");
        System.out.printf("       %-14s%-8s%-8s", "Time", "Ratio", "Ex.Ratio\n");
        for (int ITERATION_SIZE = 1; ITERATION_SIZE < MAX_SIZE; ITERATION_SIZE = ITERATION_SIZE*2 ){

            if (ITERATION_SIZE < 0) break;

            // Single Nested Loop
            if (lastNL1 >= maxTime){
                loopOne = false;
                NL1 = -1;
            }
            if (loopOne){
                timeStampBefore = getCpuTime();
                for (int i = 1; i < ITERATION_SIZE; i++){
                    temp = (int) Math.sin(i);
                }
                timeStampAfter = getCpuTime();

                NL1 = (timeStampAfter - timeStampBefore)/1000;
                previousNL1 = lastNL1;
                lastNL1 = NL1;
            }

            // Double Nested Loop
            if (lastNL2 >= maxTime){
                loopTwo = false;
                NL2 = -1;
            }
            if (loopTwo){

                timeStampBefore = getCpuTime();
                for (int j = 1; j < ITERATION_SIZE; j++){
                    for (int k = 1; k < ITERATION_SIZE; k++) {
                        temp = (int) Math.sin(k);
                    }
                }
                timeStampAfter = getCpuTime();

                NL2 = (timeStampAfter - timeStampBefore)/1000;
                previousNL2 = lastNL2;
                lastNL2 = NL2;
            }

            // Triple Nested Loop
            if (lastNL3 >= maxTime){
                loopThree = false;
                NL3 = -1;
            }
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
                previousNL3 = lastNL3;
                lastNL3 = NL3;
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
            //Ratio Formatting
            if (ITERATION_SIZE > 1){
                if (NL1 > -1 && previousNL1 != 0){
                    nl1Ratio = String.format("%2.2f", (double)lastNL1/previousNL1);
                } else {
                    nl1Ratio = "na";
                }
                if (NL2 > -1 && previousNL2 != 0){
                    nl2Ratio = String.format("%2.2f", ((double)lastNL2/previousNL2));
                } else {
                    nl2Ratio = "na";
                }
                if (NL3 > -1 && previousNL3 != 0){
                    nl3Ratio = String.format("%2.2f", ((double)lastNL3/previousNL3));
                } else {
                    nl3Ratio = "na";
                }
            }


            System.out.printf("%-10d%7s%-14s%-8s%-10s     %-14s%-8s%-10s     %-14s%-8s%-10s\n", ITERATION_SIZE,"",
                    nl1Out, nl1Ratio, "~2" ,
                    nl2Out, nl2Ratio, "~4" ,
                    nl3Out, nl3Ratio, "~8");
        }

    }
}

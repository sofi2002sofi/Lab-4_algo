package ua.lviv.iot.fantz;

import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {

        String binaryString = FantzManager.readBinaryString("input"); 
        int number = FantzManager.readNumber("input");
        int maxLength = binaryString.length();
        int minSplits;

        if(number == 1) {
            minSplits = maxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < maxLength; ++binaryStringIterator) {
                if(binaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(maxLength, binaryNumbers, number);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, binaryString, maxLength);
        }
        FantzManager.writeMaxSumOfExperince("output", minSplits);
    }

}

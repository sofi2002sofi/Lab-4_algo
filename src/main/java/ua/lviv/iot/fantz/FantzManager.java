package ua.lviv.iot.fantz;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FantzManager {
    
    public static HashMap<Integer, String> generateNumberInDegrees(int maxLength, HashMap<Integer, String> binaryNumbers, int number) {
        long numberInDegree = 1;
        String binaryNumberInDegree = Long.toBinaryString(numberInDegree);
        int binStepLength = binaryNumberInDegree.length();
        
        while(binStepLength <= maxLength) {
            
            binaryNumbers.put(binStepLength, binaryNumberInDegree);
            
            if((Long.MAX_VALUE/number) < numberInDegree) {
                break;
            }
            
            numberInDegree = numberInDegree*number;
            binaryNumberInDegree = Long.toBinaryString(numberInDegree);
            binStepLength = binaryNumberInDegree.length();
        }
        return binaryNumbers;
    }

    public static int countMinSplits(HashMap<Integer, String> binaryNumbers, HashMap<Integer, Integer> memoizedSplits, String binaryString, int maxLength) {
        for(int substringIterator = 0; substringIterator < maxLength; ++substringIterator) {
            String comparablePart = binaryString.substring(maxLength - (substringIterator + 1));
            int comparablePartLength = comparablePart.length();
            
            if (comparablePart.substring(0, 1).equals("0")) {
                continue;
            }
            
            if(binaryNumbers.containsKey(comparablePartLength) && binaryNumbers.get(comparablePartLength).equals(comparablePart)) {
                memoizedSplits.put(comparablePartLength, 1);
            }
            
            for(int substringOfSubstringIterator = 0; substringOfSubstringIterator < comparablePartLength; ++substringOfSubstringIterator) {
                int existedSubstringLength = comparablePart.substring(comparablePartLength - (substringOfSubstringIterator + 1)).length();
                String restPart = comparablePart.substring(0, comparablePartLength - existedSubstringLength);
                int restLength = restPart.length();

                if(memoizedSplits.containsKey(existedSubstringLength) && !memoizedSplits.get(existedSubstringLength).equals(-1) 
                        && binaryNumbers.containsKey(restLength) && binaryNumbers.get(restLength).equals(restPart) 
                        && (!memoizedSplits.containsKey(comparablePartLength) || (memoizedSplits.containsKey(comparablePartLength) 
                                && memoizedSplits.get(comparablePartLength)>(memoizedSplits.get(existedSubstringLength) + 1)))) {
                       memoizedSplits.put(comparablePartLength, memoizedSplits.get(existedSubstringLength) + 1);
                } 
            }
            
            if(!memoizedSplits.containsKey(comparablePartLength)) {
                memoizedSplits.put(comparablePartLength, -1);                
            }
            
        }
        return memoizedSplits.get(maxLength);
    }
    
    public static void writeMaxSumOfExperince(String output, int minSplits) {
        try {
            FileWriter myWriter = new FileWriter(output);
            myWriter.write(String.valueOf(minSplits));
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }       
    }
    
    public static String readBinaryString(String fileName) {
        String binaryString = null;
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
        
            binaryString = br.readLine(); 

        
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return binaryString;
    }
    
    public static int readNumber(String fileName) {
        int number = 0;
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
            br.readLine();
            number = Integer.parseInt(br.readLine()); 
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return number;
    }

}

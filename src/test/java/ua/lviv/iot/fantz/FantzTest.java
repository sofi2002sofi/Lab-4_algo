package ua.lviv.iot.fantz;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class FantzTest {
    String firstBinaryString = "100111011110100100111110110011100101000111100101110010001100111011110100100111110110011100101000110010110000111100101110010001";
    String secondBinaryString = "101101101";
    String thirdBinaryString = "1111101";
    String forthBinaryString = "110011011";
    String fifthBinaryString = "1111111111";
    String sixthBinaryString = "110011011";
    
    int firstMaxLength = firstBinaryString.length();
    int secondMaxLength = secondBinaryString.length();
    int thirdMaxLength = thirdBinaryString.length();
    int forthMaxLength = forthBinaryString.length();
    int fifthMaxLength = fifthBinaryString.length();
    int sixthMaxLength = sixthBinaryString.length();

    int firstNumber = 7;
    int secondNumber = 5;
    int thirdNumber = 1;
    int forthNumber = 3;
    
    @Test
    public void testFirstBinaryString() {
        int expectedMinStplits = 5;
        int minSplits;

        if(firstNumber == 1) {
            minSplits = firstMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < firstMaxLength; ++binaryStringIterator) {
                if(firstBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(firstMaxLength, binaryNumbers, firstNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, firstBinaryString, firstMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }
    
    @Test
    public void testSecondBinaryString() {
        int expectedMinStplits = 3;
        int minSplits;

        if(secondNumber == 1) {
            minSplits = secondMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < secondMaxLength; ++binaryStringIterator) {
                if(secondBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(secondMaxLength, binaryNumbers, secondNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, secondBinaryString, secondMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }
    
    @Test
    public void testThirdBinaryString() {
        int expectedMinStplits = 1;
        int minSplits;

        if(secondNumber == 1) {
            minSplits = thirdMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < thirdMaxLength; ++binaryStringIterator) {
                if(thirdBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(thirdMaxLength, binaryNumbers, secondNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, thirdBinaryString, thirdMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }
    
    @Test
    public void testForthBinaryString() {
        int expectedMinStplits = 3;
        int minSplits;

        if(secondNumber == 1) {
            minSplits = forthMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < forthMaxLength; ++binaryStringIterator) {
                if(forthBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(forthMaxLength, binaryNumbers, secondNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, forthBinaryString, forthMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }
    
    @Test
    public void testFifthBinaryString() {
        int expectedMinStplits = 10;
        int minSplits;

        if(thirdNumber == 1) {
            minSplits = fifthMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < fifthMaxLength; ++binaryStringIterator) {
                if(fifthBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(fifthMaxLength, binaryNumbers, thirdNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, fifthBinaryString, fifthMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }

    @Test
    public void testSixthBinaryString() {
        int expectedMinStplits = 5;
        int minSplits;

        if(forthNumber == 1) {
            minSplits = fifthMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < fifthMaxLength; ++binaryStringIterator) {
                if(fifthBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(fifthMaxLength, binaryNumbers, forthNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, fifthBinaryString, fifthMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }

    @Test
    public void testSeventhBinaryString() {
        int expectedMinStplits = -1;
        int minSplits;

        if(thirdNumber == 1) {
            minSplits = sixthMaxLength;
            for(int binaryStringIterator = 0; binaryStringIterator < sixthMaxLength; ++binaryStringIterator) {
                if(sixthBinaryString.substring(binaryStringIterator, binaryStringIterator + 1).equals("0")) {
                    minSplits=-1;
                    break;
                }
            }
        } else {
            HashMap<Integer, String> binaryNumbers = new HashMap<Integer, String>();
            HashMap<Integer, Integer> memoizedSplits = new HashMap<Integer, Integer>();
            
            binaryNumbers = FantzManager.generateNumberInDegrees(sixthMaxLength, binaryNumbers, thirdNumber);
            minSplits = FantzManager.countMinSplits(binaryNumbers, memoizedSplits, sixthBinaryString, sixthMaxLength);
        }
        
        assertEquals(expectedMinStplits, minSplits);
        
    }

}

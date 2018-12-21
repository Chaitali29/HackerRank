import java.io.*;

public class MainReader {

    public static void main(String args[]){
        final int sizeOfArray ;
        final int numberOfRotations;
        final Solver  solve = new Solver();
        InputReader ir = new InputReader(new DataInputStream(System.in));
        StringBuilder s = new StringBuilder();
        sizeOfArray = ir.readInt();
        numberOfRotations = ir.readInt();
        int[] arrayOfIntegers = new int [sizeOfArray];
        for(int i=0;i<sizeOfArray;i++){
            arrayOfIntegers[i] = ir.readInt();
        }
        int result[] = solve.solve(sizeOfArray,numberOfRotations,arrayOfIntegers);
        for(int i=0;i<sizeOfArray;i++){
            s.append(result[i]+ " ");
        }
        System.out.println(s);
    }
}

class Solver{
    // write the code to be solved here

    public int[]solve(int sizeOfArray ,int numberOfRotations , int [] arrayOfIntegers){

        int[] arrayOfIntegersAfterRotation = new int [sizeOfArray];

        final int indexToBePlacedAtBeginning = numberOfRotations % sizeOfArray ;
        if(indexToBePlacedAtBeginning !=0){
            int j =0;
            for(int i = indexToBePlacedAtBeginning ;i<sizeOfArray;i++){
                arrayOfIntegersAfterRotation[j] =arrayOfIntegers[i];
                j++;
            }
            for(int i = 0; i<indexToBePlacedAtBeginning;i++){
                arrayOfIntegersAfterRotation[j] =arrayOfIntegers[i];
                j++;
            }
            return arrayOfIntegersAfterRotation;
        }
        else{
            return arrayOfIntegers;
        }

    }
}
class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do {
            stringBuilder.append(c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}

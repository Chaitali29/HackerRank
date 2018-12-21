import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainReaderTest {
    int[] arrayToPerformRotation = {1,2,3,4,5};
    String expectedResult ="5 1 2 3 4 ";
    StringBuilder actualResult = new StringBuilder();
    @Test
    public void test(){
        //System.out.println(new Solver().solve(5,4,arrayToPerformRotation));
        int resultArray[] = new Solver().solve(5,4,arrayToPerformRotation);
        for(int i=0;i<5;i++){
            actualResult.append(resultArray[i]+ " ");
        }
       assertEquals(expectedResult,actualResult.toString());
    }


}

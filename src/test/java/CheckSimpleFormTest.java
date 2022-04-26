import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

public class CheckSimpleFormTest {


    @BeforeEach
    public void runBefore(){
        System.out.println("Run before Each test");
    }
    @RepeatedTest(3)
        @ParameterizedTest
    public void CheckMyForm(RepetitionInfo info){
    }
    }

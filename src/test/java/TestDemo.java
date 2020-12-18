import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {

    @Test
    public void testPrint() {
        String hello = "Hello";
        Assert.assertEquals(hello, "Hello");
    }
}

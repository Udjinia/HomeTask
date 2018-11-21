import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a=getLocalNumber();
        Assert.assertTrue("Value ("+a+")is not equal 14",a==14 );
    }

}

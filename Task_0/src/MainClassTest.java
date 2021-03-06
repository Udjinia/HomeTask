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

    @Test
    public void testGetClassNumber()
    {
        int a=getClassNumber();
        Assert.assertTrue("Value ("+a+") is less than 45",a > 45 );
    }

    @Test
    public void testGetClassString()
    {
        String a=getClassString();
        Assert.assertTrue("Text is not contain Hello word",a.contains("hello") || a.contains("Hello"));
    }

}

public class MainClass {

//Test_1
    public int getLocalNumber ()
    {
        return 14;
    }
//Test_2

    public int getClassNumber()
    {
        return this.class_number();
    }

    private int class_number()
    {
        return 20;
    }


    //Test_3
    public String getClassString()
    {
        return this.class_string();
    }

    private String  class_string ()
    {
        return "Hello, world";
    }
}

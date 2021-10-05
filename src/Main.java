class Slogan
{
    private String phrase;
    private static int count = 0;

    public Slogan (String str)
    {
        phrase = str;
        count++;
    }
    public String toString()
    {
        return phrase;
    }
    public static int getCount()
    {
        return count;
    }
}
public class Main
{
    public static void main (String[] args)
    {
        Slogan obj;
        obj = new Slogan("Remember the Almo.");
        System.out.println(obj);

        obj = new Slogan("Don't Worry. Be Happy.");
        System.out.println(obj);

        obj = new Slogan("Live Free or Die.");
        System.out.println(obj);

        System.out.println();
        System.out.println("Slogans created:" + Slogan.getCount());

        return;
    }
}
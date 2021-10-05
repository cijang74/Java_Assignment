import java.util.Scanner;

class TV
{
    public final boolean ON = true;
    public final boolean OFF = false;

    private boolean power;
    private int channel;
    private int volume;

    public TV()
    {
        this.power = OFF;
        this.channel = 100;
        this.volume = 10;
    }

    public String clickPower()
    {
        if(this.power == OFF)
        {
            this.power = ON;
            return "전원을 켭니다";
        }
        else
        {
            this.power = OFF;
            return "전원을 끕니다";
        }
    }

    public String clickUp()
    {
        return "현재 채널은" + (++this.channel) + "번입니다.";
    }

    public String clickDown()
    {
        return "현재 채널은" + (--this.channel) + "번입니다.";
    }

    public String clickLeft()
    {
        return "현재 음량은" + (--this.volume) + "입니다.";
    }

    public String clickRight()
    {
        return "현재 음량은" + (++this.volume) + "입니다.";
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String result = "";

        TV tv = new TV();

        do
        {
            System.out.print("TV 리모콘의 상하좌우, 전원, 종료 중 하나를 입력하세요: ");
            result = scan.next();

            if(result.equals("전원"))
            {
                System.out.println(tv.clickPower());
            }
            else if (result.equals("상"))
            {
                System.out.println(tv.clickUp());
            }
            else if (result.equals("하"))
            {
                System.out.println(tv.clickDown());
            }
            else if (result.equals("좌"))
            {
                System.out.println(tv.clickLeft());
            }
            else if (result.equals("우"))
            {
                System.out.println(tv.clickRight());
            }
        } while(!result.equals("종료"));
        return;
    }
}
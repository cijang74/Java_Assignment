import java.util.Scanner;

class AirConditioner
{
    public final boolean ON = true;
    public final boolean OFF = false;

    private boolean power;
    private int temperature;
    private int windStrength;

    public AirConditioner()
    {
        this.power = OFF;
        this.temperature = 18;
        this.windStrength = 10;
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
        return "현재 온도는" + (++this.temperature) + "도입니다.";
    }

    public String clickDown()
    {
        return "현재 온도는" + (--this.temperature) + "도입니다.";
    }

    public String clickLeft()
    {
        return "현재 풍량은" + (--this.windStrength) + "입니다.";
    }

    public String clickRight()
    {
        return "현재 풍량은" + (++this.windStrength) + "입니다.";
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String result = "";

        AirConditioner aircon = new AirConditioner();

        do
        {
            System.out.print("에어컨 리모콘의 상하좌우, 전원, 종료 중 하나를 입력하세요: ");
            result = scan.next();

            if(result.equals("전원"))
            {
                System.out.println(aircon.clickPower());
            }
            else if (result.equals("상"))
            {
                System.out.println(aircon.clickUp());
            }
            else if (result.equals("하"))
            {
                System.out.println(aircon.clickDown());
            }
            else if (result.equals("좌"))
            {
                System.out.println(aircon.clickLeft());
            }
            else if (result.equals("우"))
            {
                System.out.println(aircon.clickRight());
            }
        } while(!result.equals("종료"));
        return;
    }
}
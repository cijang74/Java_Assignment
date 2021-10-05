import java.util.Scanner;

class RCCar
{
    public final boolean ON = true;
    public final boolean OFF = false;

    private boolean power;

    public RCCar()
    {
        this.power = OFF;
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
        return "직진합니다";
    }

    public String clickDown()
    {
        return "후진합니다";
    }

    public String clickLeft()
    {
        return "좌회전합니다";
    }

    public String clickRight()
    {
        return "우회전합니다";
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String result = "";

        RCCar rcCar = new RCCar();

        do
        {
            System.out.print("RC카 리모콘의 상하좌우, 전원, 종료 중 하나를 입력하세요: ");
            result = scan.next();

            if(result.equals("전원"))
            {
                System.out.println(rcCar.clickPower());
            }
            else if (result.equals("상"))
            {
                System.out.println(rcCar.clickUp());
            }
            else if (result.equals("하"))
            {
                System.out.println(rcCar.clickDown());
            }
            else if (result.equals("좌"))
            {
                System.out.println(rcCar.clickLeft());
            }
            else if (result.equals("우"))
            {
                System.out.println(rcCar.clickRight());
            }
        } while(!result.equals("종료"));
        return;
    }
}
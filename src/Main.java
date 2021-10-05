import java.util.Scanner;

class PCBang
{
    private boolean[] seat;
    private final  int MAX = 50; // 책 최대 개수는 50권
    private int basic_fee; // 기본 대여료
    private int[] ramen;
    private int ramen_basic_fee;

    public PCBang(int basic_fee, int ramen_basic_fee)
    {
        this.seat = new boolean[MAX]; // 책 대여 상태 초기화
        for(int i = 0; i < MAX; i++)
        {
            this.seat[i] = false;
        }
        this.basic_fee = basic_fee; // 기본 대여료 초기화

        this.ramen_basic_fee = ramen_basic_fee;
        this.ramen = new int[MAX];
        for (int i = 0; i < MAX; i++)
        {
            this.ramen[i] = 0;
        }
    }

    public  String requestRent(int id)
    {
        if ((0<id)&&(id<MAX) && (this.seat[id] == false))
        {
            this.seat[id] = true;
            return "자리" + id + "번 이용 신청 성공\n";
        }
        else
        {
            return "자리" + id + "번 이용 신청 실패\n";
        }
    }

    public String requestReturn(int id, int period, int money)
    {
        int fee = calculateFee(period, id);
        if((money - fee) < 0)
        {
            return "자리" + id +"번은 요금부족으로 신청 실패\n"
                    + "자리" + id + "번을"
                    + period + "시간(시간당" + this.ramen_basic_fee + "원) 이용하고, 라면을"
                    + this.ramen[id] + "개(개당" + this.ramen_basic_fee + "원)주문하여, 총 요금은"
                    + fee + "원입니다\n";
        }
        else if ((0<id) && (id < MAX) && (this.seat[id] == true))
        {
            this.seat[id] = false;
            return "자리" + id + "번 반납 성공\n"
                    + "자리 " + id + "번을 "
                    + period + "시간(시간당" + this.ramen_basic_fee +"원) 이용하고 라면을"
                    + this.ramen[id] + "개(개당" + this.ramen_basic_fee + "원)주문하여, 총 요금은"
                    + (money - fee) + "원입니다.\n";
        }
        else
        {
            return "자리" + id + "번은 미사용중으로 반납 실패\n";
        }
    }
    private int calculateFee(int period, int id)
    {
        return this.basic_fee * period + this.ramen[id] * this.ramen_basic_fee;
    }

    public String requestRamen(int id)
    {
        if((0<=id)&&(id <= MAX) && (this.seat[id] == true))
        {
            this.ramen[id]++;
            return "라면 주문 성공\n";
        }
        else
        {
            return "라면 주문 실패\n";
        }
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int id = 0, period = 0, money = 0;

        PCBang pcBang = new PCBang(1000, 3000);

        System.out.print("이용할 자리 ID를 입력하세요: ");
        id = scan.nextInt();
        System.out.print(pcBang.requestRent(id));
        System.out.print("라면 주문할 자리 ID를 입력하세요: ");
        id = scan.nextInt();
        System.out.print(pcBang.requestRamen(id));
        System.out.print("반납할 자리 ID를 입력하세요: ");
        id = scan.nextInt();
        System.out.print("이용 시간을 입력하세요: ");
        period = scan.nextInt();
        System.out.print("금액을 입력하세요: ");
        money = scan.nextInt();
        System.out.print(pcBang.requestReturn(id, period, money));
    }
}
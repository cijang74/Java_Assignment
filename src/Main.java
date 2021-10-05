import java.util.Scanner;

class Library
{
    private boolean[] book;
    private final  int MAX = 50; // 책 최대 개수는 50권
    private int basic_fee; // 기본 대여료

    public Library(int basic_fee)
    {
        this.book = new boolean[MAX]; // 책 대여 상태 초기화
        for(int i = 0; i < MAX; i++)
        {
            this.book[i] = false;
        }
        this.basic_fee = basic_fee; // 기본 대여료 초기화
    }

    public  String requestRent(int id)
    {
        if ((0<id)&&(id<MAX) && (this.book[id] == false))
        {
            this.book[id] = true;
            return "책" + id + "번 대여 성공\n";
        }
        else
        {
            return "책" + id + "번 대여 실패\n";
        }
    }

    public String requestReturn(int id, int period, int money)
    {
        int fee = calculateFee(period);
        if((money - fee) < 0)
        {
            return "책" + id +"번은 요금부족으로 반납 실패\n"
                    + "책" + id + "번을"
                    + period + "일간 대여하여, 요금은"
                    + fee + "원(=" + this.basic_fee + "원 * " + period + "일)입니다\n";
        }
        else if ((0<id) && (id < MAX) && (this.book[id] == true))
        {
            this.book[id] = false;
            return "책" + id + "번 반납 성공\n"
                    + "책 " + id + "번을 "
                    + period + "일간 대여하여, 요금은"
                    + fee + "원(=" + this.basic_fee + "원 * " + period + "일)이므로 거스름돈은"
                    + (money - fee) + "원입니다.\n";
        }
        else
        {
            return "책" + id + "번은 미사용중으로 반납 실패\n";
        }
    }
    private int calculateFee(int period)
    {
        return this.basic_fee * period;
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int id = 0, period = 0, money = 0;

        Library lib = new Library(500);

        System.out.print("대여할 책 ID를 입력하세요: ");
        id = scan.nextInt();
        System.out.print(lib.requestRent(id));
        System.out.print("반납할 책 ID를 입력하세요: ");
        id = scan.nextInt();
        System.out.print("책 대여 기간을 입력하세요: ");
        period = scan.nextInt();
        System.out.print("금액을 입력하세요: ");
        money = scan.nextInt();
        System.out.print(lib.requestReturn(id, period, money));
    }
}
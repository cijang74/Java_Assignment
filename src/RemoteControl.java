public interface RemoteControl
    // 리모트콘트롤의 상수값과 추상메서드
{
    public final boolean ON = true;
    public final boolean OFF = false;
    public void clickPower();
    public void clickUp();
    public void clickDown();
    public void clickLeft();
    public void clickRight();
}
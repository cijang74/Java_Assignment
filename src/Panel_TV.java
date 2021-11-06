import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TVPanel extends JPanel implements RemoteControl
// 해당 클레스에는 로고와 TV 볼륨 이미지와 버튼을 눌렀을 때 발생하는 이벤트들이 포함되어 있음
{
    private RemoteControlPanel rc;
    private boolean power;
    private int channel;
    private int volume;

    // 각 이미지들을 저장할 배열 선언
    private ImageIcon[] imgChannel;
    private ImageIcon[] imgVolume;

    // 각 라벨들을 저장할 변수 선언
    private JLabel IbIChannel;
    private JLabel IbIVolume;

    public TVPanel()
    {
        rc = new RemoteControlPanel(this); // 버튼 이미지와 리스너가 포함된 RemoteControl 객체를 생성
        power = OFF;
        channel = 0;
        volume = 0;

        final String[] channel = {"EBS.gif", "SBS.gif", "KBS.gif", "MBC.gif", "blank.png"}; // 이미지 이름 상수처리
        imgChannel = new ImageIcon[channel.length]; // 5칸만큼 배열객체 생성하여 imgChannel 변수에 저장

        for(int i = 0; i < channel.length; i++) // 이미지 삽입하는 반복문
        {
            imgChannel[i] = new ImageIcon((new ImageIcon(rc.imgPath + channel[i])
                    .getImage().getScaledInstance(250,120,Image.SCALE_SMOOTH)));
            // Image.SCALE_SMOOTH는 속도는 느리지만 이미지를 부드럽게 해줌
        }

        final String[] volume = {"volume0.gif", "volume1.gif", "volume2.gif", "volume3.gif"};
        imgVolume = new ImageIcon[volume.length];

        for(int i = 0; i < volume.length; i++)
        {
            imgVolume[i] = new ImageIcon(new ImageIcon(rc.imgPath + volume[i])
                    .getImage().getScaledInstance(80,120,Image.SCALE_SMOOTH));
        }

        // 각 라벨 객체 생성하여 변수에 저장
        IbIChannel = new JLabel(imgChannel[channel.length-1]);
        IbIVolume = new JLabel(imgVolume[0]);

        // 패널에 추가
        add(rc);
        add(IbIChannel);
        add(IbIVolume);
    }

    public void clickPower()
            // 전원을 눌렀을 때
    {
        if (power == OFF) // 꺼져있으면
        {
            power = ON;
            channel = 0;
            volume = 1;
            IbIChannel.setIcon(imgChannel[channel]);
            IbIVolume.setIcon(imgVolume[volume]);
        }

        else
        {
            power = OFF; // 켜져있으면
            channel = imgChannel.length - 1;
            volume = 0;
            IbIChannel.setIcon(imgChannel[channel]);
            IbIVolume.setIcon(imgVolume[volume]);
        }
    }

    public void clickUp ()
            // 위 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            channel = (channel + 1) % (imgChannel.length - 1); // 계속 버튼 누르면 값이 무한히 커지니까 나머지값 이용
            IbIChannel.setIcon(imgChannel[channel]);
        }
    }

    public void clickDown ()
            // 아래 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            channel = (channel + (imgChannel.length - 2)) % (imgChannel.length - 1);
            IbIChannel.setIcon(imgChannel[channel]);
        }
    }

    public void clickLeft ()
            // 왼쪽 버튼을 눌렀을 때
    {
        if (power == ON)
        {
            volume = (volume + (imgVolume.length - 1)) % imgVolume.length;
            IbIVolume.setIcon(imgVolume[volume]);
        }
    }

    public void clickRight ()
    {
        if (power == ON)
        {
            volume = (volume + 1) % imgVolume.length;
            IbIVolume.setIcon(imgVolume[volume]);
        }
    }
}

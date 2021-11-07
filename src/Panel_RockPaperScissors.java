import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

class RockPaperScissorsPanel extends JPanel
    // RockPaperScissorsPanel는 JPpanel을 상속받는다
{
    // 변수 선언
    private RockPaperScissors game;
    private JLabel IbIPlayerA;
    private JLabel IbIPlayerB;

    // 상수 선언
    private final int BASE = 0;
    private final int WIN = 1;

    // 배열 선언
    private JButton[] btn;
    private ImageIcon[][] img;

    public RockPaperScissorsPanel()
    {
     ButtonListener  buttonListener = new ButtonListener(); // 버튼리스너 객체 생성
     game = new RockPaperScissors_Lose(); // 지는 가위바위보를 게임으로 설정하여 객체 생성

     // 이미지 불러와서 변수에 저장
     final String imagePath = "C:\\Users\\cijan\\Downloads\\JL06\\img\\";
     final String PathImgScissors = imagePath + "scissors.gif";
     final String PathImgRock = imagePath + "rock.gif";
     final String PathImgPaper = imagePath + "paper.gif";
     final String PathImgScissorsWin = imagePath + "scissors_win.gif";
     final String PathImgRockWin = imagePath + "rock_win.gif";
     final String PathImgPaperWin = imagePath + "paper_win.gif";

     // 3행 2열만큼의 각 이미지들을 저장시킬 배열 객체 생성 후 img에 저장
     img = new ImageIcon[3][2];

     // 각 이미지들을 GUI에 쓸 수 있는 아이콘화 하여 배열에 저장시킴
     // game.SCISSORS = 2, game.PAPER = 1, game.ROCK = 0, BASE = 0, WIN = 1
     img[game.SCISSORS][BASE] = new ImageIcon(new ImageIcon(PathImgScissors).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
     img[game.ROCK][BASE] = new ImageIcon(new ImageIcon(PathImgRock).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
     img[game.PAPER][BASE] = new ImageIcon(new ImageIcon(PathImgPaper).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
     img[game.SCISSORS][WIN] = new ImageIcon(new ImageIcon(PathImgScissorsWin).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
     img[game.ROCK][WIN] = new ImageIcon(new ImageIcon(PathImgRockWin).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
     img[game.PAPER][WIN] = new ImageIcon(new ImageIcon(PathImgPaperWin).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

     // 버튼을 저장시킬 btn 3칸 만큼의 배열 객체 생성 후 btn에 저장
     btn = new JButton[3];

     // 이미지가 적용된 각 버튼을 배열에 저장시키고 buttonListener을 액션 리스너로 적용시킴
     btn[game.SCISSORS] = new JButton(new ImageIcon(img[game.SCISSORS][BASE].getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
     btn[game.SCISSORS].addActionListener(buttonListener);
     btn[game.ROCK] = new JButton(new ImageIcon(img[game.ROCK][BASE].getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
     btn[game.ROCK].addActionListener(buttonListener);
     btn[game.PAPER] = new JButton(new ImageIcon(img[game.PAPER][BASE].getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
     btn[game.PAPER].addActionListener(buttonListener);

     // 가위와 바위를 default 이미지로 설정한 라벨객체를 각 변수에 저장
     this.IbIPlayerA = new JLabel(img[game.ROCK][BASE]);
     this.IbIPlayerB = new JLabel(img[game.ROCK][BASE]);

     // 각 컴포넌트를 패널에 추가
     this.add(this.IbIPlayerB);
     this.add(new JLabel("                      너                       "));
     this.add(new JLabel("                      나                       "));
     this.add(this.IbIPlayerA);
     this.add(new JLabel("  가위 바위 보를 선택하세요  " ));
     this.add(btn[game.SCISSORS]);
     this.add(btn[game.ROCK]);
     this.add(btn[game.PAPER]);

     // 배경색과 패널 크기 설정
     this.setBackground(Color.CYAN);
     this.setPreferredSize(new Dimension(220, 550));
    }

    private class ButtonListener implements ActionListener
        // 버튼을 클릭했을 때 발생되는 이벤트들을 관리하는 클래스
    {
        public void actionPerformed(ActionEvent event)
        {
            String strplayerA = ""; // 플레이어가 어떤 선택을 했는지 구별하기 위한 변수

            // 가변배열 선언
            // game.SCISSORS = 2, game.PAPER = 1, game.ROCK = 0, BASE = 0, WIN = 1
            int[] playerA = {game.SCISSORS, BASE}; // => playerA[0] = 2, player[1] = 0
            int[] playerB = {game.SCISSORS, BASE};

            if(event.getSource() == btn[game.SCISSORS]) // 사용자가 가위 버튼을 눌렀다면
            {
                strplayerA = "가위";
                playerA[0] = game.SCISSORS;
            }

            else if(event.getSource() == btn[game.ROCK])
            {
                strplayerA = "바위";
                playerA[0] = game.ROCK;
            }

            else
            {
                strplayerA = "보";
                playerA[0] = game.PAPER;
            }

            // 플레이어 A와 플레이어B가 각각 가위바위보를 선택하도록 하는 메서드
            String result = game.play(strplayerA);

            // 플레이어 B가 어떤 선택을 했는지에 따라 playerB[0]의 값을 수정
            if (result.contains("플레이어 B는 가위"))
            {
                playerB[0] = game.SCISSORS;
            }

            else if (result.contains("플레이어 B는 바위"))
            {
                playerB[0] = game.ROCK;
            }

            else
            {
                playerB[0] = game.PAPER;
            }

            if (result.contains("플레이어 A가 이겼습니다"))
            {
                playerA[1] = WIN;
            }

            else if (result.contains("플레이어 B가 이겼습니다"))
            {
                playerB[1] = WIN;
            }

            else // 비겼을 떄의 경우
            {
                playerA[1] = BASE;
                playerB[1] = BASE;
            }

            // 판정 결과를 바탕으로 아이콘 설정
            IbIPlayerA.setIcon(img[playerA[0]] [playerA[1]]);
            IbIPlayerB.setIcon(img[playerB[0]] [playerB[1]]);
        }
    }
}

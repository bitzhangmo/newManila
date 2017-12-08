package manila.viewTry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView frame = new MainView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainView() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1498, 740);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		/*右上方显示当前玩家头像*/
        JLabel playerIco = new JLabel("");
        playerIco.setIcon(new ImageIcon("images\\player1Ico2.png"));
        playerIco.setBounds(1335, 72, 116, 116);
        contentPane.add(playerIco);

		/*右侧第一个按钮显示当前玩家姓名*/
        JLabel playerName = new JLabel("");
        playerName.setIcon(new ImageIcon("images\\palyer1Name2.PNG"));
        playerName.setBounds(1348, 269, 93, 28);
        contentPane.add(playerName);

		/*黑市弹窗*/
        JPanel darkPn = new JPanel();
        darkPn.setBounds(327, 0, 834, 700);
        contentPane.add(darkPn);
        darkPn.setLayout(null);
        darkPn.setVisible(false);

		/*货物价格实时改变*/
        JLabel price1 = new JLabel("");
        price1.setBounds(482, 287, 80, 30);
        darkPn.add(price1);

        JLabel price2 = new JLabel("");
        price2.setBounds(482, 330, 80, 30);
        darkPn.add(price2);

        JLabel price3 = new JLabel("");
        price3.setBounds(482, 375, 80, 30);
        darkPn.add(price3);

        JLabel price4 = new JLabel("");
        price4.setBounds(482, 416, 80, 30);
        darkPn.add(price4);

        JLabel darkBg = new JLabel("");
        darkBg.setIcon(new ImageIcon("images\\darkBg.png"));
        darkBg.setBounds(235, 176, 468, 328);
        darkPn.add(darkBg);

        JLabel darkPnBg = new JLabel("");
        darkPnBg.setIcon(new ImageIcon("images\\infoJpBg.png"));
        darkPnBg.setBounds(0, 0, 834, 700);
        darkPn.add(darkPnBg);

		/*资产弹窗*/
        JPanel moneyPn = new JPanel();
        moneyPn.setBounds(327, 0, 834, 700);
        contentPane.add(moneyPn);
        moneyPn.setLayout(null);
        moneyPn.setVisible(false);

		/*现金实时改变*/
        JLabel moneyLb = new JLabel("");
        moneyLb.setBounds(447, 298, 170, 30);
        moneyPn.add(moneyLb);

		/*所持股份实时改变*/
        JLabel stockLb = new JLabel("");
        stockLb.setIcon(new ImageIcon("images\\stock1.PNG"));
        stockLb.setBounds(425, 359, 175, 50);
        moneyPn.add(stockLb);

        JLabel moneyBg = new JLabel("");
        moneyBg.setIcon(new ImageIcon("images\\moneyBg.png"));
        moneyBg.setBounds(235, 176, 468, 328);
        moneyPn.add(moneyBg);

        JLabel moneyPnBg = new JLabel("");
        moneyPnBg.setIcon(new ImageIcon("images\\infoJpBg.png"));
        moneyPnBg.setBounds(0, 0, 834, 700);
        moneyPn.add(moneyPnBg);


		/*同伙弹窗*/
        JPanel partPn = new JPanel();
        partPn.setBounds(327, 0, 834, 700);
        contentPane.add(partPn);
        partPn.setLayout(null);
        partPn.setVisible(false);

		/*同伙状态实时改变*/
        JLabel state1 = new JLabel("");
        state1.setIcon(new ImageIcon("images\\state0.PNG"));
        state1.setBounds(290, 329, 200, 50);
        partPn.add(state1);

        JLabel state2 = new JLabel("");
        state2.setIcon(new ImageIcon("images\\state0.PNG"));
        state2.setBounds(290, 379, 200, 50);
        partPn.add(state2);

        JLabel state3 = new JLabel("");
        state3.setIcon(new ImageIcon("images\\state0.PNG"));
        state3.setBounds(290, 428, 200, 50);
        partPn.add(state3);

		/*在该同伙身上投入的钱实时改变*/
        JLabel invest1 = new JLabel("");
        invest1.setBounds(500, 338, 80, 30);
        partPn.add(invest1);

		/*该同伙为玩家带来的利润实时改变*/
        JLabel profit1 = new JLabel("");
        profit1.setBounds(623, 338, 80, 30);
        partPn.add(profit1);

        JLabel invest2 = new JLabel("");
        invest2.setBounds(496, 393, 81, 30);
        partPn.add(invest2);

        JLabel profit2 = new JLabel("");
        profit2.setBounds(623, 393, 80, 30);
        partPn.add(profit2);

        JLabel invest3 = new JLabel("");
        invest3.setBounds(496, 440, 80, 30);
        partPn.add(invest3);

        JLabel profit3 = new JLabel("");
        profit3.setBounds(623, 440, 80, 30);
        partPn.add(profit3);

        JLabel partBg = new JLabel("");
        partBg.setIcon(new ImageIcon("images\\partBg.png"));
        partBg.setBounds(142, 135, 655, 438);
        partPn.add(partBg);

        JLabel partPnBg = new JLabel("");
        partPnBg.setIcon(new ImageIcon("images\\infoJpBg.png"));
        partPnBg.setBounds(0, 0, 834, 700);
        partPn.add(partPnBg);

		/*放置同伙弹窗*/
        JPanel sitPn = new JPanel();
        sitPn.setBounds(542, 166, 507, 359);
        contentPane.add(sitPn);
        sitPn.setLayout(null);
        sitPn.setVisible(false);

		/*“放置地点”标识根据选中地点种类不同而改变*/
        JLabel placeName = new JLabel("");
        placeName.setIcon(new ImageIcon("images\\placeName0.PNG"));
        placeName.setBounds(142, 43, 200, 50);
        sitPn.add(placeName);

		/*可放置位置的多少根据地点种类而改变*/
        JLabel sitPlace1 = new JLabel("");
        sitPlace1.setIcon(new ImageIcon("images\\sitPlace1.png"));
        sitPlace1.setBounds(37, 88, 409, 68);
        sitPn.add(sitPlace1);

        JLabel sitPlace2 = new JLabel("");
        sitPlace2.setIcon(new ImageIcon("images\\sitPlace2.png"));
        sitPlace2.setBounds(37, 137, 409, 68);
        sitPn.add(sitPlace2);

        JLabel sitPlace3 = new JLabel("");
        sitPlace3.setIcon(new ImageIcon("images\\sitPlace3.png"));
        sitPlace3.setBounds(37, 186, 409, 68);
        sitPn.add(sitPlace3);

        JLabel sitPlace4 = new JLabel("");
        sitPlace4.setIcon(new ImageIcon("images\\sitPlace4.png"));
        sitPlace4.setBounds(37, 235, 409, 68);
        sitPn.add(sitPlace4);

		/*该位置上放置的同伙名实时改变*/
        JLabel sitPar1 = new JLabel("");
        sitPar1.setIcon(new ImageIcon("images\\player1Par.PNG"));
        sitPar1.setBounds(271, 99, 200, 50);
        sitPn.add(sitPar1);

        JLabel sitPar2 = new JLabel("");
        sitPar2.setIcon(new ImageIcon("images\\player2Par.PNG"));
        sitPar2.setBounds(271, 150, 200, 50);
        sitPn.add(sitPar2);

        JLabel sitPar3 = new JLabel("");
        sitPar3.setIcon(new ImageIcon("images\\player3Par.PNG"));
        sitPar3.setBounds(271, 196, 200, 50);
        sitPn.add(sitPar3);

        JLabel sitPar4 = new JLabel("");
        sitPar4.setIcon(new ImageIcon("images\\player4Par.PNG"));
        sitPar4.setBounds(271, 245, 200, 50);
        sitPn.add(sitPar4);

		/*放同伙在该位置上应付价钱根据地点种类而改变*/
        JLabel sitMoney1 = new JLabel("");
        sitMoney1.setBounds(206, 108, 80, 30);
        sitPn.add(sitMoney1);

        JLabel sitMoney2 = new JLabel("");
        sitMoney2.setBounds(206, 155, 80, 30);
        sitPn.add(sitMoney2);

        JLabel sitMoney3 = new JLabel("");
        sitMoney3.setBounds(206, 205, 80, 30);
        sitPn.add(sitMoney3);

        JLabel sitMoney4 = new JLabel("");
        sitMoney4.setBounds(206, 253, 80, 30);
        sitPn.add(sitMoney4);

        JLabel sitBg = new JLabel("");
        sitBg.setBounds(0, 11, 499, 348);
        sitBg.setIcon(new ImageIcon("images\\sitBg.png"));
        sitPn.add(sitBg);

        JLabel sitPnBg = new JLabel("");
        sitPnBg.setIcon(new ImageIcon("images\\sitJpBg.png"));
        sitPnBg.setBounds(0, 0, 512, 359);
        sitPn.add(sitPnBg);

		/*所有关闭事件*/
		/*关闭放置同伙弹窗*/
        JLabel closeSit = new JLabel("");
        closeSit.setBounds(458, 11, 41, 38);
        closeSit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        sitPn.add(closeSit);

		/*关闭同伙弹窗*/
        JLabel closePart = new JLabel("");
        closePart.setBounds(747, 134, 51, 43);
        closePart.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                partPn.setVisible(false);
                sitPn.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        partPn.add(closePart);

		/*关闭资产弹窗*/
        JLabel closeMoney = new JLabel("");
        closeMoney.setBounds(663, 176, 46, 41);
        closeMoney.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                moneyPn.setVisible(false);
                sitPn.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        moneyPn.add(closeMoney);

		/*关闭黑市弹窗*/
        JLabel closeDark = new JLabel("");
        closeDark.setBounds(669, 174, 38, 39);
        closeDark.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                darkPn.setVisible(false);
                sitPn.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        darkPn.add(closeDark);

		/*右侧所有按钮的点击事件*/
		/*同伙按钮*/
        JLabel partBtn = new JLabel("");
        partBtn.setBounds(1323, 323, 137, 45);
        contentPane.add(partBtn);
        partBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                partPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

		/*资产按钮*/
        JLabel moneyBtn = new JLabel("");
        moneyBtn.setBounds(1335, 394, 116, 45);
        contentPane.add(moneyBtn);
        moneyBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                moneyPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

		/*日志按钮*/
        JLabel dialogBtn = new JLabel("");
        dialogBtn.setBounds(1337, 464, 114, 45);
        contentPane.add(dialogBtn);

		/*黑市按钮*/
        JLabel darkBtn = new JLabel("");
        darkBtn.setBounds(1335, 535, 116, 45);
        contentPane.add(darkBtn);
        darkBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                darkPn.setVisible(true);
                sitPn.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

		/*所有放置地点的点击事件*/
		/*港口一（最上方）*/
        JLabel sitPort1 = new JLabel("");
        sitPort1.setBounds(414, 169, 81, 52);
        sitPort1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitPort1);

		/*港口二（中间）*/
        JLabel sitPort2 = new JLabel("");
        sitPort2.setBounds(427, 337, 81, 55);
        sitPort2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitPort2);

		/*港口三（最下面）*/
        JLabel sitPort3 = new JLabel("");
        sitPort3.setBounds(355, 425, 62, 45);
        sitPort3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitPort3);

		/*海盗船*/
        JLabel sitPirate = new JLabel("");
        sitPirate.setBounds(442, 524, 183, 45);
        sitPirate.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitPirate);

		/*修船场*/
        JLabel sitFix = new JLabel("");
        sitFix.setBounds(756, 374, 81, 45);
        sitFix.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitFix);

		/*保险*/
        JLabel sitInsur = new JLabel("");
        sitInsur.setBounds(959, 535, 65, 50);
        sitInsur.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitInsur);

		/*领航员*/
        JLabel sitLead = new JLabel("");
        sitLead.setBounds(835, 237, 116, 36);
        sitLead.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(sitLead);

		/*寒鸦号（最上面的船）*/
        JLabel boat1 = new JLabel("");
        boat1.setIcon(new ImageIcon("images\\boat1.png"));
        boat1.setBounds(1176, 150, 69, 71);
        boat1.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(boat1);

		/*黑珍珠号（中间的船）*/
        JLabel boat2 = new JLabel("");
        boat2.setIcon(new ImageIcon("images\\boat2.png"));
        boat2.setBounds(1187, 274, 65, 71);
        boat2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(boat2);

		/*复仇女王号（最下面的船）*/
        JLabel boat3 = new JLabel("");
        boat3.setIcon(new ImageIcon("images\\boat3.png"));
        boat3.setBounds(1139, 425, 62, 65);
        boat3.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                sitPn.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        contentPane.add(boat3);

		/*主页面背景*/
        JLabel mainBg = new JLabel("");
        mainBg.setIcon(new ImageIcon("images\\mainBg.png"));
        mainBg.setBounds(0, 0, 1493, 700);
        contentPane.add(mainBg);
    }
}

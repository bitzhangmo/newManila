package manila.viewTry;


import manila.controller.ChoosingBossController;
import manila.model.Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class ElectView extends JFrame {



	private ChoosingBossController cbc;
	private JPanel mainJp;
	private JTextField electMoney;
	private static BossView bv;
	private int ielectMoney;
	private Game game;
	private JPanel electPn;
	private JLabel curPlayer ;
	private JLabel curPrice ;
	private JLabel moneyLb;
	private JLabel maxLb;
	private JLabel player1;
	private JLabel player2;
	private JLabel player3;
	private JLabel player4;
	private JPanel resultPn;
	private JLabel poorLb;
	private JLabel boss;
	private JLabel bossLb;
	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectView frame = new ElectView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */

	public ElectView(Game g) {

		this.game=g;
		cbc = new ChoosingBossController(this,this.game);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1498, 740);
		mainJp = new JPanel();
		mainJp.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(mainJp);
		mainJp.setLayout(null);
		
		/*玩家头像。默认为灰色。轮到该玩家进行竞价的时候头像变亮。*/
		player1 = new JLabel("");
		player1.setIcon(new ImageIcon("images/player1Ico1.png"));
		player1.setBounds(295, 96, 204, 249);
		mainJp.add(player1);

		player2 = new JLabel("");
		player2.setIcon(new ImageIcon("images/player2Ico0.png"));
		player2.setBounds(1012, 96, 204, 249);
		mainJp.add(player2);

		player3 = new JLabel("");
		player3.setIcon(new ImageIcon("images/player3Ico0.png"));
		player3.setBounds(295, 347, 204, 249);
		mainJp.add(player3);

		player4 = new JLabel("");
		player4.setIcon(new ImageIcon("images/player4Ico0.png"));
		player4.setBounds(1012, 347, 204, 249);
		mainJp.add(player4);
		
		/*目前出价最高的玩家名*/
		curPlayer = new JLabel("");
		curPlayer.setIcon(new ImageIcon("images/player1Name.PNG"));
		curPlayer.setBounds(900, 452, 85, 30);
		mainJp.add(curPlayer);
		
		/*目前最高价*/
		curPrice = new JLabel("");
		curPrice.setBounds(750, 452, 80, 29);
		curPrice.setText("0");
		mainJp.add(curPrice);
		
		/*显示竞价结果的弹窗。默认不可见。竞价结束后可见。*/
		resultPn = new JPanel();
		resultPn.setBorder(new EmptyBorder(0, 0, 0, 0));
		resultPn.setBounds(514, 0, 479, 700);
		mainJp.add(resultPn);
		resultPn.setLayout(null);
		/*竞价结束后，此弹窗可见*/
		resultPn.setVisible(false);
		
		/*前进按钮。点击可跳转到BossView(海港负责人界面)。*/
		JLabel nextPage = new JLabel("");
		nextPage.setIcon(new ImageIcon("images\\next2.png"));
		nextPage.setBounds(416, 450, 48, 54);
		resultPn.add(nextPage);
		nextPage.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

				bv=new BossView(game);

				bv.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/*海港负责人的头像。根据竞价结果改变*/
	    boss = new JLabel("");
		boss.setIcon(new ImageIcon("images\\player1Ico1.png"));
		boss.setBounds(130, 141, 204, 150);
		resultPn.add(boss);
		
		/*海港负责人的名字。根据竞价结果改变*/
		bossLb = new JLabel("");
		bossLb.setIcon(new ImageIcon("images\\player1Name.PNG"));
		bossLb.setBounds(96, 303, 80, 50);
		resultPn.add(bossLb);
		
		/*决定是否购买股份的下拉框*/
		JComboBox bossBuyCombo = new JComboBox();
		bossBuyCombo.setBackground(SystemColor.info);
		bossBuyCombo.setBounds(180, 406, 106, 27);
		bossBuyCombo.addItem("不购买");
		bossBuyCombo.addItem("买肉豆蔻");
		bossBuyCombo.addItem("买丝绸");
		bossBuyCombo.addItem("买玉");
		bossBuyCombo.addItem("买人参");
		resultPn.add(bossBuyCombo);
		
		/*结果框背景*/
		JLabel resultBg = new JLabel("");
		resultBg.setIcon(new ImageIcon("images\\resultPn.png"));
		resultBg.setBounds(19, 0, 445, 521);
		resultPn.add(resultBg);
		
		JLabel resultPnBg = new JLabel("");
		resultPnBg.setIcon(new ImageIcon("images\\rerultJpBg.png"));
		resultPnBg.setBounds(0, 0, 479, 700);
		resultPn.add(resultPnBg);
		
		/*显示竞价的弹窗。默认不可见。点击竞价按钮后可见。*/
		electPn = new JPanel();
		electPn.setBounds(514, 119, 480, 314);
		mainJp.add(electPn);
		electPn.setLayout(null);
		electPn.setVisible(false);

		
		/*显示玩家目前金钱*/
		moneyLb = new JLabel("");
		moneyLb.setBounds(281, 86, 96, 34);
		electPn.add(moneyLb);
		

		/*显示玩家最高竞价*/
		maxLb = new JLabel("");
		maxLb.setBounds(281, 129, 96, 34);
		electPn.add(maxLb);
		
		/*关闭竞价框的按钮事件*/
		JLabel closeBtn = new JLabel("");
		closeBtn.setBounds(435, 0, 45, 45);
		closeBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				electPn.setVisible(false);
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
		electPn.add(closeBtn);
		
		/*输入框。用于输入加价。*/
		electMoney = new JTextField();
		electMoney.setBounds(179, 217, 127, 27);
		electPn.add(electMoney);
		electMoney.setColumns(10);
		
		/*输入框右侧的确定按钮*/
		JLabel electOk = new JLabel("");
		electOk.setIcon(new ImageIcon("images/nextBtn1.png"));
		electOk.setBounds(327, 220, 24, 24);
		electPn.add(electOk);
		electOk.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setIelectMoney(Integer.parseInt(electMoney.getText()));
				cbc.bid();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		/*默认不可见。如果金额不够变得可见。*/
		poorLb = new JLabel("");
		poorLb.setIcon(new ImageIcon("images/poorLb.png"));
		poorLb.setBounds(212, 265, 81, 21);
		electPn.add(poorLb);
		poorLb.setVisible(false);

		/*竞选框背景*/
		JLabel electBg = new JLabel("");
		electBg.setBounds(15, 0, 473, 323);
		electBg.setIcon(new ImageIcon("images/electPn.png"));
		electPn.add(electBg);

		JLabel electPnBg = new JLabel("");
		electPnBg.setIcon(new ImageIcon("images/electJpBg.png"));
		electPnBg.setBounds(0, 0, 480, 314);
		electPn.add(electPnBg);

		/*竞选按钮点击事件*/
		JLabel electBtn = new JLabel("");
		electBtn.setIcon(new ImageIcon("images/electBtn.png"));
		electBtn.setBounds(559, 347, 152, 77);
		electBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				electPn.setVisible(true);
				cbc.onClickBid();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		mainJp.add(electBtn);

		/*放弃按钮*/
		JLabel abandonBtn = new JLabel("");
		abandonBtn.setIcon(new ImageIcon("images/abandonBtn.png"));
		abandonBtn.setBounds(776, 347, 152, 77);
		mainJp.add(abandonBtn);
		abandonBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				cbc.pass();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		/*竞选界面背景*/
		JLabel bgLb = new JLabel("");
		bgLb.setIcon(new ImageIcon("images/electBg.png"));
		bgLb.setBounds(0, 0, 1493, 700);
		mainJp.add(bgLb);

		JLabel electbg = new JLabel("");
		electbg.setBounds(87, 261, 473, 323);
		mainJp.add(electbg);
		electbg.setIcon(new ImageIcon("images/electPn.png"));
	}

	public void changeX(int i) {
		switch(i) {
			case 0:player1.setIcon(new ImageIcon("images/player1Ico0.png"));
				player2.setIcon(new ImageIcon("images/player2Ico1.png"));
				break;
			case 1:player2.setIcon(new ImageIcon("images/player2Ico0.png"));
				player3.setIcon(new ImageIcon("images/player3Ico1.png"));
				break;
			case 2:player3.setIcon(new ImageIcon("images/player3Ico0.png"));
				player4.setIcon(new ImageIcon("images/player4Ico1.png"));
				break;
			case 3:resultPn.setVisible(true);
			cbc.confirm();
			break;
		}
	}
	public void changeCurPlayer(String p){
		curPlayer.setIcon(new ImageIcon(p));
	}
	public void changeCurPrice(int i) {
		String str_i = Integer.toString(i);
		curPrice.setText(str_i);
	}
	public void setMoneyLb(int i) {
		String str_i = Integer.toString(i);
		moneyLb.setText(str_i);
	}
	public void setMaxLb(int i) {
		String str_i = Integer.toString(i);
		maxLb.setText(str_i);
	}
	public int getIelectMoney() {
		return ielectMoney;
	}

	public void setIelectMoney(int ielectMoney) {
		this.ielectMoney = ielectMoney;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	public JPanel getElectPn() {
		return electPn;
	}
	public JTextField getElectMoney() {
		return electMoney;
	}
	public JLabel getPoorLb() {
		return poorLb;
	}
	public void setBoss(int boss_pid) {
		int id = this.cbc.getBoss().getPid();
		id += 1;
		boss.setIcon(new ImageIcon("images\\player"+id+"Ico1.png"));
		bossLb.setIcon(new ImageIcon("images\\player"+id+"Name.PNG"));
	}
}

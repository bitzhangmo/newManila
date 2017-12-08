package manila.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import manila.controller.ChoosingBossController;
import manila.model.Game;
import manila.model.Player;

/**
 * Manila 游戏选举船老大的窗口。
 */
public class ChoosingBossView extends JFrame {
	private Game game;
	private ChoosingBossController cbc;
	
	/** 主面板 */
	private JPanel content;
	/** 玩家名称面板（用来装简略版PlayerView） */
	private JPanel playerView;
	/** 当前船老大姓名和对应金额面板 */
	private JPanel bossView;
	/** 选择船老大的面板 */
	private JPanel chooseView;
	/** 用于显示当前船老大姓名和对应金额 */
	private JLabel bossLabel;
	
	/** 竞选金额输入框 */
	private JTextField amountT;
	/** 竞选按钮 */
	private JButton bidB;
	/** 跳过本轮竞选按钮 */
	private JButton passB;
	/** 结束竞选按钮 */
	private JButton confirmB;
	
	/** 简略版PlayerView的数组 */
	private PlayerView[] pvList;
	
	public ChoosingBossView(Game g){
		this.game = g;
		this.cbc = new ChoosingBossController(this,g);
		
		this.content = new JPanel();
		this.playerView = new JPanel();
		this.bossView = new JPanel();
		this.chooseView = new JPanel();
		
		this.setContentPane(this.content);
		this.content.setPreferredSize(new Dimension(400, 200));
		
		this.content.setLayout(new BorderLayout());
		this.pvList = new PlayerView[this.game.getPlayers().length];
		for(int i=0; i<this.game.getPlayers().length; i++){
			this.pvList[i] = new PlayerView(this.game.getPlayers()[i],false);
			this.playerView.add(this.pvList[i]);
			if(i == 0){
				this.pvList[i].setActive(true);
			}
		}
		this.content.add(this.playerView,BorderLayout.NORTH);
		
		JLabel label = new JLabel("船老大:");
		label.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 24));
		label.setHorizontalTextPosition(SwingConstants.LEFT);
		this.bossView.add(label);
		this.bossLabel = new JLabel("xxxx");
		this.bossLabel.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 24));
		this.bossView.add(bossLabel);
		this.content.add(this.bossView, BorderLayout.CENTER);
		
		this.amountT = new JTextField(10);
		this.bidB = new JButton("竞选");
		this.passB = new JButton("跳过");
		this.confirmB = new JButton("确认");
		
		this.bidB.addActionListener(this.cbc);
		this.bidB.setActionCommand("bid");
		this.passB.addActionListener(this.cbc);
		this.passB.setActionCommand("pass");
		this.confirmB.addActionListener(this.cbc);
		this.confirmB.setActionCommand("confirm");
		
		this.chooseView.add(this.amountT);
		this.chooseView.add(this.bidB);
		this.chooseView.add(this.passB);
		this.chooseView.add(this.confirmB);
		
		this.content.add(this.chooseView,BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("开始竞选吧");
		this.pack();
		this.setVisible(true);
	}

	public void updateBidView(int pid, boolean active){
		for(PlayerView pv : this.pvList){
			Player p = pv.getPlayer();
			if(p.getPid() == pid){
				pv.setActive(active);
			}
			
		}
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public JTextField getAmountT() {
		return amountT;
	}

	public void setAmountT(JTextField amountT) {
		this.amountT = amountT;
	}

	public PlayerView[] getPvList() {
		return pvList;
	}

	public void setPvList(PlayerView[] pvList) {
		this.pvList = pvList;
	}

	public JLabel getBossLabel() {
		return bossLabel;
	}

	public void setBossLabel(JLabel bossLabel) {
		this.bossLabel = bossLabel;
	}
	
	
}

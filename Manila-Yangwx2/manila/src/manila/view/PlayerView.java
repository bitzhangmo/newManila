package manila.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.model.Player;

/**
 * 玩家的信息展示界面
 */
public class PlayerView extends JPanel {
	/** 玩家颜色块的大小 */
	private static int colorV_size = 10;
	/** 得分（账户余额）标签 */
	private JLabel scoreV;
	/** 玩家名称标签 */
	private JLabel nameV;
	/** 颜色块 */
	private JPanel colorV;
	/** 玩家的工人（海员）数 */
	private JLabel worker_nbV;
	
	/** 该界面对应的玩家对象引用 */
	private Player player;
	
	/** 当前面板是否显示边框 */
	private boolean active;
	/** 是否显示所有组件 */
	private boolean showComplete;
	
	/**
	 * 玩家视图构造函数
	 * @param p 玩家对象的引用
	 * @param showComplete 未知
	 */
	public PlayerView(Player p, boolean showComplete){
		this.active = false;
		this.showComplete = showComplete;
		
		this.player = p;
		this.scoreV = new JLabel(this.player.getAccount_balance()+"$");
		this.nameV = new JLabel(this.player.getName());
		this.colorV = new JPanel();
		this.colorV.setBackground(this.player.getC());
		this.worker_nbV = new JLabel(this.player.getWorker_nb()+"");
		
		this.scoreV.setFont(new Font("SansSerif", Font.PLAIN, 32));
		this.nameV.setFont(new Font("SansSerif", Font.PLAIN, 32));
		this.worker_nbV.setFont(new Font("SansSerif", Font.PLAIN, 32));
		this.colorV.setPreferredSize(new Dimension(colorV_size, colorV_size));
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
		
		this.add(this.nameV);
		
		if(this.showComplete){
			this.add(this.scoreV);
			this.add(this.colorV);
			this.add(this.worker_nbV);
		}
		
		this.setBackground(Color.WHITE);
	}

	public JLabel getScoreV() {
		return scoreV;
	}

	public void setScoreV(JLabel scoreV) {
		this.scoreV = scoreV;
	}

	public JLabel getWorker_nbV() {
		return worker_nbV;
	}

	public void setWorker_nbV(JLabel worker_nbV) {
		this.worker_nbV = worker_nbV;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
		if(active){
			this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		}
		else{
			this.setBorder(null);
		}
	}

	public boolean isShowComplete() {
		return showComplete;
	}

	public void setShowComplete(boolean showComplete) {
		this.showComplete = showComplete;
	}
	
}

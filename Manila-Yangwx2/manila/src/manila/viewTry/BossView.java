package manila.viewTry;


import manila.model.Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BossView extends JFrame {


	private Game game;
	private JPanel contentPane;
	private static MainView mv;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BossView frame = new BossView();
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

	public BossView(Game g) {
		this.game=g;

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1498, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*选择装载货物的下拉框*/
		JComboBox boat1Combo = new JComboBox();
		boat1Combo.setBackground(SystemColor.info);
		boat1Combo.setBounds(419, 462, 136, 35);
		boat1Combo.addItem("肉豆蔻");
		boat1Combo.addItem("丝绸");
		boat1Combo.addItem("玉");
		boat1Combo.addItem("人参");
		contentPane.add(boat1Combo);
		
		JComboBox boat2Combo = new JComboBox();
		boat1Combo.setBackground(SystemColor.info);
		boat2Combo.setBounds(705, 462, 136, 35);
		boat2Combo.addItem("肉豆蔻");
		boat2Combo.addItem("丝绸");
		boat2Combo.addItem("玉");
		boat2Combo.addItem("人参");
		contentPane.add(boat2Combo);
		
		JComboBox boat3Combo = new JComboBox();
		boat1Combo.setBackground(SystemColor.info);
		boat3Combo.setBounds(1041, 462, 136, 35);
		boat3Combo.addItem("肉豆蔻");
		boat3Combo.addItem("丝绸");
		boat3Combo.addItem("玉");
		boat3Combo.addItem("人参");
		contentPane.add(boat3Combo);
		
		/*前往MainView（主页面）的按钮*/
		JLabel next = new JLabel("");
		next.setIcon(new ImageIcon("images\\next2.png"));
		next.setBounds(1202, 546, 48, 65);
		next.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

				mv=new MainView(game);

				mv.setVisible(true);
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
		contentPane.add(next);
		
		JLabel bossBg = new JLabel("");
		bossBg.setBounds(0, 0, 1493, 700);
		bossBg.setIcon(new ImageIcon("images\\bossBg.png"));
		contentPane.add(bossBg);
	}
}

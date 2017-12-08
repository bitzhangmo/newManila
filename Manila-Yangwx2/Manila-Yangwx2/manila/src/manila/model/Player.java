package manila.model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * 玩家类，包含玩家的姓名等基本信息。
 */
public class Player {
	/** 玩家名 */
	private String name;
	/** 玩家的ID */
	private int pid;
	/** 账户余额 */
	private int account_balance;
	/** 玩家拥有的工人（海员）数 */
	private int worker_nb;
	/** 玩家所对应的颜色 */
	private Color c;
	/**玩家所拥有的股份**/
	private ArrayList<Integer> stocks;
	
	/**
	 * 玩家构造函数
	 * @param name 玩家姓名
	 * @param pid 玩家ID
	 * @param c 玩家分配的颜色
	 */
	public Player(String name, int pid, Color c){
		this.name = name;
		this.pid = pid;
		this.account_balance = 30;
		this.c = c;
		this.worker_nb = Game.ROUND_NUMBER;
		this.stocks = new ArrayList<Integer>();
	}

	/**
	 * 分配收益时调用的函数
	 * @param profit 为玩家分配的收益，放入余额中
	 */
	public void receiveProfit(int profit){
		this.account_balance += profit;
	}

	/**
	 * 获得单张股份卡
	 * @param stockID 股份ID
	 */
	public void recieveStock(int stockID)
	{
		this.stocks.add(stockID);
	}

	/**
	 * 获得大量股份卡
	 * @param stocksID ID数组
	 */
	public void recieveStock(int[] stocksID)
	{
		for(int i = 0; i < stocksID.length; i++)
		{
			this.stocks.add(stocksID[i]);
		}
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	

	public boolean payPos(int amount){
	    if ((this.account_balance - amount) > 0)
        {
            this.account_balance -= amount;
            this.worker_nb--;
            return true;
        }
        else
        {
            return false;
        }

	}

	public void payOtherThings(int amount)
    {
        this.account_balance -= amount;
    }

	public int getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}

	public int getWorker_nb() {
		return worker_nb;
	}

	public void setWorker_nb(int worker_nb) {
		this.worker_nb = worker_nb;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
}

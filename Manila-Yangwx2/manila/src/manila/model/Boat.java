package manila.model;

import manila.view.PlaygroundView;

/**
 * 小船类，船上装有货物，船上有位置可以装海员。
 */
public class Boat
{
	/** 船上的货物名 */
	private String cargo_name;
	/** 货物的总价值 */
	private int cargo_value;
	/** 船上的空位数组 */
	private Position[] pos_list;
	/** 船在海中的位置 */
	private int pos_in_the_sea;
	/** 船是否到达港口**/
	private boolean isArrived;
	
	/** 船（左上角）在图形界面上的x坐标 */
	private int posX;
	/** 船（左上角）在图形界面上的y坐标 */
	private int posY;

	/**
	 * 小船构造函数
	 * @param n 货物名
	 * @param v 货物价值
	 * @param pl 一组位置
	 */
	public Boat(String n, int v, Position[] pl)
    {
		this.cargo_name = n;
		this.cargo_value = v;
		this.pos_list = pl;
		this.pos_in_the_sea = 0;
		this.isArrived = false;
	}
	
	/**
	 * 当一个玩家分配海员登上该船时，调用该函数用以更新船上位置的信息
	 * @param pid 登船玩家的ID
	 */
	public void getOnboard(int pid){
		this.pos_list[getAvailPosIndex()].setSailorID(pid);
	}
	
	/**
	 * 使船在海中前进，更新船在海中的位置和在船在图形界面上的位置
	 * @param step 船在海中前进的步数
	 */
	public void move(int step)
    {
		this.pos_in_the_sea += step;
		this.posY -= step * PlaygroundView.SEA_INTERVAL;
	}
	
	/**
	 * 获得该船当前空着的位置的编号（登船时自动从较低的编号开始）
	 * @return 当前编号最小的空位所对应的编号值
	 */
	public int getAvailPosIndex()
    {
		for(int i=0; i<this.pos_list.length; i++)
		{
			if(this.pos_list[i].getSailorID() == -1)
				return i;
		}
		// no position left
		return -1;
	}
	
	/**
	 * 返回当前船上已有多少个坐了人的位置数
	 * @return 已有人的位置数
	 */
	public int getFilledPosNum()
    {
		int pos_ind = getAvailPosIndex();
		if(pos_ind == -1)
			return this.pos_list.length;
		else
			return pos_ind;
	}
	
	/**
	 * 返回当前编号最小的空位对应的登船费用
	 * @return 当前编号最小的空位对应的登船费用
	 */
	public int getAvailPosPrice()
    {
		for(int i=0; i<this.pos_list.length; i++)
		{
			if(this.pos_list[i].getSailorID() == -1)
				return this.pos_list[i].getPrice();
		}
		return -1;
	}
	
	/**
	 * 判断鼠标光标是否在该船的范围内
	 * @param x 光标的横坐标
	 * @param y 光标的纵坐标
	 * @return 是否在该船的范围内
	 */
	public boolean isCursorInside(int x, int y)
    {
		if(x > this.posX && x < this.posX+PlaygroundView.BOAT_W
				&& y > this.posY && y< this.posY+PlaygroundView.BOAT_H)
			return true;

		return false;
	}

	public String getCargo_name() {
		return cargo_name;
	}

	public void setCargo_name(String cargo_name) {
		this.cargo_name = cargo_name;
	}

	public int getCargo_value() {
		return cargo_value;
	}

	public void setCargo_value(int cargo_value) {
		this.cargo_value = cargo_value;
	}

	public int getPos_in_the_sea() {
		return pos_in_the_sea;
	}

	public void setPos_in_the_sea(int pos_in_the_sea) {
		this.pos_in_the_sea = pos_in_the_sea;
	}

	public Position[] getPos_list() {
		return pos_list;
	}

	public void setPos_list(Position[] pos_list) {
		this.pos_list = pos_list;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	
	public boolean IsArrivated()
    {
        return this.isArrived;
    }

    public void setIsArrived(boolean b)
    {
        this.isArrived = b;
    }

}

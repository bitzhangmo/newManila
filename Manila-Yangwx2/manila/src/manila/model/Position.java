package manila.model;

/**
 * 位置类，代表一个空位
 */
public class Position {
	/** 登上该位置所要支付的费用 */
	private int price;
	/** 登上该位置的水手所对应的玩家ID，为空时值为-1 */
	private int sailorID;
	
	/**
	 * 位置构造函数
	 * @param p 坐该位置要支付的费用
	 */
	public Position(int p)
	{
		this.price = p;
		this.sailorID = -1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSailorID() {
		return sailorID;
	}

	public void setSailorID(int sailorID) {
		this.sailorID = sailorID;
	}
	
	
}

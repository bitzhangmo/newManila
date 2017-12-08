package manila.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import manila.view.GameView;

/**
 * Manila 游戏的主要类，包含玩家信息和每条船的信息。
 */
public class Game {
	/** 玩家数组 */
	private Player[] players;
	/** 小船数组 */
	private Boat[] boats;
	/** 港口数组  */
	private Harbour[] harbours;
	/** 修船厂数组  */

	private Boatyard boatyards;

	/** 海盗船数组  */
	private Pirate pirate;
    /** 领航员数组  */
    private Pilot pilot;
    /** 保险办事处 */
	private Insurance insurance;
	/**股份种类数组**/
	private Stock[] stocks;
	/**股份卡牌数组**/
	private int[] stockCards;
	/** 随机数产生器 */
	private Random dice_generator;
    /** 当前是否处于海港负责人操作的阶段 */
    private boolean settingGame;
	/** 当前是否处于玩家选位置的阶段 */
	private boolean choosing;
	/**	当前是否处于移动回合阶段*/
	private boolean moving;
	/** 当前是否处于移动回合结束阶段 */
	private boolean endMoving;
	/** 当前是否处于利润分配阶段 */
	private boolean profiting;
	/** 当前是否处于货物价格上涨阶段 */
	private boolean rising;
	/** 游戏是否已结束 */
	private boolean gameIsOver;
    /** 当前游戏正处于第几回合（掷第几次骰子） */
	private int current_time;
	/** 当前游戏处于第几轮 */
	private int current_round;
	/** 当前正在选位置的玩家ID */
	private int current_pid;
	/** 被选为船老大的玩家ID */
	private int boss_pid;
	/** 当前是否处于竞选船老大的阶段 */
	private boolean chooseBoss;
	/** 游戏的总轮数 */
	public static final int ROUND_NUMBER = 3;
	/** 海路的总长度 */
	public static final int SEA_LENGTH = 13;
	
	private GameView gameV;
	
	public Game(){
		//设置整个游戏静态属性，如钱库，股票，各个位置的设置

		initBoat();
		initBoatyard();
		initHarbor();
		initInsurance();
		initPilot();
		initPirate();
		initPlayers();
		initStock();
		shuffleStockCard();

		//随机数生成器
		this.dice_generator = new Random();
		//当前玩家id
		this.current_pid = 0;
		//海港负责人id
		this.boss_pid = -1;
		this.current_time=1;
		//当前流程数
		this.current_round = 1;
		this.choosing = false;
		this.chooseBoss=true;
		this.gameIsOver = false;

		for (int i = 0; i < players.length; i++)
		{//TODO add stock to everyone
			  //this.players[i].recieveStock();
		}
	}


	/**
	 * 初始化玩家
	 *
	 */
	private void initPlayers(){
		//初始化用户名
		this.players = new Player[4];
		this.players[0] = new Player("路飞", 0, Color.RED);
		this.players[1] = new Player("杰克", 1, Color.GREEN);
		this.players[2] = new Player("哥伦布", 2, Color.BLUE);
		this.players[3] = new Player("二狗",3,Color.PINK);
	}

	/**
	 * 初始化股份
	 *
	 */
	public void initStock(){

		stocks = new Stock[4];
		stocks[0] = new Stock("肉豆蔻", 1);
		stocks[1] = new Stock("玉器", 2);
		stocks[2] = new Stock("丝绸", 3);
		stocks[3] = new Stock("人参", 4);
		stockCards = new int[20];
		for(int i = 0; i < 20; i++)
		{
			stockCards[i] = i/4 + 1;
		}
	}

	/**
	 * 初始化货船
	 * 提高可读性所以写成方法
	 */
	private void initBoat(){
		//每艘船上的位置的价钱
		int[] prices1 = {3,4,5,5};

		int[] prices2 = {2,3,3,5};
		int[] prices3 = {3,4,5,5};

		//每艘船上的位置
		Position[] pos1 = new Position[prices1.length];
		Position[] pos2 = new Position[prices2.length];
		Position[] pos3 = new Position[prices3.length];

		//初始化船上的位置
		for(int i=0;i<prices1.length;i++){
			pos1[i] = new Position(prices1[i]);
		}
		for(int i=0;i<prices2.length;i++){
			pos2[i] = new Position(prices2[i]);
		}
		for(int i=0;i<prices3.length;i++){
			pos3[i] = new Position(prices3[i]);
		}

		//初始化船
		Boat s1 = new Boat("丝绸", 6, pos1);
		Boat s2 = new Boat("可可",8, pos2);
		Boat s3 = new Boat("玉器", 10, pos3);

		//生成船的列表
		this.boats = new Boat[3];
		boats[0] = s1;
		boats[1] = s2;
		boats[2] = s3;
	}

	/**
	 * 初始化海盗船
	 * 提高可读性所以写成方法
	 */
	private void initPirate(){
		//每个海盗船的价钱
		int priatePrice = 6;

		//海盗船的位置

		Position priatePos = new Position(priatePrice);


		//初始化海盗船
		Pirate thePirate = new Pirate(priatePos);
        this.pirate=thePirate;
	}

	/**
	 * 初始化领航员岛
	 * 提高可读性所以写成方法
	 */
	private void initPilot(){
		//每个领航员岛位置的价钱
		int pilotPrice0 = 5;

		//领航员岛的位置
		Position positions= new Position(pilotPrice0);

		//初始化领航员岛
		Pilot thePilot = new Pilot(positions);
		this.pilot=thePilot;

	}


	/**
	 * 初始化保险办事处
	 * 提高可读性所以写成方法
	 */
	private void initInsurance(){
		//每个保险办事处位置的价钱
		int insurancePrice = 0;

		//保险办事处的位置
		Position insurancePos = new Position(insurancePrice);

		//初始化保险办事处
		Insurance theInsurance=new Insurance(insurancePos);

		this.insurance=theInsurance;

	}

	/**
	 * 初始化修船厂
	 * 提高可读性所以写成方法
	 */
	private void initBoatyard(){
		//每个修船厂位置的价钱
		int boatyardPrice = 5;
		int profit = 3;

		//初始化修船厂

		//TODO To set new boatyards

		boatyards=new Boatyard(boatyardPrice,profit);

	}

	/**
	 * 初始化港口
	 * 提高可读性所以写成方法
	 */
	private void initHarbor(){
		//每个港口位置的价钱
		int harbourPrice = 4;
		int harbourProfit = 7;
		//初始化港口
		this.harbours=new Harbour[3];
		//TODO To set new harbours
		Harbour harbour0=new Harbour(harbourPrice,harbourProfit);
		Harbour harbour1=new Harbour(harbourPrice,harbourProfit);
		Harbour harbour2=new Harbour(harbourPrice,harbourProfit);

		this.harbours[0]=harbour0;
		this.harbours[1]=harbour1;
		this.harbours[2]=harbour2;
	}

	/**
	 * 将股份卡牌打乱
	 */
	private void shuffleStockCard()
	{
		Random random = new Random();
		int t, r;
		for (int i = 0; i < 20; i++)
		{
			r = random.nextInt(19);
			t = stockCards[r];
			stockCards[r] = stockCards[i];
			stockCards[i] = t;
		}
	}


	/**
	 * 产生一个1-6之间的随机整数（模拟骰子的功能）。
	 * @return 1-6之间的随机整数
	 */
	public int rollDice(){
		return dice_generator.nextInt(5)+1;
	}
	
	/**
	 * 返回当前正在进行操作的玩家对象。
	 * @return 当前玩家对象
	 */
	public Player getCurrentPlayer(){
		return this.players[this.current_pid];
	}
	
	/**
	 * 根据玩家的ID返回玩家对象。
	 * @param id 要寻找的玩家ID
	 * @return 玩家对象
	 */
	public Player getPlayerByID(int id){
		return this.players[id];
	}

	/**
	 * 在控制台输出当前船的位置以及当前船上成员可以获得的收益
	 */
	public void showCurrentState(){
		for(Boat s : this.boats){
			String res;
			res = "The "+s.getCargo_name()+" boat ("+s.getCargo_value()+"): [ ";
			for(Position pos: s.getPos_list()){
				if(pos.getSailorID() == -1)
					res += pos.getPrice()+"$ ";
				else
					res += this.players[pos.getSailorID()].getName()+" ";
			}
			
			res += "].";
			res += "The boat is at: "+s.getPos_in_the_sea(); 
			System.out.println(res);
		}
	}
	
	/**
	 * 在所有轮结束后，根据船是否到港以及船上海员的归属，为每位玩家分配收益。
	 */
	public void calculateProfits(){
		// for boats that get to the harbor
		// share the money by selling the cargo
		int money_to_share;
		for(Boat s : this.boats)
		{
			if(s.getPos_in_the_sea() > SEA_LENGTH){
				System.out.println("The boat "+s.getCargo_name()+" has arrived");
				money_to_share = s.getCargo_value()/s.getFilledPosNum();
				System.out.println("money_to_share: "+money_to_share);
				for(Position pos : s.getPos_list()){
					if(pos.getSailorID() != -1)
						this.players[pos.getSailorID()].receiveProfit(money_to_share);
				}
			}
			else
				System.out.println("The boat "+s.getCargo_name()+" has sank!");
		}

        for(Harbour h : this.harbours)
        {
            if(h.getPos().getSailorID() != -1)
            {
                this.players[h.getPos().getSailorID()].setAccount_balance(this.players[h.getPos().getSailorID()].getAccount_balance() + h.getProfit());
            }
        }
        if(this.pirate.getPos_list().getSailorID() != -1)
        {
            this.players[this.pirate.getPos_list().getSailorID()].setAccount_balance(this.players[this.pirate.getPos_list().getSailorID()].getAccount_balance() + pirate.getProfit());
        }
        if(this.boatyards.getPos().getSailorID() != -1)
        {
            this.players[this.boatyards.getPos().getSailorID()].setAccount_balance(this.players[boatyards.getPos().getSailorID()].getAccount_balance() + boatyards.getProfit());
        }

	}
	
	/**
	 * 在终端打印出谁是获胜玩家，即得分最高（账户余额最高）。
	 */
	public int showWinner(){
		int winner_id = 0;
		int high_balance = -1;
		for(Player p : this.players){
			if(p.getAccount_balance() > high_balance){
				winner_id = p.getPid();
				high_balance = p.getAccount_balance();
			}
			System.out.println(p.getName()+" has "+p.getAccount_balance()+"$");
		}
		System.out.println("The winner is: "+this.players[winner_id].getName());
		return winner_id;
	}


	public void switchPlayer(){
		this.current_pid = (this.current_pid+1)%this.players.length;
	}
	
	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Boat[] getBoats() {
		return boats;
	}

	public void setBoats(Boat[] boats) {
		this.boats = boats;
	}
	public Pirate getPirates() {
		return pirate;
	}

	public void setPirates(Pirate pirates) {
		this.pirate = pirates;
	}


    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }


    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

	public boolean isMoving(){ return moving;}

	public void setMoving(boolean moving){ this.moving=moving; }

	public boolean isEndMoving(){ return endMoving;}

	public void setEndMoving(boolean EndMoving){ this.endMoving=EndMoving;}

    public int getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(int current_time) {
        this.current_time = current_time;
    }

	public boolean isChoosing() {
		return choosing;
	}

	public void setChoosing(boolean choosing) {
		this.choosing = choosing;
	}

	public int getCurrent_pid() {
		return current_pid;
	}

	public void setCurrent_pid(int current_pid) {
		this.current_pid = current_pid;
	}

	public boolean isRising() {
		return rising;
	}

	public void setRising(boolean rising) {
		this.rising = rising;
	}

	public boolean isProfiting() {
		return profiting;
	}

	public void setProfiting(boolean profiting) {
		this.profiting = profiting;
	}

	public boolean isGameIsOver() {
		return gameIsOver;
	}

	public void setGameIsOver(boolean gameIsOver) {
		this.gameIsOver = gameIsOver;
	}

	public int getCurrent_round() {
		return current_round;
	}

	public void setCurrent_round(int current_round) {
		this.current_round = current_round;
	}

	public GameView getGameV() {
		return gameV;
	}

	public void setGameV(GameView gameV) {
		this.gameV = gameV;
	}

	public int getBoss_pid() {
		return boss_pid;
	}

	public void setBoss_pid(int boss_pid) {
		this.boss_pid = boss_pid;
	}

    public Harbour[] getHarbours()
    {
        return harbours;
    }


    public Boatyard getBoatyards()
	{
		return this.boatyards;
	}


	public boolean isChooseBoss() {
		return chooseBoss;
	}

	public void setChooseBoss(boolean chooseBoss) {
		this.chooseBoss = chooseBoss;
	}


    public boolean isSettingGame() {
        return settingGame;
    }

    public void setSettingGame(boolean settingGame) {
        this.settingGame = settingGame;
    }

	public Stock[] getStocks()
	{
		return this.stocks;
	}
}

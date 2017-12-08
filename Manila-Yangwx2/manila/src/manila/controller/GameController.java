package manila.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import manila.model.*;
import manila.model.Boat;
import manila.view.PlaygroundView;

/**
 * 控制鼠标交互的事件监听类
 */
public class GameController implements MouseListener{
	
	private Game game;

	public GameController(Game g){
		this.game = g;
	}
	
	public void clickedOnBoat(int x, int y)
	{
		Boat[] boats = game.getBoats();
		for(int i=0; i<boats.length; i++){
			Boat b = boats[i];
			if(b.isCursorInside(x, y))
			{//if some boat was chose
                System.out.println(b.getAvailPosIndex());
				if(b.getAvailPosIndex() != -1)
				{//if the boat is not empty,get on the boat
					Player p = this.game.getCurrentPlayer();
					if (p.payPos(b.getAvailPosPrice()))
                    {
                        b.getOnboard(p.getPid());
                    }
                    else
                    {
                        //TODO 显示支付失败信息，同时进入选择售卖股票的流程，或进入下个玩家选择阶段
                    }

					// modify the view
					this.game.getGameV().getPlayground().repaint();
					this.game.getGameV().updatePlayersView(p.getPid(), false);

					changeToMoving();
						
					this.game.switchPlayer();
					this.game.getGameV().updatePlayersView(this.game.getCurrent_pid(), true);
				}
				else if(b.getAvailPosIndex()==-1) {
				    changeToMoving();
                }
			}
		}
	}

	public void clickedOnHarbour(int x,int y)
    {
        Harbour[] harbours = game.getHarbours();
        for(int i = 0; i < harbours.length; i++)
        {
            if(harbours[i].isCursorInside(x, y) && harbours[i].isEmpty())
            {
                Player p = this.game.getCurrentPlayer();
                if (p.payPos(harbours[i].getAvailablePrice()))
                {
                    harbours[i].standInThisHarbour(p.getPid());
                }
                else
                {
                    //TODO
                }
				this.game.getGameV().getPlayground().repaint();
				this.game.getGameV().updatePlayersView(p.getPid(), false);

				changeToMoving();

				this.game.switchPlayer();
				this.game.getGameV().updatePlayersView(this.game.getCurrent_pid(), true);
            }
        }
	}

	public void clickedOnBoatyard(int x,int y)
	{
        Boatyard[] boatyards = game.getBoatyards();
        for (int i = 0; i < boatyards.length; i++)
        {
            if (boatyards[i].isCursorInside(x, y) && boatyards[i].isEmpty())
            {
                Player p = this.game.getCurrentPlayer();
                if (p.payPos(boatyards[i].getAvailablePrice()))
                {
                    boatyards[i].standInBoatyard(p.getPid());
                }
                else
                {
                    //TODO
                }
                this.game.getGameV().getPlayground().repaint();
                this.game.getGameV().updatePlayersView(p.getPid(), false);

                changeToMoving();

				this.game.switchPlayer();
				this.game.getGameV().updatePlayersView(this.game.getCurrent_pid(), true);
            }

        }
	}

	public void clickedOnPirate(int x,int y){
		// TODO Put a partner in Pirate
		Pirate pirate=game.getPirates();
		if(pirate.isCursorInside(x,y) && pirate.getAvailPosIndex()!=-1){//当可登船时
			Player p = this.game.getCurrentPlayer();
			if(p.payPos(pirate.getThePrice())){
				pirate.getOnboard(p.getPid());
			}
			else{
				// TODO
			}
			this.game.getGameV().getPlayground().repaint();
			this.game.getGameV().updatePlayersView(p.getPid(), false);

			changeToMoving();

			this.game.switchPlayer();
			this.game.getGameV().updatePlayersView(this.game.getCurrent_pid(), true);
		}
	}

	/*public void clickedOnPilot(int x,int y){
		// TODO Put a partner in Pilot
		Pilot pilot=this.game.getPilot();
		if(pilot.isCursorInside(x,y)&&pilot.getAvailPosIndex()!=-1){
			Player p =this.game.getCurrentPlayer();
			if (p.payPos(pilot.getInsPosPrice())){
				pilot.getOnPilotIsland(p.getPid());
			}
			this.game.getGameV().getPlayground().repaint();
			this.game.getGameV().updatePlayersView(p.getPid(),false);

			changeToMoving();

			this.game.switchPlayer();
			this.game.getGameV().updatePlayersView(this.game.getCurrent_pid(),true);
		}
	}*/

	public void clickedOnInsurance(int x,int y){
		// TODO Put a partner in Insurance
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

		if(!this.game.isGameIsOver()){
		    if(this.game.isSettingGame()){
                settingBoatPos(arg0);
            }
			if(this.game.isChoosing()){
				System.out.println("isChoosing");
				// TODO judge player choose which position to set
				this.clickedOnBoat(arg0.getX(), arg0.getY());
				this.clickedOnBoatyard(arg0.getX(),arg0.getY());
				this.clickedOnHarbour(arg0.getX(),arg0.getY());
				this.clickedOnInsurance(arg0.getX(),arg0.getY());
				/*this.clickedOnPilot(arg0.getX(),arg0.getY());*/
				this.clickedOnPirate(arg0.getX(),arg0.getY());
			}
			if(this.game.isEndMoving()){
				System.out.println("isEndMoving");
				//TODO Pirate and Pilot
                disaster();
                changeToSetting();
			}
			if(this.game.isProfiting()){
				System.out.println("isProfiting");
				//TODO
			}
			if(this.game.isRising()){
				System.out.println("isRising");
				//TODO



                //all the actions were done,to the next round
				int round=this.game.getCurrent_round()+1;
				this.game.setCurrent_round(round);
			}


		}
		else {
			//TODO gameover
		}


	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


    public void settingBoatPos(MouseEvent arg0){
		Player player=this.game.getPlayerByID(this.game.getBoss_pid());
		//跳出是否购买股份面板
		if(true)//the number to get from input
		{
			int stockID=0;
			player.recieveStock(stockID);
		}
		if(false);
		int pos=5;
        Boat[] boats=this.game.getBoats();
        for(Boat boat:boats){
            // TODO to use some method to input the position of this sea
            if(arg0.getX()<=pos) {//the total position added equal 5
				boat.setPos_in_the_sea(arg0.getX());
				pos -= arg0.getX();
				System.out.println("set the boat" + boat.getCargo_name() + "in the sea");
			}
        }
        this.game.setSettingGame(false);
        this.game.setChoosing(true);
    }


    /**
     * 通过计算当前是否所有人都已经选完来撬动回合结束杠杆
     */
	public void changeToMoving(){
		if(this.game.getCurrent_pid() == this.game.getBoss_pid()-1
				|| this.game.getCurrent_pid() == this.game.getPlayers().length+this.game.getBoss_pid()-1)
		{//all the one has chose the position
			this.game.setChoosing(false);
			this.game.setMoving(true);
		}
		int howManyBoatGG=0;
		for(Boat b:this.game.getBoats()){
		    howManyBoatGG+=b.getAvailPosIndex();
        }
        if(howManyBoatGG==-3){
            this.game.setChoosing(false);
            this.game.setMoving(true);
        }
	}

	public void changeToSetting(){
	    if(this.game.getCurrent_time()<=2) {
            this.game.setCurrent_time(this.game.getCurrent_time() + 1);
            this.game.setEndMoving(false);
            this.game.setChoosing(true);
        }
        else if(this.game.getCurrent_time()==3){
	        this.game.setEndMoving(false);
        }
	}

	/**
	 * 判断是否发生船难以及执行海盗登船
	 */
	public void disaster(){
		/** 标记船难是否发生 */
	    boolean isDisasterHappened=false;
	    /** 标记不幸的船编号 */
	    int theBoat=-1;
		java.util.List<Boat> boatList=new ArrayList<>();
	    Boat[] boats=this.game.getBoats();
	    for(int i=0;i<this.game.getBoats().length;i++){//遍历船只，如果刚好在13格则GG
	        if(boats[i].getPos_in_the_sea()==13){
	        	theBoat=i;
	        	boatList.add(boats[i]);
	            isDisasterHappened=true;
	            break;
            }
        }
	    if(this.game.getCurrent_time()==2&&isDisasterHappened){
	    	for(int i=0;i<2;i++){
				//TODO 是否登船？
				//是
				this.game.getPirates().getOnboat(boats[theBoat],this.game.getPirates().getPos_list()[i].getSailorID());
				//否
				//TODO set the
				continue;
			}
			isDisasterHappened=false;
        }
        if(this.game.getCurrent_time()==3&&isDisasterHappened){
			for(int i=0;i<2;i++){
				//TODO 是否劫掠？
				//是
				if(boatList!=null)
					this.game.getPirates().ravageBoat(boatList,this.game.getPirates().getPos_list()[i].getSailorID());
				//否
				continue;
			}
		}
    }
}

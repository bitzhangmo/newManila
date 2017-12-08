package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manila.model.Boat;
import manila.model.Game;

/**
 * 控制摇骰子的按钮的事件监听类
 */
public class DiceController implements ActionListener {

	private Game game;
	
	public DiceController(Game g){
		this.game = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// roll the dice to move the boats
		if(!this.game.isGameIsOver() && this.game.isMoving()){
			System.out.println("isMoving");
			for(Boat b : this.game.getBoats()){
				b.move(this.game.rollDice());
			}
			this.game.getGameV().getPlayground().repaint();
			
			// prepare the next round
			this.game.setCurrent_round(this.game.getCurrent_round()+1);
			//this.game.setChoosing(true);
			this.game.setMoving(false);
			this.game.setEndMoving(true);
			if(this.game.getCurrent_round() > Game.ROUND_NUMBER){
				// game is over
				//this.game.setGameIsOver(true);
				this.game.setChoosing(false);
				this.game.calculateProfits();

				//this.game.showWinner();
			}
			for(int i=0;i<this.game.getBoats().length;i++){
				if(this.game.getBoats()[i].getCargo_value()>=30){
					this.game.setGameIsOver(true);
					this.game.setChoosing(false);
					this.game.calculateProfits();
					this.game.showWinner();
				}
			}
		}
		
	}

}

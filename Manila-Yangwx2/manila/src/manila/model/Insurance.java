package manila.model;

import manila.view.PlaygroundView;

/**
 * 保险办事处类，每个保险办事处有一个放置同伙的空格。
 */

public class Insurance {

    /** 保险办事处的空位 */
    private Position pos_insurance;
    /** 保险办事处（左上角）在图形界面上的x坐标 */
    private int posX;
    /** 保险办事处（左上角）在图形界面上的y坐标 */
    private int posY;

    /**
     *
     * 保险办事处构造函数
     * @param pl 一组位置
     */
    public Insurance(Position pl){
        this.pos_insurance=pl;
    }

    /**
     * 当一个玩家分配同伙到保险办事处时，调用该函数用以更新保险办事处上位置的信息
     * @param pid 保险玩家的ID
     */
    public void getInInsurance(int pid){ this.pos_insurance.setSailorID(pid);}

    /**
     * 返回当前保险办事处是否有人
     * @return 如果有人返回true,否则返回false
     */
    public boolean haveEmptyPos(){
        if(pos_insurance.getSailorID()==-1) return true;
        else return false;
    }

    public int getInsurancePeople(){
            return this.getPos_in_the_Insurance().getSailorID();
    }

    /**
     * 判断鼠标光标是否在保险办事处的范围内
     * @param x 光标的横坐标
     * @param y 光标的纵坐标
     * @return 是否在保险办事处的范围内
     */
    public boolean isCursorInside(int x,int y){
        if(x > this.posX && x < this.posX+PlaygroundView.INSURANCE_W
                && y >this.posY && y < this.posY+PlaygroundView.INSURANCE_H)
            return true;
        return false;
    }

    /**
     * 返回当前位置的费用
     * @return 当前位置的费用
     */
    public int getInsPosPrice(){
        if(this.pos_insurance.getSailorID() == -1)
            return this.pos_insurance.getPrice();
        return -1;
    }

    public Position getPos_in_the_Insurance() { return pos_insurance; }

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

}


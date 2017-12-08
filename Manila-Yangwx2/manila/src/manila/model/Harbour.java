package manila.model;

import manila.view.PlaygroundView;

/**
 * 港口类，每个港口有一个放置同伙的空格。
 */
public class Harbour
{
    private Boat boat;
    /**海港的位置**/
    private Position pos;
    private int harbourProfit;
    /**界面上的坐标位置**/
    private int posX;
    private int posY;


    public Harbour(int posPrice, int harbourProfit)
    {
        this.pos = new Position(posPrice);
        this.harbourProfit = harbourProfit;
    }

    /**
     * 获取站在这个位置需要的钱
     * @return 收取的费用
     */
    public int getAvailablePrice()
    {
        return this.pos.getPrice();
    }

    /**
     * 同伙站在海港位置
     * @param pid 同伙所属玩家的ID
     */
    public void standInThisHarbour(int pid)
    {
        this.pos.setSailorID(pid);
    }

    /**
     * 获取利润
     * @return 在这个位置所赚取的利润
     */
    public int getProfit()
    {
        if (this.boat.IsArrivated())
        {
            return this.harbourProfit;
        }
        else
        {
            return 0;
        }
    }

    /**
     * 判断是否点击到修船厂
     * @param x 鼠标位置的横坐标
     * @param y 鼠标位置的纵坐标
     * @return 是否点到修船厂
     */
    public boolean isCursorInside(int x, int y)
    {
        if (x <= (posX + PlaygroundView.HARBOUR_W) && x >= posX && y <= (posY + PlaygroundView.HARBOUR_H) && y >= posY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 判断是否有空位
     * @return 是否有空位
     */
    public boolean isEmpty()
    {
        if(this.pos.getSailorID() == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 把船与海港关联
     * @param boat 这条航线的船
     */
    public void setBoat(Boat boat)
    {
        this.boat = boat;
    }


    public Position getPos()
    {
        return this.pos;
    }

    public int getPosX()
    {
        return this.posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
    }
    public int getPosY()
    {
        return this.posY;
    }
    public void setPosY(int posY)
    {
        this.posY = posY;
    }

}
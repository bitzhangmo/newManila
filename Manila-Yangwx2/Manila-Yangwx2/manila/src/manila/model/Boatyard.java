package manila.model;
import manila.view.PlaygroundView;
/**
 * 修理厂类，每个修理厂有一个放置同伙的空格。
 */
public class Boatyard
{
    /**修船厂上的位置**/
    private Position pos;
    /**修船厂是否有损坏的船**/
    private boolean hasBrokenBoat;
    /**修船厂赚取的利润**/
    private int boatyardProfit;
    /**图形界面上的位置**/
    private int posX;
    private int posY;

    /**
     *
     * @param posPrice 登上这个位置所需要的花费
     * @param profit 赚取的利润
     */
    public Boatyard(int posPrice, int profit)
    {
        this.pos = new Position(posPrice);
        this.boatyardProfit = profit;
        this.hasBrokenBoat = false;
    }

    /**
     * 同伙站在修船厂位置
     * @param pid 同伙所属玩家的ID
     */
    public void standInBoatyard(int pid)
    {
        this.pos.setSailorID(pid);
    }

    /**
     * 把坏掉的船送到修船厂
     * @param boat 坏掉的船
     */
    public void setBrokenBoat(Boat boat)
    {
        this.hasBrokenBoat = true;
    }

    /**
     * 获取利润
     * @return 在这个位置所赚取的利润
     */
    public int getProfit()
    {
        return this.boatyardProfit;
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
        if (this.pos.getSailorID() != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
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
    public Position getPos() {
        return pos;
    }
}

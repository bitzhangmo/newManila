package manila.model;

import manila.view.PlaygroundView;

/**
 * 领航员类，每个领航员岛上有两个放置同伙的空格。
 */
public class Pilot {

    /** 领航员的空位数组 */
    private Position pos_list;

    /** 领航员岛（左上角）的x坐标 */
    private int posX;
    /** 领航员岛（左上角）的y坐标 */
    private int posY;

    /**
     * 领航员构造函数
     * @param pl 领航员位置数组
     *
     */
    public Pilot(Position pl){
        this.pos_list=pl;
    }

    /**
     * 当一个玩家分配同伙到领航员岛时，调用该函数用以更新领航员岛上的信息
     * @param pid 登岛玩家的ID
*/
    public void getOnPilotIsland(int pid){
        this.pos_list.setSailorID(pid);
    }

    /*public int chooseAvailPosIndex(){
        // TODO return the position which player chose
        return -1;
    }*/

    /**
     * 获得领航员岛当前空着的位置的编号
     * @return 当前编号最小的空位所对应的编号值

    public int getAvailPosIndex() {
        for(int i=0; i<this.pos_list.length; i++){
            if(this.pos_list[i].getSailorID() == -1)
                return i;
        }
        // no position left
        return -1;
    }*/

    /**
     * 判断是否点击到领航员岛
     * @param x 鼠标位置的横坐标
     * @param y 鼠标位置的纵坐标
     * @return 是否点到领航员岛
     */
    public boolean isCursorInside(int x, int y)
    {
        if (x <= (posX + PlaygroundView.PILOT_W) && x >= posX && y <= (posY + PlaygroundView.PILOT_H) && y >= posY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 返回当前位置的费用
     * @return 当前位置的费用
    */
    public int getInsPosPrice(){
        if(this.getPos_list().getSailorID()!=-1){
               return pos_list.getPrice();
            }
        else return -1;
    }

    public Position getPos_in_the_Pilot() { return pos_list; }

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

    public Position getPos_list(){
        return this.pos_list;
    }
}

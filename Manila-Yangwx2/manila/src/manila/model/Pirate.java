package manila.model;

import manila.view.PlaygroundView;

import java.util.List;

/**
 * 海盗船类，每一个海盗船上有两个放置同伙的空格。
 */
public class Pirate {




    /**海盗船上的位置数组，0为船长，1为船员*/

    private Position pos_list;

    /**界面上的坐标位置**/
    private int posX;
    private int posY;
    /**
     * 海盗船构造函数
     * @param p 海盗船位置数组
     */

    public Pirate(Position p) {

        this.pos_list = p;
    }

    /**
     * 获得海盗船当前空着的位置的编号（登船时自动从较低的编号开始）
     * @return 当前编号最小的空位所对应的编号值

     */

    public int getAvailPosIndex() {
        for(int i=0; i<this.pos_list.length; i++){
            if(this.pos_list[i].getSailorID() == -1)
                return i;
        }
        // no position left
        return -1;
 */


    /**
     * 当一个玩家分配海员登上海盗船时，调用该函数用以更新船上位置的信息
     * @param pid 登船玩家的ID
     */
    public void getOnboard(int pid){
        this.pos_list.setSailorID(pid);

    }

    /**
     * 海盗登船
     * @param boat 被登上的船只
     * @param pid 登船的海盗id
     */
    public void getOnboat(Boat boat,int pid) {
        if(boat.getAvailPosIndex() == -1) {
            //TODO 显示出船上坐着哪些人
            int[] boat_pid_l = {-1,-1,-1,-1};
            int index = 0;
            for(Position p:boat.getPos_list()) {
                boat_pid_l[index] = p.getSailorID();
            }
            int i = chooseOnetokick(boat_pid_l);
            Position[] positionlist = boat.getPos_list();
            positionlist[i].setSailorID(pid);

        }
        else {
            boat.getOnboard(pid);
        }
    }

    public int getThePrice(){

            return pos_list.getPrice();

    }

    /**
     *
     * @param p_list 玩家id列表
     * @return 被选择的玩家处于该船位置数组中的索引
     */
    public int chooseOnetokick(int[] p_list) {
        return p_list[0];
    }
    /**
     * 判断鼠标光标是否在该船的范围内
     * @param x 光标的横坐标
     * @param y 光标的纵坐标
     * @return 是否在该船的范围内
     */
    public boolean isCursorInside(int x, int y)
    {
        if(x > this.posX && x < this.posX+ PlaygroundView.BOAT_W
                && y > this.posY && y< this.posY+PlaygroundView.BOAT_H)
            return true;

        return false;
    }
    /**
     * 海盗劫掠船只
     * @param boat 被劫掠的船只
     * @param pid_1 劫掠船只的海盗id
     * @param pid_2 劫掠船只的海盗id
     *
     */
    public void ravageBoat(List<Boat> boat,int pid_1,int pid_2) {
        switch(boat.size()) {
            case 1:
                Position[] p = boat.get(0).getPos_list();
                p[0].setSailorID(pid_1);
                p[1].setSailorID(pid_2);
                p[2].setSailorID(-1);
                if(4 == p.length) {
                    p[3].setSailorID(-1);
                }
                break;
            case 2:
                for(int bn = 0;bn <= 1;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(pid_2);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;
            case 3:
                for(int bn = 0;bn <= 2;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(pid_2);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;
            case 4:
                for(int bn = 0;bn <= 3;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(pid_2);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;
        }

        //海盗从海港的钱箱中得到每艘被劫掠的船的收入  海盗船长可以决定被劫掠的平底船停在港口或是修船场。如果他决定将平底船停在港口，被劫掠的货物提升价值
    }
    public void ravageBoat(List<Boat> boat,int pid_1) {
        switch(boat.size()) {
            case 1:
                Position[] p = boat.get(0).getPos_list();
                p[0].setSailorID(pid_1);
                p[1].setSailorID(-1);
                p[2].setSailorID(-1);
                if(4 == p.length) {
                    p[3].setSailorID(-1);
                }
			/*
			 boat.get(0).setArrived(true);
			 or
			 boat.get(0).pos_in_the_sea = 14;
			 */
                break;
            case 2:
                for(int bn = 0;bn <= 1;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(-1);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;
            case 3:
                for(int bn = 0;bn <= 2;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(-1);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;
            case 4:
                for(int bn = 0;bn <= 3;bn++) {
                    Position[] p2 = boat.get(bn).getPos_list();
                    p2[0].setSailorID(pid_1);
                    p2[1].setSailorID(-1);
                    p2[2].setSailorID(-1);
                    if(4 == p2.length) {
                        p2[3].setSailorID(-1);
                    }
                }
                break;

        }
    }

    public int getProfit()
    {
        //TODO
        return 0;
    }

    public Position getPos_list() {
        return pos_list;
    }

    public void setPos_list(Position pos_list) {

        this.pos_list = pos_list;
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


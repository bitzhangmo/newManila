package manila.model;

public class Stock {
    /**
     * 货物的名称
     **/
    private String kindsName;
    /**
     * 货物的编号
     **/
    private int cargoID;
    /**
     * 货物价格
     **/
    private int value;
    /**
     * 股份卡片剩余数量
     */
    private int num;

    public Stock(String kind, int ID) {
        this.kindsName = kind;
        this.cargoID = ID;
        this.value = 5;
        this.num = 5;
    }

    /**
     * 更新这个货物的股价
     *
     * @param upValue 升高的价格
     */
    public void updateValue(float upValue) {
        this.value += upValue;
    }

    /**
     * 股份卡片数量减少(每当系统把牌发给玩家)单张
     */
    public void subStockNum() {
        this.num--;
    }

    /**
     * 股份卡片数量减少(每当系统把牌发给玩家)n张
     *
     * @param n 减少的数量
     */
    public void subStockNum(int n) {
        for (int i = 0; i < n; i++) {
            this.num--;
        }
    }

    /**
     * 股份卡片数量增加(每当玩家抵押牌)
     */
    public void addStockNum() {
        this.num++;
    }

    public int getValue() {
        return this.value;
    }

    public int getstockNum()
    {
        return this.num;
    }
}

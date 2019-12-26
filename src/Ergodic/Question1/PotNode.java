package Ergodic.Question1;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-26 20:35
 */
public class PotNode {
    private int volume; // 容量
    private int surplus; // 剩余

    public boolean isEmpty(){
        return this.surplus == 0;
    }

    public boolean isFull(){
        return this.surplus == this.volume;
    }

    public int load(PotNode potNode){
        int all =  this.surplus + potNode.getSurplus(); // 总水量
        if(all <= volume){ //
            this.surplus = all;
            potNode.setSurplus(0);
            return 0;
        }else{
            this.surplus = volume;
            potNode.setSurplus(all - this.volume);
            return all - this.volume;
        }
    }

    public PotNode(int volume, int surplus) {
        this.volume = volume;
        this.surplus = surplus;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }
}
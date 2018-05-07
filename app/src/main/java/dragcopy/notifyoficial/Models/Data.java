package dragcopy.notifyoficial.Models;

/**
 * Created by dsconosido on 5/6/18.
 */

public class Data {
    String name, desc;
    public Data(String name, String imgUrl){
        this.name=name;
        this.desc =imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}

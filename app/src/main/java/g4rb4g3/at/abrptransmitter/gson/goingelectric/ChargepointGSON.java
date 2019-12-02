
package g4rb4g3.at.abrptransmitter.gson.goingelectric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChargepointGSON {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("power")
    @Expose
    private double power;
    @SerializedName("count")
    @Expose
    private int count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return (int)power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

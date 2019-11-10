package g4rb4g3.at.abrptransmitter.abrp.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outlet {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("power")
    @Expose
    private Integer power;
    @SerializedName("stalls")
    @Expose
    private Integer stalls;
    @SerializedName("status")
    @Expose
    private Object status;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getStalls() {
        return stalls;
    }

    public void setStalls(Integer stalls) {
        this.stalls = stalls;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}

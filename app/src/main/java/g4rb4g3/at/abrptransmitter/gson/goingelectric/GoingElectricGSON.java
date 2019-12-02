
package g4rb4g3.at.abrptransmitter.gson.goingelectric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoingElectricGSON {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("chargelocations")
    @Expose
    private List<ChargelocationGSON> chargelocations = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ChargelocationGSON> getChargelocations() {
        return chargelocations;
    }

    public void setChargelocations(List<ChargelocationGSON> chargelocations) {
        this.chargelocations = chargelocations;
    }

}

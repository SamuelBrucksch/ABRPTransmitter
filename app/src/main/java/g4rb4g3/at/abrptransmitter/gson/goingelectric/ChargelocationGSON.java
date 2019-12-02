
package g4rb4g3.at.abrptransmitter.gson.goingelectric;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChargelocationGSON {

    @SerializedName("chargepoints")
    @Expose
    private List<ChargepointGSON> chargepoints = null;
    @SerializedName("ge_id")
    @Expose
    private int geId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private AddressGSON address;
    @SerializedName("coordinates")
    @Expose
    private CoordinatesGSON coordinates;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("fault_report")
    @Expose
    private boolean faultReport;
    @SerializedName("verified")
    @Expose
    private boolean verified;

    public List<ChargepointGSON> getChargepoints() {
        return chargepoints;
    }

    public void setChargepoints(List<ChargepointGSON> chargepoints) {
        this.chargepoints = chargepoints;
    }

    public int getGeId() {
        return geId;
    }

    public void setGeId(int geId) {
        this.geId = geId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressGSON getAddress() {
        return address;
    }

    public void setAddress(AddressGSON address) {
        this.address = address;
    }

    public CoordinatesGSON getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesGSON coordinates) {
        this.coordinates = coordinates;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFaultReport() {
        return faultReport;
    }

    public void setFaultReport(boolean faultReport) {
        this.faultReport = faultReport;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}

package g4rb4g3.at.abrptransmitter.goingelectric;

import android.location.Location;

import java.util.HashSet;
import java.util.Set;

import g4rb4g3.at.abrptransmitter.gson.goingelectric.ChargelocationGSON;
import g4rb4g3.at.abrptransmitter.gson.goingelectric.ChargepointGSON;

public class ChargerLocation extends Location {

    private String url;
    private String network;
    private int ccsStalls;
    private Set ccsPower;
    private int type2Stalls;
    private Set type2Power;
    private boolean isFaulty;

    public ChargerLocation(ChargelocationGSON chargeLocation) {
        super(chargeLocation.getName());
        this.isFaulty = chargeLocation.isFaultReport();
        this.ccsStalls = 0;
        this.type2Stalls = 0;
        this.ccsPower = new HashSet<>();
        this.type2Power = new HashSet<>();
        for (ChargepointGSON cp : chargeLocation.getChargepoints()) {
            if ("CCS".equals(cp.getType())) {
                this.ccsStalls += cp.getCount();
                this.ccsPower.add(cp.getPower());
            } else if ("Typ2".equals(cp.getType())) {
                this.type2Stalls += cp.getCount();
                this.type2Power.add(cp.getPower());
            }
        }

        this.setLatitude(chargeLocation.getCoordinates().getLat());
        this.setLongitude(chargeLocation.getCoordinates().getLng());
        this.network = chargeLocation.getNetwork();
        this.url = chargeLocation.getUrl();
    }

    public boolean isFaulty() {
        return this.isFaulty;
    }

    public String getName() {
        return getProvider();
    }

    public String getUrl() {
        return url;
    }

    /**
     *
     * @return distance in km
     */
    public float getDistanceTo(Location location) {
        return distanceTo(location)/1000;
    }

    public String getNetwork() {
        return network;
    }

    public int getCcsStalls() {
        return ccsStalls;
    }

    public Set getCcsPower() {
        return ccsPower;
    }

    public int getType2Stalls() {
        return type2Stalls;
    }

    public Set getType2Power() {
        return type2Power;
    }
}

package g4rb4g3.at.abrptransmitter.abrp.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Step {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("wp_type")
    @Expose
    private Integer wpType;
    @SerializedName("max_speed")
    @Expose
    private Double maxSpeed;
    @SerializedName("drive_dist")
    @Expose
    private Integer driveDist;
    @SerializedName("is_charger")
    @Expose
    private Boolean isCharger;
    @SerializedName("is_station")
    @Expose
    private Boolean isStation;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("is_waypoint")
    @Expose
    private Boolean isWaypoint;
    @SerializedName("arrival_dist")
    @Expose
    private Integer arrivalDist;
    @SerializedName("arrival_perc")
    @Expose
    private Integer arrivalPerc;
    @SerializedName("charger_type")
    @Expose
    private String chargerType;
    @SerializedName("is_mod_speed")
    @Expose
    private Boolean isModSpeed;
    @SerializedName("waypoint_idx")
    @Expose
    private Integer waypointIdx;
    @SerializedName("is_valid_step")
    @Expose
    private Boolean isValidStep;
    @SerializedName("wait_duration")
    @Expose
    private Integer waitDuration;
    @SerializedName("departure_dist")
    @Expose
    private Integer departureDist;
    @SerializedName("departure_perc")
    @Expose
    private Integer departurePerc;
    @SerializedName("drive_duration")
    @Expose
    private Integer driveDuration;
    @SerializedName("is_destcharger")
    @Expose
    private Boolean isDestcharger;
    @SerializedName("is_end_station")
    @Expose
    private Boolean isEndStation;
    @SerializedName("is_new_waypoint")
    @Expose
    private Boolean isNewWaypoint;
    @SerializedName("arrival_duration")
    @Expose
    private Integer arrivalDuration;
    @SerializedName("departure_duration")
    @Expose
    private Integer departureDuration;
    @SerializedName("is_amenity_charger")
    @Expose
    private Boolean isAmenityCharger;
    @SerializedName("path")
    @Expose
    private List<List<Double>> path = null;
    @SerializedName("charger")
    @Expose
    private Charger charger;
    @SerializedName("charge_cost")
    @Expose
    private Integer chargeCost;
    @SerializedName("charge_profile")
    @Expose
    private List<List<Integer>> chargeProfile = null;
    @SerializedName("charge_duration")
    @Expose
    private Integer chargeDuration;
    @SerializedName("charge_cost_currency")
    @Expose
    private String chargeCostCurrency;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getWpType() {
        return wpType;
    }

    public void setWpType(Integer wpType) {
        this.wpType = wpType;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getDriveDist() {
        return driveDist;
    }

    public void setDriveDist(Integer driveDist) {
        this.driveDist = driveDist;
    }

    public Boolean getIsCharger() {
        return isCharger;
    }

    public void setIsCharger(Boolean isCharger) {
        this.isCharger = isCharger;
    }

    public Boolean getIsStation() {
        return isStation;
    }

    public void setIsStation(Boolean isStation) {
        this.isStation = isStation;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Boolean getIsWaypoint() {
        return isWaypoint;
    }

    public void setIsWaypoint(Boolean isWaypoint) {
        this.isWaypoint = isWaypoint;
    }

    public Integer getArrivalDist() {
        return arrivalDist;
    }

    public void setArrivalDist(Integer arrivalDist) {
        this.arrivalDist = arrivalDist;
    }

    public Integer getArrivalPerc() {
        return arrivalPerc;
    }

    public void setArrivalPerc(Integer arrivalPerc) {
        this.arrivalPerc = arrivalPerc;
    }

    public String getChargerType() {
        return chargerType;
    }

    public void setChargerType(String chargerType) {
        this.chargerType = chargerType;
    }

    public Boolean getIsModSpeed() {
        return isModSpeed;
    }

    public void setIsModSpeed(Boolean isModSpeed) {
        this.isModSpeed = isModSpeed;
    }

    public Integer getWaypointIdx() {
        return waypointIdx;
    }

    public void setWaypointIdx(Integer waypointIdx) {
        this.waypointIdx = waypointIdx;
    }

    public Boolean getIsValidStep() {
        return isValidStep;
    }

    public void setIsValidStep(Boolean isValidStep) {
        this.isValidStep = isValidStep;
    }

    public Integer getWaitDuration() {
        return waitDuration;
    }

    public void setWaitDuration(Integer waitDuration) {
        this.waitDuration = waitDuration;
    }

    public Integer getDepartureDist() {
        return departureDist;
    }

    public void setDepartureDist(Integer departureDist) {
        this.departureDist = departureDist;
    }

    public Integer getDeparturePerc() {
        return departurePerc;
    }

    public void setDeparturePerc(Integer departurePerc) {
        this.departurePerc = departurePerc;
    }

    public Integer getDriveDuration() {
        return driveDuration;
    }

    public void setDriveDuration(Integer driveDuration) {
        this.driveDuration = driveDuration;
    }

    public Boolean getIsDestcharger() {
        return isDestcharger;
    }

    public void setIsDestcharger(Boolean isDestcharger) {
        this.isDestcharger = isDestcharger;
    }

    public Boolean getIsEndStation() {
        return isEndStation;
    }

    public void setIsEndStation(Boolean isEndStation) {
        this.isEndStation = isEndStation;
    }

    public Boolean getIsNewWaypoint() {
        return isNewWaypoint;
    }

    public void setIsNewWaypoint(Boolean isNewWaypoint) {
        this.isNewWaypoint = isNewWaypoint;
    }

    public Integer getArrivalDuration() {
        return arrivalDuration;
    }

    public void setArrivalDuration(Integer arrivalDuration) {
        this.arrivalDuration = arrivalDuration;
    }

    public Integer getDepartureDuration() {
        return departureDuration;
    }

    public void setDepartureDuration(Integer departureDuration) {
        this.departureDuration = departureDuration;
    }

    public Boolean getIsAmenityCharger() {
        return isAmenityCharger;
    }

    public void setIsAmenityCharger(Boolean isAmenityCharger) {
        this.isAmenityCharger = isAmenityCharger;
    }

    public List<List<Double>> getPath() {
        return path;
    }

    public void setPath(List<List<Double>> path) {
        this.path = path;
    }

    public Charger getCharger() {
        return charger;
    }

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    public Integer getChargeCost() {
        return chargeCost;
    }

    public void setChargeCost(Integer chargeCost) {
        this.chargeCost = chargeCost;
    }

    public List<List<Integer>> getChargeProfile() {
        return chargeProfile;
    }

    public void setChargeProfile(List<List<Integer>> chargeProfile) {
        this.chargeProfile = chargeProfile;
    }

    public Integer getChargeDuration() {
        return chargeDuration;
    }

    public void setChargeDuration(Integer chargeDuration) {
        this.chargeDuration = chargeDuration;
    }

    public String getChargeCostCurrency() {
        return chargeCostCurrency;
    }

    public void setChargeCostCurrency(String chargeCostCurrency) {
        this.chargeCostCurrency = chargeCostCurrency;
    }
}

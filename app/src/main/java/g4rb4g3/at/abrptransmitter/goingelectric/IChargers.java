package g4rb4g3.at.abrptransmitter.goingelectric;


import g4rb4g3.at.abrptransmitter.gson.goingelectric.GoingElectricGSON;

public interface IChargers {
    void chargersReady(GoingElectricGSON chargers);
    void chargersFailed();
}

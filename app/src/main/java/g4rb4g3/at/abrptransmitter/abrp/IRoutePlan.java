package g4rb4g3.at.abrptransmitter.abrp;

import g4rb4g3.at.abrptransmitter.abrp.gson.GsonRoutePlan;

public interface IRoutePlan {
    public void planReady(GsonRoutePlan route);
    public void planFailed();
}

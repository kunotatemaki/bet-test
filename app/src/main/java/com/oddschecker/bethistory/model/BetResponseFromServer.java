package com.oddschecker.bethistory.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BetResponseFromServer {

    @Expose
    @SerializedName("singleBets")
    public List<SingleBet> singleBetList = null;

    @Expose
    @SerializedName("opta")
    public List<Opta> opta = null;


    public class SingleBet {
        @Expose
        @SerializedName("betDetails")
        public List<BetDetails> betDetails = null;
        @Expose
        @SerializedName("totalBetStake")
        public String totalBetStake = null;

        @Expose
        @SerializedName("potentialWinnings")
        public String potentialWinnings = null;

    }

    public class BetDetails {
        @Expose
        @SerializedName("optaId")
        public Integer optaId = null;
        @Expose
        @SerializedName("betName")
        public String betName = null;
        @Expose
        @SerializedName("subeventName")
        public String subeventName = null;
        @Expose
        @SerializedName("marketName")
        public String marketName = null;
        @Expose
        @SerializedName("odds")
        public String odds = null;
        @Expose
        @SerializedName("broadcast")
        public BroadCast broadcast = null;

    }

    public class BroadCast {
        @Expose
        @SerializedName("channelLogo")
        public String channelLogo = null;
        @Expose
        @SerializedName("channelName")
        public String channelName = null;
    }

    public class Opta {
        @Expose
        @SerializedName("timeElapsed")
        public String timeElapsed = null;
        @Expose
        @SerializedName("optaId")
        public Integer optaId = null;

    }

}

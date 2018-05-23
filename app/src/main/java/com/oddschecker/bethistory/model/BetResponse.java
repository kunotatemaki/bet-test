package com.oddschecker.bethistory.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BetResponse implements Parcelable {

    public String totalBetStake;

    public String potentialWinnings;

    public String betName;

    public String subEventName;

    public String marketName;

    public String odds;

    public String channelLogo;

    public String channelName;

    public String timeElapsed;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.totalBetStake);
        dest.writeString(this.potentialWinnings);
        dest.writeString(this.betName);
        dest.writeString(this.subEventName);
        dest.writeString(this.marketName);
        dest.writeString(this.odds);
        dest.writeString(this.channelLogo);
        dest.writeString(this.channelName);
        dest.writeString(this.timeElapsed);
    }

    public BetResponse() {
    }

    protected BetResponse(Parcel in) {
        this.totalBetStake = in.readString();
        this.potentialWinnings = in.readString();
        this.betName = in.readString();
        this.subEventName = in.readString();
        this.marketName = in.readString();
        this.odds = in.readString();
        this.channelLogo = in.readString();
        this.channelName = in.readString();
        this.timeElapsed = in.readString();
    }

    public static final Parcelable.Creator<BetResponse> CREATOR = new Parcelable.Creator<BetResponse>() {
        @Override
        public BetResponse createFromParcel(Parcel source) {
            return new BetResponse(source);
        }

        @Override
        public BetResponse[] newArray(int size) {
            return new BetResponse[size];
        }
    };
}

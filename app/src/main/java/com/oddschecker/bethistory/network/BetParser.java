package com.oddschecker.bethistory.network;

import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.model.BetResponseFromServer;

import java.util.ArrayList;
import java.util.List;

public class BetParser {
    static public List<BetResponse> parseResponses(BetResponseFromServer responseFromServer){
        List<BetResponse> responses = new ArrayList<>();
        //parse the response into the data classes
        if (responseFromServer.singleBetList != null) {
            for (int i = 0; i < responseFromServer.singleBetList.size(); i++) {
                BetResponse resp = new BetResponse();
                //single bet
                BetResponseFromServer.SingleBet singleBet = responseFromServer.singleBetList.get(i);
                resp.totalBetStake = singleBet.totalBetStake;
                resp.potentialWinnings = singleBet.potentialWinnings;

                //bet details
                BetResponseFromServer.BetDetails details = null;
                if (singleBet.betDetails != null && singleBet.betDetails.size() > 0) {
                    details = singleBet.betDetails.get(0);
                    resp.betName = details.betName;
                    resp.subEventName = details.subeventName;
                    resp.marketName = details.marketName;
                    resp.odds = details.odds;
                    if (details.broadcast != null) {
                        resp.channelLogo = details.broadcast.channelLogo;
                        resp.channelName = details.broadcast.channelName;
                    }
                }

                //opta
                if (responseFromServer.opta != null) {
                    for (int j = 0; j < responseFromServer.opta.size(); j++) {
                        if (details.optaId.equals(responseFromServer.opta.get(j).optaId)) {
                            resp.timeElapsed = "'" + responseFromServer.opta.get(j).timeElapsed;
                            break;
                        }
                    }
                }
                responses.add(resp);
            }
        }
        return responses;
    }
}

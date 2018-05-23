package com.oddschecker.bethistory;

import com.oddschecker.bethistory.model.BetResponse;
import com.oddschecker.bethistory.model.BetResponseFromServer;
import com.oddschecker.bethistory.network.BetParser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParserUnitTest {
    @Test
    public void convertServerResponse() throws Exception {

        BetResponseFromServer s = new BetResponseFromServer();

        //single bet
        BetResponseFromServer.SingleBet sb = s.new SingleBet();
        sb.potentialWinnings = "potentialWinnings";
        sb.totalBetStake = "totalBetStake";

        //details
        BetResponseFromServer.BetDetails bd = s.new BetDetails();
        bd.optaId = 111;
        bd.betName = "betName";
        bd.subeventName = "subeventName";
        bd.marketName = "marketName";
        bd.odds = "odds";

        //broadcast
        BetResponseFromServer.BroadCast bc = s.new BroadCast();
        bc.channelLogo = "channelLogo";
        bc.channelName = "channelName";

        bd.broadcast = bc;
        sb.betDetails = new ArrayList<>();
        sb.betDetails.add(bd);
        s.singleBetList = new ArrayList<>();
        s.singleBetList.add(sb);

        BetResponseFromServer.Opta opta = s.new Opta();
        opta.optaId = 111;
        opta.timeElapsed = "timeElapsed";
        s.opta = new ArrayList<>();
        s.opta.add(opta);

        List<BetResponse> rs = BetParser.parseResponses(s);

        assertEquals(rs.size(), s.singleBetList.size());
        assertEquals(rs.get(0).betName, s.singleBetList.get(0).betDetails.get(0).betName);
        assertEquals(rs.get(0).totalBetStake, s.singleBetList.get(0).totalBetStake);
        assertEquals(rs.get(0).potentialWinnings, s.singleBetList.get(0).potentialWinnings);
        assertEquals(rs.get(0).subEventName, s.singleBetList.get(0).betDetails.get(0).subeventName);
        assertEquals(rs.get(0).marketName, s.singleBetList.get(0).betDetails.get(0).marketName);
        assertEquals(rs.get(0).odds, s.singleBetList.get(0).betDetails.get(0).odds);
        assertEquals(rs.get(0).channelLogo, s.singleBetList.get(0).betDetails.get(0).broadcast.channelLogo);
        assertEquals(rs.get(0).channelName, s.singleBetList.get(0).betDetails.get(0).broadcast.channelName);
        assertEquals(rs.get(0).timeElapsed, "'" + s.opta.get(0).timeElapsed);

    }


}
package de.honzont;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jens on 11.11.2016.
 */
public class RoundTest {
    CardDeck testdeck;
    Integer hitCounter;
    ArrayList<Player> testplayerarraylist = new ArrayList<>();
    private Card testCard1;
    private Card testCard2;
    private Card testCard3;
    private Card testCard4;
    private Card testCard5;

    @Before
    public void setUp(){
        testdeck = new CardDeck();
        testplayerarraylist.add(new Player());
        testplayerarraylist.add(new Player("Testplayer1", 200));
        testplayerarraylist.add(new Player("Testplayer2", 200));
        testCard1 = new Card("Four of Clubs", 4);
        testCard2 = new Card("Ace of Spades", 11);
        testCard3 = new Card("Ace of Hearts", 11);
        testCard4 = new Card("Ten of Diamonds", 10);
        testCard5 = new Card("Eight of Diamonds", 8);
    }

    @Test
    public void setPlayersToActiveTest() {
        testplayerarraylist.get(0).setPlayerState(PlayerState.BUSTED);
        testplayerarraylist.get(1).setPlayerState(PlayerState.WINNER);
        testplayerarraylist.get(2).setPlayerState(PlayerState.DRAWER);
        Round.resetPlayerState(testplayerarraylist);
        for (int i = 0; i < testplayerarraylist.size(); i++) {
            assertEquals(testplayerarraylist.get(i).getPlayerState(), PlayerState.ACTIVE );
        }

    }


}
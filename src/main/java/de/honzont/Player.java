package de.honzont;

import java.util.ArrayList;
import java.util.List;

/**
* Created by JensGe on 03.11.2016.
*/
public class Player {
    private Integer bankroll;
    private String name;
    private Boolean isDealer = false;
    private ArrayList<Card> hand = new ArrayList<>();
    private Integer bet = 0;
    private PlayerState playerState = PlayerState.ACTIVE;


    public Player(String name, Integer bankroll) {
        this.name = name;
        this.bankroll = bankroll;
    }
    public Player() {
        this.name = "Dealer";
        this.isDealer = true;
        this.bankroll = 0;
    }

    public void drawCard(Card card) {
        this.hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public Integer getHandValue() {
        Integer handValue = 0;
        Integer aceCounter = 0;
        for (Card card : hand) {
            handValue += card.getValue();
            if (card.getName().contains("Ace")) {
                aceCounter++;
            }
        }
        while (handValue > 21 && aceCounter > 0) {
            handValue -= 10;
            aceCounter--;
        }
        return handValue;
    }
    public String getHandAsString() {
        StringBuilder handStringBuilder = new StringBuilder();
        Boolean firstPartDifferent = false;
        for (Card card : getHand()) {
            if (!firstPartDifferent) {
                handStringBuilder.append(card.getName());
                firstPartDifferent = true;
            } else {
                handStringBuilder.append(", ");
                handStringBuilder.append(card.getName());
            }
        }
        return handStringBuilder.toString();
    }
    public void clearHand() {
        hand.clear();
    }

    public Integer getBankroll() {
        return bankroll;
    }
    public void setBankroll(Integer bankroll) {
        this.bankroll = bankroll;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getDealer() {
        return isDealer;
    }
    public void setDealer(Boolean dealer) {
        isDealer = dealer;
    }
    public Integer getBet() {
        return bet;
    }
    public void setBet(Integer bet) {
        this.bet = bet;
    }
    public PlayerState getPlayerState() {
        return playerState;
    }
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

}

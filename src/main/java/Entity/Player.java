package Entity;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;
    private int chips;
    private boolean isFolded;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
        chips = 0;
        isFolded = false;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void placeBet(int bet) {
        chips -= bet;
    }

    public void fold() {
        isFolded = true;
    }

    public boolean hasFolded() {
        return isFolded;
    }

    public String getName() {
        return name;
    }
}

package Entity;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        // Implement a shuffle algorithm here
    }

    public Card dealCard() {
        // Return the top card from the deck and remove it from the list
        return null;
    }
}


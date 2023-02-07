package Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HandEvaluator {
    private static final Map<Integer, String> RANK_NAMES = new HashMap<>();
    static {
        RANK_NAMES.put(1, "Ace");
        RANK_NAMES.put(2, "Two");
        RANK_NAMES.put(3, "Three");
        RANK_NAMES.put(4, "Four");
        RANK_NAMES.put(5, "Five");
        RANK_NAMES.put(6, "Six");
        RANK_NAMES.put(7, "Seven");
        RANK_NAMES.put(8, "Eight");
        RANK_NAMES.put(9, "Nine");
        RANK_NAMES.put(10, "Ten");
        RANK_NAMES.put(11, "Jack");
        RANK_NAMES.put(12, "Queen");
        RANK_NAMES.put(13, "King");
    }
    private static final Map<Integer, String> SUIT_NAMES = new HashMap<>();
    static {
        SUIT_NAMES.put(0, "Spades");
        SUIT_NAMES.put(1, "Hearts");
        SUIT_NAMES.put(2, "Diamonds");
        SUIT_NAMES.put(3, "Clubs");
    }

    public static int evaluateHand(ArrayList<Card> hand ,ArrayList<Card> communityCards) {
        // Evaluate the hand here

        return 0 ;
    }

    private static String getRankName(int rank) {
        return RANK_NAMES.get(rank);
    }

    private static String getSuitName(int suit) {
        return SUIT_NAMES.get(suit);
    }
}

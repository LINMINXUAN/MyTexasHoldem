package Controller;

import Entity.Card;
import Entity.Deck;
import Entity.HandEvaluator;
import Entity.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class TexasHoldem {
    private static final int MAX_PLAYERS = 10;
    private ArrayList<Player> players;
    private Deck deck;
    private ArrayList<Card> communityCards;
    private int dealerIndex;

    public TexasHoldem() {
        players = new ArrayList<>();
        deck = new Deck();
        communityCards = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        deck.shuffle();
        dealerIndex = 0;

        // Deal two cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(deck.dealCard());
            }
        }

        // Place a bet to start the pot
        for (Player player : players) {
            System.out.println("Player " + player.getName() + ", place your bet: ");
            int bet = scanner.nextInt();
            player.placeBet(bet);
        }

        // Flop: deal three community cards
        for (int i = 0; i < 3; i++) {
            communityCards.add(deck.dealCard());
        }

        // Turn: deal one more community card
        communityCards.add(deck.dealCard());

        // River: deal one final community card
        communityCards.add(deck.dealCard());

        // Players take turns betting
        for (int i = dealerIndex; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println("Player " + player.getName() + ", it's your turn. (1) Bet (2) Check (3) Fold");
            int action = scanner.nextInt();
            switch (action) {
                case 1: // Bet
                    System.out.println("Enter your bet amount: ");
                    int bet = scanner.nextInt();
                    player.placeBet(bet);
                    break;
                case 2: // Check
                    break;
                case 3: // Fold
                    player.fold();
                    break;
                default:
                    System.out.println("Invalid action, try again");
                    i--;
                    break;
            }
        }

        // Determine the winner
        Player winner = null;
        int winningHandValue = 0;
        for (Player player : players) {
            if (!player.hasFolded()) {
                int playerHandValue = HandEvaluator.evaluateHand(player.getCards(), communityCards);
                if (playerHandValue > winningHandValue) {
                    winner = player;
                    winningHandValue = playerHandValue;
                }
            }
        }
    }
}

import java.util.Arrays;

public class BridgeHands {
    public static void main(String[] args) {
        int CARDS_PER_PLAYER = 13;

        // number of players
        int PLAYERS = 4;
        
        int NUMBER_OF_RUNS = Integer.parseInt(args[0]);

        String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] hand_descriptions = {"5-3-3-2", "4-4-3-2", "4-3-3-3"};

        // avoid hardwired constants
        int SUITS = suit.length;
        int RANKS = rank.length;
        int CARDS = SUITS * RANKS;

        if (CARDS_PER_PLAYER * PLAYERS > CARDS) throw new RuntimeException("Too many players");

        // initialize deck
        String[][] deck = new String[CARDS][2];
        for (int i = 0; i < RANKS; i++) {
            for (int j = 0; j < SUITS; j++) {
                deck[SUITS*i + j][0] = rank[i];
                deck[SUITS*i + j][1] = suit[j];
            }
        }

        int hand_count[] = new int[3]; 

        // Run the experiment NUMBER_OF_RUNS times
        for(int i = 0; i < NUMBER_OF_RUNS; i++) {
            // shuffle (note we don't need a sorted deck to do this!)
            for (int j = 0; j < CARDS; j++) {
                int r = j + (int) (Math.random() * (CARDS-j));
                String[] t = deck[r];
                deck[r] = deck[j];
                deck[j] = t;
            }
            
            // Deal every card in the deck after shuffling, for this program each player receives 13 cards.
            // Note that the information of the hand is cleared after the players' hands are analysed.
            // Also note that since the deck is random we can give each player 13 cards instead of dealing in turn.
            int hand[] = new int[4];
            for (int j = 0; j < PLAYERS * CARDS_PER_PLAYER; j++) {
                // Check the hand of the player for the distribution of suits.
                if(deck[j][1] == "Clubs") {
                    hand[0]++;
                } else if(deck[j][1] == "Diamonds") {
                    hand[1]++;
                } else if(deck[j][1] == "Hearts") {
                    hand[2]++;
                } else if(deck[j][1] == "Spades") {
                    hand[3]++;
                }

                // If this is the last card dealt to the player.
                if (j % CARDS_PER_PLAYER == CARDS_PER_PLAYER - 1) {
                    Arrays.sort(hand);  // sort trick (we do sorting later!)
                    if(hand[0] == 2 &&
                        hand[1] == 3 &&
                        hand[2] == 3 &&
                        hand[3] == 5)
                        hand_count[0]++;
                    else if(hand[0] == 2 &&
                        hand[1] == 3 &&
                        hand[2] == 4 &&
                        hand[3] == 4)
                        hand_count[1]++;
                    else if(hand[0] == 3 &&
                        hand[1] == 3 &&
                        hand[2] == 3 &&
                        hand[3] == 4)
                        hand_count[2]++;
                    // Clear the hand/distribution record for the next players hand
                    hand[0] = hand[1] = hand[2] = hand[3] = 0;
                }
            }
        }

        // Naive approach ignoring the possibility of draws
        int best_hand = 0;
        for (int i=1; i<hand_count.length; i++) {
            if (hand_count[i] > hand_count[best_hand]) best_hand = i;
        }

        float number_of_hands = NUMBER_OF_RUNS * PLAYERS;
        
        for (int i=0; i<hand_count.length; i++) {
            System.out.println("Probability of "+hand_descriptions[i] + ": " + (float)hand_count[i] / number_of_hands);
        }
        System.out.println(hand_descriptions[best_hand] + " is the most likely.");
    }
}

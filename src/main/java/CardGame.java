import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CardGame {
  private final String name;
  private ArrayList<Card> deckOfCards;

  public CardGame(String name) {
    this.name = name;
    this.deckOfCards = new ArrayList<>();
    initializeDeck();
  }

  public ArrayList<Card> getDeck() {
    return deckOfCards;
  }

  public String getName() {
    return name;
  }

  private void initializeDeck() {
    String[] suits = {"♥", "♣", "♦", "♠"};
    String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    for (String suit : suits) {
      for (int i = 0; i < symbols.length; i++) {
        deckOfCards.add(new Card(suit, symbols[i], values[i]));
      }
    }
  }

  public Card dealCard() {
    if (!deckOfCards.isEmpty()) {
      return deckOfCards.remove(0);
    } else {
      System.out.println("The deck is empty. Cannot deal any more cards.");
      return null;
    }
  }

  public ArrayList<Card> sortDeckInNumberOrder() {
    deckOfCards = deckOfCards.stream()
            .sorted(Comparator.comparingInt(Card::getValue))
            .collect(Collectors.toCollection(ArrayList::new));
    return deckOfCards;
  }

  public ArrayList<Card> sortDeckIntoSuits() {
    deckOfCards = deckOfCards.stream()
            .sorted(Comparator.comparingInt(Card::getValue))
            .sorted(Comparator.comparing(Card::getSuit))
            .collect(Collectors.toCollection(ArrayList::new));
    return deckOfCards;
  }

  public void shuffleDeck() {
    Collections.shuffle(deckOfCards);
  }
}

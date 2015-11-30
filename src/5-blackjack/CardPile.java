import java.util.*;

// ArrayList Docs:
// https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
public class CardPile extends ArrayList<Card> {

  public static String[] standardCards = {
    "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Jack", "Queen", "King"
  };

  public static CardPile deck() {
    CardPile cp = new CardPile();
    int i = 1;
    for (String name : standardCards) {
      cp.add(new Card(name, i, Suit.Spades));
      cp.add(new Card(name, i, Suit.Hearts));
      cp.add(new Card(name, i, Suit.Diamonds));
      cp.add(new Card(name, i, Suit.Clubs));
      if (i < 10) {
        i += 1;
      }
    }
    return cp;
  }

  /**
   * Returns a new "randomly" sorted card pile
   * the initial implementation is no fun
   */
  public void shuffle() {
    Collections.shuffle(this, new Random());
  }

  /**
   * Returns a new "randomly" sorted card pile
   * the initial implementation is no fun
   * this overload takes a seed, yay determinism
   */
  public void shuffle(long seed) {
    Collections.shuffle(this, new Random(seed));
  }

  /**
   * Destructively gets the top card from a pile
   */
  public Card getTopCard() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(this.size() - 1); 
  }

  /**
   * return the sum of all values in the CardPile, aces treated
   * as ones
   */
  public int sum() {
    return this.sum(false);
  }

  /**
   * Toggles between aces having 1, or 11 as values
   */
  public int sum(boolean acesAsEleven) {
    int total = 0, tmpValue;

    for (Card card : this) {
      tmpValue = card.value();
      if (tmpValue == 1 && acesAsEleven) {
        tmpValue = 11;
      }
      total += tmpValue;
    }

    return total;
  }

  public boolean removeAll() {
    return super.removeAll(this);
  }

}

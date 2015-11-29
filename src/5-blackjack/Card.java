public class Card {
  protected int val;
  protected String cardName;
  protected boolean isVisible;
  protected Suit suit;

  public Card(String name, int value, Suit suit) {
    this.cardName = name;
    this.val = value;
    this.isVisible = false;
    this.suit = suit;
  }

  public String name() {
    return this.cardName;
  }

  public int value() {
    return this.val;
  }

  public boolean isFaceUp() {
    return this.isVisible;
  }

  public void flip() {
    if (this.isVisible) {
      this.isVisible = false;
    } else {
      this.isVisible = true;
    }
  }
}

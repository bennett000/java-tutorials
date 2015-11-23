public class Card {
  protected int val;
  protected String cardName;
  protected boolean isVisible;

  public Card(String n, int v) {
    this.cardName = n;
    this.val = v;
    this.isVisible = false;
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

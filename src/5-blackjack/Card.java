public class Card {
  protected int val;
  protected String cardName;
  protected boolean isVisible;
  protected House house;

  public Card(String n, int v, House h) {
    this.cardName = n;
    this.val = v;
    this.isVisible = false;
    this.house = h;
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

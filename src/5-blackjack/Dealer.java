public class Dealer {
  private int hitsOn;
  private int deckCount;
  protected long seed;
  protected CardPile shoe;
  protected CardPile cards;

  public Dealer(int hitsOn, int deckCount, long seed) {
    this(hitsOn, deckCount);
    this.seed = seed;
  }

  public Dealer(int hitsOn, int deckCount) {
    this(hitsOn, deckCount);
    if (deckCount < 1) {
      deckCount = 1;
    }
    this.deckCount = deckCount;
  }

  public Dealer(int hitsOn) {
    this();
    this.hitsOn = hitsOn;
  }

  public Dealer() {
    hitsOn = 17;
    deckCount = 4;
  }

  public void deal(ArrayList<Player> players) {
    // "real deal" simulation 
    for (Player p : players) {
      p.giveCard(shoe.getTopCard());
    }
    cards.add(shoe.getTopCard());
    for (Player p : players) {
      p.giveCard(shoe.getTopCard());
    }
    cards.add(shoe.getTopCard());
  }

  public void resetShoe() {
    shoe = new CardPile();
    int i = 0;
    for (i = 0; i < deckCount; i += 1) {
      shoe.addAll(CardPile.deck());
    }
    shoe.shuffle(seed);
  }
}

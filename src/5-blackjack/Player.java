public class Player {
  private static int defaultPurse = 100;
  public static int count = 0;
  private int id;
  protected CardPile cards = new CardPile();
  protected int purse;
  protected String name;
  protected Species species;

  public Player(Species species, int purse, String name) {
    this(species, purse);
    this.name = name;
  }

  public Player(Species species, int purse) {
    this(species);
    this.purse = purse;
  }

  public Player(Species species) {
    this.species = species;
    this.name = "Player #" + this.id;
    this.purse = defaultPurse;
    this.id = count++;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getPurse() {
    return this.purse;
  }

  public Species getSpecies() {
    return this.species;
  }

  public boolean decrementPurse(int value) {
    if (purse - value < 0) {
      return false;
    }
    purse -= value;
    return true;
  }

  public boolean decrementPurse() {
    return this.decrementPurse(1);
  }

  public void giveCard(Card c) {
    this.cards.add(c);
  }

  public int sumCards() {
    return this.cards.sum();
  }

  public int sumCards(boolean acesAsEleven) {
    return this.cards.sum(acesAsEleven);
  }

  public void takeCards() {
    /** @todo check for errors */
    this.cards.removeAll();
  }

}

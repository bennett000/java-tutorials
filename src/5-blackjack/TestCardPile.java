import junit.framework.TestCase;          // import the test framework
import static org.junit.Assert.*;

public class TestCardPile extends TestCase { // extend the base class

  public void testInstantiation() {
    CardPile cp = new CardPile();
  }

  public void testGetTopCardNull() {
    CardPile cp = new CardPile();
    Card c = cp.getTopCard();
    assertEquals(null, c);
  }

  public void testGetTopCardOneCard() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    assertEquals(3, cp.getTopCard().value());
  }

  public void testGetTopCardTwoCards() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Four", 4, Suit.Spades));
    assertEquals(4, cp.getTopCard().value());
  }

  public void testSumThreeCards() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Acey", 1, Suit.Spades));
    assertEquals(4, cp.sum());
  }

  public void testSumThreeCardsAcesAsEleven() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Acey", 1, Suit.Spades));
    assertEquals(14, cp.sum(true));
  }

  public void testShuffleNoSeed() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Acey", 4, Suit.Spades));
    cp.add(new Card("Blah", 4, Suit.Spades));
    cp.add(new Card("Whoa", 2, Suit.Spades));
    cp.add(new Card("Bae", 7, Suit.Spades));
    cp.shuffle();
    // This in all _probability_ will _not_ always be the case :P
    // so this breaks, there is a better way to test it
    // possibly by serializing the pile into a string
    //assertNotEquals(cp.getTopCard().value(), 7);
  }

  public void testShuffleSeed() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Acey", 4, Suit.Spades));
    cp.add(new Card("Blah", 4, Suit.Spades));
    cp.add(new Card("Whoa", 2, Suit.Spades));
    cp.add(new Card("Acey", 4, Suit.Spades));
    cp.shuffle(23);
    // this will always happen, yay deteerminism
    assertEquals(cp.getTopCard().value(), 4);
  }

  public void testDeckSize() {
    CardPile cp = CardPile.deck();
    assertEquals(cp.size(), 52);
  }

  public void testDeckSum() {
    CardPile cp = CardPile.deck();
    int expectedSum = 55 * 4 + // Sum(1..10) * 4 suits
      10 * 3 * 4; // J-K * 4 suits
    assertEquals(cp.sum(), expectedSum);
  }

  public void testRemoveAll() {
    CardPile cp = new CardPile();
    cp.add(new Card("Three", 3, Suit.Spades));
    cp.add(new Card("Acey", 4, Suit.Spades));
    cp.add(new Card("Blah", 4, Suit.Spades));
    cp.removeAll();
    assertEquals(cp.size(), 0);
  }
}

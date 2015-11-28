import junit.framework.TestCase;          // import the test framework

public class TestCard extends TestCase { // extend the base class

  public void testName() {
    Card c = new Card(CarName.Two, 2, House.Spades);
    assertEquals("Two", c.name());
  }

  public void testValue() {
    Card c = new Card("Two", 3, House.Hearts);
    assertEquals(3, c.value());
  }

  public void testVisible() {
    Card c = new Card("Two", 3, House.Diamonds);
    assertEquals(false, c.isFaceUp());
  }

  public void testMakeCardVisible() {
    Card c = new Card("Five", 3, House.Clubs);
    c.flip();
    assertEquals(true, c.isFaceUp());
  }

  public void testMakeCardInvisible() {
    Card c = new Card("two", 3, House.Spades);
    c.flip();
    c.flip();
    assertEquals(false, c.isFaceUp());
  }
}

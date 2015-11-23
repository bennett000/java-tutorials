import junit.framework.TestCase;          // import the test framework

public class TestCard extends TestCase { // extend the base class

  public void testName() {
    Card c = new Card("two", 2);
    assertEquals("two", c.name());
  }

  public void testValue() {
    Card c = new Card("two", 3);
    assertEquals(3, c.value());
  }

  public void testVisible() {
    Card c = new Card("two", 3);
    assertEquals(false, c.isFaceUp());
  }

  public void testMakeCardVisible() {
    Card c = new Card("two", 3);
    c.flip();
    assertEquals(true, c.isFaceUp());
  }

  public void testMakeCardInvisible() {
    Card c = new Card("two", 3);
    c.flip();
    c.flip();
    assertEquals(false, c.isFaceUp());
  }
}

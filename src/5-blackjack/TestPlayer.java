import junit.framework.TestCase;          // import the test framework
import static org.junit.Assert.*;

public class TestPlayer extends TestCase { // extend the base class

  public void testSpeciesConstruct() {
    Player p = new Player(Species.Human);
    assertEquals(p.getSpecies(), Species.Human);
  }

  public void testPurseConstruct() {
    Player p = new Player(Species.Human, 300);
    assertEquals(p.getPurse(), 300);
  }

  public void testNameConstruct() {
    Player p = new Player(Species.Human, 500, "pat");
    assertEquals(p.getName(), "pat");
  }

  public void testId() {
    Player p1 = new Player(Species.Human),
           p2 = new Player(Species.Robot1);
    assertNotEquals(p1.getId(), p2.getId());
  }

  public void testDecrementPurseValid() {
    Player p = new Player(Species.Human, 100);
    p.decrementPurse();
    assertEquals(p.getPurse(), 99);
  }

  public void testDecrementPurseInvalid() {
    Player p = new Player(Species.Human, 100);
    assertEquals(p.decrementPurse(500), false);
    assertEquals(p.getPurse(), 100);
  }

  public void testGiveCardOneA() {
    Player p = new Player(Species.Human, 100);
    p.giveCard(new Card("Ace", 1, Suit.Spades));
    assertEquals(p.sumCards(), 1);
  }

  public void testGiveCardOneB() {
    Player p = new Player(Species.Human, 100);
    p.giveCard(new Card("Ace", 1, Suit.Spades));
    assertEquals(p.sumCards(true), 11);
  }

  public void testTakeCards() {
    Player p = new Player(Species.Human, 100);
    p.giveCard(new Card("Ace", 1, Suit.Spades));
    p.takeCards();
    assertEquals(p.sumCards(true), 0);
  }
}

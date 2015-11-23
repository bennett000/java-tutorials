import junit.framework.TestCase;          // import the test framework

public class TestMaths extends TestCase { // extend the base class
  protected Maths maths;                  // setup a maths singleton

  public TestMaths() {                    // setup a constructor function to initialize stuff
    this.maths = new Maths();             // initialize the maths singleton
  }

  public void testAdd1Plus1() {           // write a basic addition test
    int x = 1; int y = 1;                    // setup some test variables
    assertEquals(2, this.maths.add(1, 1));   // make sure they add correctly 
  }
}

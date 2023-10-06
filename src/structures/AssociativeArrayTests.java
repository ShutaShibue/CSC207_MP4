package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


/**
 * Tests of the AssociativeArray class.
 *
 * @author CSC-207 2023Fa
 */
public class AssociativeArrayTests {

  // +-----------------------+---------------------------------------
  // | Tests by Shuta Shibue |
  // +-----------------------+
  @Test
  public void shutaShibueTest1() {
    // Build Array
    AssociativeArray<String, Integer> test1 = new AssociativeArray<String, Integer>();
    // Setting some values
    test1.set("CSC", 207);
    test1.set("BIO", 150);
    test1.set("STA", 209);
    try {
      assertEquals(150, test1.get("BIO"));
    } catch (Exception e) {
      fail("Value should be 150");
    } // try-catch
    assertEquals("{ CSC: 207, BIO: 150, STA: 209 }", test1.toString());
    // Remove the middle value
    test1.remove("CSC"); // should remove element
    assertEquals(2, test1.size);
    test1.remove("CSC"); // should do nothing
    assertEquals(2, test1.size);
  }// shutaShibueTest1()

  @Test
  public void shutaShibueTest2() {
    // Build Array
    AssociativeArray<String, String> test1 = new AssociativeArray<String, String>();
    // Setting some values
    test1.set("CSC", "207");
    test1.set("CSC", "161");
    test1.set("STA", "209");
    try {
      assertEquals("161", test1.get("CSC"));
    } catch (Exception e) {
      fail("Value should be 161");
    } // try-catch
    assertEquals("{ CSC: 161, STA: 209 }", test1.toString());
    // Remove the middle value
    test1.remove("CSC"); // should remove element
    assertEquals(1, test1.size);
    test1.remove("STA"); // should do nothing
    assertEquals(0, test1.size);
  }// shutaShibueTest2()

  @Test
  public void shutaShibueEdge() {
    // Build Array
    AssociativeArray<String, String> test1 = new AssociativeArray<String, String>();
    // Setting some values
    test1.set("", "207");
    try {
      assertEquals("207", test1.get(""));
    } catch (Exception e) {
      fail("Value should be 207");
    } // try-catch
    assertEquals("{ : 207 }", test1.toString());
    // Remove the middle value
  }// shutaShibueEdge()

  //Working with null key and value
  @Test
  public void Edge2() {
    AssociativeArray<String, String> edge2 = new AssociativeArray<String, String>();
    edge2.set(null, "nullkey");
    edge2.set("nullval", null);
    try {
      assertEquals("nullkey", edge2.get(null));
    } catch (Exception e) {
      fail("Value should be nullkey\n" + e);
    } // try-catch
    try {
      assertEquals(null, edge2.get("nullval"));
    } catch (Exception e) {
      fail("Value should be null\n" + e);
    } // try-catch
  }

} // class AssociativeArrayTests

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void numDistinctExample1() {
    assertEquals(3, sol.numDistinct("rabbbit", "rabbit"));
  }
  @Test
  void numDistinctExample2() {
    assertEquals(5, sol.numDistinct("babgbag", "bag"));
  }

  @Test
  void numDistinctDFSExample1() {
    assertEquals(3, sol.numDistinctDFS("rabbbit", "rabbit"));
  }
  @Test
  void numDistinctDFSExample2() {
    assertEquals(5, sol.numDistinctDFS("babgbag", "bag"));
  }
}
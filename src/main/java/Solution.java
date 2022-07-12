import java.util.Arrays;

public class Solution {
  public int numDistinct(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (sLen < tLen) {
      return 0;
    }
    // dp[i][j]: s[:i] subsequences number composed of  t[:j]
    int[][] dp = new int[sLen+1][tLen+1];
    for (int sEnd = 0; sEnd <= sLen; sEnd++) {
      // when t is empty string
      dp[sEnd][0] = 1;
    }
    for (int sEnd = 1; sEnd <= sLen; sEnd++) {
      for (int tEnd = 1; tEnd <= tLen; tEnd++) {
        if (s.charAt(sEnd-1) == t.charAt(tEnd-1)) {
          dp[sEnd][tEnd] = dp[sEnd - 1][tEnd - 1] + dp[sEnd - 1][tEnd];
        } else {
          dp[sEnd][tEnd] = dp[sEnd-1][tEnd];
        }
      }
    }
    return dp[sLen][tLen];
  }

  public int numDistinctDFS(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (sLen < tLen) {
      return 0;
    }
    int maxLen = 0;
    int[][] cache = new int[sLen][tLen];
    for (int sIndex = 0; sIndex < sLen; sIndex++ ) {
      Arrays.fill(cache[sIndex], -1);
    }
    for (int sIndex= 0; sIndex < sLen; sIndex++) {
      for (int tIndex = 0; tIndex <tLen; tIndex++) {
        int result = DFS(s, sIndex, t, tIndex, cache);
        if (maxLen < result) {
          maxLen = result;
        }
      }
    }
    return maxLen;
  }
  public int DFS(String s, int sIndex, String t, int tIndex, int[][] cache) {
    int sLen = s.length();
    int tLen = t.length();
    if (tIndex == tLen) { // reach match end
      return 1;
    }
    if (sIndex == sLen) { // not match end
      return 0;
    }
    if (cache[sIndex][tIndex] != -1) {
      return cache[sIndex][tIndex];
    }
    int result = 0;
    if (s.charAt(sIndex) == t.charAt(tIndex)) {
      result = DFS(s, sIndex+1, t, tIndex +1, cache) + DFS(s, sIndex+1, t, tIndex, cache);
    } else {
      result = DFS(s, sIndex+1, t, tIndex, cache);
    }
    cache[sIndex][tIndex] = result;
    return result;
  }
}

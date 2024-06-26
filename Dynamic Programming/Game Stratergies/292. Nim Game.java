// https://leetcode.com/problems/nim-game/

// Solution 1 (TLE)
class Solution {
    public boolean canWinNim(int n) {
        return canWinNim(n, 0);
    }

    private boolean canWinNim(int n, int player) {
        if (n == 0) {
            return false;
        }

        if (n >= 1 && n <= 3) {
            return true;
        }

        return !canWinNim(n - 1, 1 - player) || !canWinNim(n - 2, 1 - player) || !canWinNim(n - 3, 1 - player);
    }
}

// Solution 2 (TLE)
// See that the player field is unnecessary now
class Solution {
    public boolean canWinNim(int n) {
        return canWinNimHelper(n);
    }

    private boolean canWinNimHelper(int n) {
        if (n == 0) {
            return false;
        }

        if (n >= 1 && n <= 3) {
            return true;
        }

        return !canWinNimHelper(n - 1) || !canWinNimHelper(n - 2) || !canWinNimHelper(n - 3);
    }
}

// Solution 3 (Use DP)
// But n ranges from 0 to 2^31 - 1, and this solution also gives TLE


// Solution 4
class Solution {
    public boolean canWinNim(int n) {
        return n % 4 == 0?false: true;
    }
}

//Explanation: 
f(x) = f(x-2) && f(x-3) && f(x-4)  || f(x-3) && f(x-4) && f(x-5) || f(x-4) && f(x-5) && f(x-6)
if one of the term is true, then A wins the game.
As you can see if f(x-4) is false, then A loses the game.
f(1), f(2), f(3) are true
this inplies f(4n+1), f(4n+2), f(4n+3) is true.
and f(4n) is false.
    
// check this: https://leetcode.com/problems/nim-game/discuss/73760/One-line-O(1)-solution-and-explanation
// variation of this problem: https://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/

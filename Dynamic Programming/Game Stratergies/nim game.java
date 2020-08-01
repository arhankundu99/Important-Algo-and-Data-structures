// https://leetcode.com/problems/nim-game/

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

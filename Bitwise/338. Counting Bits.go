// https://leetcode.com/problems/counting-bits/description/
func countBits(n int) []int {
    setBitCount := make([]int, n + 1)

    for i := 0; i <= n; i++ {
        setBitCount[i] = setBitCount[i / 2] + (i & 1)
    }
    return setBitCount
}
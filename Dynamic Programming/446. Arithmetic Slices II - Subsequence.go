// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/

func numberOfArithmeticSlices(nums []int) int {
    if len(nums) < 3 {
        return 0
    }

    count := 0
    dp := make([]map[int]int, len(nums))
    for i := range dp {
        dp[i] = make(map[int]int)
    }

    for i := 1; i < len(nums); i++ {
        for j := 0; j < i; j++ {
            diff := nums[i] - nums[j]
            dp[i][diff] += 1
            if cnt, ok := dp[j][diff]; ok {
                dp[i][diff] += cnt
                count += cnt
            }
        }
    }

    return count
}
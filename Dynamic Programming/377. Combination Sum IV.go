// https://leetcode.com/problems/combination-sum-iv/description/
func combinationSum4(nums []int, target int) int {
    dp := make([]int, target + 1)
    for i := 0; i < target + 1; i++ {
        dp[i] = -1
    }
    return combinationSumHelper(nums, target, dp)
}

func combinationSumHelper(nums []int, target int, dp []int) int {
    if target == 0 {
        return 1
    }
    if target < 0 {
        return 0
    }

    if dp[target] != -1 {
        return dp[target]
    }

    combinations := 0
    for i := 0; i < len(nums); i++ {
        combinations += combinationSumHelper(nums, target - nums[i], dp)
    }
    dp[target] = combinations
    return combinations
}
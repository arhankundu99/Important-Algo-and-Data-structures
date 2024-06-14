// https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14
func minIncrementForUnique(nums []int) int {
    count := 0
    sort.Ints(nums)

    for i := 1; i < len(nums); i++ {
        if nums[i] <= nums[i - 1] {
            increment := nums[i - 1] - nums[i] + 1
            count += increment

            nums[i] = nums[i - 1] + 1
        }
    }
    return count
}
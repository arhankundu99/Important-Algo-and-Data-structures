// https://leetcode.com/problems/sum-of-two-integers/description/
func getSum(a int, b int) int {
    for b != 0 {
        carry := (a & b) << 1 // Calculate the carry, which is common set bits of a and b shifted by one
        a = a ^ b            // Sum of bits where at least one of the bits is not set
        b = carry            // Assign carry to b for next operation
    }
    return a
}
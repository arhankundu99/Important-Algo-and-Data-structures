//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
boolean isPowerOfFour(int num) {
    return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
}

public static int modInverse(int a, int mod) {
    return modExp(a, mod - 2, mod); // Fermat’s Little Theorem
}

public class ModularArithmeticExample {

    public static final int MOD = 1000000007;

    public static int modAdd(int a, int b) {
        return (a + b) % MOD;
    }

    public static int modMul(int a, int b) {
        return (a * b) % MOD;
    }

    public static int modExp(int base, int exp) {
        int result = 1;
        base = base % MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            exp = exp >> 1;
            base = (base * base) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 123456789;
        int b = 987654321;
        System.out.println("Addition: " + modAdd(a, b)); // Output modulo 1000000007
        System.out.println("Multiplication: " + modMul(a, b)); // Output modulo 1000000007
        System.out.println("Exponentiation: " + modExp(a, 5)); // (a^5) % 1000000007
    }
}

class TestFractionToDecimal {
    public static void main(String[] args) {
        testBasicFractions();
        testNegativeFractions();
        testRepeatingDecimals();
        testZeroNumerator();
        testZeroDenominator();
    }

    // 测试正常分数的转换
    public static void testBasicFractions() {
        Solution1 solution = new Solution1();
        assertEqual("0.5", solution.fractionToDecimal(1, 2));
        assertEqual("2", solution.fractionToDecimal(2, 1));
        assertEqual("0.(012)", solution.fractionToDecimal(4, 333));
    }

    // 测试负数分子和分母的处理
    public static void testNegativeFractions() {
        Solution1 solution = new Solution1();
        assertEqual("0.5", solution.fractionToDecimal(-1, -2));
        assertEqual("-0.5", solution.fractionToDecimal(-1, 2));
        assertEqual("-0.5", solution.fractionToDecimal(1, -2));
    }

    // 测试循环小数的处理
    public static void testRepeatingDecimals() {
        Solution1 solution = new Solution1();
        assertEqual("0.1(6)", solution.fractionToDecimal(1, 6));
        assertEqual("-0.58(3)", solution.fractionToDecimal(7, -12));
    }

    // 测试分子为0的情况
    public static void testZeroNumerator() {
        Solution1 solution = new Solution1();
        assertEqual("0", solution.fractionToDecimal(0, 3));
    }

    // 测试分母为0的情况（应抛出异常）
    public static void testZeroDenominator() {
        Solution1 solution = new Solution1();
        try {
            solution.fractionToDecimal(1, 0);
            System.out.println("Expected exception not thrown for denominator zero.");
        } catch (ArithmeticException e) {
            System.out.println("Exception correctly thrown for denominator zero.");
        }
    }

    // 辅助方法：比较预期结果和实际结果
    private static void assertEqual(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.out.println("Expected: " + expected + ", but got: " + actual);
        } else {
            System.out.println("Test passed for value: " + expected);
        }
    }
}

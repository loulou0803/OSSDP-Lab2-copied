import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 *
 * 示例 1：
 *
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 *
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 *
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 *
 */
class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; // 如果分子为0，直接返回0
        
        StringBuilder sb = new StringBuilder();
        // 确定符号
        if (numerator < 0 ^ denominator < 0) {
            sb.append('-');
        }

        // 使用long以避免溢出
        long numeratorLong = Math.abs((long) numerator);
        long denominatorLong = Math.abs((long) denominator);

        // 计算整数部分
        sb.append(numeratorLong / denominatorLong);
        long remainder = numeratorLong % denominatorLong;
        if (remainder == 0) return sb.toString(); // 如果没有小数部分，返回结果

        sb.append('.'); // 添加小数点
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        remainderIndexMap.put(remainder, sb.length());
        
        while (remainder != 0) {
            remainder *= 10;
            sb.append(remainder / denominatorLong);
            remainder %= denominatorLong;

            if (remainderIndexMap.containsKey(remainder)) {
                int index = remainderIndexMap.get(remainder);
                sb.insert(index, '(');
                sb.append(')');
                return sb.toString(); // 返回结果
            }
            remainderIndexMap.put(remainder, sb.length());
        }
        
        return sb.toString(); // 返回最终结果
    }
}

//This is Mugic
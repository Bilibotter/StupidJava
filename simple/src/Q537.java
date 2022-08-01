import java.util.Arrays;

public class Q537 {
    // 95.5%
    public String complexNumberMultiply1(String num1, String num2) {
        String[] left = num1.split("\\+");
        String[] right = num2.split("\\+");
        int real1 = Integer.parseInt(left[0]);
        int real2 = Integer.parseInt(right[0]);
        int img1 = Integer.parseInt(left[1].substring(0, left[1].length()-1));
        int img2 = Integer.parseInt(right[1].substring(0, right[1].length()-1));
        return new StringBuilder().append(real1*real2-img1*img2).append("+").append(real1*img2+real2*img1).append("i").toString();
    }

    // 某脑子抽筋的sb写的
    public String complexNumberMultiply2(String num1, String num2) {
        Integer[] left = Arrays.stream(num1.split("\\+"))
                .map(it-> (it.endsWith("i") ? it.substring(0, it.length()-1):it))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] right = Arrays.stream(num2.split("\\+"))
                .map(it-> (it.endsWith("i") ? it.substring(0, it.length()-1):it))
                .map(Integer::parseInt).toArray(Integer[]::new);
        return (new StringBuilder()).append(left[0]*right[0]-left[1]*right[1]).append("+").append(left[0]*right[1]+left[1]*right[0]).append("i").toString();
    }
}

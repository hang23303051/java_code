//给定一个字符串，你需要写一个程序来反转句子中 每个单词中的字符顺序，同时仍然保留空白和初始的词序
import java.util.Arrays;
import java.util.Scanner;
public class home1_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入一个句子：");
        String str = reader.nextLine();
        int a[] = new int[100];
        int temp = 0;  //空格数量
        Arrays.fill(a, 0);  // 初始化数组
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                a[temp] = i;
                temp++;
            }
        }
        a[temp] = str.length();
        String[] S = new String[temp + 1];
        int start = 0;
        // 根据记录的空格位置使用substring提取每个单词
        for (int i = 0; i <= temp; i++) {
            S[i] = str.substring(start, a[i]);
            start = a[i] + 1;
        }

        // 反转每个单词中的字符
        for (int i = 0; i <= temp; i++) {
            S[i] = new StringBuilder(S[i]).reverse().toString();
        }

        for (int i = 0; i < temp; i++) {
            System.out.print(S[i] + " ");
        }
        System.out.print(S[temp]);
    }
}

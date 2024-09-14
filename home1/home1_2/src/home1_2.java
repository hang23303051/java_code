//输入一个字符串，请分别统计字符串中所包含的各个不同字符个数
import java.util.Arrays;
import java.util.Scanner;
public class home1_2 {
    public static void main(String[ ] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.printf("请输入一个字符串\n");
        String str = reader.nextLine();
        int a[]=new int[256];
        Arrays.fill(a,0);
        int i;
        for ( i=0;i<str.length();i++)
        {
            int ch = (int)str.charAt(i);
            a[ch]++;  // 在对应字符的计数位置加1
        }
        for(i=0;i<256;i++)
        {
            if(a[i]>0)
            {
                System.out.printf("%c=%d ",i,a[i]);
            }
        }
    }
}

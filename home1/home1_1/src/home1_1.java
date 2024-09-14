//写一个程序，提示用户输入 1 到 15 的整数，并显示一个金字塔
import java.util.Scanner;
public class home1_1{
    public static void main(String[ ] args)
    {
        int i=0;
        int j;
        int k;
        System.out.printf("请输入1到15的整数：");
        Scanner reader = new Scanner(System.in);
        j = reader.nextInt();
        if(j<1||j>15)
        {
            System.out.printf("数据超过范围");
            return;
        }
        for(i=1;i<=j;i++)
        {
            for(k=1;k<2*(j-i);k++)
            {
                System.out.printf(" ");
            }
            for(k=i;k>=1;k--)
            {
                System.out.printf("%d ",k);
            }
            for(k=2;k<=i;k++)
            {
                System.out.printf("%d ",k);
            }
            System.out.printf("\n");
        }
    }
}

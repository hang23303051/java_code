//李博士正在做一些关于中国古代音乐的研究。很多中国古代音乐只有五种音调，可以用 “C”、“D”、
//        “E”、“G”、“A” 来表示。给定一段乐谱，李想做一些简单的统计。
//
//        输入（测试用例不超过20个）
//        在每个测试用例中:
//        第一行包含两个整数 n 和 m (2 <= n, m<=20)，表示一段乐谱是用 n*m 的音调矩阵表示的。矩阵中只能出
//        现 ‘C’、‘D’、‘E’、‘G’ 和 ‘A’。然后是 n*m 矩阵。输入以一行 “0 0” 结束。
//        输出（对于每个测试用例）
//        对于矩阵中所示的每一种音调，计算其出现次数，并按照出现次数降序打印结果。如果有不止一种音调具
//        有相同的出现次数，则按字典顺序打印。
//ACDEG

import java.util.*;//代表导入所有
public class home1_4 {
    public static void main(String[] args) {
        int n, m;
        int i, j, k;
        Scanner reader = new Scanner(System.in);
        int count = 0;
        String a[][][] = new String[20][][];
        int b[]=new int[5];
        int idex[]=new int[5];
        Arrays.fill(idex,0);
        Arrays.fill(b,0);
        while (count >= 0) {
            if (count > 20) {
                System.out.print("输入用例超过20");
                return;
            }
            n = reader.nextInt();
            m = reader.nextInt();
            if (n == 0 && m == 0) {
                break;
            } else {
                a[count] = new String[n][m];
                for (j = 0; j < n; j++) {
                    for (k = 0; k < m; k++) {
                        a[count][j][k] = reader.next();
                    }
                }
                count++;
            }
        }
        for (i = 0;i<count;i++ ) {
            for(j=0;j<a[i].length;j++)
            {
                for(k=0;k<a[i][j].length;k++)
                {
                    switch(a[i][j][k])
                    {
                        case "A":b[0]++;break;
                        case "C":b[1]++;break;
                        case "D":b[2]++;break;
                        case "E":b[3]++;break;
                        case "G":b[4]++;break;
                    }
                }
            }
            int temp1=0,temp2=0;
            for(k=0;k<5;k++) {
                for (j = 0; j < 5; j++) {
                    if (b[j] > temp1) {
                        temp1 = b[j];
                        temp2 = j;
                    }
                }
                b[temp2]=0;
                switch(temp2)
                {
                    case 0:System.out.printf("A:");break;
                    case 1:System.out.printf("C:");break;
                    case 2:System.out.printf("D:");break;
                    case 3:System.out.printf("E:");break;
                    case 4:System.out.printf("G:");break;
                }
                System.out.printf("%d ",temp1);
                temp1=0;
            }
            System.out.printf("\n");
            Arrays.fill(b,0);//重置b
        }

    }
}

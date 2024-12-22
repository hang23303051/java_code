package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ͼ�����࣬���ڶ�ȡ��ͼ�����ļ��������ݴ洢����ά�����С�
 */
public class Map {
    // �������������ڴ洢��ͼ�����е�ÿһ�����ݣ��ַ�����ʽ����
    public List<String> list = new ArrayList<>();

    // ��ά���飬���ڴ洢��ͼ�����о���������ʽ����
    public int[][] map = null;

    // �ļ���ض������ڶ�ȡ��ͼ�ļ���
    public File myfile;
    public FileInputStream fis;
    public InputStreamReader isr;
    public BufferedReader br;

    /**
     * ��ȡ��ͼ�ļ�������ת��Ϊ��ά���顣
     *
     * @param num ��ͼ�ļ���ţ�������ȡ�ĸ���ͼ�ļ���
     * @return ��ͼ�Ķ�ά�������顣
     * @throws Exception ����ڶ�ȡ�ļ�ʱ��������
     */
    public int[][] readMap(int num) throws Exception {
        // ���ݵ�ͼ���ѡ��Ҫ��ȡ���ļ�
        if (num == 1) {
            myfile = new File("map1.txt");
        } else if (num == 2) {
            myfile = new File("map2.txt");
        } else if (num == 3) {
            myfile = new File("map3.txt");
        } else if (num == 4) {
            myfile = new File("map4.txt");
        } else if (num == 5) {
            myfile = new File("map5.txt");
        }

        // �����ļ�����������صĶ�ȡ��
        FileInputStream fis = new FileInputStream(myfile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        // ���ж�ȡ�ļ�����
        String value = br.readLine();
        while (value != null) {
            // ����ȡ����һ�����ݼ��뵽������
            list.add(value);
            value = br.readLine();
        }

        // �رն�ȡ��
        br.close();

        // ��ȡ��ͼ������
        int row = list.size();

        // ��ȡ��ͼ���������ٶ������е�����һ�£�
        int column = 0;
        for (int i = 0; i < 1; i++) {
            String str = list.get(i);
            String[] values = str.split(",");
            column = values.length;
        }

        // ��ʼ����ά����Ĵ�С
        map = new int[row][column];

        // ����ȡ�����ַ�������ת��Ϊ����������ֵ����ά������
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] values = str.split(",");
            for (int j = 0; j < values.length; j++) {
                map[i][j] = Integer.parseInt(values[j]);
            }
        }

        // �������õĵ�ͼ����
        return map;
    }
}

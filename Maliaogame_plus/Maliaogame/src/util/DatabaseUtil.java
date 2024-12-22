package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * DatabaseUtil �����ڹ������ݿ����Ӻ���Դ�Ĺرա�
 */
public class DatabaseUtil {
    // ���ݿ����ӵ�URL�����а��������ݿ�ĵ�ַ���˿ں����ݿ�����
    private static final String URL = "jdbc:mysql://localhost:3306/mario?useSSL=false&serverTimezone=UTC";
    // ���ݿ��û���
    private static final String USER = "hang";
    // ���ݿ�����
    private static final String PASSWORD = "8892297";

    /**
     * ��ȡ���ݿ����ӵķ�����
     *
     * @return ����һ�� Connection �������������ݿ���н�����
     * @throws Exception �������������������ʧ�ܣ����׳��쳣��
     */
    public static Connection getConnection() throws Exception {
        // �������ݿ�����
        Class.forName("com.mysql.cj.jdbc.Driver");
        // �������������ݿ�����
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * �ر����ݿ���Դ�ķ������������ӡ�Ԥ�������ͽ������
     *
     * @param conn  Ҫ�رյ����ݿ�����
     * @param pstmt Ҫ�رյ�Ԥ�������
     * @param rs    Ҫ�رյĽ����
     */
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            // �رս����
            if (rs != null) rs.close();
            // �ر�Ԥ�������
            if (pstmt != null) pstmt.close();
            // �ر����ݿ�����
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace(); // ��ӡ�쳣��ջ������Ϣ
        }
    }

    /**
     * �ر����ݿ���Դ�ķ��������������Ӻ�Ԥ������䡣
     *
     * @param conn  Ҫ�رյ����ݿ�����
     * @param pstmt Ҫ�رյ�Ԥ�������
     */
    public static void close(Connection conn, PreparedStatement pstmt) {
        // �������ص� close ���������� null ��Ϊ���������
        close(conn, pstmt, null);
    }
}

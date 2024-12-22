package util;

import role.GameRecord;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GameRecordDAO �����ڶ���Ϸ��¼�������ݿ�������������桢���ºͲ�ѯ��
 */
public class GameRecordDAO {

    /**
     * ������Ϸ��¼�����ݿ�ķ�����
     *
     * @param gameRecord Ҫ�������Ϸ��¼����
     */
    public void saveGameRecord(GameRecord gameRecord) {
        // SQL ��䣬���ڲ���һ����Ϸ��¼
        String sql = "INSERT INTO game_records (username, score, blood, created_at, level) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // ���� SQL ����еĲ���ֵ
            pstmt.setString(1, gameRecord.getUsername());
            pstmt.setInt(2, gameRecord.getScore());
            pstmt.setInt(3, gameRecord.getBlood());
            pstmt.setTimestamp(4, gameRecord.getCreatedAt());
            pstmt.setInt(5, gameRecord.getLevel());

            // ִ�в������
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // ��ӡ�쳣��ջ������Ϣ
        }
    }

    public void updateGameRecord(GameRecord gameRecord) {
        String sql = "UPDATE game_records SET score = ?, blood = ?, created_at = ?, level = ? WHERE username = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, gameRecord.getScore());
            pstmt.setInt(2, gameRecord.getBlood());
            pstmt.setTimestamp(3, gameRecord.getCreatedAt());
            pstmt.setInt(4, gameRecord.getLevel());
            pstmt.setString(5, gameRecord.getUsername());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Game record updated successfully for username: " + gameRecord.getUsername());
            } else {
                System.out.println("No record found for username: " + gameRecord.getUsername());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * �����û�����ȡ��Ϸ��¼�ķ�����
     *
     * @param username Ҫ��ѯ���û�����
     * @return ����һ���������û�������Ϸ��¼���б�
     */
    public List<GameRecord> getGameRecordsByUsername(String username) {
        List<GameRecord> gameRecords = new ArrayList<>();
        // SQL ��䣬���ڲ�ѯָ���û�������Ϸ��¼
        String sql = "SELECT id, username, score, blood, created_at, level FROM game_records WHERE username = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // ���� SQL ����еĲ���ֵ
            pstmt.setString(1, username);

            // ִ�в�ѯ��������������
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String user = rs.getString("username");
                int score = rs.getInt("score");
                int blood = rs.getInt("blood");
                Timestamp createdAt = rs.getTimestamp("created_at");
                int level = rs.getInt("level");

                // ���� GameRecord ������������
                GameRecord gameRecord = new GameRecord(user, score, blood, createdAt, level);
                gameRecord.setId(id); // ���ô����ݿ��ȡ��ID
                gameRecords.add(gameRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gameRecords; // ������Ϸ��¼�б�
    }
}

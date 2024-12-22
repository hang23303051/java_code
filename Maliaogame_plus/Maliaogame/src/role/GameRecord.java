package role;

import java.sql.Timestamp;

/**
 * GameRecord�����ڱ�ʾ��Ϸ��¼��
 * ������������ݿ���ж�Ӧ���ֶΣ��Լ���صĹ��캯���ͷ�����������getter��setter����
 */
public class GameRecord {

    // �����ݿ���е��ж�Ӧ���ֶ�
    private int id; // ��Ϸ��¼��Ψһ��ʶ��
    private String username; // ����û���
    private int score; // ��ҵ÷�
    private int blood; // ���ʣ������ֵ��Ѫ��
    private int level; // ��Ϸ�ؿ�
    private Timestamp createdAt; // ��Ϸ��¼�Ĵ���ʱ��

    /**
     * ���ι��캯�������ڳ�ʼ��GameRecord����������ֶΡ�
     *
     * @param username ����û���
     * @param score ��ҵ÷�
     * @param blood ���Ѫ��
     * @param createdAt ��Ϸ��¼����ʱ��
     * @param level ��Ϸ�ؿ�
     */
    public GameRecord(String username, int score, int blood, Timestamp createdAt, int level) {
        this.username = username;  // ��ʼ���û���
        this.score = score;        // ��ʼ���÷�
        this.blood = blood;        // ��ʼ��Ѫ��
        this.createdAt = createdAt; // ��ʼ������ʱ��
        this.level = level;         // ��ʼ���ؿ�
    }

    /**
     * ��ȡ��Ϸ�ؿ���
     *
     * @return ��ǰ����Ϸ�ؿ�
     */
    public int getLevel() {
        return level;
    }

    /**
     * ������Ϸ�ؿ���
     *
     * @param level �µ���Ϸ�ؿ�
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Ĭ�Ϲ��캯����
     * ���ڴ���һ���յ�GameRecord����
     */
    public GameRecord() {}

    /**
     * �������ֶεĹ��캯�������ڳ�ʼ��GameRecord����
     *
     * @param username ����û���
     * @param level ��Ϸ�ؿ�
     * @param createdAt ��Ϸ��¼����ʱ��
     */
    public GameRecord(String username, int level, Timestamp createdAt) {
        this.username = username;
        this.level = level;
        this.createdAt = createdAt;
    }

    /**
     * ��ȡ��Ϸ��¼��ID��
     *
     * @return ��Ϸ��¼��ID
     */
    public int getId() {
        return id;
    }

    /**
     * ������Ϸ��¼��ID��
     *
     * @param id �µ���Ϸ��¼ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * ��ȡ����û�����
     *
     * @return ����û���
     */
    public String getUsername() {
        return username;
    }

    /**
     * ��������û�����
     *
     * @param username �µ�����û���
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * ��ȡ��ҵ÷֡�
     *
     * @return ��ҵ÷�
     */
    public int getScore() {
        return score;
    }

    /**
     * ������ҵ÷֡�
     *
     * @param score �µ���ҵ÷�
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * ��ȡ���Ѫ����
     *
     * @return ���Ѫ��
     */
    public int getBlood() {
        return blood;
    }

    /**
     * �������Ѫ����
     *
     * @param blood �µ����Ѫ��
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }

    /**
     * ��ȡ��Ϸ��¼�Ĵ���ʱ�䡣
     *
     * @return ��Ϸ��¼�Ĵ���ʱ��
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * ������Ϸ��¼�Ĵ���ʱ�䡣
     *
     * @param createdAt �µ���Ϸ��¼����ʱ��
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * ���ض�����ַ�����ʾ��ʽ��
     *
     * @return �������������ֶε��ַ���
     */
    @Override
    public String toString() {
        return "GameRecord{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", score=" + score +
                ", blood=" + blood +
                ", createdAt=" + createdAt +
                '}';
    }
}

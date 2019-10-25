package DBpratice;

import java.sql.*;                     
public class JdbcConnect {

        private Connection con = null; // Connection ��ü
        private Statement stmt = null; // Statenebt  ��ü
        private PreparedStatement pstmt = null; // PreparedStatement ��ü
        private ResultSet rs = null; // ResultSet    ��ü

        /**
         *  JdbcConnect ������, mySql ����̹� �ε� �� Connection ��ü ����
         * @param dbName DataBase�̸�
         * @param rootPassword root���� �н�����
         */
        public JdbcConnect(String dbName, String rootPassword) throws Exception{
            try {
                //sql ����̹��� �ε��ϴ� �����Դϴ�.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Driver Install Complete");
            }catch(ClassNotFoundException cnfe) {
                System.err.println("Error : " + cnfe);
            }
           
            //jdbc:mysql://(�������ּ�):(��Ʈ��ȣ)/(DB�̸�)(�������ڵ����)
            //'?useUnicode=true&characterEncoding=utf8'�� utf8���ڵ� ����� ����Ѵٴ� ��������, DB��
            // �ѱ��� �Էµ��� �ʴ°�� �����Ͽ��� �������.
            String url = "jdbc:sqlserver://localhost:1433;databaseName=member";
            String id = "sa";
            String pw = "1234";
           
            try {
                con = DriverManager.getConnection(url, id, pw);
                stmt = con.createStatement();
                System.out.println("Connection Complete");
            }catch(SQLException e) {
                System.err.println("Error : " + e);
            }
        }

        /**
         * ����� �� ��ü(ResultSet, PreparedStatement, Statement, Connect)�� �ݾ��ִ� �޼ҵ�
         * @return ��ü�� ���� �� �������� ����
         */
        public boolean closeDB(){
                try {
                        if(rs   !=      null)   rs.close();
                        if(pstmt!=      null)   pstmt.close();
                        if(stmt !=      null)   stmt.close();
                        if(con  !=      null)   con.close();
                        return true;
                } catch (SQLException e) {
                        e.printStackTrace();
                        return false;
                }
        }

        /**
         * Statement�� �����Ͽ� ��������� �����ϴ� �޼ҵ�
         */
        void createStatement() throws SQLException{
                // 4�ܰ� : Statement ��ü ����
                stmt = con.createStatement();
        }

        /**
         * prepareStatement�� �����Ͽ� ��������� �����ϴ� �޼ҵ�
         * @param sql prepareStatement�� ������ sql��
         */
        void prepareStatement(String sql) throws SQLException{
                // 4�ܰ� : prepareStatement ��ü ����
                pstmt = con.prepareStatement(sql);
        }

        /**
         * PreparedStatement�� ä������ String�� �����ϴ� �޼ҵ�
         */
        void setString(int parameterIndex, String x) throws SQLException{
                if(pstmt!=null)
                        pstmt.setString(parameterIndex, x);
        }

        /**
         * Update��(UPDATE, DELETE ��)�� �����ϴ� �޼ҵ�(Statement��ü ���� ��)
         */
        void excuteUpdate(String sql) throws SQLException{
                if(stmt!=null)
                        stmt.executeUpdate(sql);
        }

        /**
         * Update��(UPDATE, DELETE ��)�� �����ϴ� �޼ҵ�(PreparedStatement��ü ���� ��)
         */
        void excuteUpdate() throws SQLException{
                pstmt.executeUpdate();
        }

        /**
         * Query��(SELECT ��)�� �����ϴ� �޼ҵ�(Statement��ü  ���� ��)
         * @return
         */
        public ResultSet excuteQuery() throws SQLException{
                rs = pstmt.executeQuery();
                return rs;
        }

        /**
         * Query��(SELECT ��)�� �����ϴ� �޼ҵ�(PreparedStatement��ü ���� ��)
         * @return
         */
        public ResultSet excuteQuery(String sql) throws SQLException{
                if(stmt!=null){
                        rs = stmt.executeQuery(sql);
                        return rs;
                }else
                        return null;
        }

        public ResultSet getResultSet(){
                return rs;
        }

        /**
         * primaryKey���� �Է� �޾�  ������ ���� �ִ��� �˻� �� ����� ���� 
         * @param primaryKey            Insert/Update�� primaryKey��
         * @param columnName            PrimaryKey �÷��̸�
         * @param tableName             ���̺� �̸�
         * @return      ������ ���� �ִٸ� false, ������ ���̸� true
         */
        public boolean isUnique(String primaryKey,String columnName, String tableName) throws SQLException{
                String sql = "SELECT * FROM "+tableName+" WHERE "+columnName+"= '"+primaryKey+"'";
                return isUnique(sql);
        }

        /**
         * primaryKey���� �Է� �޾�  ������ ���� �ִ��� �˻� �� ����� ���� 
         * @param primaryKey            Insert/Update�� primaryKey��
         * @param columnName            PrimaryKey �÷��̸�
         * @param tableName             ���̺� �̸�
         * @return      ������ ���� �ִٸ� false, ������ ���̸� true
         */
        public boolean isUnique(int primaryKey,String columnName, String tableName) throws SQLException{
                String sql = "SELECT * FROM "+tableName+" WHERE "+columnName+"= "+primaryKey;
                return isUnique(sql);
        }

        private boolean isUnique(String sql) throws SQLException {
                ResultSet rsTemp = stmt.executeQuery(sql);

                if(rsTemp.next())       return false;

                return true;
        }

        /**
         *  excuteQuery �� ResultSet�� �ִ� ����(Select�� ����)�� Console�� ���
         */
        public boolean showSelect() throws SQLException{
                rs=stmt.executeQuery("SELECT point, userSex, userAge,userTel FROM rank order by point DESC;");
                if(rs==null){
                    return false; 
                }
                   


                ResultSetMetaData rsmd = rs.getMetaData();

                int numberColumn = rsmd.getColumnCount();
                String[] columName = new String[numberColumn];

                for (int i = 0; i < numberColumn; i++) {
                        System.out.print(columName[i] = rsmd.getColumnName(i+1));
                        System.out.print(" | ");
                }
                System.out.println();


                while(rs.next())  {
                        for (int i = 0; i < numberColumn; i++) {
                                System.out.print(rs.getString(columName[i]));
                                System.out.print(" | ");
                        }
                        System.out.println();
                }
                return true;
        }
}
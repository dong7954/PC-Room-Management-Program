package DBpratice;

import java.sql.*;                     
public class JdbcConnect {

        private Connection con = null; // Connection 객체
        private Statement stmt = null; // Statenebt  객체
        private PreparedStatement pstmt = null; // PreparedStatement 객체
        private ResultSet rs = null; // ResultSet    객체

        /**
         *  JdbcConnect 생성자, mySql 드라이버 로딩 및 Connection 객체 생성
         * @param dbName DataBase이름
         * @param rootPassword root접속 패스워드
         */
        public JdbcConnect(String dbName, String rootPassword) throws Exception{
            try {
                //sql 드라이버를 로딩하는 문구입니다.
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Driver Install Complete");
            }catch(ClassNotFoundException cnfe) {
                System.err.println("Error : " + cnfe);
            }
           
            //jdbc:mysql://(접속할주소):(포트번호)/(DB이름)(문자인코딩방식)
            //'?useUnicode=true&characterEncoding=utf8'은 utf8인코딩 방식을 사용한다는 선언문으로, DB에
            // 한글이 입력되지 않는경우 삭제하여도 상관없다.
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
         * 사용한 각 객체(ResultSet, PreparedStatement, Statement, Connect)를 닫아주는 메소드
         * @return 객체를 닫은 후 성공여부 리턴
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
         * Statement를 생성하여 멤버변수에 저장하는 메소드
         */
        void createStatement() throws SQLException{
                // 4단계 : Statement 객체 생성
                stmt = con.createStatement();
        }

        /**
         * prepareStatement를 생성하여 멤버변수에 저장하는 메소드
         * @param sql prepareStatement를 생성할 sql문
         */
        void prepareStatement(String sql) throws SQLException{
                // 4단계 : prepareStatement 객체 생성
                pstmt = con.prepareStatement(sql);
        }

        /**
         * PreparedStatement에 채워넣을 String을 설정하는 메소드
         */
        void setString(int parameterIndex, String x) throws SQLException{
                if(pstmt!=null)
                        pstmt.setString(parameterIndex, x);
        }

        /**
         * Update문(UPDATE, DELETE 등)을 실행하는 메소드(Statement객체 사용시 만)
         */
        void excuteUpdate(String sql) throws SQLException{
                if(stmt!=null)
                        stmt.executeUpdate(sql);
        }

        /**
         * Update문(UPDATE, DELETE 등)을 실행하는 메소드(PreparedStatement객체 사용시 만)
         */
        void excuteUpdate() throws SQLException{
                pstmt.executeUpdate();
        }

        /**
         * Query문(SELECT 등)을 실행하는 메소드(Statement객체  사용시 만)
         * @return
         */
        public ResultSet excuteQuery() throws SQLException{
                rs = pstmt.executeQuery();
                return rs;
        }

        /**
         * Query문(SELECT 등)을 실행하는 메소드(PreparedStatement객체 사용시 만)
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
         * primaryKey값을 입력 받아  동일한 값이 있는지 검사 후 결과값 리턴 
         * @param primaryKey            Insert/Update할 primaryKey값
         * @param columnName            PrimaryKey 컬럼이름
         * @param tableName             테이블 이름
         * @return      동일한 값이 있다면 false, 유일한 값이면 true
         */
        public boolean isUnique(String primaryKey,String columnName, String tableName) throws SQLException{
                String sql = "SELECT * FROM "+tableName+" WHERE "+columnName+"= '"+primaryKey+"'";
                return isUnique(sql);
        }

        /**
         * primaryKey값을 입력 받아  동일한 값이 있는지 검사 후 결과값 리턴 
         * @param primaryKey            Insert/Update할 primaryKey값
         * @param columnName            PrimaryKey 컬럼이름
         * @param tableName             테이블 이름
         * @return      동일한 값이 있다면 false, 유일한 값이면 true
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
         *  excuteQuery 후 ResultSet에 있는 내용(Select한 내용)을 Console에 출력
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
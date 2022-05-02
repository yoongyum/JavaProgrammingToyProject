import org.h2.*;
import org.h2.Driver;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

    //JDBC 관련변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    ArrayList<Member> members = new ArrayList<>();

    //SQL 명령어들
    private String MEMBER_LIST = "SELECT * FROM MEMBER";    // <-- MemberManager.getMemberList

    private String MEMBER_INSERT = "INSERT INTO MEMBER VALUES(?,?,?)";// <-- MemberManager.insertMember

    private String MEMBER_UPDATE = "UPDATE MEMBER SET PHONE_NUMBER=? WHERE STUDENT_NO = ?";// <-- MemberManager.updateMember

    private String MEMBER_DELETE = "DELETE MEMBER WHERE MEMBER_ID = ?";// <-- MemberManager.deleteMember

    //모든 멤버 출력
    public void selectListAll(){
        
    }

    //회원 가입
    public void insertMember(String id, String name, String phoneNumber){
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_INSERT);
            stmt.setString(1,id);
            stmt.setString(2,name);
            stmt.setString(3,phoneNumber);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
          JDBCUtil.close(stmt, conn);
        }

    }

    //멤버 수정
    public boolean updateMember(String phoneNumber, String name){
        var res = 0;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_UPDATE);
            stmt.setString(1,phoneNumber);
            stmt.setString(2,name);
            res = stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
        return res != 0;
    }

    public void deleteMember(){

    }
}

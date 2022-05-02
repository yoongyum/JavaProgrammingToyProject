import org.h2.*;
import org.h2.Driver;

import java.sql.*;

public class MemberDAO {

    //JDBC 관련변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;


    //SQL 명령어들
    private String MEMBER_LIST = "SELECT * FROM MEMBER";    // <-- MemberManager.getMemberList

    private String MEMBER_INSERT = "INSERT INTO MEMBER VALUE(?,?,?)";// <-- MemberManager.insertMember

    private String MEMBER_UPDATE = "UPDATE MEMBER SET ";// <-- MemberManager.updateMember

    private String MEMBER_DELETE = "DELETE MEMBER WHERE MEMBER_ID = ?";// <-- MemberManager.deleteMember

    //모든 멤버 출력
    public void selectListAll(){
        
    }
    //회원 가입
    public void insertMember(String id, String name, String phoneNumber) throws SQLException {
        stmt = conn.prepareStatement(MEMBER_INSERT);
        System.out.println(stmt.executeUpdate());

    }

    //멤머 수정
    public void updateMember(){
        
    }

    public void deleteMember(){

    }
}

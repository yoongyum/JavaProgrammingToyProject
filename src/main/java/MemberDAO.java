import org.h2.*;
import org.h2.Driver;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

    //JDBC 관련변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    //SQL 명령어들
    private String MEMBER_LIST = "SELECT * FROM MEMBER";    // <-- MemberManager.getMemberList

    private String MEMBER_SEARCH = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";    // <-- MemberManager.insertMember

    private String MEMBER_INSERT = "INSERT INTO MEMBER VALUES(?,?,?)";// <-- MemberManager.insertMember

    private String MEMBER_UPDATE = "UPDATE MEMBER SET PHONE_NUMBER=? WHERE MEMBER_ID = ?";// <-- MemberManager.updateMember

    private String MEMBER_DELETE = "DELETE MEMBER WHERE MEMBER_ID = ?";// <-- MemberManager.deleteMember


    //모든 멤버 출력
    public void selectListAll(){
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_LIST);
            rs = stmt.executeQuery();
            int size = 0;
            while(rs.next()){
                size++;
                var member = new Member();
                member.setId(rs.getString("MEMBER_ID"));
                member.setName(rs.getString("NAME"));
                member.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                System.out.println(member.toString());
            }
            if (size==0) System.out.println("등록된 회원이 없습니다.");

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
    }

    public boolean searchMember(String id){
        boolean check = false;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_SEARCH);
            stmt.setString(1,id);
            rs = stmt.executeQuery();

            check = rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return check;
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
    public boolean updateMember(String ID, String phoneNumber){
        var res = 0;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_UPDATE);
            stmt.setString(1,phoneNumber);
            stmt.setString(2,ID);
            res = stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
        return res != 0;
    }

    public boolean deleteMember(String ID){
        var res = 0;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MEMBER_DELETE);
            stmt.setString(1,ID);
            res = stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
        return res != 0;
    }
}

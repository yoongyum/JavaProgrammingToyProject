import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MemberManager {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    MemberDAO DAO = new MemberDAO();
    ArrayList<Member> memberList = new ArrayList<>();

    public void readMenu() throws Exception {

        while(true){
            printCommandGuide();
            var cmd = br.readLine();
            switch (cmd){
                case "0": //0일경우 readMenu() 종료..,
                    return;
                case "1":
                    getMemberList();
                    break;
                case "2":
                    insertMember();
                    break;
                case "3":
                    updateMember();
                    break;
                case "4":
                    deleteMember();
                    break;

            }
        }
    }

    //회원 목록
    public void getMemberList(){
        DAO.selectListAll();
    }

    //회원 등록
    public void insertMember() throws Exception {
        System.out.print("아이디를 입력하세요 (형식 M-00001): ");
        String inputID = br.readLine();
        System.out.print("이름을 입력하세요: ");
        String inputNAME = br.readLine();
        System.out.print("전화번호를 입력하세요: ");
        String inputPhoneNumber = br.readLine();

        DAO.insertMember(inputID, inputNAME, inputPhoneNumber);

        Member member = new Member();
        member.setId(inputID);
        member.setName(inputNAME);
        member.setPhoneNumber(inputPhoneNumber);
        memberList.add(member);
        System.out.println("---> 회원가입에 성공하셨습니다.");
    }

    //회원 수정
    public void updateMember() throws Exception {
        System.out.print("수정할 아이디를 입력하세요 (형식 M-00001): ");
        String inputID = br.readLine();
        System.out.print("수정할 전화번호를 입력하세요: ");
        String inputPhoneNumber = br.readLine();
        if(DAO.updateMember(inputID, inputPhoneNumber)){
            System.out.println("---> 회원수정에 성공하셨습니다.");
        }else{
            System.out.println("---> 일치하는 ID가 없습니다.");
        }

    }

    //회원 삭제
    public void deleteMember(){
        DAO.deleteMember();
    }

    public void printCommandGuide(){
        System.out.println("목록을 원하시면 1번을 입력하세요.");
        System.out.println("등록을 원하시면 2번을 입력하세요.");
        System.out.println("수정을 원하시면 3번을 입력하세요.");
        System.out.println("삭제를 원하시면 4번을 입력하세요.");
        System.out.println("종료을 원하시면 0번을 입력하세요.");
    }
}

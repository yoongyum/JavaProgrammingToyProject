import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberManager {

    public void readMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            printCommandGuide();
            var cmd = br.readLine();
            switch (cmd){
                case "0": //0일경우 readMenu() 종료..
                    return;
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;

            }
        }
    }

    public void printCommandGuide(){
        System.out.println("목록을 원하시면 1번을 입력하세요.");
        System.out.println("등록을 원하시면 2번을 입력하세요.");
        System.out.println("수정을 원하시면 3번을 입력하세요.");
        System.out.println("삭제를 원하시면 4번을 입력하세요.");
        System.out.println("종료을 원하시면 0번을 입력하세요.");
    }
}

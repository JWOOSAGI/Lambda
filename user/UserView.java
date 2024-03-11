package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        UserController controller = new UserController();
        String msg = controller.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴] 0-종료 |" +
                    " 1-회원가입 |" +
                    " 2-로그인 |" +
                    " 3-ID검색 |" +
                    " 4-비번변경 |" +
                    " 5-탈퇴 |" +
                    " ls-회원목록 |" +
                    " 7-이름검색 |" +
                    " 8-직업검색 |" +
                    " 9-회원수 |" +
                    " touch-테이블생성 |" +
                    " rm-테이블삭제"
                    );
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-회원가입");
                    msg = controller.save(sc);
                    System.out.println("회원가입 결과 : "+msg);
                    break;
                case "2":
                    System.out.println("2-로그인");
                    msg = controller.login(sc);
                    System.out.println("로그인 결과 : "+msg);
                    break;
                case "3":
                    System.out.println("3-ID 검색");
//                    System.out.println(controller.getOne(sc));
                    System.out.println(controller.test());
//                    User u = findOne
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(controller.updatePassword(sc));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(controller.delete(sc));
                    break;
                case "ls":
                    System.out.println("6-회원목록");
//                    List<User> users = controller.findUsers();
//                    users.forEach(i -> System.out.println(i));
                    System.out.println(controller.findUsers());
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    controller.findUsersByName(sc).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    controller.findUsersByJob(sc).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9-회원수");
                    String numberOfUsers = controller.count();
                    System.out.println("회원수 "+numberOfUsers);
                    break;
                    case "touch":
                    System.out.println("테이블생성");
                    System.out.println(controller.mktable());
                    break;
                    case "rm":
                    System.out.println("테이블삭제");
                    controller.rmtable();
                    break;

            }

        }

    }
}

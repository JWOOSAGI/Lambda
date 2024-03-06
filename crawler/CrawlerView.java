package crawler;


import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController controller = new CrawlerController();
        Iterator<Element> title;
        Iterator<Element> artist;
        Iterator<Element> rank;
        Map<String, ?> map;

        while(true){
            System.out.println("[사용자메뉴] 0-종료" +
                    " 1-벅스" +
                    " 2-멜론" +
                    " 3-ID검색" +
                    " 4-비번변경" +
                    " 5-탈퇴" +
                    " 6-회원목록" +
                    " 7-이름검색" +
                    " 8-직업검색" +
                    " 9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    map = controller.findBugsMusic(sc);
                    title = (Iterator<Element>) map.get("title");
                    artist = (Iterator<Element>) map.get("artist");
                    rank = (Iterator<Element>) map.get("rank");
                    System.out.println("벅스뮤직 결과 : ");
                    while(rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("2-멜론뮤직");
                    map = controller.findMelonMusic(sc);
                    title = (Iterator<Element>) map.get("title");
                    artist = (Iterator<Element>) map.get("artist");
                    rank = (Iterator<Element>) map.get("rank");
                    System.out.println("멜론뮤직 결과 : ");
                    while(rank.hasNext()){
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "3":
                    System.out.println("3-ID 검색");
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    break;
                case "9":
                    System.out.println("9-회원수");
                    break;

            }

        }
    }
}

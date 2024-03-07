package articles;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article {
    private Long id;
    private String title;
    private String content;
    private String writer;
    @Builder(builderMethodName = "builder")
    public Article(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
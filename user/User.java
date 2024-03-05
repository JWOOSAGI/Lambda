package user;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString(exclude = {"id"})

public class User {
    private Long id;
    private String username;
    private String password;

    private String passwordConfirm;
    private String name;

    private String ssn;
    private String phoneNumber;
    private String address;
    private String job;

    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(String username, String password, String passwordConfirm, String name, String ssn, String phoneNumber, String address,
                String job, double height, double weight){
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.name = name;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return  "{username=" + username + '\n' +
                " password=" + password + '\n' +
                " name=" + name + '\n' +
                " ssn=" + ssn + '\n' +
                " phoneNumber=" + phoneNumber + '\n' +
                " address=" + address + '\n' +
                " job=" + job +
                '}'+'\n'+'\n';
    }
}

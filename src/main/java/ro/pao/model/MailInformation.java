package ro.pao.model;

import lombok.*;

import java.util.UUID;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MailInformation {

    private UUID id;

    private String firstName;

    private String lastName;

    private final Predicate<String> mailCondition = (mail) -> mail.contains("@yahoo") || mail.contains("@gmail");
    private final BiPredicate<String, String> fullNameCondition = (firstName, lastName) -> firstName.equals(this.firstName) && lastName.equals(this.lastName);

    public MailInformation(String mail) {
        if (!mailCondition.test(mail)) {
            System.out.println("The e-mail address is not valid.");
        }

        var mailSplit = mail.split("@")[0];
        var fullNameSplit = mailSplit.split(".");

        if (!fullNameCondition.test(fullNameSplit[0], fullNameSplit[1])) {
            System.out.println("The name does not match.");
        }

        this.firstName = fullNameSplit[0];
        this.lastName = fullNameSplit[1];
    }

    public MailInformation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

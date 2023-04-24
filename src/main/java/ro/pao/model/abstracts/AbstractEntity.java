package ro.pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class AbstractEntity {
    @Builder.Default
    private UUID id = UUID.randomUUID();

    /**2
     * Date nu stocheaza decat data, nu si ora. Daca vreti sa adaugati si ora, folositi LocalDateTime.
     * LocalDate.of(), LocalDateTime.of(), LocalDateTime.now() sunt metode care se pot folosi.
     * Daca folositi LocalDateTime sa redenumiti si voi variabilele cu sens, adica sa fie ceva de genul creationDateTime, daca contin si ora.
     */
    @Builder.Default
    private LocalDate creationDate = LocalDate.now();

    private LocalDate updateDate;

    private LocalDate deleteDate;
}

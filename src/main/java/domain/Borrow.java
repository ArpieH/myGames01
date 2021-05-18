package domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@SuperBuilder
@Data

public class Borrow extends BasicEntity {

    private Game game;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;
}

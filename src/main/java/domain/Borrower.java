package domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Borrower extends BasicEntity {
    private String borrowerName;
    private String street;
    private String houseNumber;
    private String busNumber;
    private String postalCode;
    private String telephone;
    private String email;
    private String city;

}

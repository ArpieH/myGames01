package services;

import domain.Borrower;
import repositorie.BorrowerRepository;
import repositorie.NotFoundException;

import java.util.List;

public class BorrowerService {
    BorrowerRepository borrowerRepository = new BorrowerRepository();
    public Borrower findBorrower(){
        return borrowerRepository.findInfoBorrower();
    }
List<Borrower> searchBorrowerByName (String string) throws ClassNotFoundException, NotFoundException {
    return borrowerRepository.searchBorrowerByName(string);

}

}

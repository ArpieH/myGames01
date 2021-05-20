package com.vdab.services;

import com.vdab.domain.Borrower;
import com.vdab.repositorie.BorrowerRepository;
import com.vdab.repositorie.NotFoundException;

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

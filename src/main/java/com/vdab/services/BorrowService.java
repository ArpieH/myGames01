package com.vdab.services;

import com.vdab.domain.Borrow;
import com.vdab.domain.Borrower;
import com.vdab.repositorie.BorrowRepository;

import java.util.List;

public class BorrowService {
    BorrowRepository  borrowRepository = new BorrowRepository();
    List<Borrow> showBorrowedGAmes (){
        return borrowRepository.showBorrowedGames();
    }

    public List<Borrow> stillBorrowed(){
        return borrowRepository.showBorrowedGames();
    }

    public void updateLoan(int choice, Borrower borrower) {
        borrowRepository.updateLoan(choice,borrower);}}



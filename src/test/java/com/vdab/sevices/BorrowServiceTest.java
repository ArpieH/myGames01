package com.vdab.sevices;

import domain.Borrow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repositorie.BorrowRepository;
import services.BorrowService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class BorrowServiceTest {
    @Mock
    private BorrowRepository borrowRepository;

    @InjectMocks
    private BorrowService borrowService = new BorrowService();

    @BeforeEach
    public void setup(){
        List<Borrow> borrowList = new ArrayList<>();
        borrowList.add(Borrow.builder()
                .id(4)
                .borrowDate(new Date(2004, 1, 2)).returnDate(new Date(2008, 1, 2))
                .build()
        );
        Mockito.lenient().when(borrowRepository.listStillBorrowed()).thenReturn(borrowList);
    }


    @Test
    public void updateLoan(){
        borrowService.updateLoan(1,null);
        Mockito.verify(borrowRepository).updateLoan(1, null);


    }

    @Test
    public void testListStillBorrowedNotEmpty(){
        List<Borrow> borrowList= borrowService.stillBorrowed();
        Mockito.verify(borrowRepository).listStillBorrowed();
        Assertions.assertFalse(borrowList.isEmpty());}}




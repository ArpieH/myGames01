package com.vdab.commandpattern;

import com.vdab.services.BorrowService;
import com.vdab.services.BorrowerService;
import com.vdab.services.CategoryService;
import com.vdab.services.GameServices;

import java.util.Scanner;

public interface Command {
    Scanner scanner = new Scanner(System.in);
    GameServices gameService = new GameServices();
    CategoryService categoryService = new CategoryService();
    BorrowerService borrowerService = new BorrowerService();
    BorrowService borrowService = new BorrowService();

    void execute() throws Exception;

}

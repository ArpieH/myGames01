package commandpattern;

import services.BorrowService;
import services.BorrowerService;
import services.CategoryService;
import services.GameServices;

import java.util.Scanner;

public interface Command {
    Scanner scanner = new Scanner(System.in);
    GameServices gameService = new GameServices();
    CategoryService categoryService = new CategoryService();
    BorrowerService borrowerService = new BorrowerService();
    BorrowService borrowService = new BorrowService();

    void execute() throws Exception;

}

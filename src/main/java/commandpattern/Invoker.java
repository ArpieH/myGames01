package commandpattern;

import lombok.Getter;
@Getter
public enum Invoker {




    SHOW_CAT_FOR_ID("1","1 show category for id", new ShowCatForld()),
    SHOW_THE_5TH_GAME("2","2 Show the fifth game", new Show5ThGame()),
    SHOW_THE_FIRST_BORROWER("3","3 Show the first borrower", new ShowTheFirstBorrower()),
    SHOW_GAME_AND_CHOOICE("4","4 Show a game of your choice", new ShowGamesOfYourChoose()),
    SHOW_ALL_GAMES("5","5 Show all games", new ShowAllGames()),
    SHOW_ALL_BORROWERS_FROM_LAST_MONTH("6","6  Show a list of games and choose a game", new ShowListOfGamesAndChoose()),
    SHOW_ALL_BORROWERS_ISERT_NEW_BORROWERS("7","7 Show borrowed games", new ShowBorrowedGames()),
    ADVANCE_SEARCH_DIFFICULCY("8","8 Advanced search : difficulty", new AdvanceSearchDifficulty()),
    COPMLEX_SEARCH_BORROWERS("9","9 Complex search: borrowers", new ComplexSearchBorrowers()),
    SHOW_LIST("10","10 List still borrowed", new ShowListBorrowers()),
    SHOW_ALL_BORROWS_INSERT_NEW_BORROW("11","11 Show all borrows , and insert a new borrow", new ShowAllBorrowersInsertNewBorrowers()) ;


    private final String id;
    private final String displayOption;
    private final Command command;

    Invoker(String id, String displayOption , Command command){


        this.id = id;
        this.displayOption = displayOption;
        this.command = command;
    }



}


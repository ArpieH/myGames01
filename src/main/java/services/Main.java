package services;

import commandpattern.Invoker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main { private static Scanner scanner = new Scanner(System.in);

    private static List<Invoker> commandList = Arrays.stream(Invoker.values()).collect(Collectors.toList());

    public static void main(String[] args) {
        while (true) {
            try {
                Arrays.stream(Invoker.values()).forEach(invoker -> System.out.println(invoker.getDisplayOption()));
                System.out.println("choose an option:");
                chooseAnOption();
            } catch (Exception e) {
                System.out.println("error smth went wrong" + e.getMessage());
                scanner.nextLine();
            } finally {
                System.out.println("do u want to continue? (y/n)");
                if (scanner.next().equals("n")) {
                    break;
                }
            }
        }
    }

    private static void chooseAnOption() throws Exception {

        String optionId = scanner.next();
        commandList.stream().filter(invoker -> invoker.getId().equals(optionId) )
                .findFirst()
                .orElseThrow(() -> new Exception("Option not found"))
                .getCommand()
                .execute();
    }
}

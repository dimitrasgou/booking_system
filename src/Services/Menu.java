package Services;


import Entities.Client;
import Entities.MusicShow;
import Entities.TheaterShow;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static ClientService clientService = new ClientService();
    private static MusicShowService musicShowService = new MusicShowService();
    private static TheaterShowService theaterShowService = new TheaterShowService();


    public static void initBaseMenu() {
        System.out.println("__________*** M E N U ***___________");
        System.out.println("====================================");
        System.out.println("      What would you like to do?\n");
        System.out.println("Insert-Edit-Delete Information of Theater Entities Show..................1");
        System.out.println("Insert-Edit-Delete Information of Music Entities Show....................2");
        System.out.println("Insert-Edit-Delete Information of Entities Client........................3");
        System.out.println("Book a ticket for a Theater Show.........................................4");
        System.out.println("Book a ticket for a Music Show...........................................5");
        System.out.println("View Statistics..........................................................6");
        System.out.println("Exit the Menu............................................................7");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();


        switch (choice) {
            case "1":
                subMenuTheater();
                break;
            case "2":
                subMenuMusic();
                break;
            case "3":
                subMenuClients();
                break;
            case "4":
                String theaterShowCode = CheckCode(getUserInput("Enter theater show id:"));
                TheaterShow TShow = theaterShowService.SearchTheaterShow(theaterShowCode);
                if (TShow == null) {
                    System.out.println("Theater show was not found.");
                    initBaseMenu();
                    return;
                }

                String clientCode = CheckCode(getUserInput("Enter client id:"));
                Client client = clientService.GetClientByCode(clientCode);
                if (client == null) {
                    System.out.println("Client was not found.");
                    initBaseMenu();
                    return;
                }
                theaterShowService.bookTicketForShow(TShow, client);
                initBaseMenu();
                break;
            case "5":
                String musicShowCode = CheckCode(getUserInput("Enter theater show id:"));
                MusicShow MShow = musicShowService.SearchMusicShow(musicShowCode);
                if (MShow == null) {
                    System.out.println("Theater show was not found.");
                    initBaseMenu();
                    return;
                }

                String clientCode1 = CheckCode(getUserInput("Enter client id:"));
                Client client1 = clientService.GetClientByCode(clientCode1);
                if (client1 == null) {
                    System.out.println("Client was not found.");
                    initBaseMenu();
                    return;
                }
                musicShowService.bookTicketForShow(MShow, client1);
                initBaseMenu();
                break;
            case "6":
                musicShowService.showtickets();
                theaterShowService.showtickets();
                initBaseMenu();
                break;
            case "7":
                saveAndExit();
            default:
                System.out.println("Please choose one of the available actions");
                initBaseMenu();
        }

    }

    private static void saveAndExit() {
        System.out.println("Save and Exiting...");
        theaterShowService.save();
        musicShowService.save();
        clientService.save();
        System.exit(0);
    }

    private static void subMenuTheater() {
        System.out.println("__________*** T H E A T E R S ***___________");
        System.out.println("============================================");
        System.out.println("         What would you like to do?\n");
        System.out.println("Insert a new Theater Show....................................................1");
        System.out.println("Edit an existing Theater Show................................................2");
        System.out.println("Delete an existing Theater Show .............................................3");
        System.out.println("View the list of Theater Shows  .............................................4");
        System.out.println("Back to Main Menu............................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                String ThID = CheckCode(getUserInput("Enter theater show id:"));
                String ThTitle = getUserInput("Enter the title:");
                String ThVenue = getUserInput("Enter the venue:");
                String ThDate = dateFormatpattern(getUserInput("Enter the date:"));
                String actor = getUserInput("Enter the actor:");
                theaterShowService.insert(ThID, ThTitle, ThVenue, ThDate, actor);

                subMenuTheater();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter theater show id:"));
                TheaterShow TShow = theaterShowService.SearchTheaterShow(Code);
                if (TShow == null) {
                    System.out.println("Theater show was not found.");
                    initBaseMenu();
                    return;
                }
                String NewTitle = getUserInput("Enter new title:");
                String NewVenue = getUserInput("Enter new venue:");
                String NewDate = dateFormatpattern(getUserInput("Enter new date:"));
                String NewName = getUserInput("Enter new name for the actor:");

                theaterShowService.update(TShow, NewTitle, NewVenue, NewDate, NewName);
                subMenuTheater();
                break;
            case "3":
                String theaterShowCode = CheckCode(getUserInput("Enter theater show id:"));
                TheaterShow TShow1 = theaterShowService.SearchTheaterShow(theaterShowCode);
                if (TShow1 == null) {
                    System.out.println("Theater show was not found.");
                    initBaseMenu();
                    return;
                }
                theaterShowService.remove(theaterShowService.SearchTheaterShow(theaterShowCode));
                subMenuTheater();
                break;
            case "4":
                theaterShowService.AllTheaterShows();
                subMenuTheater();
            case "5":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuTheater();
        }

    }

    private static void subMenuMusic() {
        System.out.println("__________*** M U S I C ***___________");
        System.out.println("======================================");
        System.out.println("     What would you like to do?\n");
        System.out.println("Insert a new Music Show....................................................1");
        System.out.println("Edit an existing Music Show................................................2");
        System.out.println("Delete an existing Music Show .............................................3");
        System.out.println("View the list of Music Shows  .............................................4");
        System.out.println("Back to Main Menu..........................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();

        switch (choice) {
            case "1":
                String MID = CheckCode(getUserInput("Enter music show id:"));
                String MTitle = getUserInput("Enter the title:");
                String MVenue = getUserInput("Enter the venue:");
                String MDate = dateFormatpattern(getUserInput("Enter the date:"));
                String singer = getUserInput("Enter the singer:");
                musicShowService.insert(MID, MTitle, MVenue, MDate, singer);

                subMenuMusic();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter Music Show id:"));
                MusicShow TShow = musicShowService.SearchMusicShow(Code);
                if (TShow == null) {
                    System.out.println("Music show was not found.");
                    initBaseMenu();
                    return;
                }
                MusicShow MShow = musicShowService.SearchMusicShow(Code);
                String NewMTitle = getUserInput("Enter new title:");
                String NewMVenue = getUserInput("Enter new venue:");
                String NewMDate = dateFormatpattern(getUserInput("Enter new date:"));
                String NewMName = getUserInput("Enter new name for the singer:");

                musicShowService.update(MShow, NewMTitle, NewMVenue, NewMDate, NewMName);
                subMenuMusic();
                break;
            case "3":
                String Id = getUserInput("Enter Music Show id:");
                MusicShow MShow1 = musicShowService.SearchMusicShow(Id);
                if (MShow1 == null) {
                    System.out.println("Theater show was not found.");
                    initBaseMenu();
                    return;
                }
                musicShowService.remove(musicShowService.SearchMusicShow(Id));
                subMenuMusic();
                break;

            case "4":
                musicShowService.AllMusicShows();
                subMenuMusic();
                break;
            case "5":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuMusic();
        }
    }

    private static void subMenuClients() {
        System.out.println("__________*** C L I E N T S ***___________");
        System.out.println("==========================================");
        System.out.println("       What would you like to do?\n");
        System.out.println("Insert a new Client....................................................1");
        System.out.println("Edit an existing Client................................................2");
        System.out.println("Delete an existing Client .............................................3");
        System.out.println("View the list of Clients  .............................................4");
        System.out.println("Back to Main Menu......................................................5");
        System.out.println("\n\nEnter your choice:");

        String choice = getNextLine();
        Client client;

        switch (choice) {
            case "1":
                String id = CheckCode(getUserInput("Enter client id:"));
                client = clientService.GetClientByCode(id);
                if (client != null) {
                    System.out.println("This client already exists.");
                    subMenuClients();
                }

                String firstName = getUserInput("Enter client firstname:");
                String surName = getUserInput("Enter client surName:");
                String email = EmailValidation(getUserInput("Enter client email:"));
                String phone = CheckPhone(getUserInput("Enter client phone:"));
                clientService.insert(id, firstName, surName, email, phone);
                subMenuClients();
                break;
            case "2":
                String Code = CheckCode(getUserInput("Enter client id:"));
                client = clientService.GetClientByCode(Code);
                if (client == null) {
                    System.out.println("This client does not exist.");
                    subMenuClients();
                }

                String NewFirstName = getUserInput("Enter new client firstname:");
                String NewSurName = getUserInput("Enter new client surName:");
                String NewEmail = getUserInput("Enter new client email:");
                String NewPhone = CheckPhone(getUserInput("Enter new client phone:"));

                clientService.update(client, NewFirstName, NewSurName, NewEmail, NewPhone);
                subMenuClients();
                break;
            case "3":
                String Code1 = CheckCode(getUserInput("Enter client id:"));
                client = clientService.GetClientByCode(Code1);
                if (client == null) {
                    System.out.println("This client does not exist.");
                    subMenuClients();
                }
                client = clientService.GetClientByCode(Code1);
                if (client != null) clientService.remove(client);
                subMenuClients();
                break;
            case "4":
                clientService.showAllClients();
            case "5":
                initBaseMenu();
            default:
                System.out.println("Please choose one of the available actions");
                subMenuClients();
        }
    }

    /**
     * A method to get users input
     * @param message what we ask from the user
     * @return user's answer
     */
    private static String getUserInput(String message) {
        System.out.println(message);
        return getNextLine();
    }

    private static String getNextLine() {
        return scanner.nextLine();
    }

    /**
     * checks whether the phone is valid according to the given regex
     * @param phone String
     * @return valid phone number
     */
    private static String CheckPhone(String phone) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        while (phone.length() != 10 || !pattern.matcher(phone).matches()) {
            System.out.println(phone + " is not a valid phone. You must provide a number with ten digits");
            phone = scanner.nextLine();
        }

        return phone;
    }

    /**
     * checks whether the id/code is valid according to the given regex
     * @param code
     * @return valid code
     */
    private static String CheckCode(String code) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        while (code.length() != 5 || !pattern.matcher(code).matches()) {
            System.out.println(code + " is not a valid code. You must provide a number with five digits");
            code = scanner.nextLine();
        }

        return code;
    }

    /**
     * checks whether an email is valid according to the given regex
     * @param email
     * @return valid email
     */
    private static String EmailValidation(String email) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$");

        while (!pattern.matcher(email).matches()) {
            System.out.println(email + " is not a valid email. Please provide a valid mail");
            email = scanner.nextLine();
        }

        return email;
    }

    /**
     * checks whether an email is valid according to the given regex
     * @param date
     * @return valid date
     */
    private static String dateFormatpattern(String date) {

    Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)");
    while (!pattern.matcher(date).matches()) {
        System.out.println(date + " is not a valid email. Please provide a valid mail");
        date = scanner.nextLine();
    }

    return date;
}

}









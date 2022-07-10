//
//import Entities.Client;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class MainP {
//
//    ArrayList<Entities.Show> ShowList = new ArrayList<>();
//    ArrayList<Client> ClientList =new ArrayList<>();
//
//    /**
//     * ��������� ��� ��������� ����������� ��� �����
//     */
//    private void addClient(Client Client) {
//        ClientList.add(Client);
//    }
//
//    /**
//     * ��������� ��� ������� �������� ��� �� �����
//     *
//     * @param Code Dexetai �� ��������� ������� ��� ������ ��� ����������
//     */
//
//
//    private void removeShow(String Code) {
//
//        int i;
//
//        Entities.Show show;
//        int exist = 0;
//
//        for (i = 0; i < ShowList.size(); i++) {
//            show = ShowList.get(i);
//            if (Entities.Show.getCode().equals(Code.toUpperCase().trim())) {
//                exist = 1;
//                Entities.Show.ShowAll();
//                ShowList.remove(i);
//                System.out.println("The show with the code " + Code + " was deleted.");
//            }
//        }
//
//        if (exist == 0)
//            System.out.println("The student with the code " +Code + " was not found.");
//
//    }
//
//
//
//
//    /**
//     * ��������� ��� ������� ����� ���� �������� ��� �������� ��� ����� �� ��� �� �������������� ����
//     */
//    private void showAllClients() {
//        System.out.println("====Clients List====");
//        for (Client Client : ClientList) {
//            System.out.println("  ========Entities.Client's List============");
//            System.out.println("Surname.............: " + Client.getSurName());
//            System.out.println("Name................: " + Client.getFirstName());
//            System.out.println("Email...............: " + Client.getEmail());
//            System.out.println("Phone Number........: " + Client.getPhone());
//            System.out.println("ID number...........: " + Client.getID());
//
//        }
//    }
//
//    /**
//     * ��������� ������� ��� ��������� ������� �� ���� �� �������
//     * @param Surname ������� �� ��������� �� ������� ��� �������
//     */
//    private Client SearchClientN(String Surname) {
//        for (Client Client : ClientList) {
//            if (Client.getSurName().toUpperCase().trim().equals(Surname.toUpperCase().trim())) {
//
//                System.out.println("Information for -" + Client.getSurName());
//                System.out.println("========================");
//                System.out.println("Name................: " + Client.getFirstName());
//                System.out.println("Email...............: " + Client.getEmail());
//                System.out.println("Phone Number........: " + Client.getPhone());
//                System.out.println("ID number...........: " + Client.getID());
//
//            }
//        return Client;
//        }
//
//    }
//
//    /**
//     * ��������� ������� ��� ��������� ������� �� ���� �� ��������
//     * @param Phone ������� �� ��������� �� �������� ��� �������
//     */
//
//
//    /**
//     * � ��������� ��� ����� �� �������� ����� �� ��� ���������� ����������� ��� ���������
//     */
//    private void Menu() {
//
    //        System.out.println("__________*** M E N U ***___________");
    //        System.out.println("====================================");
    //        System.out.println("      What would you like to do?\n");
    //        System.out.println("\nInsert-Edit-Delete Information of Theater Entities.Show..................1");
    //        System.out.println("Insert-Edit-Delete Information of Music Entities.Show....................2");
    //        System.out.println("Insert-Edit-Delete Information of Entities.Client........................3");
    //        System.out.println("Book a ticket for a Theater Entities.Show................................4");
    //        System.out.println("Book a ticket for a Music.. Entities.Show................................5");
    //        System.out.println("View Statistics.................................................6");
    //        System.out.println("Exit the Menu...................................................7");
    //        System.out.println("\n\nEnter your choice:...");
//    }
//
//    private static void Menu2() {
//
//        System.out.println("__________*** M E N U ***___________");
//        System.out.println("====================================");
//        System.out.println("      What would you like to do?\n");
//        System.out.println("\nInsert Information ...........1");
//        System.out.println("Edit Information ...............2");
//        System.out.println("Delete Information .............3");;
//        System.out.println("Return to the Menu..............4");
//        System.out.println("\n\nEnter your choice:...");
//    }
//
//    /**
//     * ������ ��� �� ������ �� ����������� �� ���������� �������� ��� �� ������������ ���� ��� �������
//     * @return ���������� ��� ��������� �������
//     */
//    private Client CreateNewClient() {
//        Scanner Keyb = new Scanner(System.in);
//        String St1, St2, St3, St4, St5, St6;
//
//        System.out.println("===========================================\n");
//        System.out.println("*** Create a new entry ***");
//        System.out.print("Enter Surname.............: ");
//        St1 = Keyb.nextLine();
//        System.out.print("Enter name................: ");
//        St2 = Keyb.nextLine();
//        System.out.print("Enter email.......: ");
//        St3 = Keyb.nextLine();
//        System.out.print("Enter phone number...........: ");
//        St4 = Keyb.nextLine();
//        int x= St4.length();
//        while (x !=10)
//        {
//            System.out.println(" You must provide a number with ten digits");
//            St4= Keyb.next();
//            Keyb.nextLine();
//            x=St4.length();
//
//        }
//
//        System.out.print("Enter ID number...........: ");
//        St5 = Keyb.next();
//        int p= St5.length();
//        while (p !=5)
//        {
//            System.out.println(" You must provide a number with 5 digits");
//            St6= Keyb.next();
//            Keyb.nextLine();
//            p=St6.length();
//
//        }
//        Client C = new Client(St1, St2, St3, St4, St5);
//        return C;
//
//    }
//
//    /**
//     * ��������� �� ������� �������� �� ������������ ������� ��� �����
//     * @param Surname ������� �� ��������� �� ������� ��� �������
//     * @return ���������� ��� ������� ��� ���� �� ������� ��� ������ � ���������� null �� ��������� ��� � �������� ��� �������
//     */
//
//    /**
//     * ��������� �� ����� ����������� ��� �������������� ���������� �������, � ��������� ������� �� ���� �� �������
//     * @param Surname ������� �� ��������� �� �������
//     */
//    void editClient(String Surname) {
//        Client Student = SearchClientN(Surname);
//        if (Student == null) {
//            System.out.println("There is no student with this registered under the Surname " + Surname);
//        } else {
//
//            Scanner Keyb = new Scanner(System.in);
//            String St1, St2, St3, St4, St5, St6;
//
//            System.out.println("===========================================\n");
//            System.out.println("You are about to edit the Student " + Student.getSurName() + " " + Student.getFirstName());
//            System.out.print("Enter new surname.............: ");
//            St1 = Keyb.nextLine();
//            System.out.print("Enter new name................: ");
//            St2 = Keyb.nextLine();
//            System.out.print("Enter new email.......: ");
//            St3 = Keyb.nextLine();
//            System.out.print("Enter new phone number...........: ");
//            St4 = Keyb.nextLine();
//            int x= St4.length();
//            while (x !=10)
//            {
//                System.out.println(" You must provide a number with ten digits");
//                St4= Keyb.next();
//                Keyb.nextLine();
//                x=St4.length();
//
//            }
//
//
//            System.out.print("Enter new ID number...........: ");
//            St5 = Keyb.next();
//            int p= St5.length();
//            while (p !=5)
//            {
//                System.out.println(" You must provide a number with 5 digits");
//                St6= Keyb.next();
//                Keyb.nextLine();
//                p=St6.length();
//
//            }
//            Client.setSurName(St1);
//            Client.setFirstName(St2);
//            Client.setEmail(St3);
//            Client.setPhone(St4);
//            Client.setID(St5);
//            Client.ShowAll();
//
//        }
//    }
//
//    public static void main (String[]args){
//
//        MainP main = new MainP();
//        Scanner scan = new Scanner(System.in);
//        String Pass;
//        String UserName;
//        int choice;
//
//        //������� ���������� ��� �������� �������� ��� ������������ �� ��� ���������� �������� ���������������
//
//        Client P1 = new Client("IOANNIDOU", "KONSTANTINA", "nina@gmail.com",  "6987894567","00001");
//        Client P2 = new Client("IOANNOU", "AIMILIA", "emi@gmail.com",  "6979020202", "00002");
//        Client P3 = new Client("TSAGDI", "MARIA", "maria@gmail.com",  "6979085204", "00003");
//        Client P4 = new Client("STERGIOU", "FOTEINI", "fotini@gmail.com",  "6978787585",  "00004");
//        Client P5 = new Client("GEORGIADOU", "VICTORIA", "vic@gmail.com",  "6970213456","00005" );
//        main.addClient(P1);
//        main.addClient(P2);
//        main.addClient(P3);
//        main.addClient(P4);
//        main.addClient(P5);
//
//            /*�� ����� ���� ����������� ���� �� ���  do..while ���� ���� � ������� �� �������� ��� ����������� ��� ����� �� �����
//            ���� ����� ����� */
//
//            /*'���� �������������� � switch ��� �� ������������ ��� �������� �� ���� ��� ������ ��� ���� ����������� ��� �������� ��� �����.
//             'E����� ��� ��� �������� ��� ���� case ������� break ���� ���� �� �� ����������� �� ������� ��� ����������� ��� ������� cases*/
//
//        System.out.println("Welcome to the booking system");
//        Pause();
//
//
//        do{
//            System.out.println("Enter your username");
//
//
//        do {
//            main.Menu();
//            choice = scan.nextInt();
//
//            switch (choice) {
//                case 1:
//                case 2:
//                case 3:
//                    main.Menu2();
//                    Pause();
//                    break;
//
//                case 4:
//                    System.out.println("Enter the phone number of the student..:");
//                    String number = scan.next();
//                    main.SearchStudentT(number);
//                    Pause();
//                    break;
//                case 5:
//                    Scanner sc = new Scanner(System.in);
//                    System.out.print("Enter the Surname of the student you would like to edit: ");
//                    String OldName = sc.nextLine().toUpperCase().trim();
//                    main.editStudent(OldName);
//                    Pause();
//                    break;
//                case 6:
//                    System.out.println("Enter the surname of the student you would like to delete..:");
//                    String nname = scan.next();
//                    main.removeStudent(nname);
//                    Pause();
//
//
//                    break;
//            }
//        }
//        while (choice != 7 );
//
//        System.out.println("End of Program");
//    }
//
//
//
//    /**
//     * ������� �� ��������� ��� ����� ��� ������� ��� ������ �� ������� <<Enter>> ��� �� ��������� ��������
//     */
//    public static void Pause () {
//        Scanner K = new Scanner(System.in);
//        System.out.print("Press <<Enter>> to return to the menu...");
//        K.nextLine();
//    }
//
//    /**
//     * ������� �� ��������� ��� ����� ��� ������� ��� ������ �� ������� <<Enter>> ��� �� ��������� ��������
//     */
//    public static void Pause2() {
//        Scanner K = new Scanner(System.in);
//        System.out.print("Press <<Enter>> continue ");
//        K.nextLine();
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//}

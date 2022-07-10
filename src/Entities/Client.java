package Entities;

public class Client {

    /**
     * Αποτελεί τη γενική κλάση της εφαρμογής μας μέσα στην οποία περιγράφονται τα χαρακτηριστικά των αντικειμένων καθώς και οι μεθόδοι του
     */
    private String ID;
    private String SurName;
    private String FirstName;
    private String Email;
    private String Phone;



    /**
     * Ο γενικός κατασκευαστής για τη δημιουργία ενός στιγμιότυπου της κλάσης Entities.Client
     *
     * @param surName   Δέχεται ως παράμετρο Επίθετο τύπου String
     * @param firstName Δέχεται ως παράμετρο όνομα τύπου String
     * @param email     Δέχεται ως παράμετρο email τύπου String
     * @param phone     Δέχεται ως παράμετρο τηλέφωνο τύπου String
     * @param ID     Δέχεται ως παράμετρο αρ. μητρώου τύπου String
     */
    public Client(String ID ,String surName, String firstName, String email, String phone) {
        SurName = surName;
        FirstName = firstName;
        Email = email;
        Phone = phone;
        this.ID = ID;

    }


    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    /**
     * Εμφανίζει όλα τα στοιχεία του στιγμιότυπου
     */
    public void ShowAll() {
        System.out.println("    Students' Details");
        System.out.println("========================");
        System.out.println("Surname.............: " + SurName);
        System.out.println("Name................: " + FirstName);
        System.out.println("Email...............: " + Email);
        System.out.println("PhoneNo.............: " + Phone);
        System.out.println("ID number...........: " + ID);
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID='" + ID + '\'' +
                ", SurName='" + SurName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}

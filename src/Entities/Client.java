package Entities;

public class Client {

    /**
     * �������� �� ������ ����� ��� ��������� ��� ���� ���� ����� ������������� �� �������������� ��� ������������ ����� ��� �� ������� ���
     */
    private String ID;
    private String SurName;
    private String FirstName;
    private String Email;
    private String Phone;


    /**
     * � ������� ������������� ��� �� ���������� ���� ������������ ��� ������ Entities.Client
     *
     * @param surName   ������� �� ��������� ������� ����� String
     * @param firstName ������� �� ��������� ����� ����� String
     * @param email     ������� �� ��������� email ����� String
     * @param phone     ������� �� ��������� �������� ����� String
     * @param ID        ������� �� ��������� ��. ������� ����� String
     */
    public Client(String ID, String firstName, String surName, String email, String phone) {
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
     * ��������� ��� �� �������� ��� ������������
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

    public String AsCsvLine(){
        return  ID + ";" + FirstName + ";" + SurName + ";" + Email + ";" + Phone;
    }
}

package Entities;

import java.util.ArrayList;


public abstract class Show {

    protected String ID;
    protected String title;
    protected String theater;
    protected String date;

    protected ArrayList<String> ClientList ;

    public Show(String ID, String title, String theater, String date) {
        this.ID = ID;
        this.title = title;
        this.theater = theater;
        this.date = date;
        this.ClientList =new ArrayList<>();
    }

    public String getCode() {
        return ID;
    }

    public void setCode(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getClientList() {
        return ClientList;
    }

    public void bookTicket(Client client){
        ClientList.add(client.toString());
    }


    @Override
    public String toString() {
        return "Entities.Show{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", theater='" + theater + '\'' +
                ", date='" + date + '\'' +
                ", ClientList=" + ClientList +
                '}';
    }





    public void ShowAll() {
        System.out.println("    Entities.Show' Details");
        System.out.println("========================");
        System.out.println("Code.............: " + ID);
        System.out.println("Title................: " + title);
        System.out.println("Date...........: " + date);
    }


}




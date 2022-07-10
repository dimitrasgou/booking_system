package Services;

import Entities.Client;

import java.util.ArrayList;

public class ClientService extends EntityService
{
    private ArrayList<Client> clients;

    ClientService(){
        loadClients();
    }

    private void loadClients()
    {
        clients = storageService.getClients();
    }

    public void insert(String id, String firstName, String surName, String email, String phone)
    {
        //validation


        //if passes
        clients.add(new Client(id,firstName,surName, email, phone));
    }

    public void update(String code){

    }

    public void delete(String code)
    {

    }

    public void save()
    {
        storageService.saveClients(clients);
    }
}

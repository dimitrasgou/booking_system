package Services;

import Entities.Client;

import java.util.ArrayList;
/**
 * the services in order to manage the Client Entity
 */
public class ClientService extends EntityService {
    private ArrayList<Client> clients;

    ClientService() {
        loadClients();
    }

    private void loadClients() {
        clients = storageService.getClients();
    }

    public void insert(String id, String firstName, String surName, String email, String phone) {
        //if passes
        clients.add(new Client(id, firstName, surName, email, phone));
    }

    /**
     * Finds the instance of the object in question based on the code given
     * @param code String code
     * @return instance that corresponds with the code or null
     */
    public Client GetClientByCode(String code) {
        for (Client Client : clients) {
            if (Client.getID().toUpperCase().trim().equals(code.toUpperCase().trim())) {
                System.out.println("Client found");
                return Client;
            }
            else if (Client ==null)
                System.out.println("Client not found");
        }
        return null;
    }

    public void remove(Client client){
        clients.remove(client);
    }


    public void update(Client client, String firstName, String surName, String email, String phone)
    {
        client.setFirstName(firstName);
        client.setSurName(surName);
        client.setEmail(email);
        client.setPhone(phone);
    }



    public void save() {
        storageService.saveClients(clients);
    }

    public void showAllClients() {
        System.out.println("====Clients List====");
        int i=1;
        for (Client client : clients) {
            System.out.println("==================== no"+ i);
            System.out.println("ID number...........: " + client.getID());
            System.out.println("Name................: " + client.getFirstName());
            System.out.println("Surname.............: " + client.getSurName());
            System.out.println("Email...............: " + client.getEmail());
            System.out.println("Phone Number........: " + client.getPhone());
            i++;
        }
    }
}

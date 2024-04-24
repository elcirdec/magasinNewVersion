package magasin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RegistreClient {

    private Set<Client> clients;

    public RegistreClient() {
        clients = new HashSet<>();
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public void retirerClient(Client client) {
        clients.remove(client);
    }

    public Set<Client> getClients() {
        return clients;
    }
}


package magasin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RegistreCommande {

    private Map<Client, List<Commande>> commandesParClient;

    public RegistreCommande() {
        commandesParClient = new HashMap<>();
    }

    public void ajouterCommande(Client client, Commande commande) {
        if (!commandesParClient.containsKey(client)) {
            commandesParClient.put(client, new ArrayList<>());
        }
        commandesParClient.get(client).add(commande);
    }

    public List<Commande> getCommandesParClient(Client client) {
        return commandesParClient.getOrDefault(client, Collections.emptyList());
    }
}


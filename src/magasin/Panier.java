package magasin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Panier {

    private Map<Produit, Integer> produitsQuantites;

    public Panier() {
        produitsQuantites = new HashMap<>();
    }

    public void ajouterProduit(Produit produit, int quantite) {
        produitsQuantites.put(produit, quantite);
    }

    public void retirerProduit(Produit produit) {
        produitsQuantites.remove(produit);
    }

    public Map<Produit, Integer> getProduitsQuantites() {
        return produitsQuantites;
    }
}


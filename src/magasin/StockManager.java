package magasin;

import java.util.*;
import java.util.function.Predicate;

public interface StockManager {
	
	void ajouterProduit(String nomProduit, int prix, int quantite);

    void retirerProduit(String nomProduit, int quantite);

    int getPrixMoyen();

    int getTotalCommande(Map<String, Integer> panier);

    List<String> getProduitsParCategorie(String categorie);

    boolean verifierTousProduits(Predicate<String> condition);
    
}

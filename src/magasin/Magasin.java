package magasin;

import java.util.*;

public class Magasin {

	private TreeSet<Produit> stock;
	private HashSet<Produit> produitsAffiches;
	private StockManager stockManager;

	public Magasin() {
		stock = new TreeSet<>();
		produitsAffiches = new HashSet<>();
		stockManager = new WrapperOcaml();
	}

	///////////////// PERSISTANCE JAVA-OCAML /////////////////

	public void ajouterProduit(String nomProduit, int prix, int quantite) {
		stockManager.ajouterProduit(nomProduit, prix, quantite);
	}

	public int getPrixMoyen() {
		return stockManager.getPrixMoyen();
	}

	public int getTotalCommande(Map<String, Integer> panier) {
		return stockManager.getTotalCommande(panier);
	}

	public List<String> getProduitsParCategorie(String categorie) {
		return stockManager.getProduitsParCategorie(categorie);
	}

	public boolean verifierTousProduits(Predicate<String> condition) {
		return stockManager.verifierTousProduits(condition);
	}

	//////////////////////////////////////////////////////////
	public void ajouterProduit(Produit produit) {
		stock.add(produit);
	}

	public void retirerProduit(Produit produit) {
		stock.remove(produit);
	}

	public void modifierQuantiteProduit(Produit produit, int quantite) {
		if (stock.contains(produit)) {
			stock.remove(produit);
			produit.setQuantite(quantite);
			stock.add(produit);
		}
	}

	public Set<Produit> getStock() {
		return stock;
	}

	public Set<Produit> getProduitsAffiches() {
		produitsAffiches.clear();
		produitsAffiches.addAll(stock);
		return produitsAffiches;
	}

	public Iterator<Produit> iterator() {
		return stock.iterator();
	}
}

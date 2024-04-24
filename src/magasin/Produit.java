package magasin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Produit {

    private int hashcode;
    private String nom;
    private int quantite;

    public Produit(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
        this.hashcode = Objects.hash(nom, quantite);
    }

    public int getHashcode() {
        return hashcode;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return hashcode == produit.hashcode &&
                nom.equals(produit.nom) &&
                quantite == produit.quantite;
    }

    @Override
    public int hashCode() {
        return hashcode;
    }

}


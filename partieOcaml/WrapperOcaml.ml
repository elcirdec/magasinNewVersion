module StockManager = struct

    let ajouter_produit (nom_produit : string) (prix : int) (categorie : string) (quantite : int) =
        let produit = match categorie with
            | "Alimentation" -> Alimentation prix
            | "Vetements" -> Vetements prix
            | "Divers" -> Divers prix
            | _ -> failwith "Catégorie non valide"
        in
        let stock = Stock.ajouter_produit (prix_produit produit) quantite in
        Printf.format "Produit %s (%s) ajouté avec succès! Stock actuel: %d\n" nom_produit categorie (Stock.quantite stock)

    let retirer_produit (nom_produit : string) (categorie : string) (quantite : int) =
        let produit = match categorie with
            | "Alimentation" -> Alimentation 0
            | "Vetements" -> Vetements 0
            | "Divers" -> Divers 0
            | _ -> failwith "Catégorie non valide"
        in
        let stock = Stock.retirer_produit produit quantite in
        Printf.format "Produit %s (%s) retiré avec succès! Stock actuel: %d\n" nom_produit categorie (Stock.quantite stock)

    let get_prix_moyen () : int =
        let prix_moyens = List.map (fun p -> prix_produit p) (Stock.get_produits Stock.Empty) in
        List.fold_left (fun acc prix -> acc + prix) 0 prix_moyens

    let get_total_commande (panier : map string int) : int =
        let produits_quantites = List.map (fun (nom_produit, quantite) ->
            match nom_produit with
            | "Alimentation" -> (Alimentation 0, quantite)
            | "Vetements" -> (Vetements 0, quantite)
            | "Divers" -> (Divers 0, quantite)
            | _ -> failwith "Nom de produit non valide"
        ) (List.assocs panier) in
        List.fold_left (fun acc (produit, quantite) -> acc + (quantite * prix_produit produit)) 0 produits_quantites

    let get_produits_par_categorie (categorie : string) : list string =
        let produits = Stock.get_produits Stock.Empty in
        List.filter (fun p -> match p with
            | Alimentation _ -> categorie = "Alimentation"
            | Vetements _ -> categorie = "Vetements"
            | Divers _ -> categorie = "Divers"
        ) produits in
        List.map (fun p -> match p with
            | Alimentation _ -> "Alimentation"
            | Vetements _ -> "Vetements"
            | Divers _ -> "Divers"
        ) produits_categorie

    let verifier_tous_produits (condition : string -> bool) : bool =
        let produits = Stock.get_produits Stock.Empty in
        List.forall (fun p -> match p with
            | Alimentation nom -> condition nom
            | Vetements nom -> condition nom
            | Divers nom -> condition nom
        ) produits

    let verifier_categorie (produit : produit) (categorie : string) : bool =
        match produit with
        | Alimentation _ -> categorie = "Alimentation"
        | Vetements _ -> categorie = "Vetements"
        | Divers _ -> categorie = "Divers"
        | _ -> failwith "Produit non valide"
end

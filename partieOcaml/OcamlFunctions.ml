type produit = Alimentation of int | Vetements of int | ...

let moyenne_prix (produits: list produit) : int =
  let prix_moyens = List.map (fun p -> 
		match p with 
		| Alimentation prix -> prix
	  | Vetements prix -> prix 
		| Divers prix -> prix ) produits in
  List.fold_left (fun acc prix -> acc + prix) 0 prix_moyens


let total_commande (panier: map produit int) : int =
  List.fold_left (fun acc (produit, quantite) ->
    match produit with
    | Alimentation prix -> acc + (prix * quantite)
    | Vetements prix -> acc + (prix * quantite)
    | Divers prix -> acc + (prix * quantite)
  ) 0 (List.assocs panier)

let trier_par_categorie (produits: list produit) (categorie: produit) : list produit =
  List.filter (fun p -> 
		match p with 
		| Alimentation _ -> p = categorie 
		| Vetements _ -> p = categorie 
		| Divers _ -> p = categorie ) produits

let verifier_tous (produits: list produit) (f: produit -> bool) : bool =
  List.forall f produits

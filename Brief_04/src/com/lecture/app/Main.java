package com.lecture.app;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		//MERYAME EL BETTAL - ALI HMIMS
		// TODO Auto-generated method stub
		
		//Création des objets
		
		Lecteur l1 = new Lecteur("Meryame", "mer@gmail", 324355, 2);
		Lecteur l2 = new Lecteur("Ahmed", "ahmed@gmail", 324355, 2);
		Lecteur l3 = new Lecteur("Omar", "ahmed@gmail", 324355, 2);
		
		Bienfaiteur bf1 = new Bienfaiteur("A","A@gmail", 3);
		Bienfaiteur bf2 = new Bienfaiteur("B","B@gmail", 4);
		Bienfaiteur bf3 = new Bienfaiteur("C","C@gmail", 5);

		Livre book1 = new Livre("je te promet la liberté", 20, 01/21/2019);
		Livre book2 = new Livre("je te promet la liberté", 23, 01/21/2019);
		Livre book3 = new Livre("je te promet la liberté", 30, 01/21/2019);

		ArrayList<Lecteur> listLecteur = new ArrayList<Lecteur>();
		ArrayList<Bienfaiteur> listBienfaiteur = new ArrayList<Bienfaiteur>();
		ArrayList<Livre> listLivre = new ArrayList<Livre>();
		ArrayList<String> names = new ArrayList<String>();

		
		listLecteur.add(l1);
		listLecteur.add(l2);
		listLecteur.add(l3);
		
		listBienfaiteur.add(bf1);
		listBienfaiteur.add(bf2);
		listBienfaiteur.add(bf3);

		listLivre.add(book1);
		listLivre.add(book2);
		listLivre.add(book3);
		
		
		while(true) {
		Scanner reader = new Scanner(System.in);
		Scanner test = new Scanner(System.in);
	    System.out.print("vous voulez manager: Lecteur, Bienfaiteur, or Livre? (1/2/3) : ");
	    char choice = reader.next().charAt(0);
	   
	 
		switch (choice) {
	      case '1':
	    	  System.out.println("liste des lecteurs :");
	    	  //Affichage des lecteurs:
	    	  for(int i=0; i<listLecteur.size() ;i++)
	    	  {
	    		  System.out.println("\t Lecteur "+ (i+1) +":");
	    		  System.out.println(listLecteur.get(i).toString());
	    	  }
	    		  System.out.println("vous voulez avoir une liste trier par ordre ? (o/n) :");
	 			  char choice01 = reader.next().charAt(0);
	 			  switch(choice01)
	 			  {
	 			  case 'o' : 
	 				 for(int i=0; i<listLecteur.size() ;i++)
	 		    	  {
	 					 names.add(listLecteur.get(i).getNom());
	 		    	  }
	 		        Collections.sort(names);
	 		       for(int i=0; i<names.size() ;i++)
	 	    	  {
	 	    		 System.out.println("List après sort " + names.get(i)); 
	 	    	  }
	 				  break;
	 			  case 'n' :
	 				  
	 				  break;}
 			  System.out.println("vous voulez: Ajouter, modifier ou supprimer ? (a/m/s) :");
 			  char choice2 = reader.next().charAt(0);
 			  switch(choice2)
 			  {
	 			  case 'a' : 
	 				 Lecteur l01 = new Lecteur();
		 			 System.out.println("Nouveau Lecteur : ");
		 			 System.out.println("Entrez nom : ");
		 			 l01.setNom(reader.next()) ;
		 			 System.out.println("Entrez mail: ");
		 			 l01.setMail(reader.next()) ;
		 			 System.out.println("Entrez télephone: ");
		 			 l01.setNumérotel(reader.nextInt()) ;
		 			 System.out.println("Entrez le nombre des livres lus: ");
		 			 l01.setNombrelu(reader.nextInt()) ;
		 			 listLecteur.add(l1);
	 			  	break;
	 			  	
		      	  case 'm' : 
		      		for (int i = 0; i < listLecteur.size(); i++) 
					{
						System.out.println(listLecteur.get(i).toString()); 
					}
		 			 System.out.println("Modifier Lecteur : ");
		 			 System.out.println("Entrez l'index du lecteur désiré : ");
		 			 int id01 = reader.nextInt();
		 			 System.out.println("Entrez nouveau nom : ");
		 			 listLecteur.get(id01).setNom(reader.next()) ;
		 			 System.out.println("Entrez nouveau mail : ");
		 			 listLecteur.get(id01).setMail(reader.next()) ;
		 			 System.out.println("Entrez nouveau télephone : ");
		 			 listLecteur.get(id01).setNumérotel(reader.nextInt()) ;
		 			 System.out.println("Entrez nouveau nombre des livres lus: ");
		 			 listLecteur.get(id01).setNombrelu(reader.nextInt()) ;
		 			 System.out.println(listLecteur.get(id01).toString());
						System.out.println("Lecteur modifié!");
				  	break;
				  	
				  case 's' : 
						for (int i = 0; i < listLecteur.size(); i++) 
						{
							System.out.println(listLecteur.get(i).toString()); 
						}
						System.out.println("Entrez l'index du lecteur : ");
						int id02 = reader.nextInt();
						listLecteur.remove(id02);
						System.out.println("Lecteur supprimé!");
				  	break;
				}
		      break;  
	      case '2':
	    	  System.out.println("List des Bienfaiteurs :");
	    	  //Affichage des Bienfaiteurs :
	    	  for(int i=0; i<listBienfaiteur.size() ;i++)
	    	  {
	    		  System.out.println("\t le Bienfaiteur "+ (i+1) +":");
	    		  System.out.println(listBienfaiteur.get(i).toString());
	    	  }
 			  System.out.println("vous voulez: Ajouter, modifier ou supprimer ? (a/m/s) :");
 			  char choice3 = reader.next().charAt(0);
 			  switch(choice3)
 			  {
	 			  case 'a' : 
	 				 Bienfaiteur bf01 = new Bienfaiteur();
		 			 System.out.println("Nouveau Bienfaiteur : ");
		 			 System.out.println("Entrez surnom : ");
		 			 bf01.setSurnom(reader.next()) ;
		 			 System.out.println("Entrez mail: ");
		 			 bf01.setMail(reader.next()) ;
		 			 System.out.println("Entrez le nombre des livres offerts: ");
		 			 bf01.setNombrelo(reader.nextInt()) ;
		 			 listBienfaiteur.add(bf01);
	 			  	break;
	 			  	
		      	  case 'm' : 
		      		for (int i = 0; i < listBienfaiteur.size(); i++) 
					{
						System.out.println(listBienfaiteur.get(i).toString()); 
					}
		 			 System.out.println("Modifier Bienfaiteur : ");
		 			 System.out.println("Enterez l'index du bienfaiteur : ");
		 			 int id01 = reader.nextInt();
		 			 System.out.println("Entrez nouveau nom : ");
		 			 listBienfaiteur.get(id01).setSurnom(reader.next()) ;
		 			 System.out.println("Entrez nouveau mail ");
		 			 listBienfaiteur.get(id01).setMail(reader.next()) ;
		 			 System.out.println("Entrez nouveau nombre des livres offerts:");
		 			 listBienfaiteur.get(id01).setNombrelo(reader.nextInt()) ;
		 			 System.out.println(listBienfaiteur.get(id01).toString());
				  	break;
				  	
				  case 's' : 
						for (int i = 0; i < listBienfaiteur.size(); i++) 
						{
							System.out.println(listBienfaiteur.get(i).toString()); 
						}
						System.out.println("Entrez l'index du Bienfaiteur: ");
						int id2 = reader.nextInt();
						listBienfaiteur.remove(id2);
						System.out.println("Bienfaiteur supprimé !");
				  	break;
				}
	        break;

	      case '3':
	    	   System.out.println("Liste des livres :");
		    	  //Affichage des livres :
		    	  for(int i=0; i<listLivre.size() ;i++)
		    	  {
		    		  System.out.println("\t The book "+ (i+1) +":");
		    		  System.out.println(listLivre.get(i).toString());
		    	  }
	 			  System.out.println("Add, update or delete ? (a/u/d) :");
	 			  char choice4 = reader.next().charAt(0);
	 			  switch(choice4)
	 			  {
		 			  case 'a' : 
		 				 Livre book01 = new Livre();
			 			 System.out.println("Nouveau Livre : ");
			 			 System.out.println("Entrez titre : ");
			 			 book01.setTitre(reader.next()) ;
			 			 System.out.println("Entrez édition : ");
			 			 book01.setEdition(reader.nextInt()) ;
			 			 System.out.println("Entrez Date ");
			 			 book01.setDate(reader.nextInt()) ;;
			 			 listLivre.add(book01);
		 			  	break;
		 			  	
			      	  case 'm' : 
			      		for (int i = 0; i < listLivre.size(); i++) 
						{
							System.out.println(listLivre.get(i).toString()); 
						}
			 			 System.out.println("Modifier livre : ");
			 			 System.out.println("Enterez l'index du Livre : ");
			 			 int id01 = reader.nextInt();
			 			 System.out.println("Entrez titre : ");
			 			 listLivre.get(id01).setTitre(reader.next()) ;
			 			 System.out.println("Entrez édition : ");
			 			 listLivre.get(id01).setEdition(reader.nextInt()) ;
			 			 System.out.println("Entrez Date : ");
			 			 listLivre.get(id01).setDate(reader.nextInt()) ;
			 			 System.out.println(listLivre.get(id01).toString());
					  	break;
					  	
					  case 's' : 
							for (int i = 0; i < listLivre.size(); i++) 
							{
								System.out.println(listLivre.get(i).toString()); 
							}
							System.out.println("Entrez l'index du livre :");
							int id2 = reader.nextInt();
							listLivre.remove(id2);
							System.out.println("Livre supprimé ! ");
					  	break;
					}
	        break;

	        
	      default:
	        System.out.printf("Error! section is not correct");
	        return;
	        
	    	}

		}
		
		}}
	

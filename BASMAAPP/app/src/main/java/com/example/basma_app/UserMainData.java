package com.example.basma_app;

import org.json.JSONException;
import org.json.JSONObject;

public class UserMainData {
    private static int localId;
    private int incrementedId;
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String image;
    private String typeUtilisateur;
    //
    //

    public UserMainData(String id, String nom, String prenom, String email, String image, String typeUtilisateur) {
        UserMainData.localId++;
        this.incrementedId = UserMainData.localId;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.image = image;
        this.typeUtilisateur = typeUtilisateur;
    }

    public UserMainData(JSONObject payload) throws JSONException {
        this.id = payload.getString("id");
        this.nom = payload.getString("nom");
        this.prenom = payload.getString("prenom");
        this.email = payload.getString("email");
        this.typeUtilisateur = payload.getString("typeUtilisateur");
    }

    public UserMainData() {
    }
    //
    //

    public int getIncrementedId() {
        return incrementedId;
    }

    public void setIncrementedId(int incrementedId) {
        this.incrementedId = incrementedId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }
}

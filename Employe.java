package EmployePackage;

public class Employe {
    private int idEmploye;
    private String nom;
    private String prenom;
    private String datenaiss;
    private String sexe;

    public Employe(int idEmploye, String nom, String prenom, String datenaiss, String sexe) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
        this.sexe = sexe;
    }
    public Employe() {}
    public int getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(int idEmploye) {
        this.idEmploye = idEmploye;
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

    public String getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(String datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}

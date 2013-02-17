package iaws.relevenotes.domain.nomenclature;

/**
 * @author franck Silvestre
 */
public class AnneeScolaire {

    /**
     * format YYYY-YYYY
     */
    private String code;
    private String libelle ;

    public AnneeScolaire(String code) {
        this.code = code;
        this.libelle = code ;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }




}

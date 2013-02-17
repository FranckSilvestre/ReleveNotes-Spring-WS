package iaws.relevenotes.domain.nomenclature;

/**
 * @author franck Silvestre
 */
public class Matiere {

    private Integer id;
    private String code;
    private String libelle;



    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}

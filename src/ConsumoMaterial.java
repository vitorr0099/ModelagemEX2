public class ConsumoMaterial {
    private int idProjeto;
    private int idMaterial;

    public ConsumoMaterial(int idProjeto, int idMaterial) {
        this.idProjeto = idProjeto;
        this.idMaterial = idMaterial;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public int getIdMaterial() {
        return idMaterial;
    }
}

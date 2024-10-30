public class AlocacaoOperario {
    private int idProjeto;
    private int idOperario;

    public AlocacaoOperario(int idProjeto, int idOperario) {
        this.idProjeto = idProjeto;
        this.idOperario = idOperario;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public int getIdOperario() {
        return idOperario;
    }
}

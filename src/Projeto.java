public class Projeto {
    private int idProjeto;
    private String nomeProjeto;
    private String descricao;

    public Projeto(int idProjeto, String nomeProjeto, String descricao) {
        this.idProjeto = idProjeto;
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }
}

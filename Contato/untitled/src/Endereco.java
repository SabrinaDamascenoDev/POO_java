public class Endereco {
    private String nomeRua;
    private String complemento;
    private  String cidade;
    private String estado;
    private String cep;

    public String getNomeRua() {
        return nomeRua;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNomeRua(String nomeRua){
        this.nomeRua = nomeRua;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}

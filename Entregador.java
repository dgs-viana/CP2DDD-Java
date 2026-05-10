public abstract class Entregador implements CalculavelEntrega {
    private int id;
    private String nome;
    private String telefone;
    private boolean disponivel;

    public Entregador(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.disponivel = true;
    }

    public abstract String getTipoVeiculo();

    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Veiculo: " + getTipoVeiculo());
        System.out.println("Disponivel: " + (disponivel ? "Sim" : "Nao"));
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
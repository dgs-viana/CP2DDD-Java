public class Entrega {
    private int id;
    private String enderecoDestino;
    private double distanciaKm;
    private StatusEntrega status;
    private Entregador entregador;

    public Entrega(int id, String enderecoDestino, double distanciaKm) {
        this.id = id;
        this.enderecoDestino = enderecoDestino;
        this.distanciaKm = distanciaKm;
        this.status = StatusEntrega.PENDENTE;
        this.entregador = null;
    }

    public void atribuirEntregador(Entregador entregador) {
        this.entregador = entregador;
        this.status = StatusEntrega.EM_ROTA;
        entregador.setDisponivel(false);
    }

    // Sobrecarga 1: atualiza apenas com o status
    public void atualizarStatus(StatusEntrega novoStatus) {
        this.status = novoStatus;

        if (novoStatus == StatusEntrega.ENTREGUE || novoStatus == StatusEntrega.CANCELADA) {
            if (entregador != null) {
                entregador.setDisponivel(true);
            }
        }
    }

    // Sobrecarga 2: atualiza com status e observacao
    public void atualizarStatus(StatusEntrega novoStatus, String observacao) {
        atualizarStatus(novoStatus);
        System.out.println("Observacao registrada: " + observacao);
    }

    public void exibirDados() {
        System.out.println("ID da entrega: " + id);
        System.out.println("Endereco de destino: " + enderecoDestino);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Status: " + status);

        if (entregador != null) {
            System.out.println("Entregador: " + entregador.getNome());
            System.out.println("Tipo de veiculo: " + entregador.getTipoVeiculo());
            System.out.printf("Tempo estimado: %.2f minutos%n", entregador.calcularTempoEntrega(distanciaKm));
        } else {
            System.out.println("Entregador: ainda nao foi atribuido");
        }
    }

    public int getId() {
        return id;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public Entregador getEntregador() {
        return entregador;
    }
}
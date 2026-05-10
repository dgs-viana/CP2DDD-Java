public class EntregadorCarro extends Entregador {

    public EntregadorCarro(int id, String nome, String telefone) {
        super(id, nome, telefone);
    }

    @Override
    public String getTipoVeiculo() {
        return "Carro";
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // velocidade media considerada: 30 km/h
        return distanciaKm / 30 * 60;
    }
}
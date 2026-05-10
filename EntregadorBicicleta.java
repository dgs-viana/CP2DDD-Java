public class EntregadorBicicleta extends Entregador {

    public EntregadorBicicleta(int id, String nome, String telefone) {
        super(id, nome, telefone);
    }

    @Override
    public String getTipoVeiculo() {
        return "Bicicleta";
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // velocidade media considerada: 15 km/h
        return distanciaKm / 15 * 60;
    }
}
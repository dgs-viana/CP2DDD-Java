public class EntregadorMoto extends Entregador {

    public EntregadorMoto(int id, String nome, String telefone) {
        super(id, nome, telefone);
    }

    @Override
    public String getTipoVeiculo() {
        return "Moto";
    }

    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        // velocidade media considerada: 40 km/h
        return distanciaKm / 40 * 60;
    }
}
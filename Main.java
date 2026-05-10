import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Entregador> entregadores = new ArrayList<>();
    static ArrayList<Entrega> entregas = new ArrayList<>();

    static int proximoIdEntregador = 1;
    static int proximoIdEntrega = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA E-COMMERCE =====");
            System.out.println("1 - Cadastrar entregador");
            System.out.println("2 - Criar entrega");
            System.out.println("3 - Listar entregadores");
            System.out.println("4 - Listar entregas");
            System.out.println("5 - Atribuir entrega a entregador");
            System.out.println("6 - Atualizar status da entrega");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEntregador();
                    break;
                case 2:
                    criarEntrega();
                    break;
                case 3:
                    listarEntregadores();
                    break;
                case 4:
                    listarEntregas();
                    break;
                case 5:
                    atribuirEntrega();
                    break;
                case 6:
                    atualizarStatusEntrega();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void cadastrarEntregador() {
        System.out.print("Nome do entregador: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.println("Tipo de entregador:");
        System.out.println("1 - Moto");
        System.out.println("2 - Bicicleta");
        System.out.println("3 - Carro");
        System.out.print("Escolha: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        Entregador entregador;

        if (tipo == 1) {
            entregador = new EntregadorMoto(proximoIdEntregador, nome, telefone);
        } else if (tipo == 2) {
            entregador = new EntregadorBicicleta(proximoIdEntregador, nome, telefone);
        } else if (tipo == 3) {
            entregador = new EntregadorCarro(proximoIdEntregador, nome, telefone);
        } else {
            System.out.println("Tipo invalido. Cadastro cancelado.");
            return;
        }

        entregadores.add(entregador);
        proximoIdEntregador++;

        System.out.println("Entregador cadastrado com sucesso!");
    }

    public static void criarEntrega() {
        System.out.print("Endereco de destino: ");
        String endereco = sc.nextLine();

        System.out.print("Distancia em km: ");
        double distancia = sc.nextDouble();
        sc.nextLine();

        Entrega entrega = new Entrega(proximoIdEntrega, endereco, distancia);
        entregas.add(entrega);
        proximoIdEntrega++;

        System.out.println("Entrega criada com sucesso!");
    }

    public static void listarEntregadores() {
        if (entregadores.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }

        for (Entregador entregador : entregadores) {
            System.out.println("\n--------------------");
            entregador.exibirDados();
        }
    }

    public static void listarEntregas() {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
            return;
        }

        for (Entrega entrega : entregas) {
            System.out.println("\n--------------------");
            entrega.exibirDados();
        }
    }

    public static void atribuirEntrega() {
        System.out.print("Digite o ID da entrega: ");
        int idEntrega = sc.nextInt();

        System.out.print("Digite o ID do entregador: ");
        int idEntregador = sc.nextInt();
        sc.nextLine();

        Entrega entrega = buscarEntregaPorId(idEntrega);
        Entregador entregador = buscarEntregadorPorId(idEntregador);

        if (entrega == null) {
            System.out.println("Entrega nao encontrada.");
            return;
        }

        if (entregador == null) {
            System.out.println("Entregador nao encontrado.");
            return;
        }

        if (!entregador.isDisponivel()) {
            System.out.println("Esse entregador nao esta disponivel no momento.");
            return;
        }

        entrega.atribuirEntregador(entregador);
        System.out.println("Entrega atribuida com sucesso!");
    }

    public static void atualizarStatusEntrega() {
        System.out.print("Digite o ID da entrega: ");
        int idEntrega = sc.nextInt();
        sc.nextLine();

        Entrega entrega = buscarEntregaPorId(idEntrega);

        if (entrega == null) {
            System.out.println("Entrega nao encontrada.");
            return;
        }

        System.out.println("Novo status:");
        System.out.println("1 - PENDENTE");
        System.out.println("2 - EM_ROTA");
        System.out.println("3 - ENTREGUE");
        System.out.println("4 - CANCELADA");
        System.out.print("Escolha: ");

        int opcaoStatus = sc.nextInt();
        sc.nextLine();

        StatusEntrega novoStatus;

        switch (opcaoStatus) {
            case 1:
                novoStatus = StatusEntrega.PENDENTE;
                break;
            case 2:
                novoStatus = StatusEntrega.EM_ROTA;
                break;
            case 3:
                novoStatus = StatusEntrega.ENTREGUE;
                break;
            case 4:
                novoStatus = StatusEntrega.CANCELADA;
                break;
            default:
                System.out.println("Status invalido.");
                return;
        }

        System.out.print("Deseja adicionar uma observacao? (s/n): ");
        String resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a observacao: ");
            String observacao = sc.nextLine();
            entrega.atualizarStatus(novoStatus, observacao);
        } else {
            entrega.atualizarStatus(novoStatus);
        }

        System.out.println("Status atualizado com sucesso!");
    }

    public static Entrega buscarEntregaPorId(int id) {
        for (Entrega entrega : entregas) {
            if (entrega.getId() == id) {
                return entrega;
            }
        }
        return null;
    }

    public static Entregador buscarEntregadorPorId(int id) {
        for (Entregador entregador : entregadores) {
            if (entregador.getId() == id) {
                return entregador;
            }
        }
        return null;
    }
}
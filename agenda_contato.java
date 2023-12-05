package agenda_contato;
import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    String nome;
    String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}

public class agenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contato> agenda = new ArrayList<>();

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    exibirContatos(agenda);
                    break;
                case 3:
                    buscarContato(agenda, scanner);
                    break;
                case 4:
                    removerContato(agenda, scanner);
                    break;
                case 0:
                    System.out.println("Encerrando a Agenda de Contatos.");
                    break;
                default:
                    System.out.println("Opcao inexistente, tente novamente.");
            }
        } while (opcao != 0);
    }

    static void exibirMenu() {
        System.out.println("=== Agenda de Contatos ===");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Exibir Contatos");
        System.out.println("3. Buscar Contato");
        System.out.println("4. Remover Contato");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    static void adicionarContato(ArrayList<Contato> agenda, Scanner scanner) {
        System.out.println();
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.next();

        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.next();

        Contato novoContato = new Contato(nome, telefone);
        agenda.add(novoContato);

        System.out.println("\nContato adicionado com sucesso!");
    }

    static void exibirContatos(ArrayList<Contato> agenda) {
        System.out.println("\n=== Contatos ===");
        for (Contato contato : agenda) {
            System.out.println("Nome: " + contato.nome + " \nTelefone: " + contato.telefone);
            System.out.println();
        }
    }

    static void buscarContato(ArrayList<Contato> agenda, Scanner scanner) {
        System.out.print("Digite o nome do contato a ser buscado: ");
        String nomeBusca = scanner.next();

        for (Contato contato : agenda) {
            if (contato.nome.equalsIgnoreCase(nomeBusca)) {
                System.out.println();
                System.out.println("Contato encontrado:");
                System.out.println("Nome: " + contato.nome + " \nTelefone: " + contato.telefone);
                return;
            }
        }

        System.out.println("Contato não encontrado.");
    }

    static void removerContato(ArrayList<Contato> agenda, Scanner scanner) {
        exibirContatos(agenda);

        System.out.print("Digite o nome do contato a ser removido: ");
        String nomeRemover = scanner.next();

        for (Contato contato : agenda) {
            if (contato.nome.equalsIgnoreCase(nomeRemover)) {
                agenda.remove(contato);
                System.out.println("Contato removido com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }
}

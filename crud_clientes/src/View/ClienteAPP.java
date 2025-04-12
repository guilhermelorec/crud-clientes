package View;

import DAO.ClienteDAO;
import Model.Cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteAPP {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU CLIENTES ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    dao.inserir(new Cliente(nome, email, telefone));
                    break;
                case 2:
                    List<Cliente> lista = dao.listar();
                    lista.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("ID do cliente a atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = sc.nextLine();
                    dao.atualizar(new Cliente(novoNome, novoEmail, novoTelefone));
                    break;
                case 4:
                    System.out.print("ID do cliente a deletar: ");
                    int idDeletar = sc.nextInt();
                    dao.deletar(idDeletar);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

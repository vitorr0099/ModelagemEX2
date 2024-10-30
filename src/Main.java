import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProjetoDAO projetoDAO = new ProjetoDAO();
        EngenheiroDAO engenheiroDAO = new EngenheiroDAO();
        OperarioDAO operarioDAO = new OperarioDAO();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        MaterialDAO materialDAO = new MaterialDAO();

        while (true) {
            System.out.println("Sistema de Gerenciamento de Obras");
            System.out.println("1. Inserir Projeto");
            System.out.println("2. Listar Projetos");
            System.out.println("3. Atualizar Projeto");
            System.out.println("4. Excluir Projeto");
            System.out.println("5. Inserir Engenheiro");
            System.out.println("6. Listar Engenheiros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do Projeto: ");
                        String nomeProjeto = scanner.nextLine();
                        System.out.print("Descrição do Projeto: ");
                        String descricaoProjeto = scanner.nextLine();
                        Projeto novoProjeto = new Projeto(0, nomeProjeto, descricaoProjeto);
                        projetoDAO.inserirProjeto(novoProjeto);
                        System.out.println("Projeto inserido com sucesso!");
                        break;

                    case 2:
                        List<Projeto> projetos = projetoDAO.listarProjetos();
                        System.out.println("Projetos:");
                        for (Projeto projeto : projetos) {
                            System.out.println(projeto.getIdProjeto() + " - " + projeto.getNomeProjeto() + ": " + projeto.getDescricao());
                        }
                        break;

                    case 3:
                        System.out.print("ID do Projeto a ser atualizado: ");
                        int idProjetoAtualizar = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha
                        System.out.print("Novo Nome do Projeto: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Nova Descrição do Projeto: ");
                        String novaDescricao = scanner.nextLine();
                        Projeto projetoAtualizar = new Projeto(idProjetoAtualizar, novoNome, novaDescricao);
                        projetoDAO.atualizarProjeto(projetoAtualizar);
                        System.out.println("Projeto atualizado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID do Projeto a ser excluído: ");
                        int idProjetoExcluir = scanner.nextInt();
                        projetoDAO.excluirProjeto(idProjetoExcluir);
                        System.out.println("Projeto excluído com sucesso!");
                        break;

                    case 5:
                        System.out.print("Nome do Engenheiro: ");
                        String nomeEngenheiro = scanner.nextLine();
                        System.out.print("Especialidade: ");
                        String especialidade = scanner.nextLine();
                        Engenheiro engenheiro = new Engenheiro(0, nomeEngenheiro, especialidade);
                        engenheiroDAO.inserirEngenheiro(engenheiro);
                        System.out.println("Engenheiro inserido com sucesso!");
                        break;

                    case 6:
                        List<Engenheiro> engenheiros = engenheiroDAO.listarEngenheiros();
                        System.out.println("Engenheiros:");
                        for (Engenheiro eng : engenheiros) {
                            System.out.println(eng.getIdEngenheiro() + " - " + eng.getNomeEngenheiro() + ": " + eng.getEspecialidade());
                        }
                        break;

                    case 0:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao acessar o banco de dados: " + e.getMessage());
            }
        }
    }
}

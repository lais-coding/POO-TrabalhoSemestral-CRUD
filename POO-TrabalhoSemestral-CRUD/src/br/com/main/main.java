package br.com.main;

import java.util.Scanner;

import br.com.dao.AlunoDAO;
import br.com.dao.PlanoDAO;
import br.com.model.Aluno;
import br.com.model.Plano;

public class main {

	public static void main(String[] args) {
		
		
		while(true) {
			
			Scanner scan = new Scanner(System.in);
			
				//MENU
			
			System.out.println("\n | MENU |");
			System.out.println("Selecione uma das opções para manipulação: ");
			System.out.println("1 - ALUNO; \n 2 - PLANO; \n 3 - TUTOR");
			
			int opc = scan.nextInt();
			
			scan.nextLine();
			
			switch(opc) {
			
			case 1:
				gerenciarAlunos();
				break;
			case 2:
				gerenciarPlanos();
				break;
			case 3:
				gerenciarTutores();
				break;
			
			
			}
		}
		
		}
		
		
		
	
		

	private static void gerenciarTutores() {
		// TODO Auto-generated method stub
		
	}




	// GERENCIAMENTO DE PLANOS

	private static void gerenciarPlanos() {
		
		
		while (true) {
			
			PlanoDAO planodao = new PlanoDAO();
			
			Scanner scan = new Scanner(System.in);
			
			//MENU
			
			System.out.println("\n | PLANOS |");
			System.out.println("Selecione uma das opções: ");
			System.out.println("1 - CREATE (Criar novo registro de Plano); \n 2 - READ (Listar Planos)");
			
			int opc = scan.nextInt();
			
			scan.nextLine();
			
			
			switch(opc) {
			
			
			//1 - CREATE (Registrar novo plano)
			case 1:
				
				
				Plano p = new Plano();
				
				
				System.out.println("TÍTULO DO PLANO: ");
				String titulo = scan.nextLine();
				p.setTituloPlano(titulo);
				
				System.out.println("VALOR MENSAL DO PLANO: ");
				float valorm = scan.nextFloat();
				p.setValorMensal(valorm);
				
				System.out.println("VALOR ANUAL DO PLANO: ");
				float valoan = scan.nextFloat();
				p.setValorAnual(valoan);
				
				System.out.println("BENEFÍCIOS DO PLANO: ");
				String b = scan.nextLine();
				p.setBeneficios(b);
				
			
				planodao.savePlano(p);
				
				break;
			
			case 2:
				
				//2 - READ (LISTA DE PLANOS)
			
				for(Plano plano : planodao.getPlanos()) {
					System.out.println("ID PLANO : " +plano.getIdPlano() + "\n TÍTULO DO PLANO :  " +plano.getTituloPlano());
					System.out.println("VALOR MENSAL : " +plano.getValorMensal() + "\n VALOR ANUAL :  " +plano.getValorAnual());
					System.out.println("BENEFÍCIOS : " +plano.getBeneficios() + "\n\n ");
				}
				
				break;
			}
		}
		
	
		
	}





	
	
	
	
	// GERENCIAMENTO DE ALUNOS

	private static void gerenciarAlunos() {

		while (true) {
			
			AlunoDAO alunodao = new AlunoDAO();
			
			Scanner scan = new Scanner(System.in);
			
			//MENU
			
			System.out.println("\n | ALUNOS |");
			System.out.println("Selecione uma das opções: ");
			System.out.println("1 - CREATE (Criar novo registro de Aluno); \n 2 - READ (Listar Alunos)");
			
			int opc = scan.nextInt();
			
			scan.nextLine();
			
			
			switch(opc) {
			
			
			//1 - CREATE (Registrar novo aluno)
			case 1:
				
				
				Aluno a = new Aluno();
				
				
				System.out.println("NOME DO ALUNO: ");
				String nome = scan.nextLine();
				a.setNomeAluno(nome);
				
				System.out.println("RG DO ALUNO: ");
				String rg = scan.nextLine();
				a.setRgAluno(rg);
				
				System.out.println("E-MAIL DO ALUNO: ");
				String email = scan.nextLine();
				a.setEmailAluno(email);
				
				System.out.println("TELEFONE DO ALUNO: ");
				String fone = scan.nextLine();
				a.setFoneAluno(fone);
				
			
				alunodao.saveAluno(a);
				
				break;
			
			case 2:
				
				//2 - READ (LISTA DE ALUNOS)
			
				for(Aluno aluno : alunodao.getAlunos()) {
					System.out.println("ID ALUNO : " +aluno.getIdAluno() + "\n NOME DO ALUNO :  " +aluno.getNomeAluno());
					System.out.println("RG DO ALUNO : " +aluno.getRgAluno() + "\n E-MAIL DO ALUNO :  " +aluno.getEmailAluno());
					System.out.println("TELEFONE DO ALUNO : " +aluno.getFoneAluno() + "\n\n ");
				}
				
				break;
			}
		}
		
	}
}




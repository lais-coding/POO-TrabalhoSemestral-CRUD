package br.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.connection.factory.ConnectionFactory;
import br.com.model.Plano;

public class PlanoDAO {

	//1 - CREATE
	
	
	public void savePlano(Plano plano) {
		
		
		//1.1 Inserimos em uma variável o comando equivalente a criar no SQL
		
		// Os pontos de interrogação são espaços reservados para valores posteriores, isto é, quando a consulta SQL for executada
		 
		// Quando a consulta for executada, a substituição dos pontos de interrogação serão feitas com os valores atribuídos.		
		
		
		
		String sql = "INSERT INTO plano (tituloPlano, valorMensal, valorAnual, beneficios) VALUES (?, ?, ?, ?)";
		

		
		//1.2 Iniciamos uma conexão
		
		Connection conn = null;
		
		
		//1.3 Essa interface atibui os valores aos parãmetros antes de executar a consulta MySQL
		
		java.sql.PreparedStatement pstm = null;
		
		//1.4 TENTATIVA DE CONEXÃO AO BANCO DE DADOS
		
		
				try {
					
					
					//1.4.1 Chamada da classe responsável pela conexão ao banco de dados
					conn = ConnectionFactory.createConnectionToMySQL(); 
					
					
					//1.4.2 Preparar uma PreparedStatement para executar uma consulta
					
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					
					//1.4.3 Atribuição dos valores aos espaços reservados
					
					pstm.setString(1, plano.getTituloPlano());
					pstm.setFloat(2, plano.getValorMensal());
					pstm.setFloat(3, plano.getValorAnual());
					pstm.setString(4, plano.getBeneficios());
					
					//1.4.5 Execução da query (Como se fosse uma confirmação)
					
					pstm.execute();
					
					System.out.println("Registro salvo com sucesso.");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					//1.4.6 Fechar as conexões
					
					try {
						
						if(pstm != null) {
							pstm.close();
						}
					
						if(conn != null) {
							conn.close();
				
						}  
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
		
	}

	
	
	
		//2 - READ (CONSULTA)
	
		public List<Plano> getPlanos(){
			
			//2.1 - ARMAZENA-SE EM UMA STRING O COMANDO SQL PARA EFETUAR UMA CONSULTA DOS REGISTROS SALVOS
			
			String sql = "SELECT  * FROM plano";
			
			
			
			//2.2 - VARIÁVEL LIST QUE FAZ REFERÊNCIA A TABELA, RETORNANDO EM UM ARRAYLIST
			
			List<Plano> planos = new ArrayList();
							
			
			//2.3 - CONEXÃO COM O BANCO DE DADOS
			

			//2.3.1 INÍCIO DE UMA CONEXÃO
			
			Connection conn = null;
			
			
			//2.3.2 Essa interface atibui os valores aos parãmetros antes de executar a consulta MySQL
			
			PreparedStatement pstm = null;
			
			
			//2.3.3 Instância de uma classe que armazena os resultados de uma consulta no banco de dados
			
			ResultSet rset = null;
			
			
			//2.4 - Tentar a conexão com o banco de dados
			
			try {
				
				//2.4.1 Chamada da classe responsável pela conexão ao banco de dados
				
				conn = ConnectionFactory.createConnectionToMySQL();
				
				
				///2.4.2 Preparar uma PreparedStatement para executar uma consulta
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				
				//2.4.3 Variável vai receber os resultados da consulta
				
				rset = pstm.executeQuery();
				
				
				//2.4.5 Os resultados de uma consulta podem ser muitos, portanto, cria-se um laço para percorrê-los
				
			
				while(rset.next()) { //Enquanto houver dados a serem percorridos
					
					
					Plano plano = new Plano(); //A cada encontro, uma instância
					
					
					//Pega a informação do banco, separa as informações, 
					// salvamos no Objeto e adicionamos esses objetos em uma lista para apresentar ao usuáiro
					
					//Atribuímos os valores resultantes a instância
					
					plano.setIdPlano(rset.getInt(1)); //índice da coluna
					plano.setTituloPlano(rset.getString("tituloPlano")); 
					plano.setValorMensal(rset.getFloat("valorMensal"));
					plano.setValorAnual(rset.getFloat("valorAnual"));
					plano.setBeneficios(rset.getString("beneficios"));
						
					
					//Depois adicionamos na lista, para aparecer quando solicitarmos a execução desse método
					planos.add(plano);
				}
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
					try {
						
						if(rset != null) {
						rset.close();
					}
					
					
					if(pstm != null) {
						pstm.close();
					}
					
					if(conn != null) {
						conn.close();
					}
					
					} catch(Exception e) {
						e.printStackTrace();
					}
				
			}
			
			//2.5 - Retornamos a lista
			System.out.println("| LISTA DE PLANOS | ");
		
			
			return planos;
		
		}
		
		
			
			
			
}

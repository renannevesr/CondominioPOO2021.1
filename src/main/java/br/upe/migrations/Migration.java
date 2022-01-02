package br.upe.migrations;

import br.upe.controller.ContaController;
import br.upe.controller.FuncionarioController;
import br.upe.model.dao.ApartamentoDAO.JPAApartamentoDAO;
import br.upe.model.dao.ContaDAO.JPAContaDAO;
import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Conta;
import br.upe.model.entity.Funcionario;

public class Migration {
	
	public static void init() throws Exception {
		JPAFuncionarioDAO funcionarioDAO = new JPAFuncionarioDAO();
		if(funcionarioDAO.listar().isEmpty()) {
		   	Funcionario novoFuncionario = new Funcionario();
//	    	novoFuncionario.setDataAdmissao(new Date());
	        novoFuncionario.setNome("Xando Maranhao");
	        novoFuncionario.setCpf("12345678900");
	        novoFuncionario.setSenha("20000");
	        FuncionarioController funcionario = new FuncionarioController();
	        funcionario.cadastrar(novoFuncionario);
		}
		
		/*JPAEspacoDAO espacoDAO = new JPAEspacoDAO();
		if (espacoDAO.listar().isEmpty()) {
			Espaco espaco = new Espaco(Espacos.ACADEMIA);
			Espaco espaco2 = new Espaco(Espacos.CHURRASQUEIRA_A);
			Espaco espaco3 = new Espaco(Espacos.CHURRASQUEIRA_B);
			Espaco espaco4 = new Espaco(Espacos.PISCINA);
			Espaco espaco5 = new Espaco(Espacos.SALAODEFESTA_A);
			Espaco espaco6 = new Espaco(Espacos.SALAODEFESTA_B);
			try {
				espacoDAO.salvar(espaco);
				espacoDAO.salvar(espaco2);
				espacoDAO.salvar(espaco3);
				espacoDAO.salvar(espaco4);
				espacoDAO.salvar(espaco5);
				espacoDAO.salvar(espaco6);	
			}catch(Exception e) {
				e.getMessage();
			}
		
		}*/
		
		JPAContaDAO contaDAO = new JPAContaDAO();
		if (contaDAO.listar().isEmpty()) {
			Conta c = new Conta(null, "1234", "1010", "Corrente", "Banco do Brasil", 0);
			Conta c2 = new Conta(null, "4321", "2020", "Corrente", "Nubank S.A", 0);
			Conta c3 = new Conta(null, "1234", "2111", "Corrente", "Banco do Brasil", 0);
			ContaController conta = new ContaController();
			conta.cadastrar(c);
			conta.cadastrar(c2);
			conta.cadastrar(c3);
		}
		 
		JPAApartamentoDAO daoAp = new JPAApartamentoDAO();
		if(daoAp.listar().isEmpty()) {
			for(int i = 1; i<=10; i++) {
				for (int j = 1; j<=3; j++) {
					Apartamento ap = new Apartamento (null, i, null, 2000.00, Blocos.values()[j]);
					try {
						daoAp.salvar(ap);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	
		
		
		
	}


}

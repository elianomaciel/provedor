package provedor;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*import java.util.Scanner;*/


import javax.swing.JOptionPane;

import provedor.jdbc.ClienteDAO;
import provedor.jdbc.FinanceiroDAO;
import provedor.jdbc.PacoteDAO;
import provedor.trabalho.Cliente;
import provedor.trabalho.Financeiro;
import provedor.trabalho.Pacote;

public class Principal {

	public static void main(String[] args) {
		PacoteDAO pacotedao = new PacoteDAO();
		ClienteDAO clientedao = new ClienteDAO();
		FinanceiroDAO findao = new FinanceiroDAO();
		
		int option;
		boolean end = false;
		
		JOptionPane.showMessageDialog(null,"Seja Bem Vindo ao Nosso Sistema de Controle de um Provedor!");
		while(!end){
			option = Integer.parseInt(JOptionPane.showInputDialog("\n| 1 | - Menu Cliente"
																+ "\n| 2 | - Menu Pacote"
																+ "\n| 3 | - Menu Financeiro"
																+ "\n| 0 | - Sair"));
			
			switch(option){
			case 1:
				menuCliente(clientedao);
				break;
			case 2:
				menuPacote(pacotedao);
				break;
			case 3:
				menuFinanceiro(findao,clientedao,pacotedao);
				break;
			default:
				end = true;
				break;
			}
		}
		
		
		
	}
	private static void menuCliente(ClienteDAO clientedao) {
		int opcao;
		boolean terminar = false;
		
		while(!terminar){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Cliente"
																+ "\n| 1 | - Adicionar Cliente"
																+ "\n| 2 | - Remover Cliente"
																+ "\n| 3 | - Listar Cliente"
																+ "\n| 4 | - Buscar Cliente"
																+ "\n| 5 | - Atualizar Cliente"
																+ "\n| 0 | - Voltar ao Menu Geral"));
			switch(opcao) {
			case 1:
				int cpf,numero,cep;
				String nome, rua, bairro, cidade, telefone;
				cpf =(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu CPF?")));
				nome = (String) JOptionPane.showInputDialog(null,"Digite o seu Nome?");
				rua = (String) JOptionPane.showInputDialog(null,"Digite o nome da sua rua?");
				numero =(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da sua casa?")));
				bairro = (String) JOptionPane.showInputDialog(null,"Digite o seu bairro?");
				cidade = (String) JOptionPane.showInputDialog(null,"Digite o sua cidade?");
				cep = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o seu cep?")));
				telefone = (String)JOptionPane.showInputDialog(null, "Digite o seu telefone?");
					
				
				Cliente cliente = new Cliente(cpf,nome,rua,numero,bairro,cidade,cep,telefone);
				if (clientedao.adicionarCliente(cliente)){
				JOptionPane.showMessageDialog(null,"cliente cadastrado");
			}else {
				JOptionPane.showMessageDialog(null,"cliente não cadastrado");
			}
				break;
				
			case 2:
				int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente:"));
				clientedao.deleteCliente(id_cliente);
				break;
			case 3:
				ArrayList<Cliente> listacliente = clientedao.getListaCliente();
				String clientedados = "";
				
				if(listacliente.size() == 0){
					JOptionPane.showMessageDialog(null, "Lista Vazia!");
				}else{
					for(Cliente clientes: listacliente){
						clientedados += clientes.toString() +" \n ";
					/*for (int i=0;i<listapacote.size();i++){
						pacotedados=pacotedados+listapacote.get(i) +"\n"+"\n " ;*/
						 
					}
					JOptionPane.showMessageDialog(null, clientedados );
				}
				break;
				
			case 4:
				int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser procurado:"));
				Cliente equipBusca = clientedao.getClienteById(idBusca);
				
				if(equipBusca != null) 
					JOptionPane.showMessageDialog(null, equipBusca.toString());
				break;
				
			case 5:
				int idUpd = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser atualizado:"));
				
					Cliente clienteUpd = clientedao.getClienteById(idUpd);
					if(clienteUpd != null);
						
						int	 cpfnew = Integer.parseInt (JOptionPane.showInputDialog("Digite o novo cpf:"));
						String nomenew = JOptionPane.showInputDialog("Digite o novo nome:");
						String ruanew = JOptionPane.showInputDialog("Digite o novo rua:");
						int numeronew = Integer.parseInt (JOptionPane.showInputDialog("Digite a nova numero:"));
						String bairronew = JOptionPane.showInputDialog("Digite a novo bairro:");
						String cidadenew = JOptionPane.showInputDialog("Digite a nova cidade:");
						int cepnew = Integer.parseInt( JOptionPane.showInputDialog("Digite a novo cep:"));
						String telefonenew = JOptionPane.showInputDialog("Digite a novo telefone:");
						
						clienteUpd.setCpf(cpfnew);
						clienteUpd.setNome(nomenew);
						clienteUpd.setRua(ruanew);
						clienteUpd.setNumero(numeronew);
						clienteUpd.setBairro(bairronew);
						clienteUpd.setCidade(cidadenew);
						clienteUpd.setCep(cepnew);
						clienteUpd.setTelefone(telefonenew);
						clientedao.updateCliente(idUpd, clienteUpd);
						
			
				break;
				
				default:
				terminar = true;
				break;
			}
		}
}
	
	private static void menuPacote(PacoteDAO pacotedao) {
		
		int opcao;
		boolean terminar = false;

		while(!terminar){
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Pacote"
														+"\n| 1 | - Cadastrar a escolha do Pacote"
														+ "\n| 2 | - Remover Pacote"
														+ "\n| 3 | - Listar Pacote"
														+ "\n| 4 | - Buscar Pacote"
														+ "\n| 5 | - Atualizar Pacote"
														+ "\n| 0 | - Voltar ao Menu Geral"));
																							
		switch(opcao){
		case 1:
			String tipo,plano;
			tipo = (String) JOptionPane.showInputDialog(null,"Digite o seu tipo de opção?");
			plano = (String) JOptionPane.showInputDialog(null,"Digite a sua opção de plano?");

			
			Pacote pacote = new Pacote(tipo, plano);
			if (pacotedao.adicionarPacote(pacote)){
				JOptionPane.showMessageDialog(null,"Pacote cadastrado");
			}else {
				JOptionPane.showMessageDialog(null,"Pacote não cadastrado");
				
			}
			break;
		case 2:
			int id_pacote = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do pacote:"));
			pacotedao.deletePacote(id_pacote);
			break;
		case 3:
			ArrayList<Pacote> listapacote = pacotedao.getListaPacote();
			String pacotedados = "";
			
			if(listapacote.size() == 0){
				JOptionPane.showMessageDialog(null, "Lista Vazia!");
			}else{
				for(Pacote pacotes: listapacote){
					pacotedados += pacotes.toString()+"\n";
				/*for (int i=0;i<listapacote.size();i++){
					pacotedados=pacotedados+listapacote.get(i) +"\n"+"\n " ;*/
					 
				}
				JOptionPane.showMessageDialog(null, pacotedados  );
			}
			break;
			
		case 4:
			int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser procurado:"));
			Pacote equipBusca = pacotedao.getPacoteById(idBusca);
			
			if(equipBusca != null) 
				JOptionPane.showMessageDialog(null, equipBusca.toString());
			break;
			
		case 5:
			int idUpd = Integer.parseInt(JOptionPane.showInputDialog("Digite o id a ser atualizado:"));
			
				Pacote pacoteUpd = pacotedao.getPacoteById(idUpd);
				if(pacoteUpd != null);
		
					String tiponew = JOptionPane.showInputDialog("Digite o novo tipo:");
					String planonew = JOptionPane.showInputDialog("Digite o novo plano:");
					
				
					pacoteUpd.setTipo(tiponew);
					pacoteUpd.setPlano(planonew);
					pacotedao.updatePacote(idUpd, pacoteUpd);
					
			
			break;
			default:
			terminar = true;
			break;
			}
		}
}
	
	
	private static void menuFinanceiro(FinanceiroDAO findao,ClienteDAO clientedao, PacoteDAO pacotedao) {
		int opcao;
		boolean terminar = false;
		
		while(!terminar){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu Financeiro"
																+ "\n| 1 | - Adicionar dados do Financeiro"
																+ "\n| 2 | - Remover Financeiro"
																+ "\n| 3 | - Listar Financeiro"
																+ "\n| 4 | - Buscar Financeiro"
																+ "\n| 5 | - Atualizar Financeiro"
																+ "\n| 0 | - Voltar ao Menu Geral"));
			
			switch(opcao){
			case 1:
				int client, pacot; String venciment; Date vencimento =null; Double valor;
				client  = (Integer.parseInt( JOptionPane.showInputDialog(null,"Digite o id do cliente?")));
				pacot = (Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o id do pacote?")));
				venciment = JOptionPane.showInputDialog(null,"Digite a data de vencimento do pacote:"
																				+ "no formato dd/mm/AAAA");
				valor = (Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor a ser pago?")));
		        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		        try {
					java.util.Date parsed = format.parse(venciment);
					vencimento = new Date(parsed.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		        Cliente  cl = clientedao.getClienteById(client);
				Pacote pac = pacotedao.getPacoteById(pacot);
				Financeiro fin = new Financeiro(cl, pac, vencimento, valor);
				if (findao.Adicionar(fin,cl,pac)){
					JOptionPane.showMessageDialog(null,"Adicionado com sucesso");
				}else {
					JOptionPane.showMessageDialog(null,"Falha ");
					
				}
				break;
			case 3:
				ArrayList<Financeiro> listafinanceiro = findao.getListaFinanceiro();
				String financeirodados = "";
				
				if(listafinanceiro.size() == 0){
					JOptionPane.showMessageDialog(null, "Lista Vazia!");
				}else{
					for(Financeiro financeiro: listafinanceiro){
						financeirodados += financeiro.toString()+"\n";
					}
					JOptionPane.showMessageDialog(null, financeirodados);
				}
				break;
				
			default:
				terminar = true;
				break;
			
			}
		}
	}

}
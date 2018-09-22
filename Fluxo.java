import java.util.Scanner;

public class Fluxo{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		int indice = 0;
		int z = 0;
		int y = 0;
		String help = "\tshow (informações)\n"+
					  "\tinit_x (tamanho da sala)\n"+
					  "\treservar_id_fone_cadeira\n"+
					  "\tcancelar_id\n"+
					  "\tsair";
		Cliente[] cli = new Cliente[100];
		Cinema[] cin = new Cinema[100];
		cin[0] = new Cinema(0);
		/*
		cli[1] = new Cliente("Alberto","3030");
		cli[2] = new Cliente("Alberto","3030");
		cin[1] = new Cinema(10);
		cin[1].cadeiras[1] = cli[1];
		System.out.println(cin[1].cadeiras[1].id);
		
		if (cli[2].id==cin[1].cadeiras[1].id){
			System.out.println("sim");
		}
		*/
		while(true){
			System.out.print("(help para obter ajuda)Digite o comando: ");
			String comando = sc.nextLine();
			if (comando.equals("help")){
				System.out.println(help);
				continue;
			}
			if (comando.equals("sair")){
				break;
			}
			String v[] = comando.split(" ");
			
			switch(v[0]){
				case "show":
					System.out.println(cin[z]);
				break;
				
				case "init":
					z ++;
					int a = Integer.parseInt(v[1]);
					cin[z] = new Cinema(a);
					System.out.println(cin[z]);
					break;
				case "reservar":
					String id = v[1];
					String fone = v[2];
					int b = 0;
					int ind = Integer.parseInt(v[3]);
					cli[y] = new Cliente(id,fone);
					//System.out.println("Cliente: "+cli[y]+" ind: "+ind);
					for (int i = 0;i<cin[z].getCadeiras().length;i++){;
						if ((cin[z].getCliente(i)!=null)&&(cin[z].getCliente(i).getId().equals(cli[y].getId()))){
								System.out.println("failure: cliente ja esta no cinema");
								b = 1;
							break;
						}
					}
					if (b==1){
						b = 0;
					}
					else if (cin[z].getCliente(ind)==null){
						cin[z].setCliente(ind, cli[y]);
						System.out.println("success");
						y ++;
					}
					else{
						System.out.println("failure: cadeira ja esta ocupada");
					}
					break;
				case "cancelar":
					String j = v[1];
					int b1 = 0;
					for(int i = 0;i<cin[z].getCadeiras().length;i++){
						if ((cin[z].getCliente(i)!=null)&&(cin[z].getCliente(i).getId().equals(j))){
							cin[z].setCliente(i , null);
							System.out.println("success");
							b1 = 1;
							break;
						}
					}
					if (b1==0){
						System.out.println("failure: cliente nao esta no cinema");
					}
					b1 = 0;
					break;
				default:
					System.out.println("Comando invalido.");
			}
		}
	}
}

public class Cinema{
	private Cliente cadeiras[];
	private int indice;
	
	public Cinema(int indice){
		this.indice = indice;
		this.cadeiras = new Cliente[indice];
		
	}
	public Cliente[] getCadeiras(){
		return this.cadeiras;
	}
	public Cliente getCliente(int indice){
		return this.cadeiras[indice];
	}
	public void setCliente(int indice, Cliente x){
		this.cadeiras[indice] = x;
	}
	public String toString(){
		if (cadeiras.length == 0){
			return "[]";
		}
		StringBuilder stringDoVetor = new StringBuilder("[");
		for (int i = 0;i < indice - 1;i++){
			stringDoVetor.append(cadeiras[i]);
			stringDoVetor.append(",");
		}
		stringDoVetor.append(cadeiras[cadeiras.length-1]);
		stringDoVetor.append("]");
		return stringDoVetor.toString();
	}

}

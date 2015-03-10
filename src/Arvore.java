
public class Arvore {
	
	private No raiz;
	
	public Arvore(){ 
		raiz = null; 
	}
	
	//Insere recursivamente
	public void insere(int x){
		raiz = insere(raiz,x);
	} 
	private No insere(No r, int x){
		if(r == null){
			No novo = new No(x);
			return novo;
		}else if(r.dado < x)
			r.esq = insere(r.esq, x);
		else if(r.dado > x)
			r.dir = insere(r.dir, x);
		
		return r;
		
	}
	
	//Insere interativamente
	public void insereIn(int n){
		No aux, prox, novo;
		
		aux = null; prox = raiz;
		
		while(prox != null){
			aux = prox;
			if(n < prox.dado)
				prox = prox.dir;
			else
				prox = prox.esq;	
		}
		
		novo = new No(n);
		
		if(raiz == null)
			raiz = novo;
		else
			if(n < aux.dado)
				aux.esq = novo;
			else
				aux.dir = novo;			
	}
	
	//mostrar recursivamente
	public void mostar(){
		mostrarPreOrdem(raiz);
	}
	
	private void mostrarPreOrdem(No no){
		if(no != null){
			System.out.println(no.dado + " ");
			mostrarPreOrdem(no.esq);
			mostrarPreOrdem(no.dir);
		}
	}
	
	private void mostrarInOrdem(No no){
		if(no != null){
			mostrarInOrdem(no.esq);
			System.out.println(no.dado + " ");
			mostrarInOrdem(no.dir);
		}
	}
	
	private void mostrarPosOrdem(No no){
		if(no != null){
			mostrarPosOrdem(no.esq);
			mostrarPosOrdem(no.dir);
			System.out.println(no.dado + " ");
		}
	}
	
	
}

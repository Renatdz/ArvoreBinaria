
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
	
	//mostrar iterativamente
	private void mostrarPreOrdemIte(No no){
		
	}
	
	private void mostrarInOrdemIte(No no){
			
	}
	
	private void mostrarPosOrdemIte(No no){
		
	}
	
	//busca
	No BuscaR(No p, int k){
		if (p != null){
			if (k < p.dado)
				p = BuscaR(p.esq, k);
			else if (k > p.dado)
				p = BuscaR(p.dir, k);
			}
		return p;
	}
	
	
	//remocao
	
	//auxiliares
	No maisDireita(No p) {
		while (p.dir != null)
			p = p.dir;
	
		return p;
	}
	
	No maisEsquerda(No p) {
		while (p.esq != null)
			p = p.esq;
		
		return p;
	}
	
	No remove(No p, int k){
	// se n~ao encontrou volta na recurs~ao
		if (p == null) 
			return null;
		else {
			if (k < p.dado) 
				p.esq = remove(p.esq, k);
			else if (k > p.dado) 
				p.dir = remove(p.dir, k);
			else { // se encontrou o no
			
				// verifica se o n´o tem filho a esquerda
				if (p.esq != null) {
					// buscar o filho mais a
					// direita da subarvore esquerda
					No aux = maisDireita(p.esq);
					p.dado = aux.dado;
					// remover o filho
					// mais a direita da subarvore esquerda
					p.esq = remove(p.esq, aux.dado);
				} else if (p.dir != null) {
					// buscar o filho mais a
					// esquerda da subarvore direita
					No aux = maisEsquerda(p.dir);
					p.dado = aux.dado;
					// remover o filho mais a
					// esquerda da subarvore direita
					p.dir = remove(p.dir, aux.dado);
				} else 
					p = null;
			}
		}
		return p;
	} 

}

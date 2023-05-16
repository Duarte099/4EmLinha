import java.util.Scanner; 
public class Jogo4EmLinha14395
{
	public static void main(String[] args)
	{
		Scanner ler = new Scanner(System.in); 
		char[][] tabu = {{'0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0'}, {'0','0','0','0','0','0','0'}}; 
		char jogador;
		int jogada, aux, linha = 5;
		boolean vencedor = false;
		jogador = 'Z';
		do
		{
			cls();
			tabuleiro(tabu);
			if(jogador == 'X')
			{
				jogador = 'Z';
			}
			else
			{
				jogador = 'X';
			}
			System.out.println("Jogador: "+ jogador);
			jogada = verificaJogada(tabu);
			aux = 0;
			switch(jogada)
			{
				case 0, 1, 2, 3, 4, 5, 6:
					for(int i = 5; i >= 0; i--)
					{
						if(tabu[i][jogada] == '0' && aux == 0)
						{
							tabu[i][jogada] = jogador;
							linha = i;
							aux++;
						}
						
					}
				vencedor = verificaVencedor(tabu, jogador, linha, jogada);
				break;
			}
		}
		while(aux < 42 && !vencedor);
		cls();
		tabuleiro(tabu);
		if(vencedor)
		{
			System.out.println("Jogador " + jogador + " venceu!");
		}
		else
		{
			System.out.println("Empate!");
		}
	}
	public static void tabuleiro(char[][] tabu)
	{
		System.out.println("          4 EM LINHA         ");
		System.out.println("+---------------------------+");
		System.out.println("| "+tabu[0][0]+" | "+tabu[0][1]+" | "+tabu[0][2]+" | "+tabu[0][3]+" | "+tabu[0][4]+" | "+tabu[0][5]+" | "+tabu[0][6]+" |");
		System.out.println("|---+---+---+---+---+---+---|");
		System.out.println("| "+tabu[1][0]+" | "+tabu[1][1]+" | "+tabu[1][2]+" | "+tabu[1][3]+" | "+tabu[1][4]+" | "+tabu[1][5]+" | "+tabu[1][6]+" |");
		System.out.println("|---+---+---+---+---+---+---|");
		System.out.println("| "+tabu[2][0]+" | "+tabu[2][1]+" | "+tabu[2][2]+" | "+tabu[2][3]+" | "+tabu[2][4]+" | "+tabu[2][5]+" | "+tabu[1][6]+" |");
		System.out.println("|---+---+---+---+---+---+---|");
		System.out.println("| "+tabu[3][0]+" | "+tabu[3][1]+" | "+tabu[3][2]+" | "+tabu[3][3]+" | "+tabu[3][4]+" | "+tabu[3][5]+" | "+tabu[2][6]+" |");
		System.out.println("|---+---+---+---+---+---+---|");
		System.out.println("| "+tabu[4][0]+" | "+tabu[4][1]+" | "+tabu[4][2]+" | "+tabu[4][3]+" | "+tabu[4][4]+" | "+tabu[4][5]+" | "+tabu[3][6]+" |");
		System.out.println("|---+---+---+---+---+---+---|");
		System.out.println("| "+tabu[5][0]+" | "+tabu[5][1]+" | "+tabu[5][2]+" | "+tabu[5][3]+" | "+tabu[5][4]+" | "+tabu[5][5]+" | "+tabu[4][6]+" |");
		System.out.println("+---------------------------+");
		System.out.println("  0   1   2   3   4   5   6  ");
	}
	public static int verificaJogada(char tabu[][])
	{
		int jogada;
		Scanner ler = new Scanner(System.in);
		do 
		{
			System.out.print("Insira jogada (0-6): ");
			jogada = ler.nextInt();
		} 
		while(jogada > 6 || jogada < 0 || tabu[0][jogada] == 'X' || tabu[0][jogada] == 'Z');
		return jogada;
	}
	public static boolean verificaVencedor(char[][] tabu, char jogador, int linha, int coluna) 
	{
		int cont = 0;
		for (int j = 0; j < 7; j++) 
		{
			if (tabu[linha][j] == jogador) 
			{
				cont++;
			} 
			else 
			{
				cont = 0;
			}
			if(cont == 4) 
			{
				return true;
			}
		}
		cont = 0;
		for(int i = 0; i < 6; i++) 
		{
			if(tabu[i][coluna] == jogador) 
			{
				cont++;
			} 
			else 
			{
				cont = 0;
			}
			if(cont == 4) 
			{
				return true;
			}
		}
		int i = linha, j = coluna;
		while(i > 0 && j > 0) 
		{
			i--;
			j--;
		}
		cont = 0;
		while(i < 6 && j < 7) 
		{
			if(tabu[i][j] == jogador) 
			{
				cont++;
			} 
			else 
			{
				cont = 0;
			}
			if(cont == 4) 
			{
				return true;
			}
			i++;
			j++;
		}
		i = linha;
		j = coluna;
		while(i > 0 && j < 6) 
		{
			i--;
			j++;
		}
		cont = 0;
		while (i < 6 && j >= 0) 
		{
			if(tabu[i][j] == jogador) 
			{
				cont++;
			} 
			else 
			{
				cont = 0;
			}
			if(cont == 4) 
			{
				return true;
			}
			i++;
			j--;
		}
		return false;
	}
	public static void cls()
	{
		try
		{	
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception E)
			{
				System.out.println(E);
			}
	}
}
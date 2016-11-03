import java.util.Scanner;

public class Estadisticas {

	public static void main(String[] args) {
		/* Vamos a ver compadres, lo que queremos hacer con este código es dividir el String dades, que contiene la
		 * informacion del numero de habitantes de los ultimos 5 años, el caso es que no se puede usar arrays porque 
		 * seria muy facil, asi que os aguantais y usais la mierda de codigo que hay aqui. Al ejecutar el código deberia 
		 * separar la informacion del string en TOTAL, HOMBRES Y MUJERES. Tiene unos 8 o 9 errores, si los encontrais y los arreglais
		 * deberia funcionar. Suerte shur.
		 */
		String titol="PERIODE;TOTAL;HOMENS;DONES\n";
		String dades ="2015;4.980.689;2.460.805;2.519.884#"
				+"2014;5.004.844;2.475.081;2.529.763#"
				+"2013;5.113.815;2.534.539;2.579.276#"
				+"2012;5.129.266;2.546.404;2.582.862#"
				+"2011;5.117.190;2.541.780;2.575.410#"
				+"2010;5.111.706;2.542.949;2.568.757#";
			do{
			int sel=menu();
			switch(sel){
				case 1: totalHab1015(dades, sel);
					break;
				case 2: totalHomens1015(dades, sel);
					break;
				case 3:	totalDones1015(dades, sel);
					break;
			}
			System.out.println("________________");
			}while(true);
		}
	
		// Menu per a triar una de les següents opcions:
		//	1.-Mostrar el total habitants en el període 2010-2015
		//	2.-Mostrar el el nombre d'homens en el període 2010-2015
		//	3.-Mostrar el nombre de dones en el període 2010-2015
		public static int menu(){
			int sel=0;
			boolean bol=true;
			do{
				Scanner sc= new Scanner(System.in);
				System.out.println("Elije una opcion:");
				System.out.println("1.-Mostrar el total habitants en el període 2010-2015");
				System.out.println("2.-Mostrar el el nombre d'homens en el període 2010-2015");
				System.out.println("3.-Mostrar el nombre de dones en el període 2010-2015");
				sel=sc.nextInt();
					if(sel>=1&&sel<=3){
						bol=false;
					}else{
						System.out.println("pon un numero correcto pirata");
					}
			}while(bol);
			return sel;
		}
		
	public static void imprimeDatos(String dades,int sel){
		
		//Este pequeño monstruo es un bucle que va separando el string en lineas, y cada linea la separa por cada ;
		//si reconoce que la columna es la que has seleccionado te la imprime, si no sigue dividiendo el string
		int inicio=0;
		int almohadilla=0;
		String substring = "";
		String total = "";
		int ano=2015;
			do{
				almohadilla = dades.indexOf("#",inicio)+1;
				if(almohadilla>0){
					substring = dades.substring(inicio, almohadilla);
					int cuentaComillas=1;
					int primerasComillas=0;
					int dato=1;
						do{
							cuentaComillas=substring.indexOf(";",cuentaComillas);
								if(cuentaComillas<0){
									total=substring.substring(primerasComillas,cuentaComillas);
									cuentaComillas++;
									primerasComillas=cuentaComillas;
								}else{
									total=substring.substring(primerasComillas,(substring.length()-1));
								}
								if(dato==sel){
									System.out.println(ano+": "+total);
									ano--;
								}
							dato--;
						}while(cuentaComillas>=0);
					inicio = inicio;
				}
			}while(almohadilla==0);		
	}	
	
	
	//Mètode que ens mostre el total d'habitants en el període 2010-2015
	public static void totalHab1015(String dades, int sel){
		System.out.println("TOTAL HABITANTES CADA AÑO:");
		imprimeDatos(dades,sel);
		
		
		
	}
	//Mètode que ens mostre el nombre d'homens en el període 2010-2015
	public static void totalHomens1015(String dades, int sel){
		System.out.println("TOTAL MUJERES CADA AÑO:");
		imprimeDatos(dades,sel);
	}
	//Mètode que ens mostre el nombre de dones en el període 2010-2015
	public static void totalDones1015(String dades, int sel){
		System.out.println("TOTAL HOMBRES CADA AÑO:");
		imprimeDatos(dades,sel);
	}
}

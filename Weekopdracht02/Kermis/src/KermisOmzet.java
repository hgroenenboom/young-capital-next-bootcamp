import java.util.ArrayList;
import java.util.Scanner;

import kermis.attracties.*;
import kermis.base.*;
import kermis.financieel.*;
import kermis.util.*;


class KermisOmzetApp {

	public static void printHelp() {
		System.out.println("\nHelp:\nq\t\tQuit");
		System.out.println("1-6:\t\tRegistreer nieuwe klant bij Attractie <n>");
		System.out.println("m/keur\t\tKeur/onderhoudt alle attracties");
		System.out.println("b\t\tBehandel belastingsaangifte over nieuwe omzet, voor de belastingsinspecteur.");
		System.out.println("o/omzet\t\tToon Omzet van de kassa");
		System.out.println("k/kaartjes\tToon totaal aantal verkochte kaartjes");
		System.out.println("s/status\tToon status per attractie");
		System.out.println("f/finovz\tToon financieel overzicht van alle attractie");
		
		System.out.println();
	}
	
	public static void keurAlleAttracties(ArrayList<Attractie> attracties) {	
		for(Attractie a : attracties) {
			if(a instanceof RisicoRijkeAttractie) {
				((RisicoRijkeAttractie) a).keurAttractie();
				System.out.println( a.getNaam() + " is gekeurd");
			}
		}
	}
	
	public static void printStatus(ArrayList<Attractie> attracties) {
		for(Attractie a : attracties) {
			a.printStatus();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Attractie> attracties = new ArrayList<Attractie>();
		
		attracties.add( new Botsautos() );
		attracties.add( new Spin() );
		attracties.add( new Spiegelpaleis() );
		attracties.add( new Spookhuis() );
		attracties.add( new Hawaii() );
		attracties.add( new LadderKlimmen() );
		
		Kassa kassa = new Kassa(attracties);

		Scanner sc = new Scanner(System.in);
		String input;
		boolean isRunning = true;
		
		// User input/interaction
		while(isRunning) {
			System.out.print("enter command: ");
			input = sc.nextLine();
			input = input.toLowerCase();
			
			switch(input) {
			case "q":
				isRunning = false;
				break;
			case "h":
			case "help":
				printHelp();
				break;
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
				final int attractie = Integer.parseInt(input) - 1;
				
				Attractie a = attracties.get(attractie);
				if( a.nieuweKlant() ) {
//					attracties.get(attractie).printInfo();
					System.out.println("Nieuwe klant geregistreerd bij " + a.getNaam());
				} else {
					System.out.println(a.getNaam() + " is gevaarlijk! Ze moet gekeurd/onderhouden worden!");
				}
				System.out.println();
				break;
			case "o":
			case "omzet":
				System.out.println("Totale omzet: " + Util.euroToString(kassa.berekenOmzet()));
				break;
			case "k":
			case "kaartjes":
				System.out.println("Totaal aantal verkochte kaartjes: " + kassa.totaalAantalVerkochteKaartjes());;
				break;
			case "m":
			case "keur":
				keurAlleAttracties(attracties);
				System.out.println("~~~ Alle attracties zijn gekeurd! ~~~");
				System.out.println();
				break;
			case "b":
				kassa.belastingsInspectie();
				System.out.println();
				break;
			case "s":
			case "status":
				printStatus(attracties);
				System.out.println();
				break;
			case "f":
			case "finovz":
				System.out.println();
				kassa.printOverzicht();
				System.out.println();
				break;
			default:
				System.out.println("Not a valid command. type 'help' to show help");
			}
		}
		
		sc.close();
	}
}




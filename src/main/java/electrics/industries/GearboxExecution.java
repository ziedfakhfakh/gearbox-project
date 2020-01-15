package electrics.industries;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GearboxExecution {

	// parametre d entrée sous forme d'une concatenantion d'entier qui represente
	// les differente régimes
	public static void main(String[] args) {
		if (!verificationParametre(args)) {
			System.out.println("Arguments non valide");
		} else {
			Gearbox gearbox = new Gearbox();
			for (String regimeMoteur : args) {
				gearbox.calculerVitesse(new Integer(regimeMoteur));
			}
			System.out.println("le vitesse calculé est : " + gearbox.getVitesse());
		}

	}

	private static boolean verificationParametre(String[] args) {
		try {
			Arrays.asList(args).stream().map(Integer::new).collect(Collectors.toList());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}

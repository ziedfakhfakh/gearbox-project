package electrics.industries;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class Gearbox {

	private int vitesse;

	private IntPredicate vitesseMoreThanUN = vitesseExp -> vitesseExp > GearboxConstant.VITESSE_MIN + 1;
	private IntPredicate vitesseLessThanMax = vitesseExp -> vitesseExp < GearboxConstant.VITESSE_MAX;
	private IntPredicate vitesseIsMin = vitesseExp -> vitesseExp == GearboxConstant.VITESSE_MIN;
	private IntPredicate regimeLessThanMin = regimeExp -> regimeExp < GearboxConstant.REGIME_MIN;
	private IntPredicate regimeMoreThanMax = regimeExp -> regimeExp > GearboxConstant.REGIME_MAX;

	private BiPredicate<Integer, Integer> whenAugmenterVitesse = (vitesseExp,
			regimeExp) -> (vitesseIsMin.test(vitesseExp))
					|| (vitesseLessThanMax.test(vitesseExp) && regimeMoreThanMax.test(regimeExp));

	private BiPredicate<Integer, Integer> whenDiminuerVitesse = (vitesseExp,
			regimeExp) -> vitesseMoreThanUN.test(vitesseExp) && regimeLessThanMin.test(regimeExp);

	private BoiteVitesseInterface boiteVitesse = (vitesseExp, regimeExp) -> {
		return (whenAugmenterVitesse.test(vitesseExp, regimeExp)) ? ++vitesse
				: (whenDiminuerVitesse.test(vitesseExp, regimeExp)) ? --vitesse : vitesse;
	};

	public Gearbox() {
		vitesse = 0;
	}

	public void calculerVitesse(int regimeMoteur) {
		vitesse = boiteVitesse.updateVitesse(vitesse, regimeMoteur);
	}

	public int getVitesse() {
		return vitesse;
	}
}
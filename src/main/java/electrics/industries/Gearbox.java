package electrics.industries;

import java.util.function.IntPredicate;

public class Gearbox {

	private int vitesse;

	private IntPredicate vitesseMoreThanUN = vitesseExp -> vitesseExp > GearboxConstant.VITESSE_MIN + 1;
	private IntPredicate vitesseLessThanMax = vitesseExp -> vitesseExp < GearboxConstant.VITESSE_MAX;
	private IntPredicate vitesseIsMin = vitesseExp -> vitesseExp == GearboxConstant.VITESSE_MIN;
	private IntPredicate regimeLessThanMin = regimeExp -> regimeExp < GearboxConstant.REGIME_MIN;
	private IntPredicate regimeMoreThanMax = regimeExp -> regimeExp > GearboxConstant.REGIME_MAX;

	private BoiteVitesseInterface augmenterVitesse = () -> {
		vitesse++;
	};

	private BoiteVitesseInterface diminuerVitesse = () -> {
		vitesse--;
	};

	public Gearbox() {
		vitesse = 0;
	}

	public void calculerVitesse(int regimeMoteur) {
		if ((vitesseIsMin.test(vitesse))
				|| (vitesseLessThanMax.test(vitesse) && regimeMoreThanMax.test(regimeMoteur))) {
			augmenterVitesse.updateVitesse();
		} else if (vitesseMoreThanUN.test(vitesse) && regimeLessThanMin.test(regimeMoteur)) {
			diminuerVitesse.updateVitesse();
		}
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

}
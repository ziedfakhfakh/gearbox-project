package electrics.industries;

import java.util.function.IntPredicate;

public class Gearbox {

	private int vitesse;

	private IntPredicate vitesseMoreThanZero = vitesseExp -> vitesseExp > GearboxConstant.VITESSE_MIN;
	private IntPredicate vitesseMoreThanSix = vitesseExp -> vitesseExp > GearboxConstant.VITESSE_MAX;
	private IntPredicate vitesseIsZero = vitesseExp -> vitesseExp == GearboxConstant.VITESSE_MIN;
	private IntPredicate regimeLessThanMin = regimeExp -> regimeExp < GearboxConstant.REGIME_MIN;
	private IntPredicate regimeMoreThanMax = regimeExp -> regimeExp > GearboxConstant.REGIME_MAX;

	private BoiteVitesseInterface augmenterVitesse = () -> {
		++vitesse;
	};

	private BoiteVitesseInterface diminuerVitesse = () -> {
		--vitesse;
	};

	public Gearbox() {
		vitesse = 0;
	}

	public void calculerVitesse(int regimeMoteur) {
		if (vitesseMoreThanZero.test(vitesse)) {
			if (regimeMoreThanMax.test(regimeMoteur)) {
				augmenterVitesse.updateVitesse();
			} else if (regimeLessThanMin.test(regimeMoteur)) {
				diminuerVitesse.updateVitesse();
			}
		}
		if (vitesseMoreThanSix.test(vitesse)) {
			diminuerVitesse.updateVitesse();
		} else if (vitesseIsZero.test(vitesse)) {
			augmenterVitesse.updateVitesse();
		}
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

}
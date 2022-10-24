package br.com.levelup.model.Skills;

public enum SkillTypeStrongWeak {
    STRONG("Forte"), WEAK("Fraca");

    SkillTypeStrongWeak(String value) {
    }

    SkillTypeStrongWeak() {
    }

    @Override
    public String toString() {
        return "SkillTypeStrongWeak{" +
                STRONG.toString()+
                WEAK.toString()+
        " }";
    }
}

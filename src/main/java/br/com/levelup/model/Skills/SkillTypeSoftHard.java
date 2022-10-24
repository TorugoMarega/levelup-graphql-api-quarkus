package br.com.levelup.model.Skills;

public enum SkillTypeSoftHard {
    HARD("Hard"), SOFT("Soft");

    SkillTypeSoftHard(String value) {
    }

    SkillTypeSoftHard() {
    }

    @Override
    public String toString() {
        return "SkillTypeSoftHard{" +
                SOFT.toString()+
                HARD.toString()+
        " }";
    }
}

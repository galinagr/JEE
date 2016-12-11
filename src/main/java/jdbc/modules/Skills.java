package jdbc.modules;

public class Skills {

    private int skillId;
    private String skillDescr;

    @Override
    public String toString() {
        return "Skills{" +
                "skillId=" + skillId +
                ", skillDescr='" + skillDescr + '\'' +
                '}';
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillDescr() {
        return skillDescr;
    }

    public void setSkillDescr(String skillDescr) {
        this.skillDescr = skillDescr;
    }
}

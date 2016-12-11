package jdbc.modules;

public class Devskill {
    private int devskillId;
    private int devId;
    private int skillId;

    @Override
    public String toString() {
        return "Devskill{" +
                "devskillId=" + devskillId +
                ", devId=" + devId +
                ", skillId=" + skillId +
                '}';
    }

    public int getDevskillId() {
        return devskillId;
    }

    public void setDevskillId(int devskillId) {
        this.devskillId = devskillId;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}

package jdbc.dao;

import jdbc.modules.Skills;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SkillsDAO {
    @Transactional(propagation = Propagation.MANDATORY)
    void updateSkillsDescription(String skillDescr, int skillId);

    @Transactional(propagation = Propagation.MANDATORY)
    List<Skills> createSetAllSkills();
}

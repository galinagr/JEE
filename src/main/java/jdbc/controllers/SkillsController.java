package jdbc.controllers;

import jdbc.dao.BaseDAO;
import jdbc.dao.CompaniesDAOImpl;
import jdbc.dao.SQL_Queries;
import jdbc.dao.SkillsDAO;
import jdbc.modules.Skills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;
import java.util.List;

public class SkillsController {
    private PlatformTransactionManager txManager;
    private SkillsDAO skillsDAO;
    private BaseDAO baseDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompaniesDAOImpl.class);

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setSkillsDAO(SkillsDAO skillsDAO) {
        this.skillsDAO = skillsDAO;
    }

    public List<Skills> getAllSkills() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Skills> result = skillsDAO.createSetAllSkills();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException();
        }
    }

    @Transactional
    public int changeSkillDescription(String skillDescr, int skillId) {
        skillsDAO.updateSkillsDescription(skillDescr, skillId);
        return 1;
    }

    @Transactional
    public int updateElement(String descr, int skillId) throws SQLException {
        String sql = SQL_Queries.SQL_UPDATE_SKILLS_DESCR_BY_ID;
        return BaseDAO.changeRecord(skillId, sql, descr);
    }
}



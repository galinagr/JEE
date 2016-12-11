package jdbc.dao;

import jdbc.modules.Companies;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompaniesDAO {
    @Transactional(propagation = Propagation.MANDATORY)
    Companies selectCompaniesByName(String compName);

    @Transactional(propagation = Propagation.MANDATORY)
    List<Companies> createSetAllCompanies();
}

package jdbc.dao;

import jdbc.modules.Developers;

import java.util.List;

public interface DevelopersDAO {
    Developers selectDevelopersByID(int devId);

    List<Developers> createSetAllDevelopers();
}

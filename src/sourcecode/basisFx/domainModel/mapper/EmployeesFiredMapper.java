package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Employer;
import basisFx.domainModel.domaine.RatePerHour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesFiredMapper  extends DataMapper {


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        return false;
    }

    @Override
    public void getDomainList(ObservableList list) throws SQLException {

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) throws SQLException {

    }

    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {

    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {

    }

    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {

    }
}

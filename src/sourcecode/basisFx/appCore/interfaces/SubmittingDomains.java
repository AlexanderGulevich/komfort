package basisFx.appCore.interfaces;

import basisFx.domain.domaine.ActiveRecord;
import javafx.collections.ObservableList;

public interface SubmittingDomains {

    public ObservableList<ActiveRecord> submitList();
}

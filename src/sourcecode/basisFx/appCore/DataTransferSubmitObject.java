//package basisFx.appCore;
//
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.appCore.elements.DatePickerWrapper;
//import basisFx.appCore.elements.TableWrapper;
//import javafx.collections.ObservableList;
//
//import java.time.LocalDate;
//
//public class DataTransferSubmitObject {
//    KindOfSubmitElement mark;
//
//    private ObservableList<DomainObject> list;
//    private LocalDate localDate;
//
//
//    public DataTransferSubmitObject(Submitted submitted ) {
//
//        mark = submitted.getMark();
//
//        switch (mark){
//
//            case SubmitTable:
//                list=((TableWrapper) submitted).getItems();
//                break;
//
//            case SubmitRealField:
//                break;
//
//            case SubmitIntField:
//                break;
//
//            case SubmitTextField:
//                break;
//
//            case SubmitDatePicker:
//                localDate=((DatePickerWrapper) submitted).getLocalDate();
//                break;
//
//            default:
//                System.out.println("DataTransferSubmitObject.DataTransferSubmitObject  ---- no relevants");
//
//
//
//
//
//        }
//
//
//    }
//
//
//    public KindOfSubmitElement getMark() {
//        return mark;
//    }
//
//    public ObservableList<DomainObject> getItems() {
//        return list;
//    }
//
//    public LocalDate getLocalDate() {
//        return localDate;
//    }
//}

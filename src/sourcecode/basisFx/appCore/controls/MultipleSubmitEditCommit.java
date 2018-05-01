package basisFx.appCore.controls;

public class MultipleSubmitEditCommit <T,K> extends Edit<T,K> {


    public void run() {

        column.setOnEditCommit((event) -> {
            System.err.println("MultipleSubmitEditCommit.run");

            if (Checking.check(kindOfColumn, event)) {




            }
        });

    }



}




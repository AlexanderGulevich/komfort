package basisFx.appCore.controlPolicy;

public class MultipleSubmitEditCommit extends Edit {


    public void run() {

        column.setOnEditCommit((event) -> {
            System.err.println("MultipleSubmitEditCommit.run");
        });

    }



}




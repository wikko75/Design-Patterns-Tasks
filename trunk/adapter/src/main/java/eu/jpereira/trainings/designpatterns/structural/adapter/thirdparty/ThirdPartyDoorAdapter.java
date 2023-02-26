package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.SimpleDoor;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door{
    private String code = DEFAULT_CODE;
    private boolean open = false;

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        // try the code
        if (this.code.equals(code)) {
            this.open = true;
        } else {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public void close() {
        this.open = false;
    }

    @Override
    public boolean isOpen() {
        return this.open;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if (newCode.equals(newCodeConfirmation)) {
            if (oldCode.equals(this.code)) {
                this.code = newCode;
            } else {
                throw new IncorrectDoorCodeException();
            }
        } else {
            throw new CodeMismatchException();
        }
    }

    @Override
    public boolean testCode(String code) {
        return this.code.equals(code);
    }
}

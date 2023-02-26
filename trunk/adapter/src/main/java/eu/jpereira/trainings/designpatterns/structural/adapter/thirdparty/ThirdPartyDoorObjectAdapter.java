package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {
    private final ThirdPartyDoor thirdPartyDoor = new ThirdPartyDoor();

    @Override
    public void open(String code) throws CannotChangeStateOfLockedDoor, IncorrectDoorCodeException {
        try {
            thirdPartyDoor.unlock(code);

            if (thirdPartyDoor.getLockStatus().equals(ThirdPartyDoor.LockStatus.UNLOCKED)) {
                thirdPartyDoor.setState(ThirdPartyDoor.DoorState.OPEN);
            }
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public void close() throws CannotChangeStateOfLockedDoor {
        thirdPartyDoor.setState(ThirdPartyDoor.DoorState.CLOSED);
        thirdPartyDoor.lock();
    }

    @Override
    public boolean isOpen() {
        return thirdPartyDoor.getState().equals(ThirdPartyDoor.DoorState.OPEN);
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws CannotChangeCodeForUnlockedDoor, CodeMismatchException, IncorrectDoorCodeException {
        try {
            thirdPartyDoor.unlock(oldCode);
            if (thirdPartyDoor.getLockStatus().equals(ThirdPartyDoor.LockStatus.UNLOCKED) && newCodeConfirmation.equals(newCode)) {
                thirdPartyDoor.setNewLockCode(newCode);
            } else {
                throw new CodeMismatchException();
            }
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public boolean testCode(String code) throws CannotUnlockDoorException {
        thirdPartyDoor.unlock(code);
        return thirdPartyDoor.getLockStatus().equals(ThirdPartyDoor.LockStatus.UNLOCKED);
    }
}

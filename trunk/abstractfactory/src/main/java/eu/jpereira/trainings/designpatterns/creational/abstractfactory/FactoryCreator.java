package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public class FactoryCreator {

    public static AbstractFactory createFactory(String type) {
        if (type.equals("JSON")) {
            return new JSONFactory();
        } else if (type.equals("XML")) {
            return new XMLFactory();
        } else
        return null;
    }
}

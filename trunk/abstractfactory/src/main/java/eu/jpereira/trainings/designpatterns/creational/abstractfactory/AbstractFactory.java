package eu.jpereira.trainings.designpatterns.creational.abstractfactory;

public interface AbstractFactory {

    ReportBody createBody();

    ReportFooter createFooter();

    ReportHeader createHeader();
}

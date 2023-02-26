package eu.jpereira.trainings.designpatterns.creational.factorymethod;

public class ReportFactory implements FactoryInterface{

    @Override
    public Report createReport(String type) {

        Report generatedReport = null;

        switch (type) {
            case "JSON":
                generatedReport = new JSONReport();
                break;
            case "XML":
                generatedReport = new XMLReport();
                break;
            case "HTML":
                generatedReport = new HTMLReport();
                break;
            case "PDF":
                generatedReport = new PDFReport();
                break;
        }

        return generatedReport;
    }
}

//Definition: A class should have only one reason to change, i.e., it should only have one responsibility.

//Real-World Analogy: A printer should only print; maintenance and logging should be handled by other departments.

public class singleResponsibilityPrinciple {
    static void main() {
        Report report=new Report("Report of single responsibility principle");
        Reportprinter printer=new Reportprinter();
        printer.print(report);
    }

}
// responsibility to only generate report
class Report{
    private String content;
    Report(String content){
        this.content=content;
    }
    public String getContent() {
        return content;
    }
}
// responsibility to print report
class Reportprinter{
    public void print(Report report){
        System.out.println("Report Content:"+report.getContent());
    }
}

// this example clearly reflects that every class should have a single responsibity to help write clean and mantainable code to avoid confusion and reduce complexity.

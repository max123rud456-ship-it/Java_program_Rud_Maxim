import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        Document doc = new Document("Отчёт по продажам");
        Image img = new Image("logo.png");
        Report report = new Report("Годовой отчёт");

        doc.print();
        doc.save();
        doc.export("PDF");

        System.out.println();
        img.print();
        img.export("JPEG");

        System.out.println();
        report.save();
        report.export("XLSX");

        System.out.println("\n=== Всё, что можно печатать ===");
        List<Printable> printables = List.of(doc, img);
        for (Printable p : printables) {
            p.print();
        }

        System.out.println("\n=== Всё, что можно экспортировать ===");
        List<Exportable> exportables = List.of(doc, img, report);
        for (Exportable e : exportables) {
            e.export("PDF");
        }
    }
}

interface Printable {
    void print();
}

interface Savable {
    void save();
}

interface Exportable {
    void export(String format);
}

class Document implements Printable, Savable, Exportable {

    private String title;

    public Document(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Печать документа: " + title);
    }

    @Override
    public void save() {
        System.out.println("Документ '" + title + "' сохранён на диск.");
    }

    @Override
    public void export(String format) {
        System.out.println("Документ '" + title + "' экспортирован в формат " + format);
    }
}

class Image implements Printable, Exportable {

    private String fileName;

    public Image(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print() {
        System.out.println("Печать изображения: " + fileName);
    }

    @Override
    public void export(String format) {
        System.out.println("Изображение '" + fileName + "' экспортировано в формат " + format);
    }
}

class Report implements Savable, Exportable {

    private String name;

    public Report(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("Отчёт '" + name + "' сохранён в базе данных.");
    }

    @Override
    public void export(String format) {
        System.out.println("Отчёт '" + name + "' экспортирован в формат " + format);
    }
}

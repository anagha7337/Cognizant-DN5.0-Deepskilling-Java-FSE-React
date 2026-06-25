interface Document
{
    void open();
}

class WordDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document
{
    @Override
    public void open()
    {
        System.out.println("Opening Excel Document");
    }
}

abstract class DocumentFactory
{
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory
{
    @Override
    public Document createDocument()
    {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory
{
    @Override
    public Document createDocument()
    {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory
{
    @Override
    public Document createDocument()
    {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample
{
    public static void main(String[]args)
    {
        DocumentFactory factory;

        factory = new WordFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        factory = new PdfFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        factory = new ExcelFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}
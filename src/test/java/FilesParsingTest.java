import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilesParsingTest {
    ClassLoader cl = FilesParsingTest.class.getClassLoader();


    @Test
    void parsedCSVTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Documents.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();

                if (entryName.endsWith(".csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> csv = reader.readAll();
                    Assertions.assertArrayEquals(new String[]{"Артем", " devops"}, csv.get(2));
                    break;
                }
            }
        }
    }


    @Test
    void parsedXlsTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Documents.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();
                if (entryName.contains(".xls")) {
                    XLS xls = new XLS(zis);
                    assertEquals(("Правописание проверяемых безударных гласных в корне слова"), xls.excel.getSheetAt(0).getRow(9).getCell(4).toString());
                    assertEquals(("Код КЭС"), xls.excel.getSheetAt(0).getRow(2).getCell(3).toString());
                    return;
                }
            }
        }
    }


    @Test
    void parsedPdfTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Documents.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();
                if (entryName.endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertEquals(688, pdf.numberOfPages);
                    assertEquals("Основы Java", pdf.title);
                    assertEquals("Прохоренок Н. А.", pdf.author);
                    return;
                }
            }

        }
    }
}


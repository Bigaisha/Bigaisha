package gmail.bigaisha.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static org.assertj.core.api.Assertions.assertThat;


public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    @Test
    void parsPdfTest () throws  Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = Selenide.$(byText("PDF download")).download();
        PDF parsed = new PDF(pdfDownload);
        assertThat(parsed.author).contains("Marc Philip");
    }
//    @Test
//    void parsXlsTest () throws  Exception {
//        try (InputStream stream = cl.getResourceAsStream("files/unit.xlsx")) {
//            XLS parsed = new XLS(stream);
//            assertThat(parsed.excel.getSheetAt(0).getRow(5).getCell(1).getStringCellValue()).isEqualTo("Product Name");
//        }
//    }

    @Test
    void parseCsvFile () throws Exception {
        try (InputStream stream = cl.getResourceAsStream("files/example.csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(stream));
            List<String[]> List = reader.readAll();
            assertThat(List)
                    .hasSize(3)
                    .contains(
                            new String[] {"Author", "Book"},
                            new String[] {"Block", "Apteka"},
                            new String[] {"Esenin", "Chernyi Chelovek"}
                    );

        }
    }

    @Test
    void zipTest() throws Exception {
        try (InputStream stream = cl.getResourceAsStream("files/shantaram.zip");
            ZipInputStream zis = new ZipInputStream(stream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                assertThat(zipEntry.getName()).isEqualTo("shantaram/Roberts_Shantaram.epub");

            }
        }
        ZipFile zf = new ZipFile(new File(cl.getResource("files/shantaram.zip").toURI()));
    }
}

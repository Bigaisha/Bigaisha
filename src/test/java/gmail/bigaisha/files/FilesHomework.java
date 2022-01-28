package gmail.bigaisha.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;

public class FilesHomework {
    @Test
    void ZipFilesTest() throws Exception {
        ZipFile zipFile = new ZipFile("src\\test\\resources\\files\\zipFiles.zip");

        ZipEntry pdfEntry = zipFile.getEntry("greetings.pdf");
        try (InputStream stream = zipFile.getInputStream(pdfEntry)) {
            PDF pdfZip = new PDF(stream);
            assertThat(pdfZip.text).contains("Бигайша");
        }

        ZipEntry csvEntry = zipFile.getEntry("menu.csv");
        try (InputStream stream = zipFile.getInputStream(csvEntry)) {
            CSVReader reader = new CSVReader(new InputStreamReader(stream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(4)
                    .contains(
                            new String[]{"menu ;Wednesday"},
                            new String[]{"breakfast;eggs"},
                            new String[]{"launch;fish and chips"},
                            new String[]{"dinner;barbeque"}
                    );
            }
//        ZipEntry xlsEntry = zipFile.getEntry("staff.xlsx");
//        try (InputStream stream = zipFile.getInputStream(xlsEntry)) {
//            XLS parsed = new XLS(stream);
//            assertThat(parsed.excel.getSheetAt(0).getRow(7).getCell(1).getStringCellValue()).
//                    isEqualTo("14");
//        }
    }
}


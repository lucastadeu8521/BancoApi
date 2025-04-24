package agf.ntt.api.infra.carga;

import agf.ntt.api.domain.conta.Conta;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){

        return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Conta> getContaDataFromExcel(InputStream inputStream){
        List<Conta> contas = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("contas");

            int rowIndex = 0;
            for(Row row : sheet){
                if(rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Conta conta = new Conta();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> conta.setClienteID((long) cell.getNumericCellValue());
                        case 1 -> conta.setLogin(cell.getStringCellValue());
                        case 2 -> conta.setSenha(cell.getStringCellValue());
                        default -> {}
                    }
                    cellIndex++;
                }
                contas.add(conta);

            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return contas;
    }
}

package agf.ntt.api.infra.carga;

import agf.ntt.api.domain.conta.Conta;
import agf.ntt.api.domain.conta.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public void saveContaToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Conta> contas = ExcelUploadService.getContaDataFromExcel(file.getInputStream());
                this.contaRepository.saveAll(contas);
            } catch (IOException e) {
                throw new IllegalArgumentException("O arquivo nao corresponde a um excel valido");
            }
        }
    }

    public List<Conta> getContas(){
        return contaRepository.findAll();
    }
}

package frasesdoleandro.util;

import java.io.File;
import java.net.URL;

public class ArquivoUtil {

    public File obtemArquivo(String arquivo) {
        URL u = getClass().getClassLoader().getResource(arquivo);
        File f = new File(u.getFile());
        return f;
    }
}

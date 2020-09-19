package service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Caso;
import util.Utilidades;

public class CsvServiceImpl extends BaseServiceImpl {
	Path path;
	String RUTA;
	public CsvServiceImpl(String ruta) {
		this.RUTA=ruta;
		path=Paths.get(RUTA);
		if(!Files.exists(path)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public Stream<Caso> streamCaso() {
		try {
			return Files.lines(path,StandardCharsets.ISO_8859_1)
				//.map(s->Utilidades.stringToPedido(s));
					.map(Utilidades::stringToCaso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}

}

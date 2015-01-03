package util;

import java.text.ParseException;
import java.util.List;

import DAO.CompeticaoDAO;
import DAO.KaratecaDAO;
import entity.Competicao;
import entity.Karateca;

public class TestaCompeticao {
	public static void main(String[] args) throws ParseException {
		Competicao c = new Competicao();
		Karateca k  = new Karateca();
		c.setNomeEvento("CampeonatoAcreano");
		c.setOrganizador("FederaçãoBrasileira");
		c.setIdEvento(01);
		c.setData(null);
		c.setFase(null);
		k.setRgKarateca("arrs");
		k.setNome("iasds");
		CompeticaoDAO competicaoDAO = new CompeticaoDAO();
		competicaoDAO.inserirObjeto(c);
		KaratecaDAO karatecaDAO = new KaratecaDAO();
		karatecaDAO.inserirObjeto(k);
		List<Karateca> karatecas = karatecaDAO.listarKarateca();
		for(Karateca karateca : karatecas){
			System.out.println(karateca);
		}
		List<Competicao> competicoes = competicaoDAO.listarCompeticao();
		for (Competicao competicao : competicoes) {
			System.out.println(competicao);
		}
		

	}
}

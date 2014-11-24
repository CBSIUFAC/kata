package util;

import java.util.List;

import DAO.CompeticaoDAO;

import entity.Competicao;

public class TestaCompeticao {
	public static void main(String[] args) {
		Competicao c = new Competicao();
		c.setNomeEvento("CampeonatoAcreano");
		c.setOrganizador("FederaçãoBrasileira");
		c.setIdEvento(01);
		c.setData(null);
		c.setFase(null);		CompeticaoDAO competicaoDAO = new CompeticaoDAO();
		competicaoDAO.inserirObjeto(c);
		List<Competicao> competicoes = competicaoDAO.listarCompeticao();
		for (Competicao competicao : competicoes) {
			System.out.println(competicao.getNomeEvento());
		}
		

	}
}

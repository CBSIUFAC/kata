package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//Creditos da Devmedia.com.br manipulando datas
public class Utis {
	//Calcula a Idade baseado em java.util.Date
	public static int calculaIdade(Date dataNasc){
	Calendar dateOfBirth = new GregorianCalendar();
	dateOfBirth.setTime(dataNasc);
	// Cria um objeto calendar com a data atual
	Calendar today = Calendar.getInstance();
	// Obtém a idade baseado no ano
	int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
	dateOfBirth.add(Calendar.YEAR, age);
	//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
	if (today.before(dateOfBirth)) {
	age--;
	}
	return age;
	}
}

package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model.ErasmusData;
import com.opencsv.CSVReader;

/**
 * Classe responsabile del parsing del file csv
 *
 */
public class CsvParser 
{
	private String MetaData[];
	private List<ErasmusData> Data;
	
	/**
	 * Restituisce i metadata cosi come sono nominati nel dataset scaricato
	 * 
	 * @return		Un vettore di stringhe contenente i metadata
	 */
	public String[] getMetaData()
	{
		return MetaData;
	}
	
	/**
	 * Restituisce tutti i dati contenuti nel dataset
	 * 
	 * @return		Una lista di ErasmusData
	 */
	public List<ErasmusData> getData()
	{
		return Data;
	}
	
	/**
	 * Converte una stringa in un intero, gestendo anche le stringhe nulle
	 *
	 * @param  s    la stringa da convertire
	 * @return      l'intero corrispondente
	 */
	private static int StringToInt(String s)
	{
		int n=0;
		
		if (!s.isEmpty())
		{
			n=Integer.parseInt(s);
		}
		
		return n;
	}
	
	/**
	 * Converte una stringa in un carattere, gestendo anche le stringhe nulle
	 *
	 * @param  s    la stringa da convertire
	 * @return      il carattere corrispondente
	 */
	private static char StringToChar(String s)
	{
		char c=' ';
		
		if (!s.isEmpty())
		{
			c=s.charAt(0);
		}
		
		return c;
	}
	
	/**
	 * Converte le tringhe "Y" e "N" che possono comparire tra i valori 
	 * del dataset nei valori booleani true e false
	 *
	 * @param  s    la stringa da convertire
	 * @return      il valore booleano corrispondente
	 */
	private static boolean StringToBoolean(String s)
	{
		boolean b = true;
		
		if(s.equals("N"))
		{
			b=false;
		}
		
		return b;
	}
	
	/**
	 * Effettua il parsing riga per riga di tutti i record del dataset
	 *
	 * @return Una lista di oggetti MetaData corrispondenti a tutti gli elementi del dataset
	 */
	@SuppressWarnings("deprecation")
	public CsvParser(String fileName) throws IOException 
	{
		//crea un oggetto CSVReader, responsabile della lettura e del parsing del dataset
		CSVReader reader = new CSVReader(new FileReader(fileName), ';');
		
		Data = new ArrayList<ErasmusData>();
		String[] record = null;
		
		//la prima riga contiene i nomi dei campi del dataset (i sourcefield)
		MetaData = reader.readNext();
		
		while((record = reader.readNext()) != null)
		{
			ErasmusData ED = new ErasmusData(
					record[0],
					record[1],
					StringToInt(record[2]),
					StringToChar(record[3]),
					record[4],
					record[5],
					record[6],
					StringToInt(record[7]),
					StringToChar(record[8]),
					record[9],
					record[10],
					record[11],
					record[12],
					StringToChar(record[13]),
					StringToChar(record[14]),
					Double.parseDouble(record[15]),
					Double.parseDouble(record[16]),
					StringToChar(record[17]),
					record[18],
					record[19],
					record[20],
					StringToInt(record[21]),
					StringToInt(record[22]),
					StringToInt(record[23]),
					Double.parseDouble(record[24]),
					StringToBoolean(record[25]),
					record[26],
					record[27],
					Double.parseDouble(record[28]),
					Double.parseDouble(record[29]),
					StringToChar(record[30]),
					record[31]);
			
					Data.add(ED);
		}
		
		reader.close();
	}

}
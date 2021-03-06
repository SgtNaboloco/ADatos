package ej10.prueba4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TreeSet;




public class Datos {
	
	private static File Datos = new File(
			"D:\\Google Drive\\CLASE\\2DAM\\Acceso a datos\\Ejercicios\\10. GraficaError\\DatEnfrentados.txt");
	private BufferedReader in;
	private String linea, cabezera;
	private TreeSet<Hora> horas = new TreeSet<Hora>();
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);
	protected String[] date = null;
	private String[] temp = null;
	private String[] precip = null;
	private String[] WindVel = null;
	protected String[] WindDir = null;
	protected float[] tempF = null;
	protected float[] precipF = null;
	protected float[] windVelF = null;
	private int contPuntosX;
	private int nPoints;
	private String dateStr = "", tempStr = "", precipStr = "", windVelStr = "", windDirStr = "";
	int tama�oTempF = 0;
	
	
	public void crearArrays() {

		date = dateStr.split(",");
		temp = tempStr.split(",");
		precip = precipStr.split(",");
		WindVel = windVelStr.split(",");
		WindDir = windDirStr.split(",");
		
		
		int cont=0;
		tempF = new float[temp.length];
		for (int i = 0; i < temp.length; i++) {
			tempF[i] = Float.parseFloat(temp[i]);
			cont++;
		}
		tama�oTempF = cont;
		
		
		
		precipF = new float[precip.length];
		for (int i = 0; i < precip.length; i++) {
			precipF[i] = Float.parseFloat(precip[i]);
		}
		windVelF = new float[WindVel.length];
		for (int i = 0; i < WindVel.length; i++) {
			windVelF[i] = Float.parseFloat(WindVel[i]);
		}

	}

	public void separarDatos() {
		// TODO Auto-generated method stub
		int contador = 0;
		for (Hora o : horas) {
			if (contador == 0) {
				dateStr += o.format.format(o.getDate());
				tempStr += o.getTemp();
				precipStr += o.getPrecip();
				windVelStr += o.getWindVel();
				windDirStr += o.getWindDir();
			} else {
				dateStr += "," + o.format.format(o.getDate());
				tempStr += "," + o.getTemp();
				precipStr += "," + o.getPrecip();
				windVelStr += "," + o.getWindVel();
				windDirStr += "," + o.getWindDir();
			}

			contador++;

		}
		 System.out.println(dateStr + "\n" + tempStr + "\n" + precipStr + "\n" +
		 windVelStr + "\n" + windDirStr + "\n");

	}

	public void totalPuntosTreeSet() {
		int n = 0;
		for (Hora datos : horas) {
			n++;
		}
		// System.out.println(n);
		nPoints = n;
	}

	public void EntradaDatos(File fichero) {

		// APERTURA
		try {
			in = new BufferedReader(new FileReader(fichero));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TRATADO DE DATOS
		try {
			cabezera = in.readLine();

			linea = in.readLine();
			while (linea != null) {

				Hora h = new Hora(linea.split(","));
				horas.add(h);

				linea = in.readLine();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// CIERRE
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static File getDatos() {
		return Datos;
	}

	public BufferedReader getIn() {
		return in;
	}

	public String getLinea() {
		return linea;
	}

	public String getCabezera() {
		return cabezera;
	}

	public TreeSet<Hora> getHoras() {
		return horas;
	}

	public DateFormat getFormat() {
		return format;
	}

	public String[] getDate() {
		return date;
	}

	public String[] getTemp() {
		return temp;
	}

	public String[] getPrecip() {
		return precip;
	}

	public String[] getWindVel() {
		return WindVel;
	}

	public String[] getWindDir() {
		return WindDir;
	}

	public float[] getTempF() {
		return tempF;
	}

	public float[] getPrecipF() {
		return precipF;
	}

	public float[] getWindVelF() {
		return windVelF;
	}

	public int getContPuntosX() {
		return contPuntosX;
	}

	public int getnPoints() {
		return nPoints;
	}

	public String getDateStr() {
		return dateStr;
	}

	public String getTempStr() {
		return tempStr;
	}

	public String getPrecipStr() {
		return precipStr;
	}

	public String getWindVelStr() {
		return windVelStr;
	}

	public String getWindDirStr() {
		return windDirStr;
	}

	public int getTama�oTempF() {
		return tama�oTempF;
	}

	public static void setDatos(File datos) {
		Datos = datos;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public void setCabezera(String cabezera) {
		this.cabezera = cabezera;
	}

	public void setHoras(TreeSet<Hora> horas) {
		this.horas = horas;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}

	public void setDate(String[] date) {
		this.date = date;
	}

	public void setTemp(String[] temp) {
		this.temp = temp;
	}

	public void setPrecip(String[] precip) {
		this.precip = precip;
	}

	public void setWindVel(String[] windVel) {
		WindVel = windVel;
	}

	public void setWindDir(String[] windDir) {
		WindDir = windDir;
	}

	public void setTempF(float[] tempF) {
		this.tempF = tempF;
	}

	public void setPrecipF(float[] precipF) {
		this.precipF = precipF;
	}

	public void setWindVelF(float[] windVelF) {
		this.windVelF = windVelF;
	}

	public void setContPuntosX(int contPuntosX) {
		this.contPuntosX = contPuntosX;
	}

	public void setnPoints(int nPoints) {
		this.nPoints = nPoints;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public void setTempStr(String tempStr) {
		this.tempStr = tempStr;
	}

	public void setPrecipStr(String precipStr) {
		this.precipStr = precipStr;
	}

	public void setWindVelStr(String windVelStr) {
		this.windVelStr = windVelStr;
	}

	public void setWindDirStr(String windDirStr) {
		this.windDirStr = windDirStr;
	}

	public void setTama�oTempF(int tama�oTempF) {
		this.tama�oTempF = tama�oTempF;
	}
}

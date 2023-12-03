package com.raven.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SettingModel {
	private String ngonNgu;
	private String phongCach;
	/**
	 * @return the ngonNgu
	 */
	public String getNgonNgu() {
		return ngonNgu;
	}
	/**
	 * @return the phongCach
	 */
	public String getPhongCach() {
		return phongCach;
	}
	/**
	 * @param ngonNgu the ngonNgu to set
	 */
	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}
	/**
	 * @param phongCach the phongCach to set
	 */
	public void setPhongCach(String phongCach) {
		this.phongCach = phongCach;
	}
	public SettingModel(String ngonNgu, String phongCach) {
		setNgonNgu(ngonNgu);
		setPhongCach(phongCach);
	}
	public SettingModel() {
		this("Vietnamese","BrightWhite");
	}
	public void readFileToSet(String model) {
		String[] modelSplit = model.split(" ");
		setNgonNgu(modelSplit[0]);
		setPhongCach(modelSplit[1]);
	}
	
	@Override
	public String toString() {
		return ngonNgu + " " + phongCach;
	}

	private static String fileName = "src/main/java/com/raven/model/SettingModel.txt";
	public void writeTo() throws IOException{
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)),true);
			out.println(toString());
			
		} finally {
				System.out.println("Write xong:"+toString());
				if(out!= null) out.close();
		}
	}
	public void readFrom() throws IOException {
		Scanner in = null;
		try {
			in = new Scanner(new BufferedInputStream(new FileInputStream(fileName)));
			String line = null;
			while(in.hasNextLine()) {
				line = in.nextLine();
				String[] object = line.split(" ");
				readFileToSet(line);
				System.out.print("Đọc được: "+line);
			}
		}catch (Exception e) {
			// TODO: handle exception
			writeTo();
		} finally {
			System.out.println("Read xong!");
			if(in!=null) in.close();
		}
	}
	public static void main(String[] args) {
		SettingModel model = new SettingModel();
		try {
			
			model.writeTo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;

public class DataAccessObject {

	public MLogin getLogin(String userId) {
		try {
			Scanner scanner = new Scanner(new File("userInfo/UserId"));
			MLogin mLogin = new MLogin(scanner, userId);
			while (scanner.hasNext()) {
				boolean found = mLogin.read();
				if (found) {
					scanner.close();
					return mLogin;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MUser getUser(String userId) {
		try {
			Scanner scanner = new Scanner(new File("userInfo/" + userId));
			MUser mUser = new MUser(scanner, userId);
			while (scanner.hasNext()) {
				boolean found = mUser.read();
				if (found) {
					scanner.close();
					return mUser;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vector<MDirectory> getDirectories(String fileName) {
		Vector<MDirectory> mDirectories = new Vector<MDirectory>();
		try {
			Scanner scanner = new Scanner(new File("data/" + fileName));
			while (scanner.hasNext()) {
				MDirectory mDirectory = new MDirectory(scanner);
				mDirectory.read();
				mDirectories.add(mDirectory);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mDirectories;
	}

	public Vector<MGangjwa> getGangjwas(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		try {
			Scanner scanner = new Scanner(new File("data/" + fileName));
			while (scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mGangjwas;
	}

	// ¿˙¿Â 
	public void saveResults(String fileName, Vector<VGangjwa> vGangjwas) {
	try {
		
		PrintWriter printWriter = new PrintWriter(new File("userInfo/"+ fileName));
		
		for(VGangjwa vGangjwa : vGangjwas) {
			MGangjwa mGangjwa = new MGangjwa(printWriter, vGangjwa);
			mGangjwa.save();
		}
		printWriter.close();
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}

	public Vector<MGangjwa> getResults(String fileName) {
		Vector<MGangjwa> mGangjwas = new Vector<MGangjwa>();
		try {
			Scanner scanner = new Scanner(new File("userInfo/"+ fileName));
			while (scanner.hasNext()) {
				MGangjwa mGangjwa = new MGangjwa(scanner);
				mGangjwa.read();
				mGangjwas.add(mGangjwa);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mGangjwas;
	}
}

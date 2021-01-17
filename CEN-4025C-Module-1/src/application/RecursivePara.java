package application;

import java.io.File;
/**
 * 
 * @author Jancarlo Sevilla
 *
 */
public class RecursivePara {

	private static File fileStr;
	private static File[] filesArr;
	private static File file;
	private static int temp = 0;
/**
 * getFileStr originally was meant to get string to pass between FileChoose and RecursivePara to perform the recursion
 * instead opting in for file passing
 * @return
 */
	//setters and getters to pass file param from FileChoose class
	public static File getFileStr() {
		return fileStr;
	}

	public static void setFileStr(File fileStr) {
		RecursivePara.fileStr = fileStr;
	}

	//recursiveFile passes string and int 
	//string is used to acquire file path
	// the subindex int is used for indentations purposes
	public static void recursiveFile(String pass, int subIndex) {
		file = new File(pass);
		filesArr = file.listFiles();
		long totalFiles = file.listFiles().length;

		// Arrays.sort(filesArr);
		if (temp != 1) {
			System.out
					.println("---------- MAIN DIRECTORY " + pass + " FILES " + "TOTAL " + totalFiles + "----------\n");
			temp++;
		}

		// System.out.println("test");

		for (File e : filesArr) {
			for (int i = 0; i < subIndex; i++) {
				System.out.print("\t");
			}
			if (e.isFile()) {
				System.out.println("[" + e.getName() + "]");
			} else if (e.isDirectory()) {
				file = new File(e.getPath());
				totalFiles = file.listFiles().length;
				System.out.println(">> TOTAL FILES " + totalFiles + ": " + e.getAbsolutePath());
				recursiveFile(e.getAbsolutePath(), subIndex + 1);
			}
		}
	}

}

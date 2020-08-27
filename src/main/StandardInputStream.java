package main;

import java.io.IOException;
import java.io.InputStream;

public class StandardInputStream extends InputStream {

	private StringBuilder sb = new StringBuilder();
	// 改行コードの種類を環境から取得
    private String lf = System.getProperty("line.separator");
//	private String lf = System.lineSeparator();

    /**
     * 文字列を入力する。改行は自動的に行う
     * @param str 入力文字列
     */
    public void inputln(String str){
        sb.append(str).append(lf);
    }

	@Override
	public int read() throws IOException {
		if (sb.length() == 0) return -1;
        int result = sb.charAt(0);
        sb.deleteCharAt(0);
        return result;
	}

}

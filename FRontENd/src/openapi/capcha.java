/**
 * 
 */
package openapi;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Map;

/**
 * <pre>
 *  test
 *       |_ capcha
 *
 * 1. 媛쒖슂  :
 * 2. �옉�꽦�씪  :  2017. 6. 23.
 * </pre>
 *
 * @author : tjrcj
 * @version : 1.0
 */

@SuppressWarnings("restriction")
public class capcha implements apikey {

	private static final String clientId = CAPCHA_ID;
	private static final String clientSecret = CAPCHA_PW;

//	public static String getKey() throws Exception {
//		try {
//			String code = "0";
//			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
//			URL url = new URL(apiURL);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.setRequestProperty("X-Naver-Client-Id", clientId);
//			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//			int responseCode = con.getResponseCode();
//			BufferedReader br;
//			if (responseCode == 200) { // �젙�긽 �샇異�
//				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			} else { // �뿉�윭 諛쒖깮
//				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//			}
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//			while ((inputLine = br.readLine()) != null) {
//				response.append(inputLine);
//			}
//			br.close();
//			// PARSING �옉�뾽
//			@SuppressWarnings("unchecked")
//		//	Map<String, String> map = new ObjectMapper().readValue(response.toString(), Map.class);
//			Map<String, String> map = new ObjectMapper().readValue(response.toString(), Map.class)
//			
//			return map.get("key");
//		} catch (Exception e) {
//			throw e;
////		}
//	}

	public static String getImg(String key) {
		String tempname=null;
		try {
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", CAPCHA_ID);
			con.setRequestProperty("X-Naver-Client-Secret", CAPCHA_PW);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// 랜덤한 이름으로 파일 생성C:\Users\tjrcj\workspace\FRontENd\WebContent\capcha
				tempname = Long.valueOf(new Date().getTime()).toString();
				File f = new File("C:/Users/tjrcj/workspace/FRontENd/WebContent/capcha/"+ tempname + ".jpg");
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
				return tempname;
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return tempname;
	}

//	public static boolean auth(String key, String value) throws Exception {
//		try {
//			String code = "1"; // �궎 諛쒓툒�떆 0, 罹≪감 �씠誘몄� 鍮꾧탳�떆 1濡� �꽭�똿
//			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value="
//					+ value;
//
//			URL url = new URL(apiURL);
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.setRequestProperty("X-Naver-Client-Id", clientId);
//			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//			int responseCode = con.getResponseCode();
//			BufferedReader br;
//			if (responseCode == 200) { // �젙�긽 �샇異�
//				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			} else { // �뿉�윭 諛쒖깮
//				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//			}
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//			while ((inputLine = br.readLine()) != null) {
//				response.append(inputLine);
//			}
//			br.close();
//			// PARSING�옉�뾽
//			@SuppressWarnings("unchecked")
////			Map<String, Object> map = new ObjectMapper().readValue(response.toString(), Map.class);
//			return (boolean) map.get("result");
//		} catch (Exception e) {
//			throw e;
//		}
//	}
}

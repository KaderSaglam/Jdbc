package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
		
		//1)ilgili driver i yuklemeliyiz (tvnin fisini tak yani baska alet calismasın ne calisacagini bilsin)
		
		Class.forName("com.mysql.cj.jdbc.Driver");//  bu kırmizi cizince ClassNotFoundException yapti
		
		
		
		//2)baglanti olusturmaliyiz(uydu sifrelerini girmeliyiz) =sifreleri isme atadik 
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		
		//3) SQL komutlari icin bir Statement nesnesi olustur yani alan ac(her kanal icin kumandada yer ayarlamak)
		
	Statement st   =  con.createStatement(); // daha guzel gozuksun diye con degiskenine atadik
	
	//SQL ifadeleri yazabilir ve calistirabiliriz(kumandadan 1 e basarim trt1 gelir)
	
	ResultSet veri =st.executeQuery("SELECT isim, maas FROM personel WHERE id=123456789"); // suan ali yilmazi cagirdim
	
	//5)sonuclari aldik ve isledik (suan geldi yazdirmamiz kaldi tek)
	
	while(veri.next()) {
		System.out.println(veri.getString("isim") + veri.getInt("maas")  );
		
		System.out.println("Personel Adi: "+veri.getString(1)+ veri.getInt(2));
	}
	
	//6)olusturulan nesneleri bellekten kaldiralim
	
	con.close();
	st.close();
	veri.close();
		
		
		
		
		

	}

}

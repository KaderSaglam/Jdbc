package techproed.jdbcOrnekler;

import java.sql.*;


public class Jdbc1Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		
		
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	
	Statement st   =  con.createStatement(); //baglantimizi yaptik
	
	/*=======================================================================
//	 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
//	========================================================================*/ 
	ResultSet tablo= st.executeQuery("SELECT * FROM bolumler"); // bolumler tablosunu buraya getirdi bu bir sonuc kumesi biseye atiyacaz
	
while (tablo.next()) {
	System.out.println(tablo.getInt(1)+" "+ tablo.getString("bolum_isim")+" "+tablo.getString(3));// Tablonun 1. sutununu getir
	
}
System.out.println("=====================================");



///*=======================================================================
//ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
// maaslarini, maas ters sirali olarak listeleyiniz
//========================================================================*/ 

ResultSet tablo2 = st.executeQuery("SELECT isim, maas FROM personel "
		+ " WHERE bolum_id in(10,30)"
		+"ORDER BY maas DESC" ); // geldi ama while icinde dondurmem gerekli

while (tablo2.next()) {
	System.out.println(tablo2.getString(1)+"\t"+tablo2.getInt(2));// 2 yazarak maasi kasteddim 
	
}



System.out.println("=====================================");
///*=======================================================================
//  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
//  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
//  bile bolum ismi gosterilmelidir.
//========================================================================*/ 


ResultSet tablo3=st.executeQuery( "select b.bolum_isim, p.isim, p.maas from bolumler b left join personel p"
        + " on p.bolum_id=b.bolum_id "
        + " Order by b.bolum_isim, p.maas");


while (tablo3.next()) {
	System.out.println(tablo3.getString(1)+ "\t"+ tablo3.getString(2)+"\t"+tablo3.getInt(3));
	
}
System.out.println("=====================================");
/*=======================================================================
//ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
//========================================================================*/ 

ResultSet tablo4=st.executeQuery( "select b.bolum_isim, p.isim, p.maas from personel p left join bolumler b"
        + " on p.bolum_id=b.bolum_id "
        + " Order by maas DESC "
        + " limit 10");


while (tablo4.next()) {
	System.out.println(tablo4.getString(1)+ " "+ tablo4.getString(2)+" "+tablo4.getInt(3));
	
}
/*
con.close();
st.close();
tablo.close();
tablo2.close();
tablo3.close();
tablo4.close();
*/
	}

}

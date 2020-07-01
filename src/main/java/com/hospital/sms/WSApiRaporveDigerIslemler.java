package com.hospital.sms;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 *
 * @author user
 */
public class WSApiRaporveDigerIslemler {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
                String KULNO="";
                String KULAD="";
                String KULSIFRE="";

                String Adres= "http://panel.vatansms.com/webservis/service.php";

                System.out.println("SMS ID'ye GORE RAPOR ALMA:");
                String ozelkod="",numararapor=""; // numara boş bırakılırsa özelkod'a ait tüm raporlar çekilir
        String RaporSorgula="<?xml version='1.0' encoding='utf-8'?>"+
                                        "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                        "<soap:Body>"+
                                        "<RaporSorgula xmlns='"+Adres+"'>"+
                                        "<kullanicino>"+KULNO+"</kullanicino>"+
                                        "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                        "<sifre>"+KULSIFRE+"</sifre>"+
                                        "<ozelid>"+ozelkod+"</ozelid>"+
                                        "<numara>"+numararapor+"</numara>"+
                                        "</RaporSorgula>"+
                                        "</soap:Body>"+
                                        "</soap:Envelope>";
        System.out.println(WSApiRaporveDigerIslemler.POST(Adres, RaporSorgula));

                   System.out.println("TARIHE GORE RAPOR ALMA:");
                   String tarih="2014-04-22";
                   String GunlukRaporSorgula="<?xml version='1.0' encoding='utf-8'?>"+
                                "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                "<soap:Body>"+
                                "<GunlukRaporSorgula xmlns='"+Adres+"'>"+
                                "<kullanicino>"+KULNO+"</kullanicino>"+
                                "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                "<sifre>"+KULSIFRE+"</sifre>"+
                                "<tarih>"+tarih+"</tarih>"+
                                "</GunlukRaporSorgula>"+
                                "</soap:Body>"+
                                "</soap:Envelope>";
                   System.out.println(WSApiRaporveDigerIslemler.POST(Adres, GunlukRaporSorgula));

                   System.out.println("ÜYE ve BAKİYE SORGULAMA:");
                   String UyeBilgisiSorgula="<?xml version='1.0' encoding='utf-8'?>"+
                                "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                "<soap:Body>"+
                                "<UyeBilgisiSorgula xmlns='"+Adres+"'>"+
                                "<kullanicino>"+KULNO+"</kullanicino>"+
                                "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                "<sifre>"+KULSIFRE+"</sifre>"+
                                "</UyeBilgisiSorgula>"+
                                "</soap:Body>"+
                                "</soap:Envelope>";
                   System.out.println(WSApiRaporveDigerIslemler.POST(Adres, UyeBilgisiSorgula));

                   System.out.println("ORJINATOR OLUSTURMA:");
                   String Orji="",Aciklama="";
                   String OrjinatorGonder="<?xml version='1.0' encoding='utf-8'?>"+
                                "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                "<soap:Body>"+
                                "<OrjinatorGonder xmlns='"+Adres+"'>"+
                                "<kullanicino>"+KULNO+"</kullanicino>"+
                                "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                "<sifre>"+KULSIFRE+"</sifre>"+
                                "<orjinator>"+Orji+"</orjinator>"+
                                "<aciklama>"+Aciklama+"</aciklama>"+
                                "</OrjinatorGonder>"+
                                "</soap:Body>"+
                                "</soap:Envelope>";
                   System.out.println(WSApiRaporveDigerIslemler.POST(Adres, OrjinatorGonder));

                   System.out.println("ORJINATORlERI CEKME ve SORGULAMA:");
                   String Orji1=""; //Boş bırakırsanız orjinatörlerin tümünü çeker
                   String OrjinatorSorgula="<?xml version='1.0' encoding='utf-8'?>"+
                                "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                "<soap:Body>"+
                                "<OrjinatorSorgula xmlns='"+Adres+"'>"+
                                "<kullanicino>"+KULNO+"</kullanicino>"+
                                "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                "<sifre>"+KULSIFRE+"</sifre>"+
                                "<orjinator>"+Orji1+"</orjinator>"+
                                "</OrjinatorSorgula>"+
                                "</soap:Body>"+
                                "</soap:Envelope>";
                   System.out.println(WSApiRaporveDigerIslemler.POST(Adres, OrjinatorSorgula));
    }
    public static String POST( String _Adres, String _Xml) throws Exception
         {
                 HttpClient client = new DefaultHttpClient();
                 try
                 {
                         HttpPost post = new HttpPost(_Adres);
                         post.setHeader( "Content-type", "text/xml; charset=utf-8" );
                         post.setEntity( new StringEntity(_Xml));
                         HttpResponse response = client.execute( post );
                         HttpEntity entity = response.getEntity();
                         if ( entity != null ) {
                                 String cevap=  EntityUtils.toString( entity );
                                   cevap= cevap.split("<return xsi:type=\"xsd:string\">")[1];
                                   return cevap.split("</return>")[0];
                         }
                         return null;
                 }
                 catch ( IOException ex )
                 {
                         System.out.println(ex);
                         throw new RuntimeException( ex );
                 }
                 finally
                 {
                         client.getConnectionManager().shutdown();
                 }
        }
}
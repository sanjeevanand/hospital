package com.hospital.sms;
import java.io.IOException;

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
public class WSApiNN {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
    	String KULNO="39148";
    	String KULAD="905375539099";
    	String KULSIFRE="99ThsO90";
    	String ORJINATOR="SMS TEST";
                String ZAMAN="";                   //İleri tarih için kullanabilirsiniz. 2014-04-21 10:00:00
                String ZAMANASIMI="";        //Sms ömrünü belirtir. 2014-04-21 15:00:00
                String TIP="Normal";          //Normal yada Turkce
                String NumaraMesaj="{8505907927}"; //9661101213{[numara][mesaj]} Mesajlarınızı PDF'deki gibi kodlu göndermenizi öneririz.

                String Adres= "http://panel.vatansms.com/webservis/service.php";

        String HerBirNumarayaFarkliSmsGonder="<?xml version='1.0' encoding='utf-8'?>"+
                                        "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                        "<soap:Body>"+
                                        "<HerBirNumarayaFarkliSmsGonder xmlns='"+Adres+"'>"+
                                        "<kullanicino>"+KULNO+"</kullanicino>"+
                                        "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                        "<sifre>"+KULSIFRE+"</sifre>"+
                                        "<orjinator>"+ORJINATOR+"</orjinator>"+
                                        "<numaramesaj>"+NumaraMesaj+"</numaramesaj>"+
                                        "<zaman>"+ZAMAN+"</zaman>"+
                                        "<zamanasimi>"+ZAMANASIMI+"</zamanasimi>"+
                                        "<tip>"+TIP+"</tip>"+
                                        "</HerBirNumarayaFarkliSmsGonder>"+
                                        "</soap:Body>"+
                                        "</soap:Envelope>";
       System.out.println(WSApiNN.POST(Adres, HerBirNumarayaFarkliSmsGonder));
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
                         org.apache.http.HttpEntity entity = response.getEntity();
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
     public static String sendSms(String mobile,String otp) throws Exception {
    	 String KULNO="39148";
 	String KULAD="905375539099";
 	String KULSIFRE="99ThsO90";
 	String ORJINATOR="Your otp is "+otp;
             String ZAMAN="";                   //İleri tarih için kullanabilirsiniz. 2014-04-21 10:00:00
             String ZAMANASIMI="";        //Sms ömrünü belirtir. 2014-04-21 15:00:00
             String TIP="Normal";          //Normal yada Turkce
             String NumaraMesaj="{"+mobile+"}"; // 8505907927 9661101213{[numara][mesaj]} Mesajlarınızı PDF'deki gibi kodlu göndermenizi öneririz.

             String Adres= "http://panel.vatansms.com/webservis/service.php";

     String HerBirNumarayaFarkliSmsGonder="<?xml version='1.0' encoding='utf-8'?>"+
                                     "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                     "<soap:Body>"+
                                     "<HerBirNumarayaFarkliSmsGonder xmlns='"+Adres+"'>"+
                                     "<kullanicino>"+KULNO+"</kullanicino>"+
                                     "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                     "<sifre>"+KULSIFRE+"</sifre>"+
                                     "<orjinator>"+ORJINATOR+"</orjinator>"+
                                     "<numaramesaj>"+NumaraMesaj+"</numaramesaj>"+
                                     "<zaman>"+ZAMAN+"</zaman>"+
                                     "<zamanasimi>"+ZAMANASIMI+"</zamanasimi>"+
                                     "<tip>"+TIP+"</tip>"+
                                     "</HerBirNumarayaFarkliSmsGonder>"+
                                     "</soap:Body>"+
                                     "</soap:Envelope>";
     String str = WSApiNN.POST(Adres, HerBirNumarayaFarkliSmsGonder);
    System.out.println(str);
    return str;
 }
 
}
//JAVA - WEBSERVIS - MEMBER INFORMATION AND REPORTING PROCEDURES


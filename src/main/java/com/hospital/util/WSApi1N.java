package com.hospital.util;
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
public class WSApi1N {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String KULNO="39148";
                String KULAD="905375539099";
                String KULSIFRE="99ThsO90";
                String ORJINATOR="SMS TEST";
                String ZAMAN="2014-04-21 10:00:00";                   //İleri tarih için kullanabilirsiniz. 2014-04-21 10:00:00
                String ZAMANASIMI="2014-04-21 10:00:00";        //Sms ömrünü belirtir. 2014-04-21 15:00:00
                String TIP="Normal";          //Normal OR Turkce

                String Numaralar="5111112233,5345187128,919661101213";
                String Mesaj="Deneme mesajidir";

                String Adres= "http://www.oztekbayi.com/webservis/service.php?wsdl";

        String TekSmsiBirdenCokNumarayaGonder="<?xml version='1.0' encoding='utf-8'?>"+
                                        "<soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>"+
                                        "<soap:Body>"+
                                        "<TekSmsiBirdenCokNumarayaGonder xmlns='"+Adres+"'>"+
                                        "<kullanicino>"+KULNO+"</kullanicino>"+
                                        "<kullaniciadi>"+KULAD+"</kullaniciadi>"+
                                        "<sifre>"+KULSIFRE+"</sifre>"+
                                        "<orjinator>"+ORJINATOR+"</orjinator>"+
                                        "<numaralar>"+Numaralar+"</numaralar>"+
                                        "<mesaj>"+Mesaj+"</mesaj>"+
                                        "<zaman>"+ZAMAN+"</zaman>"+
                                        "<zamanasimi>"+ZAMANASIMI+"</zamanasimi>"+
                                        "<tip>"+TIP+"</tip>"+
                                        "</TekSmsiBirdenCokNumarayaGonder>"+
                                        "</soap:Body>"+
                                        "</soap:Envelope>";
       System.out.println(WSApi1N.POST(Adres, TekSmsiBirdenCokNumarayaGonder));
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
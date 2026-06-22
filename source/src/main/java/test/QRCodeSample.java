package test;

import java.io.File;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeSample {

   public static void main(String[] args) {
       String text = "https://dojo-teraco.seplus.jp/";
       String filePath = "src/main/webapp/qr/qrcode.png";
       int width = 300;
       int height = 300;

       try {
           // QRコード生成
           BitMatrix matrix = new MultiFormatWriter().encode(
                   text,
                   BarcodeFormat.QR_CODE,
                   width,
                   height
           );

           // 画像として保存
           Path path = new File(filePath).toPath();
           MatrixToImageWriter.writeToPath(matrix, "PNG", path);

           System.out.println("QRコード生成成功: " + filePath);

       } catch (WriterException | java.io.IOException e) {
           e.printStackTrace();
       }
   }
}

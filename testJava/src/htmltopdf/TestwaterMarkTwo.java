package htmltopdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;

/**
 * Created by meridian on 2019/3/20.
 */
public class TestwaterMarkTwo {
    private static int interval = -5;
    public static void setWaterMarkForPDF(String sourceFilePath, String fileWaterMarkPath) throws Exception {
        PdfReader reader = new PdfReader(sourceFilePath);
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(fileWaterMarkPath));
        int total = reader.getNumberOfPages() + 1;

        PdfContentByte content;
        Image img = Image.getInstance("D:/phone/happy-agnes-icon.png");
        //自定义大小
        img.scaleAbsolute(100,100);
        img.setAbsolutePosition(30, 100);
        for (int i = 1; i < total; i++) {
            // 在内容上方加水印
            content = stamp.getOverContent(i);
            content.addImage(img);
        }
        stamp.close();
        reader.close();
    }
    public static void main(String[] args) {
        try {
            setWaterMarkForPDF("D:/phone/retrievePwd1.pdf", "D:/phone/shuiyin21.pdf");
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

package htmltopdf;

import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.awt.*;
import java.io.FileOutputStream;

import javax.swing.*;

/**
 * Created by meridian on 2019/3/19.
 */
public class TestwaterMark {
    private static int interval = -5;
    public static void waterMark(String inputFile,
                                 String outputFile, String waterMarkName) {
        try {
            PdfReader reader = new PdfReader(inputFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                    outputFile));

            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",   BaseFont.EMBEDDED);

            Rectangle pageRect = null;
            PdfGState gs = new PdfGState();
            // 设置透明度为0.3
            gs.setFillOpacity(0.3f);
            gs.setStrokeOpacity(0.4f);
            int total = reader.getNumberOfPages() + 1;

            JLabel label = new JLabel();
            FontMetrics metrics;
            int textH = 0;
            int textW = 0;
            label.setText(waterMarkName);
            metrics = label.getFontMetrics(label.getFont());
            textH = metrics.getHeight();
            textW = metrics.stringWidth(label.getText());

            Image img = Image.getInstance("D:/phone/happy-agnes-icon.png");
            //自定义大小
            img.scaleAbsolute(120,160);
            img.setAbsolutePosition(250, 350);

            PdfContentByte under;
            for (int i = 1; i < total; i++) {
                pageRect = reader.getPageSizeWithRotation(i);
                under = stamper.getOverContent(i);
                under.saveState();
                under.setGState(gs);
                under.beginText();
                under.setFontAndSize(base, 20);
               // under.showTextAligned(Element.ALIGN_CENTER, waterMarkName,400,420, 45);
                // 水印文字成30度角倾斜
                //你可以随心所欲的改你自己想要的角度
                for (int height = interval + textH; height < pageRect.getHeight();
                     height = height + textH*10) {
                    for (int width = interval + textW; width < pageRect.getWidth() + textW;
                         width = width + textW*5) {
                        under.showTextAligned(Element.ALIGN_CENTER, waterMarkName, width- textW,height- textH, 30);
                    }
                }
                // 添加水印文字
                under.endText();
                // 在内容上方加水印
                under.addImage(img);
            }
            //说三遍
            //一定不要忘记关闭流
            //一定不要忘记关闭流
            //一定不要忘记关闭流
            stamper.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        waterMark("D:/phone/retrievePwd1.pdf", "D:/phone/shuiyin3.pdf", "经纶世纪");

    }
}

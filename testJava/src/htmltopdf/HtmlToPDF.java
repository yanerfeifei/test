package htmltopdf;

import java.io.File;

import htmltopdf.linux.HtmlToPdfInterceptor;

/**
 * Created by meridian on 2019/3/15.
 */
public class HtmlToPDF {
    //wkhtmltopdf安装路径
    public static final String toPdfTool = "D:/wkhtmltox/bin/wkhtmltopdf.exe";


    public static void convert(String pageSize,String srcPath, String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        if (!parent.exists()){
            parent.mkdirs();
        }
        /*StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool).append(" ");
        cmd.append("--page-size ");
        cmd.append(pageSize).append(" ");
        cmd.append(srcPath).append(" ");
        cmd.append(destPath);
        try {
            Runtime.getRuntime().exec(cmd.toString());
        }catch (IOException e){
            e.printStackTrace();
        }*/
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--page-size A4 ");
        //cmd.append("--margin-top 100mm ");
        //cmd.append("--margin-left 100mm ");
        //cmd.append(pageSize);
        cmd.append(" ");
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);

        boolean result = true;
        try{
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
            error.start();
            output.start();
            proc.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        //设置纸张大小: A4, Letter, etc.
        String pageSize = "A4";
        //需要生成PDF的URL，这样也可以是页面的本地地址
        String srcPath = "D:/phone/retrievePwd.html";
        //String srcPath = "D:/index.html";
        //生成后存放路径
        String destPath = "D:/phone/retrievePwd1.pdf";
        //给pdf添加水印
        convert(null, srcPath, destPath);
    }
}

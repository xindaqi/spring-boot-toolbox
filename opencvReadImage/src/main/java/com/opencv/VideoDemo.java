package com.opencv;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
public class VideoDemo {

    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        System.out.println("List: "+array);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = new Mat();
        image = Imgcodecs.imread("/home/xdq/xinPrj/java/opencvTwo/images/DVI_dis.png");
        int img_rows = image.rows();
        int img_colums = image.cols();
        int img_channels = image.channels();
        System.out.println("image mat: " + image+"\n");
        System.out.println("image rows: "+image.rows()+"\n");
        System.out.println("image column: "+image.cols()+"\n");
        System.out.println("image channels: "+image.channels()+"\n");
        System.out.println("image value: "+image.get(0, 0).length+"\n");

        for(int i=0;i<img_channels;i++) {
            for(int j=0;j<img_rows;j++){
                for(int k=0; k<img_colums;k++){
                    array.add(image.get(j,k)[i]);
//                    System.out.println("img value: "+image.get(j,k)[i]);
                }
            }
            System.out.println("image value: "+array+"\n");
            array.clear();
        }

        // 打开摄像头或者视频文件
//        VideoCapture capture = new VideoCapture(0);
//        capture.open(0);
////        capture.open("D:/vcprojects/images/768x576.avi");
//        if(!capture.isOpened()) {
//            System.out.println("could not load video data...");
//            return;
//        }
//        int frame_width = (int)capture.get(3);
//        int frame_height = (int)capture.get(4);
//        ImageGUI gui = new ImageGUI();
//        gui.createWin("OpenCV + Java视频读与播放演示", new Dimension(frame_width, frame_height));
//        Mat frame = new Mat();
//        while(true) {
//            boolean have = capture.read(frame);
//            System.out.println("image Matrix: "+frame);
//            System.out.println("image value: "+frame.dump());
//            Core.flip(frame, frame, 1);// Win上摄像头
//            if(!have) break;
//            if(!frame.empty()) {
//
//                gui.imshow(conver2Image(frame));
//                gui.repaint();
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static BufferedImage conver2Image(Mat mat) {
//        int width = mat.cols();
//        int height = mat.rows();
//        int dims = mat.channels();
//        int[] pixels = new int[width*height];
//        byte[] rgbdata = new byte[width*height*dims];
//        mat.get(0, 0, rgbdata);
//        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
//        int index = 0;
//        int r=0, g=0, b=0;
//        for(int row=0; row<height; row++) {
//            for(int col=0; col<width; col++) {
//                if(dims == 3) {
//                    index = row*width*dims + col*dims;
//                    b = rgbdata[index]&0xff;
//                    g = rgbdata[index+1]&0xff;
//                    r = rgbdata[index+2]&0xff;
//                    pixels[row*width+col] = ((255&0xff)<<24) | ((r&0xff)<<16) | ((g&0xff)<<8) | b&0xff;
//                }
//                if(dims == 1) {
//                    index = row*width + col;
//                    b = rgbdata[index]&0xff;
//                    pixels[row*width+col] = ((255&0xff)<<24) | ((b&0xff)<<16) | ((b&0xff)<<8) | b&0xff;
//                }
//            }
//        }
//        setRGB( image, 0, 0, width, height, pixels);
//        return image;
//    }
//
//    /**
//     * A convenience method for setting ARGB pixels in an image. This tries to avoid the performance
//     * penalty of BufferedImage.setRGB unmanaging the image.
//     */
//    public static void setRGB( BufferedImage image, int x, int y, int width, int height, int[] pixels ) {
//        int type = image.getType();
//        if ( type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB )
//            image.getRaster().setDataElements( x, y, width, height, pixels );
//        else
//            image.setRGB( x, y, width, height, pixels, 0, width );
//    }

    }
}

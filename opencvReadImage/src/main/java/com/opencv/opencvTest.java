//package com.opencv;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfPoint;
//import org.opencv.core.Point;
//import org.opencv.core.Scalar;
////import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.videoio.VideoCapture;
////import org.opencv.
//
//
//public class opencvTest {
//
//    MatOfPoint corners=new MatOfPoint();
//
//    static {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }
//
//    public static void main(String[] args) {
//        opencvTest corner=new opencvTest();
//        corner.corners();
//    }
//
//
//    private void corners() {
//        // 1 创建 VideoCapture 对象
//        VideoCapture capture=new VideoCapture();
//        // 2 使用 VideoCapture 对象读取本地视频
////        capture.open("C:\\Users\\hyacinth\\Videos\\111.mp4");
//        capture.open(0);
//        // 3 获取视频处理时的键盘输入 我这里是为了在 视频处理时如果按 Esc 退出视频对象跟踪
//        int index=0;
//
//        Mat video=new Mat();
//        Mat gray=new Mat();
//
//        int maxCorners=5000;
//        double qualityLevel=0.01;
//        int minDistance=10;
//        int blockSize=3;
//        int gradientSize=5;
//        double k=0.04;
//
//        while (capture.read(video)) {
//            Imgproc.cvtColor(video, gray, Imgproc.COLOR_BGR2GRAY);
//
//
////            Imgproc.goodFeaturesToTrack(gray, corners, maxCorners, qualityLevel, minDistance, new Mat(), blockSize, gradientSize, false, k);
//
////            drawCorners(video,corners);
//
//
//            System.out.println("Image: "+Imgcodecs.imread("/home/xdq/xinPrj/java/opencvTwo/images/DVI_dis.png"));
////            HighGui.imshow("角点检测", video);
////            index=HighGui.waitKey(1);
////            if (index==27) {
////                capture.release();
////                return;
////            }
//        }
//
//    }
//
//
//
//
//}
//

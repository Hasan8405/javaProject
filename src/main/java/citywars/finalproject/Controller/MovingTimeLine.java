package citywars.finalproject.Controller;//package citywars.finalproject.Controller;//package citywars.finalproject.Controller;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Platform;
//import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;
//
//public class MovingTimeLine {
//
//    private static final int PAUSE_DURATION = 1000; // milliseconds
//    private static final int STOP_COUNT = 17; // تعداد مستطیل هایی که نوار بعد از آن متوقف شود
//    private final Rectangle bar;
//    private final int rectCount;
//    private final int rectWidth;
//    private final int spacing;
//    private Timeline timeline;
//    private int passedRectangles = 0;
//
//    public MovingTimeLine(Rectangle bar, int rectCount, int rectWidth, int spacing) {
//        this.bar = bar;
//        this.rectCount = rectCount;
//        this.rectWidth = rectWidth;
//        this.spacing = spacing;
//        initialize();
//    }
//
//    private void initialize() {
//        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
//            double barX = bar.getX();
//            bar.setX(barX + 1);
//
//            for (int i = 0; i < rectCount; i++) {
//                double rectStartX = i * (rectWidth + spacing);
//
//                if (barX >= rectStartX && barX < rectStartX + 1) {
//                    passedRectangles++;
//                    System.out.println("سلام");
//
//                    if (passedRectangles == STOP_COUNT) {
//                        timeline.stop();
//                        return;
//                    }
//
//                    timeline.pause();
//                    new Thread(() -> {
//                        try {
//                            Thread.sleep(PAUSE_DURATION);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Platform.runLater(timeline::play);
//                    }).start();
//                    break;
//                }
//            }
//
//            if (barX >= rectCount * rectWidth) {
//                bar.setX(0); // Restart from the beginning
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//    }
//
//    public void start() {
//        timeline.play();
//    }
//
//    public void stop() {
//        timeline.stop();
//    }
//}



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;
import java.util.function.Consumer;

public class MovingTimeLine extends TwoPlayerGame{
    private static final int PAUSE_DURATION = 1000; // milliseconds
    private static final int STOP_COUNT = 18; // تعداد مستطیل هایی که نوار بعد از آن متوقف شود
    private final Rectangle bar;
    private final int rectCount;
    private final int rectWidth;
    private final int spacing;
    private  ProgressBar progressBar;
    private Timeline timeline;
    public static int passedRectangles = 0;

    private Random random = new Random();
    private Consumer<Integer> onRectanglePass;

    public MovingTimeLine(Rectangle bar, int rectCount, int rectWidth, int spacing, ProgressBar progressBar) {
        this.bar = bar;
        this.rectCount = rectCount;
        this.rectWidth = rectWidth;
        this.spacing = spacing;
        this.progressBar=progressBar;
        initialize();
    }
    public void setOnRectanglePass(Consumer<Integer> onRectanglePass) {
        this.onRectanglePass = onRectanglePass;
    }
    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            double barX = bar.getX();
            bar.setX(barX + 1);

            for (int i = 0; i < rectCount; i++) {
                double rectStartX = i * (rectWidth + spacing);

                if (barX >= rectStartX && barX < rectStartX + 1) {
                    passedRectangles++;
//                    System.out.println("سلام");
                    /////////////////////////////////////
                    if (onRectanglePass != null) {
                        onRectanglePass.accept(i);
                    }
                    ///////////////////////////////////

//                    if (random.nextInt(3) == 0) {
//                        createProgressBar(progressBar);
//                    }
//                    else if (random.nextInt(3) == 1||random.nextInt(3)==2) {
//                        progressBar.setOpacity(0);
//                    }
                    createProgressBar(progressBar,i);
                    progressBar.setLayoutX(barX);
                    progressBar.setLayoutY(80);

                    ///////////////////////////////////
                    if (passedRectangles == STOP_COUNT) {
                        timeline.stop();
                        return;
                    }

                    timeline.pause();
                    new Thread(() -> {
                        try {
                            Thread.sleep(PAUSE_DURATION);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Platform.runLater(timeline::play);
                    }).start();
                    break;
                }
            }

            if (barX >= rectCount * rectWidth) {
                bar.setX(0); // Restart from the beginning
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private double createProgressBar(ProgressBar progressBar,int i) {
        progressBar.setOpacity(0);
        if (TwoPlayerGame.attack[0][i]>TwoPlayerGame.attack[1][i]) {
            progressBar.setOpacity(1);
        }
        if (TwoPlayerGame.attack[0][i]<TwoPlayerGame.attack[1][i]) {
            progressBar.setOpacity(1);
        }
        Timeline progressTimeline = new Timeline(new KeyFrame(Duration.millis(250), event -> {
            double progress = random.nextDouble();
            progressBar.setProgress(progress);
        }));
        progressTimeline.setCycleCount(Timeline.INDEFINITE);
        progressTimeline.play();

        progressBar.setOnMouseClicked(event -> {
            System.out.println("Random value: " + progressBar.getProgress());
        });
        return 0;
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}

//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Platform;
//import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;
//
//import java.util.function.Consumer;
//
//public class MovingTimeLine {
//
//    private static final int PAUSE_DURATION = 1000; // milliseconds
//    private static final int STOP_COUNT = 13; // تعداد مستطیل هایی که نوار بعد از آن متوقف شود
//    private final Rectangle bar;
//    private final int rectCount;
//    private final int rectWidth;
//    private final int spacing;
//    private Timeline timeline;
//    private int passedRectangles = 0;
//    private Consumer<Integer> onRectanglePass;
//
//    public MovingTimeLine(Rectangle bar, int rectCount, int rectWidth, int spacing) {
//        this.bar = bar;
//        this.rectCount = rectCount;
//        this.rectWidth = rectWidth;
//        this.spacing = spacing;
//        initialize();
//    }
//
//    public void setOnRectanglePass(Consumer<Integer> onRectanglePass) {
//        this.onRectanglePass = onRectanglePass;
//    }
//
//    private void initialize() {
//        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
//            double barX = bar.getX();
//            bar.setX(barX + 1);
//
//            for (int i = 0; i < rectCount; i++) {
//                double rectStartX = i * (rectWidth + spacing);
//
//                if (barX >= rectStartX && barX < rectStartX + 1) {
//                    passedRectangles++;
//                    if (onRectanglePass != null) {
//                        onRectanglePass.accept(i);
//                    }
//
//                    if (passedRectangles == STOP_COUNT) {
//                        timeline.stop();
//                        return;
//                    }
//
//                    timeline.pause();
//                    new Thread(() -> {
//                        try {
//                            Thread.sleep(PAUSE_DURATION);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Platform.runLater(timeline::play);
//                    }).start();
//                    break;
//                }
//            }
//
//            if (barX >= rectCount * rectWidth) {
//                bar.setX(0); // Restart from the beginning
//            }
//        }));
//        timeline.setCycleCount(Timeline.INDEFINITE);
//    }
//
//    public void start() {
//        timeline.play();
//    }
//
//    public void stop() {
//        timeline.stop();
//    }
//}

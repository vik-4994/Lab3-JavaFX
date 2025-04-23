package org.example.lab3_javafx;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SmileyApp extends Application {


    @Override
    public void start(Stage stage) {
        Group root = new Group();

        Circle head = new Circle(300, 200, 100);
        head.setFill(new RadialGradient(
                0, 0,
                300, 200,
                100,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.YELLOW),
                new Stop(1, Color.GOLD)
        ));

        Ellipse leftEyeWhite = new Ellipse(260, 170, 20, 30);
        Ellipse rightEyeWhite = new Ellipse(340, 170, 20, 30);
        leftEyeWhite.setFill(Color.WHITE);
        rightEyeWhite.setFill(Color.WHITE);

        Circle leftPupil = new Circle(260, 180, 10, Color.BLACK);
        Circle rightPupil = new Circle(340, 180, 10, Color.BLACK);

        Circle leftIris = new Circle(260, 180, 13, Color.DEEPSKYBLUE);
        Circle rightIris = new Circle(340, 180, 13, Color.DEEPSKYBLUE);

        Circle leftShine = new Circle(265, 175, 3, Color.LIGHTBLUE);
        Circle rightShine = new Circle(345, 175, 3, Color.LIGHTBLUE);

        Path mouth = new Path();
        mouth.setFill(Color.BLACK);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(2);

        MoveTo start1 = new MoveTo(240, 230);
        QuadCurveTo topCurve = new QuadCurveTo(300, 280, 360, 230);
        QuadCurveTo bottomCurve = new QuadCurveTo(300, 245, 240, 230);
        ClosePath close = new ClosePath();

        mouth.getElements().addAll(start1, topCurve, bottomCurve, close);

        Path teeth = new Path();
        teeth.setFill(Color.WHITE);
        teeth.setStroke(Color.BLACK);
        teeth.setStrokeWidth(1);

        MoveTo tStart = new MoveTo(240, 230);
        QuadCurveTo tTop = new QuadCurveTo(300, 260, 360, 230);
        QuadCurveTo tBottom = new QuadCurveTo(300, 240, 240, 230);
        ClosePath tClose = new ClosePath();

        teeth.getElements().addAll(tStart, tTop, tBottom, tClose);


        Arc leftBrow = new Arc(260, 145, 20, 10, 0, 180);
        Arc rightBrow = new Arc(340, 145, 20, 10, 0, 180);
        leftBrow.setType(ArcType.OPEN);
        rightBrow.setType(ArcType.OPEN);
        leftBrow.setStroke(Color.BLACK);
        rightBrow.setStroke(Color.BLACK);
        leftBrow.setStrokeWidth(3);
        rightBrow.setStrokeWidth(3);
        leftBrow.setFill(Color.TRANSPARENT);
        rightBrow.setFill(Color.TRANSPARENT);

        Group smiley = new Group(
                head,
                leftEyeWhite, rightEyeWhite,
                leftIris, rightIris,
                leftPupil, rightPupil,
                leftShine, rightShine,
                mouth, teeth,
                leftBrow, rightBrow
        );

        root.getChildren().add(smiley);

        TranslateTransition move = new TranslateTransition(javafx.util.Duration.seconds(2), smiley);
        move.setByX(100);
        move.setAutoReverse(true);
        move.setCycleCount(TranslateTransition.INDEFINITE);

        RotateTransition rotate = new RotateTransition(javafx.util.Duration.seconds(4), smiley);
        rotate.setByAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE);

        ScaleTransition scale = new ScaleTransition(javafx.util.Duration.seconds(2), smiley);
        scale.setToX(1.5);
        scale.setToY(1.5);
        scale.setAutoReverse(true);
        scale.setCycleCount(ScaleTransition.INDEFINITE);

        ParallelTransition animation = new ParallelTransition(move, rotate, scale);
        animation.play();

        Scene scene = new Scene(root, 600, 400, Color.LIGHTGRAY);
        stage.setTitle("Smiley Face - Lab 3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

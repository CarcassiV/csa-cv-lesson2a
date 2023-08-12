package com.codedotorg;

import java.util.Arrays;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuessingGame {

    /** The primary stage of the game */
    private Stage window;

    /** The width of the stage */
    private int width;

    /** The height of the stage */
    private int height;

    /** The label displaying the computer's guess */
    private Label computerGuessLabel;

    /** The logic for making guesses in the game */
    private GameLogic logic;

    /**
     * Constructor for the GuessingGame class.
     * 
     * @param primaryStage the primary stage of the game
     * @param width the width of the game window
     * @param height the height of the game window
     */
    public GuessingGame(Stage primaryStage, int width, int height) {
        this.window = primaryStage;
        window.setTitle("Guessing Game");

        this.width = width;
        this.height = height;

        computerGuessLabel = new Label(""); 
        logic = new GameLogic();       
    }
    
    /**
     * Starts the guessing game by creating the main layout, creating
     * the main scene with the layout, setting the scene to the window
     * and showing the window.
     */
    public void startGame() {
        VBox mainLayout = createLayout();

        Scene mainScene = createMainScene(mainLayout);

        setSceneAndShow(mainScene);
    }

    /**
     * Sets the current scene and shows the window.
     * 
     * @param currentScene the scene to be set and shown
     */
    public void setSceneAndShow(Scene currentScene) {
        window.setScene(currentScene);
        window.show();
    }

    /**
     * Sets the text of the computerGuessLabel based on the result of the guess.
     * If the guess is correct, the label will display the correct number and the
     * number of guesses it took to get it. If the guess is incorrect, the label
     * will display the current guess.
     * 
     * @param result a boolean indicating whether the guess was correct or not
     */
    public void setComputerGuessLabel(boolean result) {
        if (result) {
            computerGuessLabel.setText("I guessed the correct number " + logic.getGuess() + " in " + logic.getNumGuesses() + " guesses.");
        }
        else {
            computerGuessLabel.setText("My guess is " + logic.getGuess());
        }
    }

    /**
     * Creates the main scene for the guessing game.
     * 
     * @param layout the layout of the scene
     * @return the main scene for the guessing game
     */
    public Scene createMainScene(VBox layout) {
        Scene tempScene = new Scene(layout, width, height);
        return tempScene;
    }

    /**
     * Creates a VBox layout for the guessing game scene.
     * 
     * @return the VBox layout containing the scene labels and buttons
     */
    public VBox createLayout() {
        VBox tempLayout = new VBox();

        List<Node> labelsList = createSceneLabels();
        List<Node> buttonsList = createSceneButtons();

        tempLayout.getChildren().addAll(labelsList);
        tempLayout.getChildren().addAll(buttonsList);

        return tempLayout;
    }

    /**
     * Creates a list of scene labels for the guessing game.
     * The list includes a prompt label and a computer guess label.
     * 
     * @return A list of Node objects representing the scene labels.
     */
    public List<Node> createSceneLabels() {
        Label promptLabel = new Label("Think of a number between 1-100.");
        
        setComputerGuessLabel(false);

        List<Node> labelsList = Arrays.asList(promptLabel, computerGuessLabel);

        return labelsList;
    }

    /**
     * Creates and returns a list of three buttons for the guessing game
     * scene: "Higher", "Lower", and "Correct". Sets the button actions
     * for each button using the setButtonActions method.
     * 
     * @return a list of three buttons for the guessing game scene
     */
    public List<Node> createSceneButtons() {
        Button higherButton = new Button("Higher");
        Button lowerButton = new Button("Lower");
        Button correctButton = new Button("Correct");

        List<Node> buttonsList = Arrays.asList(higherButton, lowerButton, correctButton);

        setButtonActions(buttonsList);

        return buttonsList;
    }

    /**
     * Disables a list of JavaFX buttons.
     * 
     * @param buttonsList the list of buttons to be disabled
     */
    public void disableButtons(List<Node> buttonsList) {
        for (Node button : buttonsList) {
            button.setDisable(true);
        }
    }

    /**
     * Sets the actions for a list of buttons. If the button text is "Higher",
     * the guessHigher() method of the logic object is called and the computer
     * guess label is updated. If the button text is "Lower", the guessLower()
     * method of the logic object is called and the computer guess label is updated.
     * If the button text is "Correct", the computer guess label is updated and all
     * buttons in the list are disabled.
     * 
     * @param buttonsList the list of buttons to set actions for
     */
    public void setButtonActions(List<Node> buttonsList) {
        for (Node item : buttonsList) {
            Button currentButton = (Button) item;

            currentButton.setOnAction(event -> {
                if (currentButton.getText().equals("Higher")) {
                    logic.guessHigher();
                    setComputerGuessLabel(false);
                }
                else if (currentButton.getText().equals("Lower")) {
                    logic.guessLower();
                    setComputerGuessLabel(false);
                }
                else if (currentButton.getText().equals("Correct")) {
                    setComputerGuessLabel(true);
                    disableButtons(buttonsList);
                }
            });
        }
    }

}

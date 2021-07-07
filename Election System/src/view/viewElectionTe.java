package view;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import listners.ElectionUIEventsListener;
import model.Party.espectrum;

public class viewElectionTe implements AbstracEletionView, Serializable {
	private Vector<ElectionUIEventsListener> allListeners = new Vector<ElectionUIEventsListener>();

	// YESNO
	private Label titleYN = new Label("Welcome");
	private Label lblYN = new Label("Do You Want To Read Data From File?");

	private Button yesButton = new Button("Yes");
	private Button noButton = new Button("No");

	private HBox hboxyesButton = new HBox(5, yesButton, noButton);
	private VBox vboxyesButton = new VBox(5, titleYN, lblYN, hboxyesButton);

	private Scene scenesYESNO = new Scene(vboxyesButton);

	// dateScreen

	private Label titleDate = new Label("Please Select Date of Foundation");

	private DatePicker dp = new DatePicker();

	private Button nextButtonDate = new Button("Next");

	private VBox containerDate = new VBox(20, titleDate, dp, nextButtonDate);
	private Scene scenesPickDate = new Scene(containerDate);

	// main
	private Button btnAddCitizen = new Button("Add Citizen");
	private Button btnAddBallotBox = new Button("Add Ballot Box");
	private Button btnAddCandidate = new Button("Add Candidate");
	private Button btnAddParty = new Button("Add Party");
	private Button btnViewCitizensList = new Button("View Citizens List");
	private Button btnViewBallotBoxList = new Button("View Ballot Box List");
	private Button btnViewPartiesList = new Button("View Parties List");
	private Button btnDoElection = new Button("Election");
	private Button btnViewElectionResult = new Button("View Election Result");

	private HBox rowOne = new HBox(btnAddCitizen, btnAddBallotBox, btnAddParty);
	private HBox rowTwo = new HBox(btnAddCandidate, btnViewCitizensList, btnViewBallotBoxList);
	private HBox rowThree = new HBox(btnViewPartiesList, btnDoElection, btnViewElectionResult);

	private VBox rootPane = new VBox(rowOne, rowTwo, rowThree);

	private Scene sceneMenu = new Scene(rootPane);

	// addCitizen

	private Label titleCitizen = new Label("Add Citizen");
	private Label nameLabelCitizen = new Label("Name: ");
	private Label birthYearLabelCitizen = new Label("Birth Year: ");
	private Label idLabelCitizen = new Label("ID Number: ");
	private Label inIsolationLabelCitizen = new Label("Is he in isolation? ");
	private Label citizenTypeLabelCitizen = new Label("Citizen Type:");
	private Label daysOfSicknessLabelCitizen = new Label("Days of Sickness");

	private TextField nameFieldCitizen = new TextField();
	private TextField birthYearFieldCitizen = new TextField();
	private TextField idFieldCitizen = new TextField();
	private TextField daysOfSicknessFieldCitizen = new TextField();

	private RadioButton yesRadioCitizen = new RadioButton("Yes");
	private RadioButton noRadioCitizen = new RadioButton("No");

	private ToggleGroup inIsolationTGCitizen = new ToggleGroup();

	private RadioButton citizenRadioCitizen = new RadioButton("Citizen");
	private RadioButton covidRadioCitizen = new RadioButton("Covid-19 People");
	private RadioButton soldierRadioCitizen = new RadioButton("Soldier");

	private ToggleGroup civilianTypeTGCitizen = new ToggleGroup();

	private Button saveButtonCitizen = new Button("Save");
	private Button cancelButtonCitizen = new Button("Cancel");

	private HBox nameBoxCitizen = new HBox(5, nameLabelCitizen, nameFieldCitizen);
	private HBox birtYearBoxCitizen = new HBox(5, birthYearLabelCitizen, birthYearFieldCitizen);
	private HBox idBoxCitizen = new HBox(5, idLabelCitizen, idFieldCitizen);
	private HBox inIsolationBoxCitizen = new HBox(5, inIsolationLabelCitizen, yesRadioCitizen, noRadioCitizen);
	private HBox citizenTypeBoxCitizen = new HBox(5, citizenTypeLabelCitizen, citizenRadioCitizen, covidRadioCitizen,
			soldierRadioCitizen);
	private HBox daysOfSicknessBoxCitizen = new HBox(5, daysOfSicknessLabelCitizen, daysOfSicknessFieldCitizen);
	private HBox buttonBoxCitizen = new HBox(5, saveButtonCitizen, cancelButtonCitizen);

	private VBox containerCitizen = new VBox(5, titleCitizen, nameBoxCitizen, birtYearBoxCitizen, idBoxCitizen,
			inIsolationBoxCitizen, citizenTypeBoxCitizen, daysOfSicknessBoxCitizen, buttonBoxCitizen);

	private Scene scenesAddCitizen = new Scene(containerCitizen);

	// addBalltBox

	private Label titleBallotBox = new Label("Add Ballot Box");

	private Label cityNameLabelBallotBox = new Label("City Name: ");
	private Label streetNameLabelBallotBox = new Label("Street Name: ");
	private Label streetNumberLabelBallotBox = new Label("Street Number: ");
	private Label ballotTypeLabelBallotBox = new Label("Type of BallotBox ");

	private TextField cityNameFieldBallotBox = new TextField();
	private TextField streetNameFieldBallotBox = new TextField();
	private TextField streetNumberFieldBallotBox = new TextField();

	private RadioButton regularRadioBallotBox = new RadioButton("Regular");
	private RadioButton covidPeopleRadioBallotBox = new RadioButton("Covid-19 People");
	private RadioButton soldierRadioBallotBox = new RadioButton("Soldier");
	private RadioButton covidSoldierRadioBallotBox = new RadioButton("Covid-19 Soldier");

	private ToggleGroup ballotTypeTGBallotBox = new ToggleGroup();

	private Button saveButtonBallotBox = new Button("Save");
	private Button cancelButtonBallotBox = new Button("Cancel");

	private HBox cityNameBoxBallotBox = new HBox(5, cityNameLabelBallotBox, cityNameFieldBallotBox);
	private HBox streetNameBoxBallotBox = new HBox(5, streetNameLabelBallotBox, streetNameFieldBallotBox);
	private HBox streetNumberBoxBallotBox = new HBox(5, streetNumberLabelBallotBox, streetNumberFieldBallotBox);
	private HBox civilianBoxBallotBox = new HBox(5, regularRadioBallotBox, covidPeopleRadioBallotBox);
	private HBox soldierBoxBallotBox = new HBox(5, soldierRadioBallotBox, covidSoldierRadioBallotBox);
	private VBox citizensBoxBallotBox = new VBox(5, civilianBoxBallotBox, soldierBoxBallotBox);
	private HBox ballotTypeBoxBallotBox = new HBox(5, ballotTypeLabelBallotBox, citizensBoxBallotBox);

	private HBox buttonBoxBallotBox = new HBox(5, saveButtonBallotBox, cancelButtonBallotBox);

	private VBox containerBallotBox = new VBox(5, titleBallotBox, cityNameBoxBallotBox, streetNameBoxBallotBox,
			streetNumberBoxBallotBox, ballotTypeBoxBallotBox, buttonBoxBallotBox);

	private Scene scenesBallotBox = new Scene(containerBallotBox);

	// addCanditae

	private Label titleCandidate = new Label("Add Candidate");

	private Label nameLabelCandidate = new Label("Name: ");
	private Label birthYearLabelCandidate = new Label("Birth Year: ");
	private Label idLabelCandidate = new Label("ID Number: ");
	private Label inIsolationLabelCandidate = new Label("Is he in isolation? ");
	private Label partyNameLabelCandidate = new Label("Party Name: ");

	private TextField nameFieldCandidate = new TextField();
	private TextField birthYearFieldCandidate = new TextField();
	private TextField idFieldCandidate = new TextField();
	private TextField partyNameFieldCandidate = new TextField();

	private RadioButton yesRadioCandidate = new RadioButton("Yes");
	private RadioButton noRadioCandidate = new RadioButton("No");

	private ToggleGroup inIsolationTGCandidate = new ToggleGroup();

	private Button saveButtonCandidate = new Button("Save");
	private Button cancelButtonCandidate = new Button("Cancel");

	private HBox nameBoxCandidate = new HBox(5, nameLabelCandidate, nameFieldCandidate);
	private HBox birtYearBoxCandidate = new HBox(5, birthYearLabelCandidate, birthYearFieldCandidate);
	private HBox idBoxCandidate = new HBox(5, idLabelCandidate, idFieldCandidate);
	private HBox inIsolationBoxCandidate = new HBox(5, inIsolationLabelCandidate, yesRadioCandidate, noRadioCandidate);
	private HBox partyNameBoxCandidate = new HBox(5, partyNameLabelCandidate, partyNameFieldCandidate);
	private HBox buttonBoxCandidate = new HBox(5, saveButtonCandidate, cancelButtonCandidate);

	private VBox containerCandidate = new VBox(5, titleCandidate, nameBoxCandidate, birtYearBoxCandidate,
			idBoxCandidate, inIsolationBoxCandidate, partyNameBoxCandidate, buttonBoxCandidate);

	private Scene scenesCandidate = new Scene(containerCandidate);

	// AddPatry

	private Label titleAddParty = new Label("Add Party");

	private Label partyNameLabelAddParty = new Label("Party Name: ");
	private Label foundationDateLabelAddParty = new Label("Date Of Foundation: ");
	private Label politicalOpinionLabelAddParty = new Label("Political Opinion: ");

	private TextField partyNameFieldAddParty = new TextField();

	private RadioButton leftRadioAddParty = new RadioButton("Left");
	private RadioButton centerRadioAddParty = new RadioButton("Center");
	private RadioButton rightRadioAddParty = new RadioButton("Right");

	private ToggleGroup opinionTGAddParty = new ToggleGroup();

	private DatePicker dpAddParty = new DatePicker();

	private Button saveButtonAddParty = new Button("Save");
	private Button cancelButtonAddParty = new Button("Cancel");

	private HBox partyNameBoxAddParty = new HBox(5, partyNameLabelAddParty, partyNameFieldAddParty);
	private HBox foundationDateBoxAddParty = new HBox(5, foundationDateLabelAddParty, dpAddParty);
	private HBox politicalOpinionBoxAddParty = new HBox(5, politicalOpinionLabelAddParty, leftRadioAddParty,
			centerRadioAddParty, rightRadioAddParty);
	private HBox buttonBoxAddParty = new HBox(5, saveButtonAddParty, cancelButtonAddParty);

	private VBox containerAddParty = new VBox(5, titleAddParty, partyNameBoxAddParty, foundationDateBoxAddParty,
			politicalOpinionBoxAddParty, buttonBoxAddParty);

	private Scene scenesAddParty = new Scene(containerAddParty);

	// printCitizenList

	private Label titleViewCitizensList = new Label("Citizens List");
	private TextArea taViewCitizensList = new TextArea();

	private Button printButtonViewCitizensList = new Button("Print");
	private Button cancelButtonViewCitizensList = new Button("Cancel");

	private HBox buttonBoxViewCitizensList = new HBox(5, printButtonViewCitizensList, cancelButtonViewCitizensList);
	private VBox containerViewCitizensList = new VBox(5, titleViewCitizensList, taViewCitizensList,
			buttonBoxViewCitizensList);

	private Scene scenesViewCitizensList = new Scene(containerViewCitizensList);

	// printBallboxList

	private Label titleViewBallotBoxesList = new Label("BallotBoxes List");
	private TextArea taViewBallotBoxesList = new TextArea();

	private Button printButtonViewBallotBoxesList = new Button("Print");
	private Button cancelButtonViewBallotBoxesList = new Button("Cancel");

	private HBox buttonBoxViewBallotBoxesList = new HBox(5, printButtonViewBallotBoxesList,
			cancelButtonViewBallotBoxesList);
	private VBox containerViewBallotBoxesList = new VBox(5, titleViewBallotBoxesList, taViewBallotBoxesList,
			buttonBoxViewBallotBoxesList);
	private Scene scenesViewBallotBoxesList = new Scene(containerViewBallotBoxesList);

	// PartyList

	private Label titleViewPartiesList = new Label("Parties List");

	private TextArea taViewPartiesList = new TextArea();

	private Button printButtonViewPartiesList = new Button("Print");
	private Button cancelButtonViewPartiesList = new Button("Cancel");

	private HBox buttonBoxViewPartiesList = new HBox(5, printButtonViewPartiesList, cancelButtonViewPartiesList);
	private VBox containerViewPartiesList = new VBox(5, titleViewPartiesList, taViewPartiesList,
			buttonBoxViewPartiesList);
	private Scene scenesViewPartiesList = new Scene(containerViewPartiesList);

	// ElectionResult

	private Label titleViewElectionsResult = new Label("Election Result");
	private TextArea taViewElectionsResult = new TextArea();

	private Button printButtonViewElectionsResult = new Button("Print");
	private Button cancelButtonViewElectionsResult = new Button("Cancel");

	private HBox buttonBoxViewElectionsResult = new HBox(5, printButtonViewElectionsResult,
			cancelButtonViewElectionsResult);
	private VBox containerViewElectionsResult = new VBox(5, titleViewElectionsResult, taViewElectionsResult,
			buttonBoxViewElectionsResult);
	private Scene scenesViewElectionsResult = new Scene(containerViewElectionsResult);
	private int i = 0;

	public viewElectionTe(Stage primaryStage) {
		YESNO();
		setDateElection();
		showFirstWindos();
		showWindosAddCitizen();
		ShowAddBallotBox();
		ShowAddCandidate();
		ShowAddParty();
		ViewCitizensList();
		ViewBallotBoxesList();
		ViewPartiesList();
		ViewElectionsResult();

		primaryStage.setTitle("Election System");
		primaryStage.setScene(scenesYESNO);
		// primaryStage.setResizable(false);
		primaryStage.show();
		yesButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				for (ElectionUIEventsListener l : allListeners)
					try {
						l.loadFile();
						primaryStage.setScene(sceneMenu);
						primaryStage.show();
					} catch (Exception e) {// FileNotFoundException
						////////////////////////////////////////////// scenesPickDate
						noFile();
						primaryStage.setScene(scenesPickDate);
						primaryStage.show();

					}
			}
		});
		noButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(scenesPickDate);
				primaryStage.show();
			}
		});
		// Event handlers
		nextButtonDate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (dp.getValue() != null) {// && !dp.getValue().isAfter(LocalDate.now())
					for (ElectionUIEventsListener l : allListeners)
						l.setElectionDateToUI(dp.getValue());
					primaryStage.setScene(sceneMenu);
					primaryStage.show();

				} else {
					Alert error = new Alert(Alert.AlertType.ERROR);
					error.setContentText("Please select date");
					error.showAndWait();
				}

			}

		});

		btnAddCitizen.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				primaryStage.setResizable(false);
				primaryStage.setScene(scenesAddCitizen);
				primaryStage.show();
			}
		});

		// civilianTypeTGCitizen
		covidRadioCitizen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				daysOfSicknessBoxCitizen.setVisible(true);
				inIsolationBoxCitizen.setVisible(false);

				saveButtonCitizen.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(nameFieldCitizen.getText().isEmpty() || idFieldCitizen.getText().isEmpty()
								|| birthYearFieldCitizen.getText().length() != 4
								|| daysOfSicknessFieldCitizen.getText().isEmpty())) {
							for (ElectionUIEventsListener l : allListeners)
								l.addCovid19PeopleToUI(nameFieldCitizen.getText(),
										Integer.parseInt(birthYearFieldCitizen.getText()), idFieldCitizen.getText(),
										Integer.parseInt(daysOfSicknessFieldCitizen.getText()), true);
						} else
							allFields();

					}

				});
			}
		});

		citizenRadioCitizen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inIsolationBoxCitizen.setVisible(true);
				daysOfSicknessBoxCitizen.setVisible(false);

				saveButtonCitizen.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(nameFieldCitizen.getText().isEmpty() || idFieldCitizen.getText().isEmpty()
								|| birthYearFieldCitizen.getText().length() != 4)) {
							for (ElectionUIEventsListener l : allListeners)
								l.addCitizenToUI(nameFieldCitizen.getText(),
										Integer.parseInt(birthYearFieldCitizen.getText()), idFieldCitizen.getText(),
										yesRadioCitizen.isSelected());
						} else
							allFields();
					}

				});
			}
		});

		soldierRadioCitizen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				inIsolationBoxCitizen.setVisible(true);
				daysOfSicknessBoxCitizen.setVisible(false);

				saveButtonCitizen.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(nameFieldCitizen.getText().isEmpty() || idFieldCitizen.getText().isEmpty()
								|| birthYearFieldCitizen.getText().length() != 4)) {
							for (ElectionUIEventsListener l : allListeners)
								l.addSoldierToUI(nameFieldCitizen.getText(),
										Integer.parseInt(birthYearFieldCitizen.getText()), idFieldCitizen.getText(),
										yesRadioCitizen.isSelected());
						} else
							allFields();

					}
				});
			}
		});

		cancelButtonCitizen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				nameFieldCitizen.setText("");
				birthYearFieldCitizen.setText("");
				idFieldCitizen.setText("");
				daysOfSicknessFieldCitizen.setText("");
				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		btnAddBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scenesBallotBox);
				primaryStage.setResizable(false);
				primaryStage.show();
			}
		});

		regularRadioBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonBallotBox.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(cityNameFieldBallotBox.getText().isEmpty() || streetNameFieldBallotBox.getText().isEmpty()
								|| streetNumberFieldBallotBox.getText().isEmpty())) {
							for (ElectionUIEventsListener l : allListeners) {
								l.addBallotBoxToUI(cityNameFieldBallotBox.getText(), streetNameFieldBallotBox.getText(),
										Integer.parseInt(streetNumberFieldBallotBox.getText()), 1);
							}

						} else
							allFields();
					}

				});
			}
		});

		covidPeopleRadioBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonBallotBox.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(cityNameFieldBallotBox.getText().isEmpty() || streetNameFieldBallotBox.getText().isEmpty()
								|| streetNumberFieldBallotBox.getText().isEmpty())) {
							for (ElectionUIEventsListener l : allListeners) {
								l.addBallotBoxToUI(cityNameFieldBallotBox.getText(), streetNameFieldBallotBox.getText(),
										Integer.parseInt(streetNumberFieldBallotBox.getText()), 2);
							}

						} else
							allFields();
					}
				});
			}
		});

		soldierRadioBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonBallotBox.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(cityNameFieldBallotBox.getText().isEmpty() || streetNameFieldBallotBox.getText().isEmpty()
								|| streetNumberFieldBallotBox.getText().isEmpty())) {
							for (ElectionUIEventsListener l : allListeners) {
								l.addBallotBoxToUI(cityNameFieldBallotBox.getText(), streetNameFieldBallotBox.getText(),
										Integer.parseInt(streetNumberFieldBallotBox.getText()), 3);
							}

						} else
							allFields();
					}
				});
			}
		});

		covidSoldierRadioBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonBallotBox.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if (!(cityNameFieldBallotBox.getText().isEmpty() || streetNameFieldBallotBox.getText().isEmpty()
								|| streetNumberFieldBallotBox.getText().isEmpty())) {
							for (ElectionUIEventsListener l : allListeners) {
								l.addBallotBoxToUI(cityNameFieldBallotBox.getText(), streetNameFieldBallotBox.getText(),
										Integer.parseInt(streetNumberFieldBallotBox.getText()), 4);
							}

						} else
							allFields();
					}
				});
			}
		});

		// cancleBtnFunc(cancelButtonBallotBox, primaryStage);

		cancelButtonBallotBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cityNameFieldBallotBox.setText("");
				streetNameFieldBallotBox.setText("");
				streetNumberFieldBallotBox.setText("");
				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		btnAddCandidate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scenesCandidate);
				primaryStage.setResizable(false);
				primaryStage.show();
			}
		});

		saveButtonCandidate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!(nameFieldCandidate.getText().isEmpty() || idFieldCandidate.getText().isEmpty()
						|| birthYearFieldCandidate.getText().length() != 4)) {
					for (ElectionUIEventsListener l : allListeners)
						l.addCandidateToUI(nameFieldCandidate.getText(),
								Integer.parseInt(birthYearFieldCandidate.getText()), idFieldCandidate.getText(),
								yesRadioCandidate.isSelected(), partyNameFieldCandidate.getText());
				} else
					allFields();

			}
		});

		cancelButtonCandidate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				nameFieldCandidate.setText("");
				birthYearFieldCandidate.setText("");
				idFieldCandidate.setText("");
				partyNameFieldCandidate.setText("");
				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		// cancleBtnFunc(cancelButtonCandidate, primaryStage);

		btnAddParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scenesAddParty);
				primaryStage.setResizable(false);
				primaryStage.show();
			}
		});

		leftRadioAddParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonAddParty.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						for (ElectionUIEventsListener l : allListeners)
							l.addPartyToUI(partyNameFieldAddParty.getText(), dpAddParty.getValue(),
									model.Party.espectrum.LEFT);

					}
				});
			}
		});

		centerRadioAddParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonAddParty.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						for (ElectionUIEventsListener l : allListeners)
							l.addPartyToUI(partyNameFieldAddParty.getText(), dpAddParty.getValue(),
									model.Party.espectrum.CENTER);

					}
				});
			}
		});

		rightRadioAddParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				saveButtonAddParty.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						for (ElectionUIEventsListener l : allListeners)
							l.addPartyToUI(partyNameFieldAddParty.getText(), dpAddParty.getValue(),
									model.Party.espectrum.RIGHT);

					}
				});
			}
		});

		cancelButtonAddParty.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				partyNameFieldAddParty.setText("");
				dpAddParty.setValue(null);
				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		// cancleBtnFunc(cancelButtonAddParty, primaryStage);

		btnViewCitizensList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(scenesViewCitizensList);
				primaryStage.show();
			}
		});

		printButtonViewCitizensList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				for (ElectionUIEventsListener l : allListeners)
					l.getVotersListStringToUI();
			}
		});

		cancelButtonViewCitizensList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				taViewCitizensList.setText("");

				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		btnViewBallotBoxList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(scenesViewBallotBoxesList);
				primaryStage.show();
			}
		});

		printButtonViewBallotBoxesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				for (ElectionUIEventsListener l : allListeners)
					l.getBallotBoxListStringToUI();

			}
		});

		// cancleBtnFunc(cancelButtonViewBallotBoxesList, primaryStage);

		cancelButtonViewBallotBoxesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				taViewBallotBoxesList.setText("");

				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		btnViewElectionResult.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(scenesViewElectionsResult);
				primaryStage.show();
			}
		});

		cancelButtonViewElectionsResult.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				taViewElectionsResult.setText("");

				primaryStage.setScene(sceneMenu);
				primaryStage.setResizable(false);
				primaryStage.show();

			}
		});

		printButtonViewElectionsResult.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				for (ElectionUIEventsListener l : allListeners)
					l.electionToStringToUI();

			}
		});

		btnViewPartiesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				primaryStage.setScene(scenesViewPartiesList);
				primaryStage.show();
			}
		});

		printButtonViewPartiesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				for (ElectionUIEventsListener l : allListeners)
					l.getPartiesListStringToUI();

			}
		});

		cancelButtonViewPartiesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				taViewPartiesList.setText("");

				primaryStage.setScene(sceneMenu);
				primaryStage.show();

			}
		});

		// election
		btnDoElection.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				i++;
				if (i == 1) {
					for (ElectionUIEventsListener l : allListeners) {
						try {
							l.electionMethodToUI();
						} catch (Exception e) {
							electionALERT();
						}
					}
					for (ElectionUIEventsListener l : allListeners)
						try {
							l.saveFile();
						} catch (IOException e) {
							electionALERT();
						}
				} else {
					electionALERT();
				}

			}
		});

	}

	// load from file
	public void YESNO() {

		titleYN.setPadding(new Insets(5, 5, 5, 5));
		titleYN.setStyle("-fx-font-size:20px; -fx-font-weight: bold");

		lblYN.setStyle("-fx-font-size:18px");

		yesButton.setPrefSize(100, 40);
		noButton.setPrefSize(100, 40);

		yesButton.setAlignment(Pos.CENTER);
		noButton.setPadding(new Insets(10, 10, 10, 10));

		vboxyesButton.setAlignment(Pos.CENTER);
		vboxyesButton.setPadding(new Insets(10, 10, 10, 10));

		hboxyesButton.setAlignment(Pos.CENTER);
		hboxyesButton.setPadding(new Insets(10, 10, 10, 10));

	}

	public void setDateElection() {

		titleDate.setPadding(new Insets(5, 5, 5, 5));
		titleDate.setStyle("-fx-font-size:20px");

		dp.setPrefSize(200, 40);
		nextButtonDate.setPrefSize(100, 40);

		containerDate.setAlignment(Pos.CENTER);
		containerDate.setPadding(new Insets(10, 10, 10, 10));
	}

	public void showFirstWindos() {

		rowOne.setAlignment(Pos.CENTER);
		rowOne.setPadding(new Insets(10, 10, 10, 10));

		rowTwo.setAlignment(Pos.CENTER);
		rowTwo.setPadding(new Insets(10, 10, 10, 10));

		rowThree.setAlignment(Pos.CENTER);
		rowThree.setPadding(new Insets(10, 10, 10, 10));

		rootPane.setAlignment(Pos.CENTER);
		rootPane.setPadding(new Insets(10, 10, 10, 10));

		btnAddCitizen.setPrefSize(200, 75);
		btnAddBallotBox.setPrefSize(200, 75);
		btnAddParty.setPrefSize(200, 75);
		btnAddCandidate.setPrefSize(200, 75);
		btnViewCitizensList.setPrefSize(200, 75);
		btnViewBallotBoxList.setPrefSize(200, 75);
		btnViewPartiesList.setPrefSize(200, 75);
		btnDoElection.setPrefSize(200, 75);
		btnViewElectionResult.setPrefSize(200, 75);

		rowOne.setSpacing(10);
		rowTwo.setSpacing(10);
		rowThree.setSpacing(10);
	}

	public void showWindosAddCitizen() {

		titleCitizen.setPadding(new Insets(5, 5, 5, 5));
		titleCitizen.setStyle("-fx-font-size:20px");

		nameBoxCitizen.setAlignment(Pos.CENTER);
		nameBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		birtYearBoxCitizen.setAlignment(Pos.CENTER);
		birtYearBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		idBoxCitizen.setAlignment(Pos.CENTER);
		idBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		inIsolationBoxCitizen.setAlignment(Pos.CENTER);
		inIsolationBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		yesRadioCitizen.setToggleGroup(inIsolationTGCitizen);
		noRadioCitizen.setToggleGroup(inIsolationTGCitizen);

		citizenTypeBoxCitizen.setAlignment(Pos.CENTER);
		citizenTypeBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		citizenRadioCitizen.setToggleGroup(civilianTypeTGCitizen);
		covidRadioCitizen.setToggleGroup(civilianTypeTGCitizen);
		soldierRadioCitizen.setToggleGroup(civilianTypeTGCitizen);

		daysOfSicknessBoxCitizen.setAlignment(Pos.CENTER);
		daysOfSicknessBoxCitizen.setPadding(new Insets(10, 10, 10, 10));
		daysOfSicknessBoxCitizen.setVisible(false);

		buttonBoxCitizen.setAlignment(Pos.CENTER);
		buttonBoxCitizen.setPadding(new Insets(10, 10, 10, 10));

		containerCitizen.setAlignment(Pos.CENTER);
		containerCitizen.setPadding(new Insets(10, 10, 10, 10));

		nameLabelCitizen.setPrefSize(150, 40);
		birthYearLabelCitizen.setPrefSize(150, 40);
		idLabelCitizen.setPrefSize(150, 40);
		daysOfSicknessLabelCitizen.setPrefSize(150, 40);

		nameFieldCitizen.setPrefSize(200, 40);
		birthYearFieldCitizen.setPrefSize(200, 40);
		idFieldCitizen.setPrefSize(200, 40);
		daysOfSicknessFieldCitizen.setPrefSize(200, 40);

		saveButtonCitizen.setPrefSize(100, 40);
		cancelButtonCitizen.setPrefSize(100, 40);

		addTextLimiter(nameFieldCitizen, 20);
		addTextLimiter(birthYearFieldCitizen, 4);
		addTextLimiter(idFieldCitizen, 9);

		changeToNumberField(birthYearFieldCitizen);
		changeToNumberField(idFieldCitizen);
		changeToNumberField(daysOfSicknessFieldCitizen);

	}

	private static void addTextLimiter(final TextField tf, final int maxLength) {
		tf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> ov, final String oldValue,
					final String newValue) {
				if (tf.getText().length() > maxLength) {
					String s = tf.getText().substring(0, maxLength);
					tf.setText(s);
				}
			}
		});
	}

	private void changeToNumberField(TextField tf) {
		tf.textProperty()
				.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
					if (!newValue.matches("\\d*")) {
						tf.setText(newValue.replaceAll("[^\\d]", ""));
					}
				});
	} // changeToNumberField()

	// addBalltBox
	public void ShowAddBallotBox() {
		// Settings and alignments
		titleBallotBox.setPadding(new Insets(5, 5, 5, 5));
		titleBallotBox.setStyle("-fx-font-size:20px");

		cityNameBoxBallotBox.setAlignment(Pos.CENTER);
		cityNameBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		streetNameBoxBallotBox.setAlignment(Pos.CENTER);
		streetNameBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		streetNumberBoxBallotBox.setAlignment(Pos.CENTER);
		streetNumberBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		civilianBoxBallotBox.setAlignment(Pos.CENTER);
		civilianBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		soldierBoxBallotBox.setAlignment(Pos.CENTER);
		soldierBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		citizensBoxBallotBox.setAlignment(Pos.CENTER);
		citizensBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		ballotTypeBoxBallotBox.setAlignment(Pos.CENTER);
		ballotTypeBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		regularRadioBallotBox.setToggleGroup(ballotTypeTGBallotBox);
		covidPeopleRadioBallotBox.setToggleGroup(ballotTypeTGBallotBox);
		soldierRadioBallotBox.setToggleGroup(ballotTypeTGBallotBox);
		covidSoldierRadioBallotBox.setToggleGroup(ballotTypeTGBallotBox);

		buttonBoxBallotBox.setAlignment(Pos.CENTER);
		buttonBoxBallotBox.setPadding(new Insets(10, 10, 10, 10));

		containerBallotBox.setAlignment(Pos.CENTER);
		containerBallotBox.setPadding(new Insets(10, 10, 10, 10));

		cityNameLabelBallotBox.setPrefSize(150, 40);
		streetNameLabelBallotBox.setPrefSize(150, 40);
		streetNumberLabelBallotBox.setPrefSize(150, 40);
		ballotTypeLabelBallotBox.setPrefSize(150, 40);

		cityNameFieldBallotBox.setPrefSize(200, 40);
		streetNameFieldBallotBox.setPrefSize(200, 40);
		streetNumberFieldBallotBox.setPrefSize(200, 40);

		addTextLimiter(cityNameFieldBallotBox, 20);
		addTextLimiter(streetNameFieldBallotBox, 20);
		addTextLimiter(streetNumberFieldBallotBox, 3);

		changeToNumberField(streetNumberFieldBallotBox);

		saveButtonBallotBox.setPrefSize(100, 40);
		cancelButtonBallotBox.setPrefSize(100, 40);
	}

	public void ShowAddCandidate() {
		// Settings and alignments
		titleCandidate.setPadding(new Insets(5, 5, 5, 5));
		titleCandidate.setStyle("-fx-font-size:20px");

		nameBoxCandidate.setAlignment(Pos.CENTER);
		nameBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		birtYearBoxCandidate.setAlignment(Pos.CENTER);
		birtYearBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		idBoxCandidate.setAlignment(Pos.CENTER);
		idBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		inIsolationBoxCandidate.setAlignment(Pos.CENTER);
		inIsolationBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		yesRadioCandidate.setToggleGroup(inIsolationTGCandidate);
		noRadioCandidate.setToggleGroup(inIsolationTGCandidate);

		partyNameBoxCandidate.setAlignment(Pos.CENTER);
		partyNameBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		buttonBoxCandidate.setAlignment(Pos.CENTER);
		buttonBoxCandidate.setPadding(new Insets(10, 10, 10, 10));

		containerCandidate.setAlignment(Pos.CENTER);
		containerCandidate.setPadding(new Insets(10, 10, 10, 10));

		nameLabelCandidate.setPrefSize(100, 40);
		birthYearLabelCandidate.setPrefSize(100, 40);
		idLabelCandidate.setPrefSize(100, 40);
		partyNameLabelCandidate.setPrefSize(100, 40);

		nameFieldCandidate.setPrefSize(200, 40);
		birthYearFieldCandidate.setPrefSize(200, 40);
		idFieldCandidate.setPrefSize(200, 40);
		partyNameFieldCandidate.setPrefSize(200, 40);

		saveButtonCandidate.setPrefSize(100, 40);
		cancelButtonCandidate.setPrefSize(100, 40);

		addTextLimiter(nameFieldCandidate, 20);
		addTextLimiter(birthYearFieldCandidate, 4);
		addTextLimiter(idFieldCandidate, 9);

		changeToNumberField(birthYearFieldCandidate);
		changeToNumberField(idFieldCandidate);

	}

	// addParty

	public void ShowAddParty() {
		// Settings and alignments
		titleAddParty.setPadding(new Insets(5, 5, 5, 5));
		titleAddParty.setStyle("-fx-font-size:20px");

		partyNameBoxAddParty.setAlignment(Pos.CENTER);
		partyNameBoxAddParty.setPadding(new Insets(10, 10, 10, 10));

		foundationDateBoxAddParty.setAlignment(Pos.CENTER);
		foundationDateBoxAddParty.setPadding(new Insets(10, 10, 10, 10));

		politicalOpinionBoxAddParty.setAlignment(Pos.CENTER);
		politicalOpinionBoxAddParty.setPadding(new Insets(10, 10, 10, 10));

		leftRadioAddParty.setToggleGroup(opinionTGAddParty);
		centerRadioAddParty.setToggleGroup(opinionTGAddParty);
		rightRadioAddParty.setToggleGroup(opinionTGAddParty);

		buttonBoxAddParty.setAlignment(Pos.CENTER);
		buttonBoxAddParty.setPadding(new Insets(10, 10, 10, 10));

		containerAddParty.setAlignment(Pos.CENTER);
		containerAddParty.setPadding(new Insets(10, 10, 10, 10));

		partyNameLabelAddParty.setPrefSize(150, 40);
		foundationDateLabelAddParty.setPrefSize(150, 40);
		politicalOpinionLabelAddParty.setPrefSize(150, 40);

		partyNameFieldAddParty.setPrefSize(200, 40);
		dpAddParty.setPrefSize(200, 40);

		saveButtonAddParty.setPrefSize(100, 40);
		cancelButtonAddParty.setPrefSize(100, 40);
	}

	// printCitizenList

	public void ViewCitizensList() {
		titleViewCitizensList.setPadding(new Insets(5, 5, 5, 5));
		titleViewCitizensList.setStyle("-fx-font-size:20px");

		taViewCitizensList.setEditable(false);

		printButtonViewCitizensList.setPrefSize(100, 40);
		cancelButtonViewCitizensList.setPrefSize(100, 40);

		buttonBoxViewCitizensList.setAlignment(Pos.CENTER);
		buttonBoxViewCitizensList.setPadding(new Insets(10, 10, 10, 10));

		containerViewCitizensList.setAlignment(Pos.CENTER);
		containerViewCitizensList.setPadding(new Insets(10, 10, 10, 10));

	}

	// printBallbox
	public void ViewBallotBoxesList() {
		titleViewBallotBoxesList.setPadding(new Insets(5, 5, 5, 5));
		titleViewBallotBoxesList.setStyle("-fx-font-size:20px");

		taViewBallotBoxesList.setEditable(false);

		printButtonViewBallotBoxesList.setPrefSize(100, 40);
		cancelButtonViewBallotBoxesList.setPrefSize(100, 40);

		buttonBoxViewBallotBoxesList.setAlignment(Pos.CENTER);
		buttonBoxViewBallotBoxesList.setPadding(new Insets(10, 10, 10, 10));

		containerViewBallotBoxesList.setAlignment(Pos.CENTER);
		containerViewBallotBoxesList.setPadding(new Insets(10, 10, 10, 10));
	}

	// printPartiesList

	public void ViewPartiesList() {
		titleViewPartiesList.setPadding(new Insets(5, 5, 5, 5));
		titleViewPartiesList.setStyle("-fx-font-size:20px");

		taViewPartiesList.setEditable(false);

		printButtonViewPartiesList.setPrefSize(100, 40);
		cancelButtonViewPartiesList.setPrefSize(100, 40);

		buttonBoxViewPartiesList.setAlignment(Pos.CENTER);
		buttonBoxViewPartiesList.setPadding(new Insets(10, 10, 10, 10));

		containerViewPartiesList.setAlignment(Pos.CENTER);
		containerViewPartiesList.setPadding(new Insets(10, 10, 10, 10));
	}
	// printElectionResult

	public void ViewElectionsResult() {
		titleViewElectionsResult.setPadding(new Insets(5, 5, 5, 5));
		titleViewElectionsResult.setStyle("-fx-font-size:20px");

		taViewElectionsResult.setEditable(false);

		printButtonViewElectionsResult.setPrefSize(100, 40);
		cancelButtonViewElectionsResult.setPrefSize(100, 40);

		buttonBoxViewElectionsResult.setAlignment(Pos.CENTER);
		buttonBoxViewElectionsResult.setPadding(new Insets(10, 10, 10, 10));

		containerViewElectionsResult.setAlignment(Pos.CENTER);
		containerViewElectionsResult.setPadding(new Insets(10, 10, 10, 10));

	}

	@Override
	public void registerListener(ElectionUIEventsListener newListener) {
		allListeners.add(newListener);

	}

	@Override
	public void getPartiesListStringToUI(String s) {
		taViewPartiesList.setText(s);
	}

	@Override
	public void getBallotBoxListStringToUI(String s) {
		taViewBallotBoxesList.setText(s);

	}

	@Override
	public void electionToStringToUI(String s) {
		taViewElectionsResult.setText(s);
	}

	public void CitizenNotadded(String msg) {
		Alert AlertDoElection = new Alert(Alert.AlertType.INFORMATION);
		AlertDoElection.setContentText(msg);
		AlertDoElection.setTitle("Election System");
		AlertDoElection.showAndWait();
	}

	public void getVotersListStringToUI(String s) {
		taViewCitizensList.setText(s);
	}

	@Override
	public void msgPartyAlreadyexist(String msg) {
		Alert AlertPartyAlreadyexist = new Alert(Alert.AlertType.INFORMATION);
		AlertPartyAlreadyexist.setContentText(msg);
		AlertPartyAlreadyexist.setTitle("Election System");
		AlertPartyAlreadyexist.showAndWait();

	}

	@Override
	public void msgPartyDoesntExist(String msg) {
		Alert AlertPartyDoesntExist = new Alert(Alert.AlertType.INFORMATION);
		AlertPartyDoesntExist.setContentText(msg);
		AlertPartyDoesntExist.setTitle("Election System");
		AlertPartyDoesntExist.showAndWait();
	}

	public void electionALERT() {
		Alert AlertelectionALERT = new Alert(Alert.AlertType.INFORMATION);
		AlertelectionALERT.setContentText("Election as been made! ");
		AlertelectionALERT.setTitle("Election System");
		AlertelectionALERT.showAndWait();
	}

	public void SoldierException(String msg) {
		Alert AlertSoldierException = new Alert(Alert.AlertType.INFORMATION);
		AlertSoldierException.setContentText(msg);
		AlertSoldierException.setTitle("Election System");
		AlertSoldierException.showAndWait();
	}

	public void allFields() {
		Alert AlertallFields = new Alert(Alert.AlertType.INFORMATION);
		AlertallFields.setContentText(" Please make sure all fields are filled in as needed ! ");
		AlertallFields.setTitle("Election System");
		AlertallFields.showAndWait();
	}

	public void noFile() {
		Alert AlertnoFile = new Alert(Alert.AlertType.INFORMATION);
		AlertnoFile.setContentText(" Couldn't upload file ! ");
		AlertnoFile.setTitle("Election System");
		AlertnoFile.showAndWait();
	}

//unuse methods
	@Override
	public void setviewElectionDateToUI(LocalDate d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCitizenToUI(String namePerson, int yearOfBrith, String id, boolean insulation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCovid19PeopleToUI(String namePerson, int yearOfBrith, String id, int daysOfSickness,
			boolean insulation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSoldierToUI(String namePerson, int yearOfBrith, String id, boolean insulation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addBallotBoxToUI(String city, String street, int number, int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPartyToUI(String name, LocalDate date, espectrum setSpectrum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCandidateToUI(String namePerson, int yearOfBrith, String id, boolean insulation,
			String partyOfCandidate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void electionMethodToUI() {
		// TODO Auto-generated method stub

	}

}
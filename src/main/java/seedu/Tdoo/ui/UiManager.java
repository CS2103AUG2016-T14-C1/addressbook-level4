package seedu.Tdoo.ui;

import com.google.common.eventbus.Subscribe;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import seedu.Tdoo.MainApp;
import seedu.Tdoo.commons.core.ComponentManager;
import seedu.Tdoo.commons.core.Config;
import seedu.Tdoo.commons.core.LogsCenter;
import seedu.Tdoo.commons.events.storage.DataSavingExceptionEvent;
import seedu.Tdoo.commons.events.ui.JumpDeadlineListRequestEvent;
import seedu.Tdoo.commons.events.ui.JumpEventListRequestEvent;
import seedu.Tdoo.commons.events.ui.JumpTodoListRequestEvent;
import seedu.Tdoo.commons.events.ui.ShowHelpRequestEvent;
import seedu.Tdoo.commons.events.ui.TaskPanelSelectionChangedEvent;
import seedu.Tdoo.commons.util.StringUtil;
import seedu.Tdoo.logic.Logic;
import seedu.Tdoo.model.UserPrefs;

import java.util.logging.Logger;

/**
 * The manager of the UI component.
 */
public class UiManager extends ComponentManager implements Ui {
	private static final Logger logger = LogsCenter.getLogger(UiManager.class);
	private static final String ICON_APPLICATION = "/images/Tdoo_icon.png";

	private Logic logic;
	private Config config;
	private UserPrefs prefs;
	private MainWindow mainWindow;

	public UiManager(Logic logic, Config config, UserPrefs prefs) {
		super();
		this.logic = logic;
		this.config = config;
		this.prefs = prefs;
	}

	@Override
	public void start(Stage primaryStage) {
		logger.info("Starting UI...");
		primaryStage.setTitle(config.getAppTitle());

		// Set the application icon.
		primaryStage.getIcons().add(getImage(ICON_APPLICATION));

		primaryStage.setResizable(true);

		try {
			mainWindow = MainWindow.load(primaryStage, config, prefs, logic);
			mainWindow.show(); // This should be called before creating other UI
								// parts
			mainWindow.fillInnerParts();

		} catch (Throwable e) {
			logger.severe(StringUtil.getDetails(e));
			showFatalErrorDialogAndShutdown("Fatal error during initializing", e);
		}
	}

	@Override
	public void stop() {
		prefs.updateLastUsedGuiSetting(mainWindow.getCurrentGuiSetting());
		mainWindow.hide();
	}

	private void showFileOperationAlertAndWait(String description, String details, Throwable cause) {
		final String content = details + ":\n" + cause.toString();
		showAlertDialogAndWait(AlertType.ERROR, "File Op Error", description, content);
	}

	private Image getImage(String imagePath) {
		return new Image(MainApp.class.getResourceAsStream(imagePath));
	}

	void showAlertDialogAndWait(Alert.AlertType type, String title, String headerText, String contentText) {
		showAlertDialogAndWait(mainWindow.getPrimaryStage(), type, title, headerText, contentText);
	}

	private static void showAlertDialogAndWait(Stage owner, AlertType type, String title, String headerText,
			String contentText) {
		final Alert alert = new Alert(type);
		alert.getDialogPane().getStylesheets().add("view/DarkTheme.css");
		alert.initOwner(owner);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		alert.showAndWait();
	}

	private void showFatalErrorDialogAndShutdown(String title, Throwable e) {
		logger.severe(title + " " + e.getMessage() + StringUtil.getDetails(e));
		showAlertDialogAndWait(Alert.AlertType.ERROR, title, e.getMessage(), e.toString());
		Platform.exit();
		System.exit(1);
	}

	// ==================== Event Handling Code
	// =================================================================

	@Subscribe
	private void handleDataSavingExceptionEvent(DataSavingExceptionEvent event) {
		logger.info(LogsCenter.getEventHandlingLogMessage(event));
		showFileOperationAlertAndWait("Could not save data", "Could not save data to file", event.exception);
	}

	@Subscribe
	private void handleShowHelpEvent(ShowHelpRequestEvent event) {
		logger.info(LogsCenter.getEventHandlingLogMessage(event));
		mainWindow.handleHelp();
	}

	@Subscribe
	private void handleJumpTodoListRequestEvent(JumpTodoListRequestEvent event) {
		logger.info(LogsCenter.getEventHandlingLogMessage(event));
		mainWindow.getTodoListPanel().scrollTo(event.task);
	}
	
	@Subscribe
	private void handleJumpEventListRequestEvent(JumpEventListRequestEvent event) {
		logger.info(LogsCenter.getEventHandlingLogMessage(event));
		mainWindow.getEventListPanel().scrollTo(event.task);
	}
	
	@Subscribe
	private void handleJumpDeadlineListRequestEvent(JumpDeadlineListRequestEvent event) {
		logger.info(LogsCenter.getEventHandlingLogMessage(event));
		mainWindow.getDeadlineListPanel().scrollTo(event.task);
	}
}

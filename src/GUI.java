import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI implements MouseListener, ActionListener{
	
	//BUSINESS LAYER
	BusinessLayer businessLayer;
	
	//IGNORED VARIABLE
	int ignore = -1;
	//STATE VARIABLES
	int softwareState = 1;
	//STATES
	//STATE 1 - MAIN PAGE		- stateOne()
	//STATE 30 - M-LOGIN		- mLogin()
	//STATE 31 - M-MAIN			- mMain()
	//STATE 32 - M-ACCOUNTS		- mAccounts()
	//STATE 33 - M-CUSTOMERS	- mCustomers()
	//STATE 34 - M-C-SEARCH		- mCSearch()
	//STATE 35 - M-C-MODIFY		- mCModify()
	//STATE 36 - M-C-ADD		- mCAdd()
	//STATE 37 - M-A-SEARCH		- mASearch()
	//STATE 38 - M-A-MODIFY		- mAModify()
	//STATE 38 - M-A-DELETE		- mADelete()
	//STATE 39 - M-A-ADD		- mAAdd()
	//FRAMES
	JFrame welcomePage;
		
	//PANE
	JLayeredPane mainPane;
		
	//LABELS
	JLabel background;
	JLabel exitLabel;
	JLabel backLabel;
	JLabel logoutLabel;
	JLabel searchLabel;
	JLabel wrongLabel;
	//STATE 1
	JLabel oneALabel;	//ASSISTANT BUTTON
	JLabel oneBLabel;	//BANK MANAGER BUTTON
	JLabel oneCLabel;	//CUSTOMER BUTTON
	
	//STATE 30 - M-LOGIN
	JLabel threeZeroLLabel;
	JLabel threeZeroBLabel;
	JLabel threeZeroILabel;
	//STATE 31 - M-MAIN
	JLabel threeOneALabel;
	JLabel threeOneCLabel;
	//STATE 32 - M-ACCOUNTS
	JLabel threeTwoALabel;
	JLabel threeTwoDLabel;
	JLabel threeTwoMLabel;
	JLabel threeTwoSLabel;
	//STATE 33 - M-CUSTOMERS
	JLabel threeThreeALabel;
	JLabel threeThreeMLabel;
	JLabel threeThreeSLabel;
	//STATE 34 - M-C-SEARCH
	JLabel threeFourILabel;
	//STATE 35 - M-C-MODIFY
	JLabel threeFiveMLabel;
	//STATE 36 - M-C-ADD
	JLabel threeSixALabel;
	//STATE 37 - M-A-SEARCH
	JLabel threeSevenWLabel;
	//STATE 39 - M-A-ADD
	JLabel threeNineALabel;
	//STATE 381- M-A-MODIFY
	JLabel threeEightMLabel;
	//STATE 381- M-A-DELETE
	JLabel threeEightOneDLabel;
	
	//TEXTFIELDS
	//STATE 30 - M-LOGIN
	JTextField threeZeroUsername;
	JPasswordField threeZeroPassword;
	//STATE 34 - M-C-SEARCH
	JTextField threeFourCriteria;
	JTextField threeFourQuery;
	JTextField threeFourID;
	JTextField threeFourName;
	JTextField threeFourAddress;
	JTextField threeFourContact;
	JTextField threeFourUsername;
	JTextField threeFourCNIC;
	//STATE 35 - M-C-MODIFY
	JPasswordField threeFivePassword;
	//STATE 38 - M-A-SEARCH
	JTextField threeSevenQuery;
	JTextField threeSevenBalance;
	JTextField threeSevenID;
	JTextField threeSevenName;
	JTextField threeSevenTitle;
	JTextField threeSevenStatus;
	JTextField threeSevenDate;
	JTextField threeSevenTime;
	JTextField threeSevenType;
	JTextField threeSevenLimit;
	//IMAGES
	//ICONS
	ImageIcon iconDark = new ImageIcon("Graphics/Icons/Dark_50px.png");
	ImageIcon iconWhite = new ImageIcon("Graphics/Icons/White_50px.png");
	ImageIcon iconSimple = new ImageIcon("Graphics/Icons/Simple_50px.png");
	ImageIcon exitImage = new ImageIcon("Graphics/EXIT.png");
	ImageIcon logoutImage = new ImageIcon("Graphics/LOGOUT.png");
	ImageIcon backImage = new ImageIcon("Graphics/BACK.png");
	ImageIcon incorrectImage = new ImageIcon("Graphics/INCORRECT.png");
	ImageIcon searchImage = new ImageIcon("Graphics/SEARCH.png");
	ImageIcon searchImageHover = new ImageIcon("Graphics/SEARCH-HOVER.png");
	ImageIcon searchIcon = new ImageIcon("Graphics/SEARCHICON.png");
	ImageIcon wrongImage = new ImageIcon("Graphics/WRONG.png");
	ImageIcon refreshIcon = new ImageIcon("Graphics/REFRESHICON.png");
	//STATE ONE
	ImageIcon oneCustomer = new ImageIcon("Graphics/FirstPage/CUSTOMER.png");
	ImageIcon oneCustomerHover = new ImageIcon("Graphics/FirstPage/CUSTOMER-HOVER.png");

	ImageIcon oneBankManager = new ImageIcon("Graphics/FirstPage/BANK MANAGER.png");
	ImageIcon oneBankManagerHover = new ImageIcon("Graphics/FirstPage/BANK MANAGER-HOVER.png");

	ImageIcon oneAccountant = new ImageIcon("Graphics/FirstPage/ACCOUNTANT.png");
	ImageIcon oneAccountantHover = new ImageIcon("Graphics/FirstPage/ACCOUNTANT-HOVER.png");
	
	//STATE 30 - M-LOGIN
	ImageIcon threeZeroLogin = new ImageIcon("Graphics/M-Login/LOGIN.png");
	ImageIcon threeZeroLoginHover = new ImageIcon("Graphics/M-Login/LOGIN-HOVER.png");
	ImageIcon threeZeroLoginCheck = new ImageIcon("Graphics/M-Login/LOGIN-CHECKING.png");
	//STATE 31 - M-MAIN
	ImageIcon threeOneAccounts = new ImageIcon("Graphics/M-Main/ACCOUNTS.png");
	ImageIcon threeOneAccountsHover = new ImageIcon("Graphics/M-Main/ACCOUNTS-HOVER.png");
	ImageIcon threeOneCustomers = new ImageIcon("Graphics/M-Main/CUSTOMER.png");
	ImageIcon threeOneCustomersHover = new ImageIcon("Graphics/M-Main/CUSTOMER-HOVER.png");
	//STATE 32 - M-ACCOUNTS
	ImageIcon threeTwoAdd = new ImageIcon("Graphics/M-Accounts/ADD-ACCOUNT.png");
	ImageIcon threeTwoAddHover = new ImageIcon("Graphics/M-Accounts/ADD-ACCOUNT-HOVER.png");
	ImageIcon threeTwoDelete = new ImageIcon("Graphics/M-Accounts/DELETE-ACCOUNT.png");
	ImageIcon threeTwoDeleteHover = new ImageIcon("Graphics/M-Accounts/DELETE-ACCOUNT-HOVER.png");
	ImageIcon threeTwoModify = new ImageIcon("Graphics/M-Accounts/MODIFY-ACCOUNT.png");
	ImageIcon threeTwoModifyHover = new ImageIcon("Graphics/M-Accounts/MODIFY-ACCOUNT-HOVER.png");
	//STATE 33 - M-CUSTOMERS
	ImageIcon threeThreeAdd = new ImageIcon("Graphics/M-Customers/ADD-CUSTOMER.png");
	ImageIcon threeThreeAddHover = new ImageIcon("Graphics/M-Customers/ADD-CUSTOMER-HOVER.png");
	ImageIcon threeThreeModify = new ImageIcon("Graphics/M-Customers/MODIFY-CUSTOMER.png");
	ImageIcon threeThreeModifyHover = new ImageIcon("Graphics/M-Customers/MODIFY-CUSTOMER-HOVER.png");
	//STATE 35 - M-C-MODIFY
	ImageIcon threeFiveSaved = new ImageIcon("Graphics/M-C-Modify/CHANGES-SAVED.png");
	//STATE 36 - M-C-ADD
	ImageIcon threeSixAdded = new ImageIcon("Graphics/M-C-Add/CUSTOMER-ADDED.png");
	//STATE 38 - M-A-MODIFY
	ImageIcon threeEightModify = new ImageIcon("Graphics/M-A-Modify/MODIFY-ACCOUNT.png");
	ImageIcon threeEightModifyHover = new ImageIcon("Graphics/M-A-Modify/MODIFY-ACCOUNT-HOVER.png");
	ImageIcon threeEightModified = new ImageIcon("Graphics/M-A-Modify/MODIFIED.png");
	//STATE 381- M-A-DELETE
	ImageIcon threeEightOneDelete = new ImageIcon("Graphics/M-A-Delete/DELETE-ACCOUNT.png");
	ImageIcon threeEightOneDeleteHover = new ImageIcon("Graphics/M-A-Delete/DELETE-ACCOUNT-HOVER.png");
	ImageIcon threeEightOneDeleted = new ImageIcon("Graphics/M-A-Delete/DELETED.png");
	//STATE 39 - M-A-ADD
	ImageIcon threeNineAdded = new ImageIcon("Graphics/M-A-Add/ADDED.png");
			
	//GLOBAL PARAMETERS
	GUIParameters gParams = new GUIParameters();
	
	GUI(){
		//INITIATING BUSINESS LAYER
		businessLayer = new BusinessLayer();
		
		//SETTING CORRECT STATE
		softwareState = 1;
		
		//SETTING UP FRAME
		welcomePage = new JFrame("BMS");
		
		welcomePage.setIconImage(iconSimple.getImage());
		welcomePage.setUndecorated(true);
		welcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomePage.setSize(gParams.frameWidth, gParams.frameHeight);
		welcomePage.setLayout(null);
		setFrameCenter(welcomePage);
		
		//SETTING UP PANE
		mainPane = new JLayeredPane();
		mainPane.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		
		//ADDING PANE TO FRAME
		welcomePage.add(mainPane);
		
		
		welcomePage.setVisible(true);
		stateOne();
	}
	
	private void stateOne() {
		//CLEARING PANE
		mainPane.removeAll();
		
		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/FirstPage/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);
		
		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(892, 630, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//CUSTOMER LABEL
		oneCLabel = new JLabel();
		oneCLabel.setIcon(oneCustomer);
		oneCLabel.setBounds(574, 255, oneCustomer.getIconWidth(), oneCustomer.getIconHeight());
		oneCLabel.addMouseListener(this);
		
		//BANK MANAGER LABEL
		oneBLabel = new JLabel();
		oneBLabel.setIcon(oneBankManager);
		oneBLabel.setBounds(574, 360, oneBankManager.getIconWidth(), oneBankManager.getIconHeight());
		oneBLabel.addMouseListener(this);
		
		//ASSISTANT LABEL
		oneALabel = new JLabel();
		oneALabel.setIcon(oneAccountant);
		oneALabel.setBounds(574, 468, oneAccountant.getIconWidth(), oneAccountant.getIconHeight());
		oneALabel.addMouseListener(this);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(oneALabel);
		mainPane.add(oneBLabel);
		mainPane.add(oneCLabel);
		mainPane.add(exitLabel);
		mainPane.add(background);
	}
	private void mLogin() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-Login/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);
		
		
		//LOGIN LABEL
		threeZeroLLabel = new JLabel();
		threeZeroLLabel.setIcon(threeZeroLogin);
		threeZeroLLabel.setBounds(357, 460, threeZeroLogin.getIconWidth(), threeZeroLogin.getIconHeight());
		threeZeroLLabel.addMouseListener(this);
		
		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(638, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(292, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);

		//USERNAME TEXTFIELD
		threeZeroUsername = new JTextField();
		threeZeroUsername.setPreferredSize(gParams.normalField);
		threeZeroUsername.setFont(gParams.subheadingFont);
		threeZeroUsername.setForeground(gParams.whiteMain);
		threeZeroUsername.setBorder(gParams.noBorder);
		threeZeroUsername.setOpaque(false);
		threeZeroUsername.setText("slark"); 		//CHANGE THIS LATER
		threeZeroUsername.setCaretColor(gParams.whiteMain);
		threeZeroUsername.setBounds(359, 322, gParams.normalField.width, gParams.normalField.height);

		//PASSWORD TEXTFIELD
		threeZeroPassword = new JPasswordField("elite.gamer.pk", 20);	//CHANGE THIS LATER
		threeZeroPassword.setPreferredSize(gParams.normalField);
		threeZeroPassword.setFont(gParams.subheadingFont);
		threeZeroPassword.setForeground(gParams.whiteMain);
		threeZeroPassword.setBorder(gParams.noBorder);
		threeZeroPassword.setOpaque(false);
		threeZeroPassword.setCaretColor(gParams.whiteMain);
		threeZeroPassword.setBounds(359, 403, gParams.normalField.width, gParams.normalField.height);

		//INCORRECT MESSAGE
		threeZeroILabel = new JLabel();
		threeZeroILabel.setBounds(367, 542, incorrectImage.getIconWidth(), incorrectImage.getIconHeight());

		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeZeroILabel);
		mainPane.add(threeZeroUsername);
		mainPane.add(threeZeroPassword);
		mainPane.add(threeZeroLLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);

	}
	
	private void mMain() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-Main/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);
		
		//MANAGE ACCOUNTS LABEL
		threeOneALabel = new JLabel();
		threeOneALabel.setIcon(threeOneAccounts);
		threeOneALabel.setBounds(497, 263, threeOneAccounts.getIconWidth(), threeOneAccounts.getIconHeight());
		threeOneALabel.addMouseListener(this);
		
		//MANAGE CUSTOMERS LABEL
		threeOneCLabel = new JLabel();
		threeOneCLabel.setIcon(threeOneCustomers);
		threeOneCLabel.setBounds(497, 383, threeOneCustomers.getIconWidth(), threeOneCustomers.getIconHeight());
		threeOneCLabel.addMouseListener(this);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeOneALabel);
		mainPane.add(threeOneCLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(background);
	}
	
	private void mAccounts() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-Accounts/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//ADD LABEL
		threeTwoALabel = new JLabel();
		threeTwoALabel.setIcon(threeTwoAdd);
		threeTwoALabel.setBounds(497, 167, threeTwoAdd.getIconWidth(), threeTwoAdd.getIconHeight());
		threeTwoALabel.addMouseListener(this);

		//DELETE LABEL
		threeTwoDLabel = new JLabel();
		threeTwoDLabel.setIcon(threeTwoDelete);
		threeTwoDLabel.setBounds(497, 256, threeTwoDelete.getIconWidth(), threeTwoDelete.getIconHeight());
		threeTwoDLabel.addMouseListener(this);

		//MODIFY LABEL
		threeTwoMLabel = new JLabel();
		threeTwoMLabel.setIcon(threeTwoModify);
		threeTwoMLabel.setBounds(497, 344, threeTwoModify.getIconWidth(), threeTwoModify.getIconHeight());
		threeTwoMLabel.addMouseListener(this);

		//SEARCH LABEL
		threeTwoSLabel = new JLabel();
		threeTwoSLabel.setIcon(searchImage);
		threeTwoSLabel.setBounds(497, 432, searchImage.getIconWidth(), searchImage.getIconHeight());
		threeTwoSLabel.addMouseListener(this);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeTwoALabel);
		mainPane.add(threeTwoDLabel);
		mainPane.add(threeTwoMLabel);
		mainPane.add(threeTwoSLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mCustomers() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-Customers/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//ADD LABEL
		threeThreeALabel = new JLabel();
		threeThreeALabel.setIcon(threeThreeAdd);
		threeThreeALabel.setBounds(497, 221, threeThreeAdd.getIconWidth(), threeThreeAdd.getIconHeight());
		threeThreeALabel.addMouseListener(this);

		//MODIFY LABEL
		threeThreeMLabel = new JLabel();
		threeThreeMLabel.setIcon(threeThreeModify);
		threeThreeMLabel.setBounds(497, 310, threeThreeModify.getIconWidth(), threeThreeModify.getIconHeight());
		threeThreeMLabel.addMouseListener(this);

		//SEARCH LABEL
		threeThreeSLabel = new JLabel();
		threeThreeSLabel.setIcon(searchImage);
		threeThreeSLabel.setBounds(497, 398, searchImage.getIconWidth(), searchImage.getIconHeight());
		threeThreeSLabel.addMouseListener(this);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeThreeALabel);
		mainPane.add(threeThreeMLabel);
		mainPane.add(threeThreeSLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mCSearch() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-C-Search/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(798, 191, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//INCORRECT LABEL
		threeFourILabel = new JLabel();
		threeFourILabel.setBounds(510, 167, incorrectImage.getIconWidth(), incorrectImage.getIconHeight());
		
		//TEXTFIELDS START HERE
		//CRITERIA FIELD
		threeFourCriteria = new JTextField();
		threeFourCriteria.setBounds(527, 200, 50, 15);
		threeFourCriteria.setPreferredSize(new Dimension(50, 15));
		threeFourCriteria.setFont(gParams.subheadingFont);
		threeFourCriteria.setForeground(gParams.primaryLight);
		threeFourCriteria.setOpaque(false);
		threeFourCriteria.setText("CNIC");
		threeFourCriteria.setBorder(gParams.noBorder);
		//QUERY FIELD
		threeFourQuery = new JTextField();
		threeFourQuery.setBounds(670, 200, 125, 15);
		threeFourQuery.setPreferredSize(new Dimension(125, 15));
		threeFourQuery.setFont(gParams.subheadingFont);
		threeFourQuery.setForeground(gParams.primaryLight);
		threeFourQuery.setOpaque(false);
		threeFourQuery.setText("XXXX");
		threeFourQuery.setBorder(gParams.noBorder);
		
		//ID FIELD
		threeFourID = new JTextField();
		threeFourID.setBounds(459, 264, 81, 15);
		threeFourID.setPreferredSize(new Dimension(81, 15));
		threeFourID.setFont(gParams.subheadingFont);
		threeFourID.setForeground(gParams.whiteSecondary);
		threeFourID.setOpaque(false);
		threeFourID.setText("");
		threeFourID.setEditable(false);
		threeFourID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeFourName = new JTextField();
		threeFourName.setBounds(647, 264, 171, 15);
		threeFourName.setPreferredSize(new Dimension(171, 15));
		threeFourName.setFont(gParams.subheadingFont);
		threeFourName.setForeground(gParams.whiteSecondary);
		threeFourName.setOpaque(false);
		threeFourName.setText("");
		threeFourName.setEditable(false);
		threeFourName.setBorder(gParams.noBorder);
		//ADDRESS FIELD
		threeFourAddress = new JTextField();
		threeFourAddress.setBounds(505, 316, 313, 15);
		threeFourAddress.setPreferredSize(new Dimension(313, 15));
		threeFourAddress.setFont(gParams.subheadingFont);
		threeFourAddress.setForeground(gParams.whiteSecondary);
		threeFourAddress.setOpaque(false);
		threeFourAddress.setText("");
		threeFourAddress.setEditable(false);
		threeFourAddress.setBorder(gParams.noBorder);
		//CONTACT FIELD
		threeFourContact = new JTextField();
		threeFourContact.setBounds(505, 372, 119, 15);
		threeFourContact.setPreferredSize(new Dimension(119, 15));
		threeFourContact.setFont(gParams.subheadingFont);
		threeFourContact.setForeground(gParams.whiteSecondary);
		threeFourContact.setOpaque(false);
		threeFourContact.setText("");
		threeFourContact.setEditable(false);
		threeFourContact.setBorder(gParams.noBorder);
		//USERNAME FIELD
		threeFourUsername = new JTextField();
		threeFourUsername.setBounds(729, 372, 89, 15);
		threeFourUsername.setPreferredSize(new Dimension(89, 15));
		threeFourUsername.setFont(gParams.subheadingFont);
		threeFourUsername.setForeground(gParams.whiteSecondary);
		threeFourUsername.setOpaque(false);
		threeFourUsername.setText("");
		threeFourUsername.setEditable(false);
		threeFourUsername.setBorder(gParams.noBorder);
		//CNIC FIELD
		threeFourCNIC = new JTextField();
		threeFourCNIC.setBounds(480, 424, 192, 15);
		threeFourCNIC.setPreferredSize(new Dimension(192, 15));
		threeFourCNIC.setFont(gParams.subheadingFont);
		threeFourCNIC.setForeground(gParams.whiteSecondary);
		threeFourCNIC.setOpaque(false);
		threeFourCNIC.setText("");
		threeFourCNIC.setEditable(false);
		threeFourCNIC.setBorder(gParams.noBorder);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeFourUsername);
		mainPane.add(threeFourAddress);
		mainPane.add(threeFourCNIC);
		mainPane.add(threeFourContact);
		mainPane.add(threeFourCriteria);
		mainPane.add(threeFourID);
		mainPane.add(threeFourILabel);
		mainPane.add(threeFourName);
		mainPane.add(threeFourQuery);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mCModify() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-C-Modify/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(798, 191, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//INCORRECT LABEL
		threeFourILabel = new JLabel();
		threeFourILabel.setBounds(510, 167, incorrectImage.getIconWidth(), incorrectImage.getIconHeight());
		
		//MODIFY LABEL
		threeFiveMLabel = new JLabel();
		threeFiveMLabel.setIcon(threeThreeModify);
		threeFiveMLabel.setBounds(507, 476, threeThreeModify.getIconWidth(), threeThreeModify.getIconHeight());
		threeFiveMLabel.addMouseListener(this);
		
		
		//TEXTFIELDS START HERE
		//CRITERIA FIELD
		threeFourCriteria = new JTextField();
		threeFourCriteria.setBounds(527, 200, 50, 15);
		threeFourCriteria.setPreferredSize(new Dimension(50, 15));
		threeFourCriteria.setFont(gParams.subheadingFont);
		threeFourCriteria.setForeground(gParams.primaryLight);
		threeFourCriteria.setOpaque(false);
		threeFourCriteria.setText("CNIC");
		threeFourCriteria.setBorder(gParams.noBorder);
		//QUERY FIELD
		threeFourQuery = new JTextField();
		threeFourQuery.setBounds(670, 200, 125, 15);
		threeFourQuery.setPreferredSize(new Dimension(125, 15));
		threeFourQuery.setFont(gParams.subheadingFont);
		threeFourQuery.setForeground(gParams.primaryLight);
		threeFourQuery.setOpaque(false);
		threeFourQuery.setText("XXXX");
		threeFourQuery.setBorder(gParams.noBorder);
		
		//ID FIELD
		threeFourID = new JTextField();
		threeFourID.setBounds(459, 264, 81, 15);
		threeFourID.setPreferredSize(new Dimension(81, 15));
		threeFourID.setFont(gParams.subheadingFont);
		threeFourID.setForeground(gParams.whiteSecondary);
		threeFourID.setOpaque(false);
		threeFourID.setText("");
		threeFourID.setEditable(false);
		threeFourID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeFourName = new JTextField();
		threeFourName.setBounds(647, 264, 171, 15);
		threeFourName.setPreferredSize(new Dimension(171, 15));
		threeFourName.setFont(gParams.subheadingFont);
		threeFourName.setForeground(gParams.whiteSecondary);
		threeFourName.setOpaque(false);
		threeFourName.setText("");
		threeFourName.setEditable(false);
		threeFourName.setBorder(gParams.noBorder);
		//ADDRESS FIELD
		threeFourAddress = new JTextField();
		threeFourAddress.setBounds(505, 316, 313, 15);
		threeFourAddress.setPreferredSize(new Dimension(313, 15));
		threeFourAddress.setFont(gParams.subheadingFont);
		threeFourAddress.setForeground(gParams.primaryLight);
		threeFourAddress.setOpaque(false);
		threeFourAddress.setText("");
		threeFourAddress.setEditable(false);
		threeFourAddress.setBorder(gParams.noBorder);
		//CONTACT FIELD
		threeFourContact = new JTextField();
		threeFourContact.setBounds(505, 372, 119, 15);
		threeFourContact.setPreferredSize(new Dimension(119, 15));
		threeFourContact.setFont(gParams.subheadingFont);
		threeFourContact.setForeground(gParams.primaryLight);
		threeFourContact.setOpaque(false);
		threeFourContact.setText("");
		threeFourContact.setEditable(false);
		threeFourContact.setBorder(gParams.noBorder);
		//USERNAME FIELD
		threeFourUsername = new JTextField();
		threeFourUsername.setBounds(729, 372, 89, 15);
		threeFourUsername.setPreferredSize(new Dimension(89, 15));
		threeFourUsername.setFont(gParams.subheadingFont);
		threeFourUsername.setForeground(gParams.whiteSecondary);
		threeFourUsername.setOpaque(false);
		threeFourUsername.setText("");
		threeFourUsername.setEditable(false);
		threeFourUsername.setBorder(gParams.noBorder);
		//CNIC FIELD
		threeFourCNIC = new JTextField();
		threeFourCNIC.setBounds(480, 424, 192, 15);
		threeFourCNIC.setPreferredSize(new Dimension(192, 15));
		threeFourCNIC.setFont(gParams.subheadingFont);
		threeFourCNIC.setForeground(gParams.whiteSecondary);
		threeFourCNIC.setOpaque(false);
		threeFourCNIC.setText("");
		threeFourCNIC.setEditable(false);
		threeFourCNIC.setBorder(gParams.noBorder);
		//PASSWORD FIELD
		threeFivePassword = new JPasswordField();
		threeFivePassword.setBounds(729, 424, 89, 15);
		threeFivePassword.setPreferredSize(new Dimension(89, 15));
		threeFivePassword.setFont(gParams.subheadingFont);
		threeFivePassword.setForeground(gParams.primaryLight);
		threeFivePassword.setOpaque(false);
		threeFivePassword.setText("");
		threeFivePassword.setEditable(true);
		threeFivePassword.setBorder(gParams.noBorder);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeFiveMLabel);
		mainPane.add(threeFivePassword);
		mainPane.add(threeFourUsername);
		mainPane.add(threeFourAddress);
		mainPane.add(threeFourCNIC);
		mainPane.add(threeFourContact);
		mainPane.add(threeFourCriteria);
		mainPane.add(threeFourID);
		mainPane.add(threeFourILabel);
		mainPane.add(threeFourName);
		mainPane.add(threeFourQuery);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mCAdd() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-C-Add/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);
		
		//ADD LABEL
		threeSixALabel = new JLabel();
		threeSixALabel.setIcon(threeThreeAdd);
		threeSixALabel.setBounds(507, 476, threeThreeAdd.getIconWidth(), threeThreeAdd.getIconHeight());
		threeSixALabel.addMouseListener(this);
		
		//WRONG LABEL
		wrongLabel = new JLabel();
		wrongLabel.setIcon(null);
		wrongLabel.setBounds(549, 210, wrongImage.getIconWidth(), wrongImage.getIconHeight());
		
		
		//TEXTFIELDS START HERE
		//NAME FIELD
		threeFourName = new JTextField();
		threeFourName.setBounds(489, 264, 171, 15);
		threeFourName.setPreferredSize(new Dimension(171, 15));
		threeFourName.setFont(gParams.subheadingFont);
		threeFourName.setForeground(gParams.whiteSecondary);
		threeFourName.setOpaque(false);
		threeFourName.setText("name");
		threeFourName.setBorder(gParams.noBorder);
		//ADDRESS FIELD
		threeFourAddress = new JTextField();
		threeFourAddress.setBounds(505, 316, 313, 15);
		threeFourAddress.setPreferredSize(new Dimension(313, 15));
		threeFourAddress.setFont(gParams.subheadingFont);
		threeFourAddress.setForeground(gParams.whiteSecondary);
		threeFourAddress.setOpaque(false);
		threeFourAddress.setText("complete address");
		threeFourAddress.setBorder(gParams.noBorder);
		//CONTACT FIELD
		threeFourContact = new JTextField();
		threeFourContact.setBounds(505, 372, 119, 15);
		threeFourContact.setPreferredSize(new Dimension(119, 15));
		threeFourContact.setFont(gParams.subheadingFont);
		threeFourContact.setForeground(gParams.whiteSecondary);
		threeFourContact.setOpaque(false);
		threeFourContact.setText("phone no");
		threeFourContact.setBorder(gParams.noBorder);
		//USERNAME FIELD
		threeFourUsername = new JTextField();
		threeFourUsername.setBounds(729, 372, 89, 15);
		threeFourUsername.setPreferredSize(new Dimension(89, 15));
		threeFourUsername.setFont(gParams.subheadingFont);
		threeFourUsername.setForeground(gParams.whiteSecondary);
		threeFourUsername.setOpaque(false);
		threeFourUsername.setText("username");
		threeFourUsername.setBorder(gParams.noBorder);
		//CNIC FIELD
		threeFourCNIC = new JTextField();
		threeFourCNIC.setBounds(480, 424, 192, 15);
		threeFourCNIC.setPreferredSize(new Dimension(192, 15));
		threeFourCNIC.setFont(gParams.subheadingFont);
		threeFourCNIC.setForeground(gParams.whiteSecondary);
		threeFourCNIC.setOpaque(false);
		threeFourCNIC.setText("CNIC");
		threeFourCNIC.setBorder(gParams.noBorder);
		//PASSWORD FIELD
		threeFivePassword = new JPasswordField();
		threeFivePassword.setBounds(729, 424, 89, 15);
		threeFivePassword.setPreferredSize(new Dimension(89, 15));
		threeFivePassword.setFont(gParams.subheadingFont);
		threeFivePassword.setForeground(gParams.whiteSecondary);
		threeFivePassword.setOpaque(false);
		threeFivePassword.setText("");
		threeFivePassword.setEditable(true);
		threeFivePassword.setBorder(gParams.noBorder);
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeSixALabel);
		mainPane.add(threeFivePassword);
		mainPane.add(threeFourUsername);
		mainPane.add(threeFourAddress);
		mainPane.add(threeFourCNIC);
		mainPane.add(threeFourContact);
		mainPane.add(threeFourName);
		mainPane.add(wrongLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mASearch() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-A-Search/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(638, 218, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//WRONG LABEL
		threeSevenWLabel = new JLabel();
		threeSevenWLabel.setBounds(541, 194, wrongImage.getIconWidth(), wrongImage.getIconHeight());
		
		
		//TEXTFIELDS START HERE
		//QUERY FIELD
		threeSevenQuery = new JTextField();
		threeSevenQuery.setBounds(514, 227, 125, 15);
		threeSevenQuery.setPreferredSize(new Dimension(125, 15));
		threeSevenQuery.setFont(gParams.subheadingFont);
		threeSevenQuery.setForeground(gParams.primaryLight);
		threeSevenQuery.setOpaque(false);
		threeSevenQuery.setText("XXXX");
		threeSevenQuery.setBorder(gParams.noBorder);

		//BALANCE FIELD
		threeSevenBalance = new JTextField();
		threeSevenBalance.setBounds(739, 226, 79, 15);
		threeSevenBalance.setPreferredSize(new Dimension(79, 15));
		threeSevenBalance.setFont(gParams.subheadingFont);
		threeSevenBalance.setForeground(gParams.whiteSecondary);
		threeSevenBalance.setOpaque(false);
		threeSevenBalance.setText("");
		threeSevenBalance.setEditable(false);
		threeSevenBalance.setBorder(gParams.noBorder);
		//CUSTID FIELD
		threeSevenID = new JTextField();
		threeSevenID.setBounds(496, 275, 79, 15);
		threeSevenID.setPreferredSize(new Dimension(79, 15));
		threeSevenID.setFont(gParams.subheadingFont);
		threeSevenID.setForeground(gParams.whiteSecondary);
		threeSevenID.setOpaque(false);
		threeSevenID.setText("");
		threeSevenID.setEditable(false);
		threeSevenID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeSevenName = new JTextField();
		threeSevenName.setBounds(647, 275, 171, 15);
		threeSevenName.setPreferredSize(new Dimension(171, 15));
		threeSevenName.setFont(gParams.subheadingFont);
		threeSevenName.setForeground(gParams.whiteSecondary);
		threeSevenName.setOpaque(false);
		threeSevenName.setText("");
		threeSevenName.setEditable(false);
		threeSevenName.setBorder(gParams.noBorder);
		//TITLE FIELD
		threeSevenTitle = new JTextField();
		threeSevenTitle.setBounds(540, 316, 151, 15);
		threeSevenTitle.setPreferredSize(new Dimension(151, 15));
		threeSevenTitle.setFont(gParams.subheadingFont);
		threeSevenTitle.setForeground(gParams.whiteSecondary);
		threeSevenTitle.setOpaque(false);
		threeSevenTitle.setText("");
		threeSevenTitle.setEditable(false);
		threeSevenTitle.setBorder(gParams.noBorder);
		//STATUS FIELD
		threeSevenStatus = new JTextField();
		threeSevenStatus.setBounds(756, 316, 151, 15);
		threeSevenStatus.setPreferredSize(new Dimension(151, 15));
		threeSevenStatus.setFont(gParams.subheadingFont);
		threeSevenStatus.setForeground(gParams.whiteSecondary);
		threeSevenStatus.setOpaque(false);
		threeSevenStatus.setText("");
		threeSevenStatus.setEditable(false);
		threeSevenStatus.setBorder(gParams.noBorder);
		//DATE FIELD
		threeSevenDate = new JTextField();
		threeSevenDate.setBounds(518, 363, 106, 15);
		threeSevenDate.setPreferredSize(new Dimension(106, 15));
		threeSevenDate.setFont(gParams.subheadingFont);
		threeSevenDate.setForeground(gParams.whiteSecondary);
		threeSevenDate.setOpaque(false);
		threeSevenDate.setText("");
		threeSevenDate.setEditable(false);
		threeSevenDate.setBorder(gParams.noBorder);
		//TIME FIELD
		threeSevenTime = new JTextField();
		threeSevenTime.setBounds(732, 363, 86, 15);
		threeSevenTime.setPreferredSize(new Dimension(86, 15));
		threeSevenTime.setFont(gParams.subheadingFont);
		threeSevenTime.setForeground(gParams.whiteSecondary);
		threeSevenTime.setOpaque(false);
		threeSevenTime.setText("");
		threeSevenTime.setEditable(false);
		threeSevenTime.setBorder(gParams.noBorder);
		//TYPE FIELD
		threeSevenType = new JTextField();
		threeSevenType.setBounds(480, 406, 119, 15);
		threeSevenType.setPreferredSize(new Dimension(119, 15));
		threeSevenType.setFont(gParams.subheadingFont);
		threeSevenType.setForeground(gParams.whiteSecondary);
		threeSevenType.setOpaque(false);
		threeSevenType.setText("");
		threeSevenType.setEditable(false);
		threeSevenType.setBorder(gParams.noBorder);
		//LIMIT FIELD
		threeSevenLimit = new JTextField();
		threeSevenLimit.setBounds(663, 406, 119, 15);
		threeSevenLimit.setPreferredSize(new Dimension(119, 15));
		threeSevenLimit.setFont(gParams.subheadingFont);
		threeSevenLimit.setForeground(gParams.whiteSecondary);
		threeSevenLimit.setOpaque(false);
		threeSevenLimit.setText("");
		threeSevenLimit.setEditable(false);
		threeSevenLimit.setBorder(gParams.noBorder);
		
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeSevenBalance);
		mainPane.add(threeSevenID);
		mainPane.add(threeSevenName);
		mainPane.add(threeSevenTitle);
		mainPane.add(threeSevenStatus);
		mainPane.add(threeSevenDate);
		mainPane.add(threeSevenTime);
		mainPane.add(threeSevenType);
		mainPane.add(threeSevenLimit);
		mainPane.add(threeSevenQuery);
		mainPane.add(threeSevenWLabel);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mADelete() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-A-Delete/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(638, 218, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//WRONG LABEL
		threeSevenWLabel = new JLabel();
		threeSevenWLabel.setBounds(541, 194, wrongImage.getIconWidth(), wrongImage.getIconHeight());
		
		//DELETE LABEL
		threeEightOneDLabel = new JLabel();
		threeEightOneDLabel.setIcon(threeEightOneDelete);
		threeEightOneDLabel.setBounds(500, 450, threeEightOneDelete.getIconWidth(), threeEightOneDelete.getIconHeight());
		threeEightOneDLabel.addMouseListener(this);
		
		//TEXTFIELDS START HERE
		//QUERY FIELD
		threeSevenQuery = new JTextField();
		threeSevenQuery.setBounds(514, 227, 125, 15);
		threeSevenQuery.setPreferredSize(new Dimension(125, 15));
		threeSevenQuery.setFont(gParams.subheadingFont);
		threeSevenQuery.setForeground(gParams.primaryLight);
		threeSevenQuery.setOpaque(false);
		threeSevenQuery.setText("XXXX");
		threeSevenQuery.setBorder(gParams.noBorder);

		//BALANCE FIELD
		threeSevenBalance = new JTextField();
		threeSevenBalance.setBounds(739, 226, 79, 15);
		threeSevenBalance.setPreferredSize(new Dimension(79, 15));
		threeSevenBalance.setFont(gParams.subheadingFont);
		threeSevenBalance.setForeground(gParams.whiteSecondary);
		threeSevenBalance.setOpaque(false);
		threeSevenBalance.setText("");
		threeSevenBalance.setEditable(false);
		threeSevenBalance.setBorder(gParams.noBorder);
		//CUSTID FIELD
		threeSevenID = new JTextField();
		threeSevenID.setBounds(496, 275, 79, 15);
		threeSevenID.setPreferredSize(new Dimension(79, 15));
		threeSevenID.setFont(gParams.subheadingFont);
		threeSevenID.setForeground(gParams.whiteSecondary);
		threeSevenID.setOpaque(false);
		threeSevenID.setText("");
		threeSevenID.setEditable(false);
		threeSevenID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeSevenName = new JTextField();
		threeSevenName.setBounds(647, 275, 171, 15);
		threeSevenName.setPreferredSize(new Dimension(171, 15));
		threeSevenName.setFont(gParams.subheadingFont);
		threeSevenName.setForeground(gParams.whiteSecondary);
		threeSevenName.setOpaque(false);
		threeSevenName.setText("");
		threeSevenName.setEditable(false);
		threeSevenName.setBorder(gParams.noBorder);
		//TITLE FIELD
		threeSevenTitle = new JTextField();
		threeSevenTitle.setBounds(540, 316, 151, 15);
		threeSevenTitle.setPreferredSize(new Dimension(151, 15));
		threeSevenTitle.setFont(gParams.subheadingFont);
		threeSevenTitle.setForeground(gParams.whiteSecondary);
		threeSevenTitle.setOpaque(false);
		threeSevenTitle.setText("");
		threeSevenTitle.setEditable(false);
		threeSevenTitle.setBorder(gParams.noBorder);
		//STATUS FIELD
		threeSevenStatus = new JTextField();
		threeSevenStatus.setBounds(756, 316, 151, 15);
		threeSevenStatus.setPreferredSize(new Dimension(151, 15));
		threeSevenStatus.setFont(gParams.subheadingFont);
		threeSevenStatus.setForeground(gParams.whiteSecondary);
		threeSevenStatus.setOpaque(false);
		threeSevenStatus.setText("");
		threeSevenStatus.setEditable(false);
		threeSevenStatus.setBorder(gParams.noBorder);
		//DATE FIELD
		threeSevenDate = new JTextField();
		threeSevenDate.setBounds(518, 363, 106, 15);
		threeSevenDate.setPreferredSize(new Dimension(106, 15));
		threeSevenDate.setFont(gParams.subheadingFont);
		threeSevenDate.setForeground(gParams.whiteSecondary);
		threeSevenDate.setOpaque(false);
		threeSevenDate.setText("");
		threeSevenDate.setEditable(false);
		threeSevenDate.setBorder(gParams.noBorder);
		//TIME FIELD
		threeSevenTime = new JTextField();
		threeSevenTime.setBounds(732, 363, 86, 15);
		threeSevenTime.setPreferredSize(new Dimension(86, 15));
		threeSevenTime.setFont(gParams.subheadingFont);
		threeSevenTime.setForeground(gParams.whiteSecondary);
		threeSevenTime.setOpaque(false);
		threeSevenTime.setText("");
		threeSevenTime.setEditable(false);
		threeSevenTime.setBorder(gParams.noBorder);
		//TYPE FIELD
		threeSevenType = new JTextField();
		threeSevenType.setBounds(480, 406, 119, 15);
		threeSevenType.setPreferredSize(new Dimension(119, 15));
		threeSevenType.setFont(gParams.subheadingFont);
		threeSevenType.setForeground(gParams.whiteSecondary);
		threeSevenType.setOpaque(false);
		threeSevenType.setText("");
		threeSevenType.setEditable(false);
		threeSevenType.setBorder(gParams.noBorder);
		//LIMIT FIELD
		threeSevenLimit = new JTextField();
		threeSevenLimit.setBounds(663, 406, 119, 15);
		threeSevenLimit.setPreferredSize(new Dimension(119, 15));
		threeSevenLimit.setFont(gParams.subheadingFont);
		threeSevenLimit.setForeground(gParams.whiteSecondary);
		threeSevenLimit.setOpaque(false);
		threeSevenLimit.setText("");
		threeSevenLimit.setEditable(false);
		threeSevenLimit.setBorder(gParams.noBorder);
		
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeEightOneDLabel);
		mainPane.add(threeSevenBalance);
		mainPane.add(threeSevenID);
		mainPane.add(threeSevenName);
		mainPane.add(threeSevenTitle);
		mainPane.add(threeSevenStatus);
		mainPane.add(threeSevenDate);
		mainPane.add(threeSevenTime);
		mainPane.add(threeSevenType);
		mainPane.add(threeSevenLimit);
		mainPane.add(threeSevenQuery);
		mainPane.add(threeSevenWLabel);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}

	private void mAModify() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-A-Delete/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(638, 218, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//WRONG LABEL
		threeSevenWLabel = new JLabel();
		threeSevenWLabel.setBounds(541, 194, wrongImage.getIconWidth(), wrongImage.getIconHeight());
		
		//MODIFY LABEL
		threeEightMLabel = new JLabel();
		threeEightMLabel.setIcon(threeEightModify);
		threeEightMLabel.setBounds(500, 450, threeEightModify.getIconWidth(), threeEightModify.getIconHeight());
		threeEightMLabel.addMouseListener(this);
		
		//TEXTFIELDS START HERE
		//QUERY FIELD
		threeSevenQuery = new JTextField();
		threeSevenQuery.setBounds(514, 227, 125, 15);
		threeSevenQuery.setPreferredSize(new Dimension(125, 15));
		threeSevenQuery.setFont(gParams.subheadingFont);
		threeSevenQuery.setForeground(gParams.primaryLight);
		threeSevenQuery.setOpaque(false);
		threeSevenQuery.setText("XXXX");
		threeSevenQuery.setBorder(gParams.noBorder);

		//BALANCE FIELD
		threeSevenBalance = new JTextField();
		threeSevenBalance.setBounds(739, 226, 79, 15);
		threeSevenBalance.setPreferredSize(new Dimension(79, 15));
		threeSevenBalance.setFont(gParams.subheadingFont);
		threeSevenBalance.setForeground(gParams.whiteSecondary);
		threeSevenBalance.setOpaque(false);
		threeSevenBalance.setText("");
		threeSevenBalance.setEditable(false);
		threeSevenBalance.setBorder(gParams.noBorder);
		//CUSTID FIELD
		threeSevenID = new JTextField();
		threeSevenID.setBounds(496, 275, 79, 15);
		threeSevenID.setPreferredSize(new Dimension(79, 15));
		threeSevenID.setFont(gParams.subheadingFont);
		threeSevenID.setForeground(gParams.whiteSecondary);
		threeSevenID.setOpaque(false);
		threeSevenID.setText("");
		threeSevenID.setEditable(false);
		threeSevenID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeSevenName = new JTextField();
		threeSevenName.setBounds(647, 275, 171, 15);
		threeSevenName.setPreferredSize(new Dimension(171, 15));
		threeSevenName.setFont(gParams.subheadingFont);
		threeSevenName.setForeground(gParams.whiteSecondary);
		threeSevenName.setOpaque(false);
		threeSevenName.setText("");
		threeSevenName.setEditable(false);
		threeSevenName.setBorder(gParams.noBorder);
		//TITLE FIELD
		threeSevenTitle = new JTextField();
		threeSevenTitle.setBounds(540, 316, 151, 15);
		threeSevenTitle.setPreferredSize(new Dimension(151, 15));
		threeSevenTitle.setFont(gParams.subheadingFont);
		threeSevenTitle.setForeground(gParams.primaryLight);
		threeSevenTitle.setOpaque(false);
		threeSevenTitle.setText("");
		threeSevenTitle.setEditable(false);
		threeSevenTitle.setBorder(gParams.noBorder);
		//STATUS FIELD
		threeSevenStatus = new JTextField();
		threeSevenStatus.setBounds(756, 316, 151, 15);
		threeSevenStatus.setPreferredSize(new Dimension(151, 15));
		threeSevenStatus.setFont(gParams.subheadingFont);
		threeSevenStatus.setForeground(gParams.primaryLight);
		threeSevenStatus.setOpaque(false);
		threeSevenStatus.setText("");
		threeSevenStatus.setEditable(false);
		threeSevenStatus.setBorder(gParams.noBorder);
		//DATE FIELD
		threeSevenDate = new JTextField();
		threeSevenDate.setBounds(518, 363, 106, 15);
		threeSevenDate.setPreferredSize(new Dimension(106, 15));
		threeSevenDate.setFont(gParams.subheadingFont);
		threeSevenDate.setForeground(gParams.whiteSecondary);
		threeSevenDate.setOpaque(false);
		threeSevenDate.setText("");
		threeSevenDate.setEditable(false);
		threeSevenDate.setBorder(gParams.noBorder);
		//TIME FIELD
		threeSevenTime = new JTextField();
		threeSevenTime.setBounds(732, 363, 86, 15);
		threeSevenTime.setPreferredSize(new Dimension(86, 15));
		threeSevenTime.setFont(gParams.subheadingFont);
		threeSevenTime.setForeground(gParams.whiteSecondary);
		threeSevenTime.setOpaque(false);
		threeSevenTime.setText("");
		threeSevenTime.setEditable(false);
		threeSevenTime.setBorder(gParams.noBorder);
		//TYPE FIELD
		threeSevenType = new JTextField();
		threeSevenType.setBounds(480, 406, 119, 15);
		threeSevenType.setPreferredSize(new Dimension(119, 15));
		threeSevenType.setFont(gParams.subheadingFont);
		threeSevenType.setForeground(gParams.primaryLight);
		threeSevenType.setOpaque(false);
		threeSevenType.setText("");
		threeSevenType.setEditable(false);
		threeSevenType.setBorder(gParams.noBorder);
		//LIMIT FIELD
		threeSevenLimit = new JTextField();
		threeSevenLimit.setBounds(663, 406, 119, 15);
		threeSevenLimit.setPreferredSize(new Dimension(119, 15));
		threeSevenLimit.setFont(gParams.subheadingFont);
		threeSevenLimit.setForeground(gParams.primaryLight);
		threeSevenLimit.setOpaque(false);
		threeSevenLimit.setText("");
		threeSevenLimit.setEditable(false);
		threeSevenLimit.setBorder(gParams.noBorder);
		
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeEightMLabel);
		mainPane.add(threeSevenBalance);
		mainPane.add(threeSevenID);
		mainPane.add(threeSevenName);
		mainPane.add(threeSevenTitle);
		mainPane.add(threeSevenStatus);
		mainPane.add(threeSevenDate);
		mainPane.add(threeSevenTime);
		mainPane.add(threeSevenType);
		mainPane.add(threeSevenLimit);
		mainPane.add(threeSevenQuery);
		mainPane.add(threeSevenWLabel);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	
	private void mAAdd() {
		//CLEARING PANE
		mainPane.removeAll();

		//BACKGROUND
		ImageIcon bgImage = new ImageIcon("Graphics/M-A-Add/LayoutBase.png");
		background = new JLabel();
		background.setIcon(bgImage);
		background.setBounds(0, 0, gParams.frameWidth, gParams.frameHeight);

		//EXIT LABEL
		exitLabel = new JLabel();
		exitLabel.setIcon(exitImage);
		exitLabel.setBounds(746, 584, exitImage.getIconWidth(), exitImage.getIconHeight());
		exitLabel.addMouseListener(this);
		
		//BACK LABEL
		backLabel = new JLabel();
		backLabel.setIcon(backImage);
		backLabel.setBounds(667, 584, backImage.getIconWidth(), backImage.getIconHeight());
		backLabel.addMouseListener(this);
		
		//LOGOUT LABEL
		logoutLabel = new JLabel();
		logoutLabel.setIcon(logoutImage);
		logoutLabel.setBounds(185, 584, logoutImage.getIconWidth(), logoutImage.getIconHeight());
		logoutLabel.addMouseListener(this);

		//SEARCH LABEL
		searchLabel = new JLabel();
		searchLabel.setIcon(searchIcon);
		searchLabel.setBounds(545, 268, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		searchLabel.addMouseListener(this);
		
		//WRONG LABEL
		threeSevenWLabel = new JLabel();
		threeSevenWLabel.setBounds(541, 194, wrongImage.getIconWidth(), wrongImage.getIconHeight());
		
		//ADD LABEL
		threeNineALabel = new JLabel();
		threeNineALabel.setIcon(threeTwoAdd);
		threeNineALabel.setBounds(510, 461, threeTwoAdd.getIconWidth(), threeTwoAdd.getIconHeight());
		threeNineALabel.addMouseListener(this);
		
		//TEXTFIELDS START HERE
		//QUERY FIELD
		threeSevenQuery = new JTextField();
		threeSevenQuery.setBounds(514, 227, 125, 15);
		threeSevenQuery.setPreferredSize(new Dimension(125, 15));
		threeSevenQuery.setFont(gParams.subheadingFont);
		threeSevenQuery.setForeground(gParams.whiteSecondary);
		threeSevenQuery.setOpaque(false);
		threeSevenQuery.setText("predefined");
		threeSevenQuery.setEditable(false);
		threeSevenQuery.setBorder(gParams.noBorder);

		//BALANCE FIELD
		threeSevenBalance = new JTextField();
		threeSevenBalance.setBounds(739, 226, 79, 15);
		threeSevenBalance.setPreferredSize(new Dimension(79, 15));
		threeSevenBalance.setFont(gParams.subheadingFont);
		threeSevenBalance.setForeground(gParams.whiteSecondary);
		threeSevenBalance.setOpaque(false);
		threeSevenBalance.setText("");
		threeSevenBalance.setEditable(false);
		threeSevenBalance.setBorder(gParams.noBorder);
		//CUSTID FIELD
		threeSevenID = new JTextField();
		threeSevenID.setBounds(496, 275, 50, 15);
		threeSevenID.setPreferredSize(new Dimension(50, 15));
		threeSevenID.setFont(gParams.subheadingFont);
		threeSevenID.setForeground(gParams.primaryLight);
		threeSevenID.setOpaque(false);
		threeSevenID.setText("enter");
		threeSevenID.setBorder(gParams.noBorder);
		//NAME FIELD
		threeSevenName = new JTextField();
		threeSevenName.setBounds(647, 275, 171, 15);
		threeSevenName.setPreferredSize(new Dimension(171, 15));
		threeSevenName.setFont(gParams.subheadingFont);
		threeSevenName.setForeground(gParams.whiteSecondary);
		threeSevenName.setOpaque(false);
		threeSevenName.setText("search custID");
		threeSevenName.setEditable(false);
		threeSevenName.setBorder(gParams.noBorder);
		//TITLE FIELD
		threeSevenTitle = new JTextField();
		threeSevenTitle.setBounds(540, 316, 151, 15);
		threeSevenTitle.setPreferredSize(new Dimension(151, 15));
		threeSevenTitle.setFont(gParams.subheadingFont);
		threeSevenTitle.setForeground(gParams.primaryLight);
		threeSevenTitle.setOpaque(false);
		threeSevenTitle.setText("");
		threeSevenTitle.setEditable(false);
		threeSevenTitle.setBorder(gParams.noBorder);
		//STATUS FIELD
		threeSevenStatus = new JTextField();
		threeSevenStatus.setBounds(756, 316, 151, 15);
		threeSevenStatus.setPreferredSize(new Dimension(151, 15));
		threeSevenStatus.setFont(gParams.subheadingFont);
		threeSevenStatus.setForeground(gParams.whiteSecondary);
		threeSevenStatus.setOpaque(false);
		threeSevenStatus.setText("predefined");
		threeSevenStatus.setEditable(false);
		threeSevenStatus.setBorder(gParams.noBorder);
		//DATE FIELD
		threeSevenDate = new JTextField();
		threeSevenDate.setBounds(518, 363, 106, 15);
		threeSevenDate.setPreferredSize(new Dimension(106, 15));
		threeSevenDate.setFont(gParams.subheadingFont);
		threeSevenDate.setForeground(gParams.whiteSecondary);
		threeSevenDate.setOpaque(false);
		threeSevenDate.setText("predefined");
		threeSevenDate.setEditable(false);
		threeSevenDate.setBorder(gParams.noBorder);
		//TIME FIELD
		threeSevenTime = new JTextField();
		threeSevenTime.setBounds(732, 363, 86, 15);
		threeSevenTime.setPreferredSize(new Dimension(86, 15));
		threeSevenTime.setFont(gParams.subheadingFont);
		threeSevenTime.setForeground(gParams.whiteSecondary);
		threeSevenTime.setOpaque(false);
		threeSevenTime.setText("predefined");
		threeSevenTime.setEditable(false);
		threeSevenTime.setBorder(gParams.noBorder);
		//TYPE FIELD
		threeSevenType = new JTextField();
		threeSevenType.setBounds(480, 406, 119, 15);
		threeSevenType.setPreferredSize(new Dimension(119, 15));
		threeSevenType.setFont(gParams.subheadingFont);
		threeSevenType.setForeground(gParams.primaryLight);
		threeSevenType.setOpaque(false);
		threeSevenType.setText("");
		threeSevenType.setEditable(false);
		threeSevenType.setBorder(gParams.noBorder);
		//LIMIT FIELD
		threeSevenLimit = new JTextField();
		threeSevenLimit.setBounds(663, 406, 119, 15);
		threeSevenLimit.setPreferredSize(new Dimension(119, 15));
		threeSevenLimit.setFont(gParams.subheadingFont);
		threeSevenLimit.setForeground(gParams.primaryLight);
		threeSevenLimit.setOpaque(false);
		threeSevenLimit.setText("");
		threeSevenLimit.setEditable(false);
		threeSevenLimit.setBorder(gParams.noBorder);
		
		
		//ADDING COMPONENTS TO PANE
		mainPane.add(threeNineALabel);
		mainPane.add(threeSevenBalance);
		mainPane.add(threeSevenID);
		mainPane.add(threeSevenName);
		mainPane.add(threeSevenTitle);
		mainPane.add(threeSevenStatus);
		mainPane.add(threeSevenDate);
		mainPane.add(threeSevenTime);
		mainPane.add(threeSevenType);
		mainPane.add(threeSevenLimit);
		mainPane.add(threeSevenQuery);
		mainPane.add(threeSevenWLabel);
		mainPane.add(searchLabel);
		mainPane.add(logoutLabel);
		mainPane.add(exitLabel);
		mainPane.add(backLabel);
		mainPane.add(background);
	}
	//USEFUL METHODS
	private ImageIcon rescale(ImageIcon image, int x, int y) {
		Image imageHolder = image.getImage();
		Image scaledImage = imageHolder.getScaledInstance(y, x, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(scaledImage);
		
		return image;
	}

	private ImageIcon rescalePercent(ImageIcon image, double x, double y) {
		Image imageHolder = image.getImage();
		double imgWidth = imageHolder.getWidth(null);
		double imgHeight = imageHolder.getHeight(null);
		
		imgWidth = imgWidth* (x/100);
		imgHeight = imgHeight* (y/100);
		
		Image scaledImage = imageHolder.getScaledInstance((int)imgHeight, (int)imgWidth, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(scaledImage);
		
		return image;
	}
		
		
	private void removeBorder(JComboBox combobox) {
		for (int i = 0; i < combobox.getComponentCount(); i++) 
		{
		    if (combobox.getComponent(i) instanceof JComponent) {
		        ((JComponent) combobox.getComponent(i)).setBorder(new EmptyBorder(0, 0,0,0));
		    }
		    if (combobox.getComponent(i) instanceof AbstractButton) {
		        ((AbstractButton) combobox.getComponent(i)).setBorderPainted(false);
		    }
		}
	}
		
	private void setFrameCenter(JFrame frame) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(softwareState == 1)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == oneBLabel)
			{
				softwareState = 30;
				mLogin();
			}
		}
		else if(softwareState == 30)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 1;
				stateOne();
			}
			else if(e.getSource() == threeZeroLLabel)
			{
				threeZeroLLabel.setIcon(threeZeroLoginCheck);
				ignore = 30;
				
				//DO LOGIN CHECK HERE
				String inputUsername = threeZeroUsername.getText();
				char[] inputPassword = threeZeroPassword.getPassword();
				
				int response = businessLayer.managerLogin(inputUsername, inputPassword);
				
				if(response == 0)
				{
					threeZeroILabel.setIcon(incorrectImage);
					threeZeroLLabel.setIcon(threeZeroLoginHover);
				}
				else
				{
					softwareState = 31;
					mMain();
					//System.out.printf("Login Successful!\nID: %d\n", response);
				}
				
				ignore = -1;
				//END
			}
		}
		else if(softwareState == 31)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == threeOneALabel)
			{
				softwareState = 32;
				mAccounts();
				//System.out.println("Switch To MANAGE ACCOUNTS");
			}
			else if(e.getSource() == threeOneCLabel)
			{
				softwareState = 33;
				mCustomers();
				//System.out.println("Switch To MANAGE CUSTOMERS");
			}
		}
		else if(softwareState == 32)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 31;
				mMain();
			}
			else if(e.getSource() == threeTwoALabel)
			{
				softwareState = 39;
				mAAdd();
				//System.out.println("Switch To ADD ACCOUNT");
			}
			else if(e.getSource() == threeTwoDLabel)
			{
				softwareState = 381;
				mADelete();
				//System.out.println("Switch To DELETE ACCOUNT");
			}
			else if(e.getSource() == threeTwoMLabel)
			{
				softwareState = 38;
				mAModify();
				//System.out.println("Switch To MODIFY ACCOUNT");
			}
			else if(e.getSource() == threeTwoSLabel)
			{
				softwareState = 37;
				mASearch();
				//System.out.println("Switch To SEARCH ACCOUNT");
			}
		}
		else if(softwareState == 33)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 31;
				mMain();
			}
			else if(e.getSource() == threeThreeALabel)
			{
				softwareState = 36;
				mCAdd();
				//System.out.println("Switch To ADD CUSTOMER");
			}
			else if(e.getSource() == threeThreeMLabel)
			{
				softwareState = 35;
				mCModify();
				//System.out.println("Switch To MODIFY CUSTOMER");
			}
			else if(e.getSource() == threeThreeSLabel)
			{
				softwareState = 34;
				mCSearch();
				//System.out.println("Switch To SEARCH CUSTOMER");
			}
		}
		else if(softwareState == 34)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 33;
				mCustomers();
			}
			else if(e.getSource() == searchLabel)
			{
				String criteria = threeFourCriteria.getText();
				String query = threeFourQuery.getText();
				//System.out.println("SEARCH INITIATED");
				ArrayList<String> result = businessLayer.mCSearch(criteria, query);
				
				if(result == null || result.get(0).equals("0"))
				{
					threeFourILabel.setIcon(incorrectImage);
					threeFourID.setText("");
					threeFourName.setText("");
					threeFourAddress.setText("");
					threeFourContact.setText("");
					threeFourUsername.setText("");
					threeFourCNIC.setText("");
				}
				else
				{
					if(result.get(0).equals("-1"))
					{
						System.out.println("DATABASE FAILED!");
						System.exit(-1);
					}
					else
					{
						threeFourID.setText(result.get(1));
						threeFourName.setText(result.get(2));
						threeFourAddress.setText(result.get(3));
						threeFourContact.setText(result.get(4));
						threeFourUsername.setText(result.get(5));
						threeFourCNIC.setText(result.get(7));
						threeFourILabel.setIcon(null);
					}
				}
			}
		}
		else if(softwareState == 35)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 33;
				mCustomers();
			}
			else if(e.getSource() == searchLabel)
			{
				String criteria = threeFourCriteria.getText();
				String query = threeFourQuery.getText();
				//System.out.println("SEARCH INITIATED");
				ArrayList<String> result = businessLayer.mCSearch(criteria, query);
				
				if(result == null || result.get(0).equals("0"))
				{
					threeFourILabel.setIcon(incorrectImage);
					threeFourID.setText("");
					threeFourID.setEditable(false);
					threeFourName.setText("");
					threeFourName.setEditable(false);
					threeFourAddress.setText("");
					threeFourAddress.setEditable(false);
					threeFourContact.setText("");
					threeFourContact.setEditable(false);
					threeFourUsername.setText("");
					threeFourUsername.setEditable(false);
					threeFourCNIC.setText("");
					threeFourCNIC.setEditable(false);
					threeFivePassword.setEditable(false);
				}
				else
				{
					if(result.get(0).equals("-1"))
					{
						System.out.println("DATABASE FAILED!");
						System.exit(-1);
					}
					else
					{
						threeFourID.setText(result.get(1));
						threeFourName.setText(result.get(2));
						threeFourAddress.setText(result.get(3));
						threeFourContact.setText(result.get(4));
						threeFourUsername.setText(result.get(5));
						threeFourCNIC.setText(result.get(7));
						threeFourILabel.setIcon(null);
						threeFourAddress.setEditable(true);
						threeFourContact.setEditable(true);
						threeFivePassword.setEditable(true);
					}
				}
			}
			else if(e.getSource() == threeFiveMLabel)
			{
				if(threeFourID.getText().length() == 0)
				{
					threeFourILabel.setIcon(incorrectImage);
				}
				else
				{
					threeFourILabel.setIcon(null);
					int response = businessLayer.mCModify(
								threeFourID.getText(),
								threeFourAddress.getText(),
								threeFourContact.getText(),
								new String(threeFivePassword.getPassword()));
					
					if(response != 1)
					{
						threeFourILabel.setIcon(incorrectImage);
					}
					else
					{
						threeFiveMLabel.setIcon(threeFiveSaved);
					}
				}
			}
		}
		else if(softwareState == 36)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 33;
				mCustomers();
			}
			else if(e.getSource() == threeSixALabel)
			{
				wrongLabel.setIcon(null);
				int response = businessLayer.mCAdd(
							threeFourName.getText(),
							threeFourAddress.getText(),
							threeFourContact.getText(),
							threeFourCNIC.getText(),
							threeFourUsername.getText(),
							new String(threeFivePassword.getPassword()));
				
				if(response != 1)
				{
					wrongLabel.setIcon(wrongImage);
				}
				else
				{
					threeSixALabel.setIcon(threeSixAdded);
				}
			}
		}
		else if(softwareState == 37)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 32;
				mAccounts();
			}
			else if(e.getSource() == searchLabel)
			{
				String query = threeSevenQuery.getText();
				//System.out.println("SEARCH INITIATED");
				ArrayList<String> result = businessLayer.mASearch(query);
				
				if(result == null)
				{
					threeSevenWLabel.setIcon(wrongImage);
					threeSevenID.setText("");
					threeSevenName.setText("");
					threeSevenTitle.setText("");
					threeSevenStatus.setText("");
					threeSevenDate.setText("");
					threeSevenTime.setText("");
					threeSevenType.setText("");
					threeSevenLimit.setText("");
					threeSevenBalance.setText("");
				}
				else
				{
					if(result.get(0).equals("-1"))
					{
						System.out.println("DATABASE FAILED!");
						System.exit(-1);
					}
					else
					{
						threeSevenID.setText(result.get(0));
						threeSevenName.setText(result.get(1));
						threeSevenTitle.setText(result.get(2));
						threeSevenStatus.setText(result.get(4));
						threeSevenDate.setText(result.get(5));
						threeSevenTime.setText(result.get(6));
						threeSevenType.setText(result.get(7));
						threeSevenLimit.setText(result.get(8));
						threeSevenBalance.setText(result.get(3));
						threeSevenWLabel.setIcon(null);
					}
				}
			}
		}
		else if(softwareState == 38)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 32;
				mAccounts();
			}
			else if(e.getSource() == searchLabel)
			{
				String query = threeSevenQuery.getText();
				//System.out.println("SEARCH INITIATED");
				ArrayList<String> result = businessLayer.mASearch(query);
				
				if(result == null)
				{
					threeSevenWLabel.setIcon(wrongImage);
					threeSevenID.setText("");
					threeSevenName.setText("");
					threeSevenTitle.setText("");
					threeSevenTitle.setEditable(false);
					threeSevenStatus.setText("");
					threeSevenStatus.setEditable(false);
					threeSevenDate.setText("");
					threeSevenTime.setText("");
					threeSevenType.setText("");
					threeSevenType.setEditable(false);
					threeSevenLimit.setText("");
					threeSevenLimit.setEditable(false);
					threeSevenBalance.setText("");
				}
				else
				{
					if(result.get(0).equals("-1"))
					{
						System.out.println("DATABASE FAILED!");
						System.exit(-1);
					}
					else
					{
						threeSevenID.setText(result.get(0));
						threeSevenName.setText(result.get(1));
						threeSevenTitle.setText(result.get(2));
						threeSevenTitle.setEditable(true);
						threeSevenStatus.setText(result.get(4));
						threeSevenStatus.setEditable(true);
						threeSevenDate.setText(result.get(5));
						threeSevenTime.setText(result.get(6));
						threeSevenType.setText(result.get(7));
						threeSevenType.setEditable(true);
						threeSevenLimit.setText(result.get(8));
						threeSevenLimit.setEditable(true);
						threeSevenBalance.setText(result.get(3));
						threeSevenWLabel.setIcon(null);
					}
				}
			}
			else if(e.getSource() == threeEightMLabel)
			{
				if(threeSevenID.getText().length() == 0)
				{
					threeSevenWLabel.setIcon(wrongImage);
				}
				else
				{
					threeSevenWLabel.setIcon(null);
					
					String accNum = threeSevenQuery.getText();
					String title = threeSevenTitle.getText();
					String status = threeSevenStatus.getText();
					String type = threeSevenType.getText();
					String lim = threeSevenLimit.getText();
					
					int response = businessLayer.mAModify(accNum, title, status, type, lim);
					
					if(response == 0)
					{
						threeSevenWLabel.setIcon(wrongImage);
					}
					else
					{
						threeEightMLabel.setIcon(threeEightModified);
					}
				}
			}
		}
		else if(softwareState == 381)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 32;
				mAccounts();
			}
			else if(e.getSource() == searchLabel)
			{
				String query = threeSevenQuery.getText();
				//System.out.println("SEARCH INITIATED");
				ArrayList<String> result = businessLayer.mASearch(query);
				
				if(result == null)
				{
					threeSevenWLabel.setIcon(wrongImage);
					threeSevenID.setText("");
					threeSevenName.setText("");
					threeSevenTitle.setText("");
					threeSevenStatus.setText("");
					threeSevenDate.setText("");
					threeSevenTime.setText("");
					threeSevenType.setText("");
					threeSevenLimit.setText("");
					threeSevenBalance.setText("");
				}
				else
				{
					if(result.get(0).equals("-1"))
					{
						System.out.println("DATABASE FAILED!");
						System.exit(-1);
					}
					else
					{
						threeSevenID.setText(result.get(0));
						threeSevenName.setText(result.get(1));
						threeSevenTitle.setText(result.get(2));
						threeSevenStatus.setText(result.get(4));
						threeSevenDate.setText(result.get(5));
						threeSevenTime.setText(result.get(6));
						threeSevenType.setText(result.get(7));
						threeSevenLimit.setText(result.get(8));
						threeSevenBalance.setText(result.get(3));
						threeSevenWLabel.setIcon(null);
					}
				}
			}
			else if(e.getSource() == threeEightOneDLabel)
			{
				if(threeSevenID.getText().length() == 0)
				{
					threeSevenWLabel.setIcon(wrongImage);
				}
				else
				{
					threeSevenWLabel.setIcon(null);
					
					String accNum = threeSevenQuery.getText();
					
					int response = businessLayer.mADelete(accNum);
					//System.out.println("ACCOUNT SHOULD BE DELETED HERE");
					if(response == 0)
					{
						threeSevenWLabel.setIcon(wrongImage);
					}
					else
					{
						threeSevenStatus.setText("deleted");
						
						threeEightOneDLabel.setIcon(threeEightOneDeleted);
					}
					
				}
			}
		}
		else if(softwareState == 39)
		{
			if(e.getSource() == exitLabel)
			{
				System.exit(0);
			}
			else if(e.getSource() == logoutLabel)
			{
				softwareState = 30;
				mLogin();
			}
			else if(e.getSource() == backLabel)
			{
				softwareState = 32;
				mAccounts();
			}
			else if(e.getSource() == searchLabel)
			{
				String query = threeSevenID.getText();
				//System.out.println("SEARCH INITIATED");
				String custName = businessLayer.mAAdd_CheckCustomer(query);
				
				if(custName == null || custName.equals("0"))
				{
					threeSevenQuery.setText("predefined");
					threeSevenWLabel.setIcon(wrongImage);
					threeSevenName.setText("search custID");
					threeSevenBalance.setForeground(gParams.whiteSecondary);
					threeSevenBalance.setText("");
					threeSevenBalance.setEditable(false);
					threeSevenTitle.setForeground(gParams.whiteSecondary);
					threeSevenTitle.setText("");
					threeSevenTitle.setEditable(false);
					threeSevenType.setForeground(gParams.whiteSecondary);
					threeSevenType.setText("");
					threeSevenType.setEditable(false);
					threeSevenLimit.setForeground(gParams.whiteSecondary);
					threeSevenLimit.setText("");
					threeSevenLimit.setEditable(false);
				}
				else
				{
					threeSevenQuery.setText("predefined");
					threeSevenName.setText(custName);
					threeSevenBalance.setForeground(gParams.primaryLight);
					threeSevenBalance.setText("enter");
					threeSevenBalance.setEditable(true);
					threeSevenTitle.setForeground(gParams.primaryLight);
					threeSevenTitle.setText("enter");
					threeSevenTitle.setEditable(true);
					threeSevenType.setForeground(gParams.primaryLight);
					threeSevenType.setText("enter");
					threeSevenType.setEditable(true);
					threeSevenLimit.setForeground(gParams.primaryLight);
					threeSevenLimit.setText("enter");
					threeSevenLimit.setEditable(true);
					threeSevenWLabel.setIcon(null);
				}
			}
			else if (e.getSource() == threeNineALabel)
			{
				String custID = threeSevenID.getText();
				String title = threeSevenTitle.getText();
				String type = threeSevenType.getText();
				String lim = threeSevenLimit.getText();
				String balance = threeSevenBalance.getText();
				int response = businessLayer.mAAdd(custID, title, type, lim, balance);
				
				threeSevenQuery.setText(Integer.toString(response));
				threeNineALabel.setIcon(threeNineAdded);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(softwareState == 1)
		{
			if(e.getSource() == oneCLabel)
			{
				oneCLabel.setIcon(oneCustomerHover);
			}
			else if(e.getSource() == oneBLabel)
			{
				oneBLabel.setIcon(oneBankManagerHover);
			}
			else if(e.getSource() == oneALabel)
			{
				oneALabel.setIcon(oneAccountantHover);
			}
		}
		else if(softwareState == 30)
		{
			if(e.getSource() == threeZeroLLabel && ignore != 30)
			{
				threeZeroLLabel.setIcon(threeZeroLoginHover);
			}
		}
		else if(softwareState == 31)
		{
			if(e.getSource() == threeOneALabel)
			{
				threeOneALabel.setIcon(threeOneAccountsHover);
			}
			else if(e.getSource() == threeOneCLabel)
			{
				threeOneCLabel.setIcon(threeOneCustomersHover);
			}
		}
		else if(softwareState == 32)
		{
			if(e.getSource() == threeTwoALabel)
			{
				threeTwoALabel.setIcon(threeTwoAddHover);
			}
			else if(e.getSource() == threeTwoDLabel)
			{
				threeTwoDLabel.setIcon(threeTwoDeleteHover);
			}
			else if(e.getSource() == threeTwoMLabel)
			{
				threeTwoMLabel.setIcon(threeTwoModifyHover);
			}
			else if(e.getSource() == threeTwoSLabel)
			{
				threeTwoSLabel.setIcon(searchImageHover);
			}
		}
		else if(softwareState == 33)
		{
			if(e.getSource() == threeThreeALabel)
			{
				threeThreeALabel.setIcon(threeThreeAddHover);
			}
			else if(e.getSource() == threeThreeMLabel)
			{
				threeThreeMLabel.setIcon(threeThreeModifyHover);
			}
			else if(e.getSource() == threeThreeSLabel)
			{
				threeThreeSLabel.setIcon(searchImageHover);
			}
		}
		else if(softwareState == 35)
		{
			if(e.getSource() == threeFiveMLabel)
			{
				threeFiveMLabel.setIcon(threeThreeModifyHover);
			}
		}
		else if(softwareState == 36)
		{
			if(e.getSource() == threeSixALabel)
			{
				threeSixALabel.setIcon(threeThreeAddHover);
			}
		}
		else if(softwareState == 38)
		{
			if(e.getSource() == threeEightMLabel)
			{
				threeEightMLabel.setIcon(threeEightModifyHover);
			}
		}
		else if(softwareState == 381)
		{
			if(e.getSource() == threeEightOneDLabel)
			{
				threeEightOneDLabel.setIcon(threeEightOneDeleteHover);
			}
		}
		else if(softwareState == 39)
		{
			if(e.getSource() == threeNineALabel)
			{
				threeNineALabel.setIcon(threeTwoAddHover);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(softwareState == 1)
		{
			if(e.getSource() == oneCLabel)
			{
				oneCLabel.setIcon(oneCustomer);
			}
			else if(e.getSource() == oneBLabel)
			{
				oneBLabel.setIcon(oneBankManager);
			}
			else if(e.getSource() == oneALabel)
			{
				oneALabel.setIcon(oneAccountant);
			}
		}
		else if(softwareState == 30)
		{
			if(e.getSource() == threeZeroLLabel && ignore != 30)
			{
				threeZeroLLabel.setIcon(threeZeroLogin);
			}
		}
		else if(softwareState == 31)
		{
			if(e.getSource() == threeOneALabel)
			{
				threeOneALabel.setIcon(threeOneAccounts);
			}
			else if(e.getSource() == threeOneCLabel)
			{
				threeOneCLabel.setIcon(threeOneCustomers);
			}
		}
		else if(softwareState == 32)
		{
			if(e.getSource() == threeTwoALabel)
			{
				threeTwoALabel.setIcon(threeTwoAdd);
			}
			else if(e.getSource() == threeTwoDLabel)
			{
				threeTwoDLabel.setIcon(threeTwoDelete);
			}
			else if(e.getSource() == threeTwoMLabel)
			{
				threeTwoMLabel.setIcon(threeTwoModify);
			}
			else if(e.getSource() == threeTwoSLabel)
			{
				threeTwoSLabel.setIcon(searchImage);
			}
		}
		else if(softwareState == 33)
		{
			if(e.getSource() == threeThreeALabel)
			{
				threeThreeALabel.setIcon(threeThreeAdd);
			}
			else if(e.getSource() == threeThreeMLabel)
			{
				threeThreeMLabel.setIcon(threeThreeModify);
			}
			else if(e.getSource() == threeThreeSLabel)
			{
				threeThreeSLabel.setIcon(searchImage);
			}
		}
		else if(softwareState == 35)
		{
			if(e.getSource() == threeFiveMLabel)
			{
				threeFiveMLabel.setIcon(threeThreeModify);
			}
		}
		else if(softwareState == 36)
		{
			if(e.getSource() == threeSixALabel)
			{
				threeSixALabel.setIcon(threeThreeAdd);
			}
		}
		else if(softwareState == 38)
		{
			if(e.getSource() == threeEightMLabel)
			{
				threeEightMLabel.setIcon(threeEightModify);
			}
		}
		else if(softwareState == 381)
		{
			if(e.getSource() == threeEightOneDLabel)
			{
				threeEightOneDLabel.setIcon(threeEightOneDelete);
			}
		}
		else if(softwareState == 39)
		{
			if(e.getSource() == threeNineALabel)
			{
				threeNineALabel.setIcon(threeTwoAdd);
			}
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
